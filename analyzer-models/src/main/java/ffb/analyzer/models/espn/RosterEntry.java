package ffb.analyzer.models.espn;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ffb.analyzer.models.espn.Player.InjuryStatus;
import ffb.analyzer.models.espn.deserializers.EpochMillisecondDeserializer;
import java.time.LocalDate;

/**
 * Entity representing a single roster entity.
 */
public class RosterEntry extends EspnEntity<RosterEntry> {

    /**
     * Enum for how a player was obtained.
     */
    public enum AcquisitionType {
        DRAFT,
        TRADE
    }

    /**
     * Enum for the status of a roster.
     */
    public enum RosterStatus {
        NORMAL
    }

    private LocalDate acquisitionDate;
    private AcquisitionType acquisitionType;
    private InjuryStatus injuryStatus;
    private int lineupSlotId;
    private int playerId;
    private PlayerPoolEntry playerPoolEntry;
    private RosterStatus status;

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    @JsonDeserialize(using = EpochMillisecondDeserializer.class)
    public void setAcquisitionDate(LocalDate acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public AcquisitionType getAcquisitionType() {
        return acquisitionType;
    }

    public void setAcquisitionType(String acquisitionType) {
        this.acquisitionType = AcquisitionType.valueOf(acquisitionType);
    }

    public InjuryStatus getInjuryStatus() {
        return injuryStatus;
    }

    public void setInjuryStatus(String injuryStatus) {
        this.injuryStatus = InjuryStatus.valueOf(injuryStatus);
    }

    public int getLineupSlotId() {
        return lineupSlotId;
    }

    public void setLineupSlotId(int lineupSlotId) {
        this.lineupSlotId = lineupSlotId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public PlayerPoolEntry getPlayerPoolEntry() {
        return playerPoolEntry;
    }

    public void setPlayerPoolEntry(PlayerPoolEntry playerPoolEntry) {
        this.playerPoolEntry = playerPoolEntry;
    }

    public RosterStatus getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = RosterStatus.valueOf(status);
    }
}
