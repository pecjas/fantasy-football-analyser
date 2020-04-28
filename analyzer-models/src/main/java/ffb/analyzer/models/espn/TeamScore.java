package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/**
 * Entity representing a team's score.
 */
public class TeamScore extends EspnEntity<TeamScore> {
    private CumulativeScore cumulativeScore;
    private int gamesPlayed;
    private int teamId;

    @JsonProperty("totalPoints")
    private double points;

    @JsonProperty("pointsByScoringPeriod")
    private Map<Integer, Double> scores;

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

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Map<Integer, Double> getScores() {
        return scores;
    }

    public void setScores(Map<Integer, Double> scores) {
        this.scores = scores;
    }
}
