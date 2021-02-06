package Team;


import Teammate.Teammate;

public class Team implements TeamInterface {
    private final String name;
    private Teammate[] teammates;

    public Team(String name){
        this(name, new Teammate("Teammate #1"), new Teammate("Teammate #2"), new Teammate("Teammate #3"), new Teammate("Teammate #4"));
    }

    public Team(String name, Teammate ... teammates){
        this.name = name;
        this.teammates = teammates;
    }

    @Override
    public void runDistance(int distance){
        for (Teammate teammate: teammates) {
            teammate.setCloseDistance(false); // обнуляем тимейта, так как он мог пройти какую-то дистанцию перед этим
            teammate.run(distance);
        }
    }

    @Override
    public void swimDistance(int distance){
        for (Teammate teammate: teammates) {
            teammate.setCloseDistance(false);
            teammate.swim(distance);
        }
    }

    @Override
    public void printTeammates(){
        System.out.printf("Участники команды \"%s\": %n", name);
        for (Teammate teammate: teammates) {
            System.out.println(teammate.toString());
        }
    }

    @Override
    public void printSuccessfulTeammates(){
        System.out.printf("Участники команды \"%s\", которые прошли испытание: %n", name);
        for (Teammate teammate: teammates) {
            if (teammate.getCloseDistance()){
                System.out.println(teammate.toString());
            }
        }
    }
}
