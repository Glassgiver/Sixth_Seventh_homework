package org.example;
import java.util.Random;
public abstract class Animal {
    protected Random random = new Random();
    protected String name;
    protected String animalKind;
    protected String color;
    protected int age;
    protected int runMax;
    protected int swimMax;
    protected double jumpOverMax;
    protected int staminaMax;
    protected double staminaCurrent;
    protected int hunger;
    protected int hungerMax;
    protected boolean isExhausted = false;
    protected abstract void setMax();

    public void showInfo(){
        System.out.printf("name: %s \n" +
                          "age: %d\n" +
                          "color: %s\n" +
                          "current stamina: %f\n" +
                          "max stamina: %d\n" +
                          "max run: %d\n" +
                          "max swim: %d\n" +
                          "max jump: %f\n", name, age, color, staminaCurrent, staminaMax, runMax, swimMax, jumpOverMax);
    }

    public boolean train(){
        if (swimMax == 500 && runMax == 1500 && staminaMax == 500){
            System.out.printf("You can't train %s anymore because he reached max level!", name);
            return false;
        }

        swimMax += random.nextInt(5);
        runMax += random.nextInt(100);
        staminaMax += random.nextInt(10);

        if (swimMax > 500){
            swimMax = 500;
        }

        if (runMax > 500){
            runMax = 1500;
        }

        if (staminaMax > 500){
            staminaMax = 500;
        }

        return true;
    }


    public void run(int value){
        System.out.printf("%s is trying to run...", name);
        if (runMax == 0){
            System.out.printf("%s can't run! \n", name);
        }
        checkTheAction(value,runMax);
    }
    public void swim (int value){
        if (swimMax == 0){
            System.out.printf("Your %s can't swim! \n", animalKind);
        }
        checkTheAction(value,swimMax);
    }
    public void jumpOver(int value){
        if (jumpOverMax == 0){
            System.out.printf("Your %s can't run! \n", animalKind);
        }
        checkTheAction(value,jumpOverMax);
    }
    public boolean eat(Plate plate){
        if (isExhausted){
            System.out.printf("%s needs to sleep first!\n", name);
            return false;
        }
        if(hunger == 0){
            System.out.printf("%s is not hungry!\n", name);
            return false;
        }
        if(plate.getFoodValue() == 0){
            System.out.println("Fill the plate first! It's empty");
            return false;
        }
        int resultOfEating = plate.decrease(hunger);
        if(resultOfEating == hunger){
            System.out.printf("%s rested!\n", name);
            hunger = 0;
            staminaCurrent = staminaMax;
            return true;
        }
        if(resultOfEating < hunger){
            System.out.printf("%s rested, but not fully. Fill the plate\n", name);
            hunger -= resultOfEating;
            staminaCurrent += resultOfEating;
        }
        return false;
    }
    public boolean sleep(){
        if(isExhausted){
            System.out.println("zzzzzzz");
            isExhausted = false;
            return true;
        }

        System.out.printf("%s doesn't want to sleep!", name);
        return false;
    }

    // ---------------------------------- //
    private boolean checkTheAction(int value, double actionMax){
        if (actionMax == 0){
            return false;
        }
        if(isExhausted){
            System.out.printf("You can't do that, because %s is too tired", animalKind);
            return false;
        }

        if (value > actionMax || staminaCurrent < (value/10)){
            System.out.printf("Result: failed! \n Warning! Your %s is exhausted and needs to sleep. \n", animalKind);
            staminaCurrent = 0;
            hunger = hungerMax;
            isExhausted = true;
            return false;
        }
        if (value < actionMax){
            staminaCurrent -= value/10;
            hunger += value/10;
            System.out.println("Result: success!");
        }
        else{
            staminaCurrent = 0;
            System.out.printf("Result: success! \n Warning! Your %s is too tired!\n", animalKind);
        }
        return true;
    }
}
