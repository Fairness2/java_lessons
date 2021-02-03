package Course;

import Team.Team;

public class SwimmingCourse extends Course {

    public SwimmingCourse(int distance){
        super(distance);
    }

    @Override
    public void doIt(Team team){
        team.swimDistance(distance);
    }
}
