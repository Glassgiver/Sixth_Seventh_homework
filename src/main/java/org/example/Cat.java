package org.example;

public class Cat extends Animal{
    public Cat(String name, String color, int age){
        setMax();
        this.name = name;
        this.color = color;
        this.age = age;
        this.staminaCurrent = staminaMax;
        this.animalKind = "cat";
    }
    //tired cats constructor
    public Cat (String name, int age){
        setMax();
        catTired();
        this.name = name;
        this.age = age;
        this.staminaCurrent = staminaMax;
        this.animalKind = "cat";
    }

    protected void setMax(){
        this.swimMax = 0;
        this.runMax = 200;
        this.jumpOverMax = 2;
        this.staminaMax = 250;
    }


    public void catTired(){
        this.staminaCurrent = 50;
        this.hunger = 50;
    }
    public void showShortInfo(){
        System.out.println("Name: " + name);
        System.out.println("Stamina: " + staminaCurrent);
    }
}
