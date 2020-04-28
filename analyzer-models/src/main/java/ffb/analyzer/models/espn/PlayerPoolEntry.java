package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.List;
import java.util.Map;

/**
 * Entity representing an entry in a player pool.
 */
public class PlayerPoolEntry extends EspnEntity<PlayerPoolEntry> {

    public enum PlayerStatus {
        ON_TEAM;

        private static final Map<String, PlayerStatus> PLAYER_STATUS_BY_NAME = Map.ofEntries(
            new SimpleImmutableEntry<>("ONTEAM", ON_TEAM),
            new SimpleImmutableEntry<>("ON_TEAM", ON_TEAM)
        );

        /**
         * Converts synonyms of a {@link PlayerStatus} to that {@link PlayerStatus}.
         * @param value String representation of the {@link PlayerStatus}.
         * @return {@link PlayerStatus}.
         */
        public static PlayerStatus fromString(String value) {
            return PLAYER_STATUS_BY_NAME.get(value);
        }
    }

    private double appliedStatTotal;
    private int id;
    private int teamId;
    private List<Player> players;
    private boolean lineupLocked;
    private boolean rosterLocked;
    private PlayerStatus status;
    private boolean tradeLocked;

    public double getAppliedStatTotal() {
        return appliedStatTotal;
    }

    public void setAppliedStatTotal(double appliedStatTotal) {
        this.appliedStatTotal = appliedStatTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamId() {
        return teamId;
    }

    @JsonProperty("onTeamId")
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public boolean isLineupLocked() {
        return lineupLocked;
    }

    public void setLineupLocked(boolean locked) {
        this.lineupLocked = locked;
    }

    public boolean isRosterLocked() {
        return rosterLocked;
    }

    public void setRosterLocked(boolean rosterLocked) {
        this.rosterLocked = rosterLocked;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = PlayerStatus.fromString(status);
    }

    public boolean isTradeLocked() {
        return tradeLocked;
    }

    public void setTradeLocked(boolean tradeLocked) {
        this.tradeLocked = tradeLocked;
    }
}
