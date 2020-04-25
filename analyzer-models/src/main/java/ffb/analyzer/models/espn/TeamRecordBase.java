package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class TeamRecordBase {
    public enum StreakType {
        WIN,
        LOSS,
        TIE,
        NONE
    }

    private int wins;
    private int losses;
    private int ties;

    private int gamesBack;

    @JsonProperty("percentage")
    private float winPercentage;

    private int streakLength;
    private StreakType streakType;


    public int getWins() { return wins; }
    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() { return losses; }
    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() { return ties; }
    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getGamesBack() { return gamesBack; }
    public void setGamesBack(int gamesBack) {
        this.gamesBack = gamesBack;
    }

    public float getWinPercentage() { return winPercentage; }
    public void setWinPercentage(float winPercentage) {
        this.winPercentage = winPercentage;
    }

    public int getStreakLength() { return streakLength; }
    public void setStreakLength(int streakLength) {
        this.streakLength = streakLength;
    }

    public StreakType getStreakType() { return streakType; }
    public void setStreakType(StreakType streakType) {
        this.streakType = streakType;
    }
}
