package Teammate;

public class Teammate implements TeammateInterface {
    private final String name;
    private int runningStamina;
    private int swimmingStamina;
    private boolean closeDistance;

    public Teammate(String name){
        this(name, 50, 10);
    }

    public Teammate(String name, int runningStamina, int swimmingStamina){
        this.name = name;
        this.runningStamina = runningStamina;
        this.swimmingStamina = swimmingStamina;
    }

    @Override
    public boolean run(int distance) {
        closeDistance = runningStamina >= distance;
        return closeDistance;
    }

    @Override
    public boolean swim(int distance) {
        closeDistance = swimmingStamina >= distance;
        return closeDistance;
    }

    @Override
    public boolean getCloseDistance() {
        return closeDistance;
    }

    @Override
    public void setCloseDistance(boolean closeDistance) {
        this.closeDistance = closeDistance;
    }

    @Override
    public String toString(){
        return String.format("Имя: %s, прошёл дистандцию: %s", name, closeDistance ? "да" : "нет");
    }
}
