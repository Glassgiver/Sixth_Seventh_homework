package org.example;

public class Plate {
    private int foodValue;

    public int getFoodValue() {
        return foodValue;
    }

    private void setFoodValue(int foodValue) {
        this.foodValue = foodValue;
    }

    public boolean fill(int value){
        if (value <= 0){
            System.out.println("You can't fill the plate with an air..");
            return false;
        }

        foodValue = value;
        return true;
    }

    public int decrease(int value){
        if (value <= foodValue){
            foodValue -= value;
            return value;
        }
        if (value > foodValue){
            foodValue = 0;
            return foodValue;
        }
        return 0;
    }
}
