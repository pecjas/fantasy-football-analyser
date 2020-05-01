package ffb.analyzer.models.espn;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ffb.analyzer.models.espn.deserializers.ScoresByStatDeserializer;


/**
 * Entity representing the cumulative score for a match up.
 */
public class CumulativeScore extends EspnEntity<CumulativeScore> {
    private int losses;
    private int ties;
    private int wins;

    @JsonProperty("scoreByStat")
    List<ScoreByStat> scoresByStats;

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

    public List<ScoreByStat> getScoresByStats() {
        return scoresByStats;
    }

    @JsonDeserialize(using = ScoresByStatDeserializer.class)
    public void setScoresByStats(List<ScoreByStat>  scoresByStats) {
        this.scoresByStats = scoresByStats;
    }
}
