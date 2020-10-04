package com.example.nasa;

public class Eventco {
    private String launch,landing,docking,fromiss,toiss,layover;

    public Eventco() {
    }

    public Eventco(String launch, String landing, String docking, String fromiss, String toiss, String layover) {
        this.launch = launch;
        this.landing = landing;
        this.docking = docking;
        this.fromiss = fromiss;
        this.toiss = toiss;
        this.layover = layover;
    }

    public String getLaunch() {
        return launch;
    }

    public void setLaunch(String launch) {
        this.launch = launch;
    }

    public String getLanding() {
        return landing;
    }

    public void setLanding(String landing) {
        this.landing = landing;
    }

    public String getDocking() {
        return docking;
    }

    public void setDocking(String docking) {
        this.docking = docking;
    }

    public String getFromiss() {
        return fromiss;
    }

    public void setFromiss(String fromiss) {
        this.fromiss = fromiss;
    }

    public String getToiss() {
        return toiss;
    }

    public void setToiss(String toiss) {
        this.toiss = toiss;
    }

    public String getLayover() {
        return layover;
    }

    public void setLayover(String layover) {
        this.layover = layover;
    }
}
