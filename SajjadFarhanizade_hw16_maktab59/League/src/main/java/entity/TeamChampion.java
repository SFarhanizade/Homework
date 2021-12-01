package entity;

public class TeamChampion {
    private Team team;
    private Integer points;

    public TeamChampion(Team team, Integer points) {
        this.team = team;
        this.points = points;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
