package com.bigdata.model;

/**
 * Created by bianzexin on 17/5/4.
 */
public class YarnMetric {

    public ClusterMetrics getClusterMetrics() {
        return clusterMetrics;
    }

    public void setClusterMetrics(ClusterMetrics clusterMetrics) {
        this.clusterMetrics = clusterMetrics;
    }

    private ClusterMetrics clusterMetrics;

}
