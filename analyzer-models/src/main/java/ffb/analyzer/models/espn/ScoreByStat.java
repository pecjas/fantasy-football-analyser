package ffb.analyzer.models.espn;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ffb.analyzer.models.espn.deserializers.ScoreByStatDeserializer;

/**
 * Entity representing the score by stat id.
 */
@JsonDeserialize(using = ScoreByStatDeserializer.class)
public class ScoreByStat extends EspnEntity<ScoreByStat> {
    private int id;
    private boolean ineligible;
    private double rank;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
