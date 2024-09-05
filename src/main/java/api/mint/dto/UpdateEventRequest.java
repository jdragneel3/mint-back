package api.mint.dto;

import api.mint.constant.EventType;
import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.serde.config.naming.SnakeCaseStrategy;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Serdeable(naming = SnakeCaseStrategy.class)
public class UpdateEventRequest {
    private Optional<Instant> startDate = Optional.empty();
    private Optional<Instant> endDate = Optional.empty();
    private Optional<EventType> eventType = Optional.empty();
    private Optional<String> description = Optional.empty();
    private Optional<UUID> instructorId = Optional.empty();

    public UpdateEventRequest() {
    }

    public UpdateEventRequest(Optional<Instant> startDate, Optional<Instant> endDate, Optional<EventType> eventType, Optional<String> description, Optional<UUID> instructorId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventType = eventType;
        this.description = description;
        this.instructorId = instructorId;
    }

    public Optional<Instant> getStartDate() {
        return startDate;
    }

    public void setStartDate(Optional<Instant> startDate) {
        this.startDate = startDate;
    }

    public Optional<Instant> getEndDate() {
        return endDate;
    }

    public void setEndDate(Optional<Instant> endDate) {
        this.endDate = endDate;
    }

    public Optional<EventType> getEventType() {
        return eventType;
    }

    public void setEventType(Optional<EventType> eventType) {
        this.eventType = eventType;
    }

    public Optional<String> getDescription() {
        return description;
    }

    public void setDescription(Optional<String> description) {
        this.description = description;
    }

    public Optional<UUID> getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Optional<UUID> instructorId) {
        this.instructorId = instructorId;
    }
}
