package animals;
import helpers.Helpers;

public abstract class Animal {
    protected String name;
    protected int runningDistance;
    protected int swimmingDistance;
    private static int createdAnimals = 0;

    public Animal(){
        createdAnimals++;
    }

    public Animal(String name, int runningDistance, int swimmingDistance){
        createdAnimals++;
        this.name = name;
        this.runningDistance = runningDistance;
        this.swimmingDistance = swimmingDistance;
    }

    public void run(int distance){
        if (this.runningDistance == 0){
            System.out.printf("%s не умеет бегать%n", this.name);
            return;
        }
        if (distance > this.runningDistance){
            System.out.printf("Дистанция слишком длинная для бега животного %s %n", this.name);
            return;
        }
        System.out.printf("%s пробежал(а) %s %s %n", this.name, distance, Helpers.pluralization(distance, Helpers.distanceWords));
    }
    public void swim(int distance){
        if (this.swimmingDistance == 0){
            System.out.printf("%s не умеет плавать%n", this.name);
            return;
        }
        if (distance > this.swimmingDistance){
            System.out.printf("Дистанция слишком длинная для плаванья животного %s %n", this.name);
            return;
        }
        System.out.printf("%s проплыл(а) %s %s %n", this.name, distance, Helpers.pluralization(distance, Helpers.distanceWords));
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunningDistance() {
        return this.runningDistance;
    }

    public void setRunningDistance(int runningDistance) {
        this.runningDistance = runningDistance;
    }

    public int getSwimmingDistance() {
        return this.swimmingDistance;
    }

    public void setSwimmingDistance(int swimmingDistance) {
        this.swimmingDistance = swimmingDistance;
    }

    public static int getCreatedAnimals(){
        return createdAnimals;
    }

    @Override
    public abstract String toString();

    public abstract void print();
}
