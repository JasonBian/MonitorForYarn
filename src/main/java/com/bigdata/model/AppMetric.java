package com.bigdata.model;

/**
 * Created by bianzexin on 17/3/30.
 */

import com.bigdata.Utils;

import java.util.Map;

public class AppMetric {
    private AppMetric() {
    }

    public static AppMetric apply(Map<String, Object> map, long ts) {
        AppMetric appMetric = new AppMetric();

        appMetric.applicationId = (String) map.get("id");
        appMetric.allocatedMB = (int) map.get("allocatedMB");
        appMetric.allocatedVCores = (int) map.get("allocatedVCores");
        appMetric.queue = (String) map.get("queue");
        appMetric.user = (String) map.get("user");
        appMetric.name = (String) map.get("name");

        appMetric.state = (String) map.get("state");
        appMetric.finalState = (String) map.get("finalState");
        appMetric.progress = (Double) map.get("progress");

        appMetric.timestamp = Utils.getDateFormat(ts);
        appMetric.id = appMetric.applicationId + "$" + ts;

        return appMetric;
    }

    private String id;
    private int allocatedMB;
    private int allocatedVCores;
    private String queue;
    private String name;
    private String user;

    private String applicationId;
    private String timestamp;

    //modify by zexinBian
    private String state;
    private String finalState;
    private Double progress;



    public String getId() {
        return id;
    }

    public void setId(String value) {
        id = value;
    }

    public int getAllocatedMB() {
        return allocatedMB;
    }

    public void setAllocatedMB(int value) {
        allocatedMB = value;
    }

    public int getAllocatedVCores() {
        return allocatedVCores;
    }

    public void setAllocatedVCores(int value) {
        allocatedVCores = value;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String value) {
        queue = value;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String value) {
        applicationId = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String value) {
        timestamp = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String value) {
        user = value;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFinalState() {
        return finalState;
    }

    public void setFinalState(String finalState) {
        this.finalState = finalState;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public String toCSV() {
        char split = ',';
        StringBuffer sb = new StringBuffer()
                .append(id).append(split)
                .append(applicationId).append(split)
                .append(allocatedMB).append(split)
                .append(allocatedVCores).append(split)
                .append(queue).append(split)
                .append(timestamp).append(split)
                .append(user).append(split)
                .append(state).append(split)
                .append(finalState).append(split)
                .append(String.valueOf(progress)).append(split)
                .append(name);
        return sb.toString();
    }
}
