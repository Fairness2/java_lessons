package animals;

import java.util.Random;

public class Cat extends Animal {

    private boolean full;
    private int needFood;

    public Cat(){
        super();
    }

    public Cat(String name){
        this(name, 200, 0);
    }

    public Cat(String name, int runningDistance, int swimmingDistance){
        super(name, runningDistance, swimmingDistance);
        Random random = new Random();
        this.needFood = random.nextInt(11) + 10;
    }

    public Cat(String name, int runningDistance, int swimmingDistance, int needFood){
        super(name, runningDistance, swimmingDistance);
        this.needFood = needFood;
    }

    /*@Override
    public void swim(int distance){
        System.out.println("Кошки не умеют плавать");
    }*/

    @Override
    public String toString(){
        return String.format("Имя: %s, вид: %s, допустимя дистанция передвижения: %s, допустимая дистанция плавания: %s, покормлен: %s, необходимо питания %s", this.name, "кот", this.runningDistance, this.swimmingDistance, this.full, this.needFood);
    }

    @Override
    public void print(){
        System.out.println(this.toString());
    }

    public int getNeedFood() {
        return this.needFood;
    }

    public boolean getFull(){
        return this.full;
    }

    public void feed(Plate plate){
        if (plate.takeFood(this.needFood)){
            System.out.printf("Кот %s покормлен %n", this.name);
            this.full = true;
        }
        else{
            System.out.printf("Кот %s не покормлен. Необходимо еды: %s %n", this.name, this.needFood);
        }
    }
}
