package factory;

import entities.Team;

public class TeamFactory {
    public static Team getInstance(String teamName) {
        return new Team(teamName);
    }
}
