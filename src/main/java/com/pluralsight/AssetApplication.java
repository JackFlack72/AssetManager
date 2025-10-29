package com.pluralsight;

import java.util.ArrayList;

public class AssetApplication {
    public static void main(String[] args) {
        House house = new House("Beach House", "10/29/2025", 2200000.00, "12345 Ur Mom", 1, 2000, 3000);
        Vehicle vehicle = new Vehicle("My Baby", "10/29/2025", 500000, "McLaren 720S", 2023, 0);
        ArrayList<Asset> assets = new ArrayList<>();

        assets.add(house);
        assets.add(vehicle);

        for (Asset asset : assets) {
            System.out.println(asset);
        }
    }
}
