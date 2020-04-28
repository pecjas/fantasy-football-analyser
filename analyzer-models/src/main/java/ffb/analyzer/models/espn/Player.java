package ffb.analyzer.models.espn;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ffb.analyzer.models.espn.deserializers.PlayerRankingsDeserializer;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Player extends EspnEntity<Player> {

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

    public enum InjuryStatus {
        NORMAL,
        ACTIVE,
        QUESTIONABLE,
        OUT,
        DOUBTFUL
    }

    private boolean active;
    private Position position;
    private boolean droppable;
    private List<Integer> eligibleSlots;
    private String firstName;
    private String fullName;
    private String lastName;
    private int id;
    private boolean injured;
    private InjuryStatus status;
    private int proTeamId;
    private List<PlayerRanking> rankings;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Position getPosition() {
        return position;
    }

    @JsonProperty("defaultPositionId")
    public void setPosition(int position) {
        this.position = Position.valueOf(position);
    }

    public boolean isDroppable() {
        return droppable;
    }

    public void setDroppable(boolean droppable) {
        this.droppable = droppable;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInjured() {
        return injured;
    }

    public void setInjured(boolean injured) {
        this.injured = injured;
    }

    public InjuryStatus getStatus() {
        return status;
    }

    @JsonProperty("injuryStatus")
    public void setStatus(String status) {
        this.status = InjuryStatus.valueOf(status);
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
