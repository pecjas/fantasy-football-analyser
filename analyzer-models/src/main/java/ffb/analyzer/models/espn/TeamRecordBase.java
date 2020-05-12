package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;

abstract class TeamRecordBase<T extends TeamRecordBase<T>> extends EspnEntity<T> {
    public enum StreakType {
        WIN,
        LOSS,
        TIE,
        NONE
    }

    private int wins;
    private int losses;
    private int ties;
    private float winPercentage;

    private int gamesBack;

    private int streakLength;
    private StreakType streakType;

    public float getWinPercentage() {
        if (winPercentage == 0.0f) {
            calculateWinPercentage();
        }

        return winPercentage;
    }

    private void calculateWinPercentage() {
        winPercentage = (float) wins / (float) getCountGamesPlayed();
    }

    public int getCountGamesPlayed() {
        return (wins + losses + ties);
    }


    public int getWins() {
        return wins;
    }
    public void setWins(int wins) {
        this.wins = wins;
        calculateWinPercentage();
    }

    public int getLosses() {
        return losses;
    }
    public void setLosses(int losses) {
        this.losses = losses;
        calculateWinPercentage();
    }

    public int getTies() {
        return ties;
    }
    public void setTies(int ties) {
        this.ties = ties;
        calculateWinPercentage();
    }

    public int getGamesBack() {
        return gamesBack;
    }
    public void setGamesBack(int gamesBack) {
        this.gamesBack = gamesBack;
    }

    public int getStreakLength() {
        return streakLength;
    }
    public void setStreakLength(int streakLength) {
        this.streakLength = streakLength;
    }

    public StreakType getStreakType() {
        return streakType;
    }
    public void setStreakType(StreakType streakType) {
        this.streakType = streakType;
    }
}
