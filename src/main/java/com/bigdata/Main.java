package com.bigdata;

import com.bigdata.model.AppMetric;
import com.bigdata.model.YarnMetric;
import com.bigdata.model.YarnCluster;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by bianzexin on 17/3/30.
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final MetricsFormat metricFormat;
    private static final String format;
    static {
        format = Utils.get(Constants.FORMAT, Constants.JSON);
        if (Constants.CSV.equals(format))
            metricFormat = MetricsFormat.csvFormat;
        else
            metricFormat = MetricsFormat.jsonFormat;
    }


    public static void main(String[] args) {
        logger.info("Eagle eye starts monitoring ...");
        logger.info(SearchEngine.Request.yarnRequest.getUrl());

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(Integer.valueOf(Utils.get(Constants.CORE_POOL_SIZE, "3")));
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                byte[] response = SearchEngine.search(SearchEngine.Request.yarnRequest);
                YarnCluster yarnCluster = Utils.jsonToObject(response, YarnCluster.class);
                List<AppMetric> appMetrics = yarnCluster.appMetrics();

                List<String> messages = new ArrayList<String>();
                for (AppMetric appMetric : appMetrics) {
                    messages.add(metricFormat.getMetrics(appMetric));
                }

                System.out.println(messages);
                Utils.getPublisher().send(messages);
            }
        }, 0, Long.valueOf(Utils.get(Constants.SCHEDULE_PERIOD, "10")), TimeUnit.SECONDS);


        /**
         * Get cluster metric
         */
        ScheduledExecutorService clusterExecutor = Executors.newScheduledThreadPool(Integer.valueOf(Utils.get(Constants.CORE_POOL_SIZE, "5")));
        clusterExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                byte[] response = SearchEngine.search(SearchEngine.Request.yarnMetricRequest);
                YarnMetric yarnMetric = Utils.jsonToObject(response, YarnMetric.class);
                String message = Constants.CSV.equals(format) ? yarnMetric.getClusterMetrics().toCSV() : Utils.objectToJson(yarnMetric.getClusterMetrics());
                System.out.println(message);
                //TODO
            }
        }, 0, Long.valueOf(Utils.get(Constants.SCHEDULE_PERIOD, "10")), TimeUnit.MINUTES);
    }

    interface MetricsFormat {
        String getMetrics(AppMetric metric);

        MetricsFormat csvFormat = new MetricsFormat() {
            @Override
            public String getMetrics(AppMetric metric) {
                return metric.toCSV();
            }
        };

        MetricsFormat jsonFormat = new MetricsFormat() {
            @Override
            public String getMetrics(AppMetric metric) {
                return Utils.objectToJson(metric);
            }
        };
    }

}
