package Course;

import Team.Team;

public class RunningCourse extends Course {

    public RunningCourse(int distance){
        super(distance);
    }

    @Override
    public void doIt(Team team){
        team.runDistance(distance);
    }
}
