package api.mint.dto;

import api.mint.constant.EventType;
import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.serde.config.naming.SnakeCaseStrategy;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Serdeable(naming = SnakeCaseStrategy.class)
public class EventResponse {
    private UUID id;
    private Instant startDate;
    private Instant endDate;
    private EventType eventType;
    private String description;
    private UUID instructorId;
    private String instructorName;
    private long durationInDays;

    public EventResponse() {
    }

    public EventResponse(UUID id, Instant startDate, Instant endDate, EventType eventType, String description, UUID instructorId, String instructorName) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventType = eventType;
        this.description = description;
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.durationInDays = ChronoUnit.DAYS.between(startDate, endDate);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(UUID instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public long getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(long durationInDays) {
        this.durationInDays = durationInDays;
    }
}
