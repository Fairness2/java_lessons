import animals.*;
import helpers.Helpers;

public class Sixth {
    public static void main(String[] args) {
        //doTask();
        doTask98019();

    }

    private static void doTask(){
        AnimalGroup animalGroup1 = new AnimalGroup();
        printCountAnimals(animalGroup1);
        Animal[] animals = {
                animalGroup1.createCat("Барсик"),
                animalGroup1.createCat("Суперкот", 500, 10),
                animalGroup1.createDog("Шарик"),
                animalGroup1.createDog("Старый пират", 250, 0),
        };
        printCountAnimals(animalGroup1);
        printAnimals(animals);
        moveAllAnimalsWithRunning(animals, 100);
        moveAllAnimalsWithSwimming(animals, 10);
    }

    private static void printCountAnimals(AnimalGroup animalGroup1){
        System.out.println("Создано:");
        System.out.printf("Создано животных: %s %n", animalGroup1.getAnimalCnt());
        System.out.printf("Создано котов: %s %n", animalGroup1.getCatCnt());
        System.out.printf("Создано псов: %s %n", animalGroup1.getDogCnt());
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

    private static void doTask98019(){
        AnimalGroup animalGroup1 = new AnimalGroup();
        Cat[] cats = {
                animalGroup1.createCat("Барсик"),
                animalGroup1.createCat("Мурка"),
                animalGroup1.createCat("Мурзик"),
                animalGroup1.createCat("Старый пират"),
        };
        printAnimals(cats);
        Plate plate = new Plate(50);
        plate.print();
        feedCats(cats, plate);
        printAnimals(cats);
        plate.print();
        plate.addFood(50);
        feedCats(cats, plate);
        printAnimals(cats);
        plate.print();
    }

    private static void feedCats(Cat[] cats, Plate plate){
        for (Cat cat: cats) {
            if (!cat.getFull()) {
                cat.feed(plate);
            }
        }
    }


}
