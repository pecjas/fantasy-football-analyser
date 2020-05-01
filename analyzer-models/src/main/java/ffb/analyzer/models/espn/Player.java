package ffb.analyzer.models.espn;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ffb.analyzer.models.espn.deserializers.PlayerRankingsDeserializer;



/**
 * Entity representing a player.
 */
public class Player extends EspnEntity<Player> {

    /**
     * Enum for a player's position.
     */
    public enum Position {
        QB(1),
        RB(2),
        WR(3),
        TE(4),
        K(5),
        DEFENSE(16);

        private static final Map<Integer, Position> POSITION_BY_ID;

        static {
            POSITION_BY_ID = List.of(Position.values())
                .stream()
                .collect(Collectors.toMap(Position::getValue, Function.identity()));
        }

        private final int id;

        public static Position valueOf(int positionId) {
            return POSITION_BY_ID.get(positionId);
        }

        Position(Integer id) {
            this.id = id;
        }

        public int getValue() {
            return id;
        }
    }

    /**
     * Enum for a player's injury status.
     */
    public enum InjuryStatus {
        NORMAL,
        ACTIVE,
        QUESTIONABLE,
        OUT,
        DOUBTFUL
    }

    private List<Integer> eligibleSlots;
    private String firstName;
    private String lastName;
    private int id;
    private InjuryStatus injuryStatus;
    private int proTeamId;
    private List<PlayerRanking> rankings;

    @JsonProperty("defaultPositionId")
    private Position position;

    @JsonProperty("droppable")
    private boolean isDroppable;

    @JsonProperty("active")
    private boolean isActive;

    @JsonProperty("injured")
    private boolean isInjured;

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        this.isActive = active;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = Position.valueOf(position);
    }

    public boolean isDroppable() {
        return isDroppable;
    }

    public void setDroppable(boolean droppable) {
        this.isDroppable = droppable;
    }

    public List<Integer> getEligibleSlots() {
        return eligibleSlots;
    }

    public void setEligibleSlots(List<Integer> eligibleStats) {
        this.eligibleSlots = eligibleStats;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInjured() {
        return isInjured;
    }

    public void setIsInjured(boolean injured) {
        this.isInjured = injured;
    }

    public InjuryStatus getInjuryStatus() {
        return injuryStatus;
    }

    public void setInjuryStatus(InjuryStatus status) {
        this.injuryStatus = status;
    }

    public int getProTeamId() {
        return proTeamId;
    }

    public void setProTeamId(int proTeamId) {
        this.proTeamId = proTeamId;
    }

    public List<PlayerRanking> getRankings() {
        return rankings;
    }

    @JsonDeserialize(using = PlayerRankingsDeserializer.class)
    public void setRankings(List<PlayerRanking> rankings) {
        this.rankings = rankings;
    }
}
