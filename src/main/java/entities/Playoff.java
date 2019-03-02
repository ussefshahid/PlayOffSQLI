package entities;

import utils.Parser;

import java.util.*;

public class Playoff {
    private List<Team> teams=new ArrayList<Team>();

    public Playoff(String[] qualificationsResults) {
        for (String qualificationsResult : qualificationsResults) {
            analyseTheMatch(qualificationsResult);
        }
    }

    public String[] layout() {
        sortTheTeamByPoints();

        String playoffMatches=teams.get(0)+" vs "+teams.get(3)+"/"+teams.get(1)+" vs "+teams.get(2);
        return playoffMatches.split("/");
    }

    private void analyseTheMatch(String qualificationsResult){
        Team[] _2teams= Parser.stringToTeams(qualificationsResult);

        increaseWinnerPoints(_2teams[0]);
        addIfNotExistAndReturnIfExist(_2teams[1]);
    }

    private void increaseWinnerPoints(Team winnerTeam){
        winnerTeam = addIfNotExistAndReturnIfExist(winnerTeam);
        winnerTeam.addPoint();
    }

    private Team addIfNotExistAndReturnIfExist(Team team){
        if(!teams.contains(team)){
            teams.add(team); return team;
        }

        return getByName(team.getName()).get();
    }

    private void sortTheTeamByPoints(){
        Collections.sort(teams);
    }

    private Optional<Team> getByName(String teamName){
        return teams.stream()
                .filter(team -> team.getName().equals(teamName))
                .findAny();
    }
}
