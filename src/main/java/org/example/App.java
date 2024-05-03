package org.example;


public class App 
{
    public static void main(String[] args) {
        Plate plate = new Plate();
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Whiskers", 5);
        cats[1] = new Cat("Tom", 3);
        cats[2] = new Cat("Salem", 7);

        plate.fill(100);

        for (Cat cat : cats) {
            System.out.println("Current food:" + plate.getFoodValue());
            cat.showShortInfo();
            cat.eat(plate);
            System.out.println();
        }

        plate.fill(-1);
        System.out.println("Current food:" + plate.getFoodValue());

        System.out.println();

        plate.fill(100);
        System.out.println("Current food:" + plate.getFoodValue());
        cats[2].eat(plate);
    }
}
