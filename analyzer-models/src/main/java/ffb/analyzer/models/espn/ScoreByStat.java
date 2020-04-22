package ffb.analyzer.models.espn;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ffb.analyzer.models.espn.serialization.ScoreByStatSerializer;

@JsonDeserialize(using = ScoreByStatSerializer.class)
public class ScoreByStat {
    private int id;
    private boolean ineligible;
    private double rank;
    private String result;
    private double score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIneligible() {
        return ineligible;
    }

    public void setIneligible(boolean ineligible) {
        this.ineligible = ineligible;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
