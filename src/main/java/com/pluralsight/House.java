package com.pluralsight;

public class House extends Asset {
    private String address;
    private int condition; //(1 -excellent, 2 -good, 3 -fair, 4 -poor)
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public double getValue() {
        // A house's value is determined as:
        // $180.00 per square foot (excellent)
        // $130.00 per square foot (good)
        // $90.00 per square foot (fair)
        // $80.00 per square foot (poor)
        double houseValue = switch (condition) { //condition: (1 -excellent, 2 -good, 3 -fair, 4 -poor)
            case 1 -> 180.00;
            case 2 -> 130.00;
            case 3 -> 90.00;
            case 4 -> 80.00;
            default -> throw new IllegalArgumentException("Unknown Value...");
        };
        // PLUS 25 cents per square foot of lot size
        double lotValue = .25 * lotSize;
        return lotValue + houseValue;
    }

    @Override
    public String toString() {
        System.out.println("description, dateAcquired, originalCost, address, condition, squareFoot, lotSize");
        final StringBuilder sb = new StringBuilder("House: ");
        sb.append(address);
        sb.append(", ").append(condition);
        sb.append(", ").append(squareFoot);
        sb.append(", ").append(lotSize);
        sb.append('.');
        return sb.toString();
    }
}
