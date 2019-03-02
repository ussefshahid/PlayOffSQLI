package utils;

import entities.Team;
import factory.TeamFactory;

public class Parser {
    private static final String splitChar=" ";

    public static Team[] stringToTeams(String _2teams){
        Team[] teams=new Team[2];
        String[] teamsNames=_2teams.split(splitChar);

        teams[0] = TeamFactory.getInstance(teamsNames[0]);
        teams[1] = TeamFactory.getInstance(teamsNames[1]);

        return teams;
    }
}
