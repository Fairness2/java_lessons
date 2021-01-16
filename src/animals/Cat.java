package animals;

public class Cat extends Animal {

    private static int createdCats = 0;

    public Cat(){
        super();
        createdCats++;
    }

    public Cat(String name){
        super(name, 200, 0);
        createdCats++;
    }

    public Cat(String name, int runningDistance, int swimmingDistance){
        super(name, runningDistance, swimmingDistance);
        createdCats++;
    }

    /*@Override
    public void swim(int distance){
        System.out.println("Кошки не умеют плавать");
    }*/

    @Override
    public String toString(){
        return String.format("Имя: %s, вид: %s, допустимя дистанция передвижения: %s, допустимая дистанция плавания: %s", this.name, "кот", this.runningDistance, this.swimmingDistance);
    }

    @Override
    public void print(){
        System.out.println(this.toString());
    }

    public static int getCreatedCats(){
        return createdCats;
    }
}
