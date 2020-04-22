package ffb.analyzer.models.espn;

import java.util.List;

public class CumulativeScore {
    private int losses;
    private int ties;
    private int wins;
    List<ScoreByStat> scoreByStats;

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

    public List<ScoreByStat> getScoreByStats() {
        return scoreByStats;
    }

    public void setScoreByStats(List<ScoreByStat> scoreByStats) {
        this.scoreByStats = scoreByStats;
    }
}
