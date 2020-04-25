package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CumulativeScore extends EspnEntity<CumulativeScore> {
    private int losses;
    private int ties;
    private int wins;

    @JsonProperty("scoreByStat")
    ScoresByStats scoresByStats;

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public ScoresByStats getScoresByStats() {
        return scoresByStats;
    }

    public void setScoresByStats(ScoresByStats scoresByStats) {
        this.scoresByStats = scoresByStats;
    }
}
