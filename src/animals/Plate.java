package animals;

public class Plate {
    private int foodCnt;

    public Plate(){}

    public Plate(int foodCnt){
        this.foodCnt = foodCnt;
    }

    public int getFoodCnt() {
        return foodCnt;
    }

    public void setFoodCnt(int foodCnt) {
        if (foodCnt < 0){
            System.out.println("Нельзя положить в тарелку отрицательное число еды");
            return;
        }
        this.foodCnt = foodCnt;
    }

    public void addFood(int foodCnt){
        if (foodCnt < 0){
            System.out.println("Нельзя добавить в тарелку отрицательное число еды");
            return;
        }
        this.foodCnt += foodCnt;
        System.out.printf("Тарелка пополнена, новое кол-во еды: %s %n", this.foodCnt);
    }

    @Override
    public String toString(){
        return String.format("Тарелка с едой, кол-во еды: %s", this.foodCnt);
    }

    public void print(){
        System.out.println(this.toString());
    }

    public boolean takeFood(int foodCnt){
        if (foodCnt < 0){
            System.out.println("Нельзя взять из тарелки отрицательное число еды");
            return false;
        }
        if ((this.foodCnt - foodCnt) < 0){
            System.out.printf("В тарелке недостаточно еды. Текущее кол-во еды: %s %n", this.foodCnt);
            return false;
        }
        this.foodCnt -= foodCnt;
        System.out.printf("Из тарелки взята еда. Текущее кол-во еды: %s %n", this.foodCnt);
        return true;
    }

}
