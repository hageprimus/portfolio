package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private String name;
    private String owner;
    private List<Valuable> assets;

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.assets = new ArrayList<>();
    }

    public void add(Valuable asset) {
        assets.add(asset);
    }

    public double getValue() {
        double total = 0;
        for (Valuable v : assets) {
            total += v.getValue();
        }
        return total;
    }

    public Valuable getMostValuable() {
        double highest = 0;
        Valuable highestAsset = assets.get(0);
        for (Valuable v : assets) {
            if (highest < v.getValue()) {
                highest = v.getValue();
                highestAsset = v;
            }
        }
        return highestAsset;
    }

    public Valuable getLeastValuable() {
        double lowest = Double.MAX_VALUE;
        Valuable lowestAsset = assets.get(0);
        for (Valuable v : assets) {
            if (lowest > v.getValue()) {
                lowest = v.getValue();
                lowestAsset = v;
            }
        }
        return lowestAsset;
    }

}
