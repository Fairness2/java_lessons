package animals;

public class Dog extends Animal {

    public Dog(){
        super();
    }

    public Dog(String name){
        super(name, 500, 10);
    }

    public Dog(String name, int runningDistance, int swimmingDistance){
        super(name, runningDistance, swimmingDistance);
    }

    @Override
    public String toString(){
        return String.format("Имя: %s, вид: %s, допустимя дистанция передвижения: %s, допустимая дистанция плавания: %s", this.name, "пёс", this.runningDistance, this.swimmingDistance);
    }

    @Override
    public void print(){
        System.out.println(this.toString());
    }

}
