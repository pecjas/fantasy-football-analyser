package ffb.analyzer.models;

import ffb.analyzer.models.espn.SeasonMatchups;

public class Matchup {

    public enum GameType {
        REGULAR,
        PLAYOFF;

        static GameType fromWeek(int week) {
            return week < 14 ? REGULAR : PLAYOFF;
        }
    }

    private int weekId;
    private int year;
    private int homeTeamId;
    private int homeTeamPoints;
    private int awayTeamId;
    private int awayTeamPoints;
    private GameType type;

    public static Matchup fromDTO(SeasonMatchups dto) {
        return new Matchup();
    }


    public int getWeekId() {
        return weekId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
        setGameType(weekId);
    }

    public String getGameType() {
        return type.toString();
    }

    private void setGameType(int week) {
        this.type = GameType.fromWeek(week);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public int getHomeTeamPoints() {
        return homeTeamPoints;
    }

    public void setHomeTeamPoints(int homeTeamPoints) {
        this.homeTeamPoints = homeTeamPoints;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public int getAwayTeamPoints() {
        return awayTeamPoints;
    }

    public void setAwayTeamPoints(int awayTeamPoints) {
        this.awayTeamPoints = awayTeamPoints;
    }

}
