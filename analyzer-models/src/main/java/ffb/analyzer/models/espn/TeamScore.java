package ffb.analyzer.models.espn;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamScore extends EspnEntity<TeamScore> {
    private CumulativeScore cumulativeScore;
    private int gamesPlayed;
    private int teamId;

    @JsonProperty("totalPoints")
    private float points;

    @JsonProperty("pointsByScoringPeriod")
    private Map<Integer, Float> scores;

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

    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
        this.points = points;
    }

    public Map<Integer, Float> getScores() {
        return scores;
    }

    public void setScores(Map<Integer, Float> scores) {
        this.scores = scores;
    }
}
