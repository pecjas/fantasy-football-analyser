package ffb.analyzer.models.espn;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entity representing a team's score.
 */
public class TeamScore extends EspnEntity<TeamScore> {
    private CumulativeScore cumulativeScore;
    private int gamesPlayed;
    private int teamId;

    @JsonProperty("pointsByScoringPeriod")
    private Map<Integer, Float> scores;

    @JsonIgnore
    private float totalPointsScored;

    public float getTotalPointsScored() {
        if (totalPointsScored == 0.0f) {
            calculateTotalPointsScored();
        }

        return totalPointsScored;
    }

    private void calculateTotalPointsScored() {
        totalPointsScored = scores.values().stream().reduce(0f, Float::sum);
    }

    public CumulativeScore getCumulativeScore() {
        return cumulativeScore;
    }

    public void setCumulativeScore(CumulativeScore cumulativeScore) {
        this.cumulativeScore = cumulativeScore;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Map<Integer, Float> getScores() {
        return scores;
    }

    public void setScores(Map<Integer, Float> scores) {
        this.scores = scores;
        calculateTotalPointsScored();
    }
}
