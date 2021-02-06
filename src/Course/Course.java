package Course;

import Team.Team;

public abstract class Course implements CourseInterface {
    protected final int distance;

    public Course(int distance){
        this.distance = distance;
    }

    @Override
    public abstract void doIt(Team team);
}
