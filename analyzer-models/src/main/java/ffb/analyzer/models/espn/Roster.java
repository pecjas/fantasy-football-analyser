package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Entity to represent a team's roster.
 */
public class Roster extends EspnEntity<Roster> {

    private double appliedStatTotal;
    private List<RosterEntry> players;

    public double getAppliedStatTotal() {
        return appliedStatTotal;
    }

    public void setAppliedStatTotal(double appliedStatTotal) {
        this.appliedStatTotal = appliedStatTotal;
    }

    public List<RosterEntry> getPlayers() {
        return players;
    }

    @JsonProperty("entries")
    public void setPlayers(List<RosterEntry> players) {
        this.players = players;
    }
}
