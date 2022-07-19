package ttl.larku.app;

public class WhatIsABean {
    private int xzy;

    private String name;

    //"value" read/write
    public int getValue() {
        return xzy;
    }

    public void setValue(int value) {
        this.xzy = value;
    }

    public int getXzy() {
        return xzy;
    }

    public void setXzy(int xzy) {
        this.xzy = xzy;
    }
}