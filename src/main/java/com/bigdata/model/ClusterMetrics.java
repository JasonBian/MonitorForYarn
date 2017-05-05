package com.bigdata.model;

import java.util.Map;

/**
 * Created by bianzexin on 17/5/2.
 */
public class ClusterMetrics {

    private int appsSubmitted;
    private int appsCompleted;
    private int appsPending;
    private int appsRunning;
    private int appsFailed;
    private int appsKilled;
    private long reservedMB;
    private long availableMB;
    private long allocatedMB;
    private long totalMB;
    private long reservedVirtualCores;
    private long availableVirtualCores;
    private long allocatedVirtualCores;
    private long totalVirtualCores;
    private int containersAllocated;
    private int containersReserved;
    private int containersPending;
    private int totalNodes;
    private int activeNodes;
    private int lostNodes;
    private int unhealthyNodes;
    private int decommissionedNodes;
    private int rebootedNodes;

    public int getAppsSubmitted() {
        return appsSubmitted;
    }

    public void setAppsSubmitted(int appsSubmitted) {
        this.appsSubmitted = appsSubmitted;
    }

    public int getAppsCompleted() {
        return appsCompleted;
    }

    public void setAppsCompleted(int appsCompleted) {
        this.appsCompleted = appsCompleted;
    }

    public int getAppsPending() {
        return appsPending;
    }

    public void setAppsPending(int appsPending) {
        this.appsPending = appsPending;
    }

    public int getAppsRunning() {
        return appsRunning;
    }

    public void setAppsRunning(int appsRunning) {
        this.appsRunning = appsRunning;
    }

    public int getAppsFailed() {
        return appsFailed;
    }

    public void setAppsFailed(int appsFailed) {
        this.appsFailed = appsFailed;
    }

    public int getAppsKilled() {
        return appsKilled;
    }

    public void setAppsKilled(int appsKilled) {
        this.appsKilled = appsKilled;
    }

    public long getReservedMB() {
        return reservedMB;
    }

    public void setReservedMB(long reservedMB) {
        this.reservedMB = reservedMB;
    }

    public long getAvailableMB() {
        return availableMB;
    }

    public void setAvailableMB(long availableMB) {
        this.availableMB = availableMB;
    }

    public long getTotalMB() {
        return totalMB;
    }

    public void setTotalMB(long totalMB) {
        this.totalMB = totalMB;
    }

    public long getReservedVirtualCores() {
        return reservedVirtualCores;
    }

    public void setReservedVirtualCores(long reservedVirtualCores) {
        this.reservedVirtualCores = reservedVirtualCores;
    }

    public long getAvailableVirtualCores() {
        return availableVirtualCores;
    }

    public void setAvailableVirtualCores(long availableVirtualCores) {
        this.availableVirtualCores = availableVirtualCores;
    }

    public long getAllocatedVirtualCores() {
        return allocatedVirtualCores;
    }

    public void setAllocatedVirtualCores(long allocatedVirtualCores) {
        this.allocatedVirtualCores = allocatedVirtualCores;
    }

    public long getTotalVirtualCores() {
        return totalVirtualCores;
    }

    public void setTotalVirtualCores(long totalVirtualCores) {
        this.totalVirtualCores = totalVirtualCores;
    }

    public int getContainersAllocated() {
        return containersAllocated;
    }

    public void setContainersAllocated(int containersAllocated) {
        this.containersAllocated = containersAllocated;
    }

    public int getContainersReserved() {
        return containersReserved;
    }

    public void setContainersReserved(int containersReserved) {
        this.containersReserved = containersReserved;
    }

    public int getContainersPending() {
        return containersPending;
    }

    public void setContainersPending(int containersPending) {
        this.containersPending = containersPending;
    }

    public int getTotalNodes() {
        return totalNodes;
    }

    public void setTotalNodes(int totalNodes) {
        this.totalNodes = totalNodes;
    }

    public int getActiveNodes() {
        return activeNodes;
    }

    public void setActiveNodes(int activeNodes) {
        this.activeNodes = activeNodes;
    }

    public int getLostNodes() {
        return lostNodes;
    }

    public void setLostNodes(int lostNodes) {
        this.lostNodes = lostNodes;
    }

    public int getUnhealthyNodes() {
        return unhealthyNodes;
    }

    public void setUnhealthyNodes(int unhealthyNodes) {
        this.unhealthyNodes = unhealthyNodes;
    }

    public int getDecommissionedNodes() {
        return decommissionedNodes;
    }

    public void setDecommissionedNodes(int decommissionedNodes) {
        this.decommissionedNodes = decommissionedNodes;
    }

    public int getRebootedNodes() {
        return rebootedNodes;
    }

    public void setRebootedNodes(int rebootedNodes) {
        this.rebootedNodes = rebootedNodes;
    }

    public long getAllocatedMB() {
        return allocatedMB;
    }

    public void setAllocatedMB(long allocatedMB) {
        this.allocatedMB = allocatedMB;
    }

    public ClusterMetrics() {
    }

    public String toCSV() {
        char split = ',';
        StringBuffer sb = new StringBuffer()
                .append(appsCompleted).append(split)
                .append(appsPending).append(split)
                .append(appsRunning).append(split)
                .append(appsFailed).append(split)
                .append(appsKilled).append(split)
                .append(reservedMB).append(split)
                .append(availableMB).append(split)
                .append(totalMB).append(split)
                .append(reservedVirtualCores).append(split)
                .append(availableVirtualCores).append(split)
                .append(allocatedVirtualCores).append(split)
                .append(totalVirtualCores).append(split)
                .append(containersAllocated).append(split)
                .append(containersReserved).append(split)
                .append(containersPending).append(split)
                .append(totalNodes).append(split)
                .append(activeNodes).append(split)
                .append(lostNodes).append(split)
                .append(unhealthyNodes).append(split)
                .append(decommissionedNodes).append(split)
                .append(rebootedNodes).append(split);
        return sb.toString();
    }
}
