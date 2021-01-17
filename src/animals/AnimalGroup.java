package animals;

public class AnimalGroup {
    private int catCnt;
    private int dogCnt;

    public Cat createCat(){
        this.catCnt++;
        return new Cat();
    }

    public Cat createCat(String name){
        this.catCnt++;
        return new Cat(name);
    }

    public Cat createCat(String name, int runningDistance, int swimmingDistance){
        this.catCnt++;
        return new Cat(name, runningDistance, swimmingDistance);
    }

    public Dog createDog(){
        this.dogCnt++;
        return new Dog();
    }

    public Dog createDog(String name){
        this.dogCnt++;
        return new Dog(name);
    }

    public Dog createDog(String name, int runningDistance, int swimmingDistance){
        this.dogCnt++;
        return new Dog(name, runningDistance, swimmingDistance);
    }

    public int getCatCnt() {
        return this.catCnt;
    }

    public int getDogCnt() {
        return this.dogCnt;
    }

    public int getAnimalCnt() {
        return this.dogCnt + this.catCnt;
    }



}
