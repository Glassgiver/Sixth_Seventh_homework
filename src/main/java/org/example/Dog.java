package org.example;

public class Dog extends Animal{

    public Dog(String name, String color, int age){
        setMax();
        this.name = name;
        this.color = color;
        this.age = age;
        this.staminaCurrent = staminaMax;
        this.animalKind = "dog";
    }
    protected void setMax(){
        this.swimMax = 10;
        this.runMax = 500;
        this.jumpOverMax = 0.5;
        this.staminaMax = 250;
    }
}
