package ffb.analyzer.models.espn;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entity to represent a team's roster.
 */
public class Roster extends EspnEntity<Roster> {

    private double appliedStatTotal;

    @JsonProperty("entries")
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

    public void setPlayers(List<RosterEntry> players) {
        this.players = players;
    }
}
