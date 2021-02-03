import Course.Course;
import Course.RunningCourse;
import Course.SwimmingCourse;
import Team.Team;
import Teammate.Teammate;

public class Ninth {
    public static void main(String[] args) {
        doTask();
    }

    private static void  doTask(){
        Course runningCourse = new RunningCourse(60);
        Course swimmingCourse = new SwimmingCourse(10);

        Team team = new Team(
                "Команда синих",
                new Teammate("Вася", 100, 15),
                new Teammate("Лена", 40, 5),
                new Teammate("Василиса", 80, 10),
                new Teammate("Илья")
                );

        team.printTeammates();

        System.out.println();
        System.out.println("Проходим беговую дистанцию");
        System.out.println();
        runningCourse.doIt(team);
        team.printSuccessfulTeammates();

        System.out.println();
        System.out.println("Проходим плавательную дистанцию");
        System.out.println();
        swimmingCourse.doIt(team);
        team.printSuccessfulTeammates();
    }
}
