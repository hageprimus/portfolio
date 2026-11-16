package com.pluralsight;

public abstract class Asset implements Valuable {
    protected String name;
    protected double marketValue;

    public Asset(String name, double marketValue) {
        this.name = name;
        this.marketValue = marketValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public double getValue() {
        return marketValue;
    }

    @Override
    public String toString() {
        return String.format("%s, %,.2f", getName(), getValue());
    }
}
