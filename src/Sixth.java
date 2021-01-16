import animals.*;
import helpers.Helpers;

public class Sixth {
    public static void main(String[] args) {
        doTask();
    }

    private static void doTask(){
        printCountAnimals();
        Animal[] animals = {
                new Cat("Барсик"),
                new Cat("Суперкот", 500, 10),
                new Dog("Шарик"),
                new Dog("Старый пират", 250, 0),
        };
        printCountAnimals();
        printAnimals(animals);
        moveAllAnimalsWithRunning(animals, 100);
        moveAllAnimalsWithSwimming(animals, 10);
    }

    private static void printCountAnimals(){
        System.out.println("Создано:");
        System.out.printf("Создано животных: %s %n", Animal.getCreatedAnimals());
        System.out.printf("Создано котов: %s %n", Cat.getCreatedCats());
        System.out.printf("Создано псов: %s %n", Dog.getCreatedDogs());
    }

    private static void printAnimals(Animal[] animals){
        System.out.println("Все животные:");
        for (Animal animal: animals) {
            System.out.println(animal);
        }
    }

    private static void moveAllAnimalsWithRunning(Animal[] animals, int distance){
        System.out.printf("Пройти всеми %s %s %n", distance, Helpers.pluralization(distance, Helpers.distanceWords));
        for (Animal animal: animals) {
            animal.run(distance);
        }
    }

    private static void moveAllAnimalsWithSwimming(Animal[] animals, int distance){
        System.out.printf("Проплыть всеми %s %s %n", distance, Helpers.pluralization(distance, Helpers.distanceWords));
        for (Animal animal: animals) {
            animal.swim(distance);
        }
    }


}
