package entities;

import java.util.Comparator;

public class Team implements Comparable<Team> {
    private String name;
    private int point;

    public Team(String name) {
        this.name = name;
        point=0;
    }

    public String getName() {
        return name;
    }

    public void addPoint(){
        point++;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Team team) {
        return team.point - point;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Team)) return false;
        Team team=(Team) obj;

        return team.name.equals(name);
    }
}
