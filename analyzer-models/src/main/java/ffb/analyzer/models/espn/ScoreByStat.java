package ffb.analyzer.models.espn;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ffb.analyzer.models.espn.serialization.ScoreByStatDeserializer;

@JsonDeserialize(using = ScoreByStatDeserializer.class)
public class ScoreByStat extends EspnEntity<ScoreByStat> {
    private int id;
    private boolean ineligible;
    private float rank;
    private float score;

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

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
