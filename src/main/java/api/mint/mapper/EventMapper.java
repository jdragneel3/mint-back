package api.mint.mapper;

import api.mint.constant.EventType;
import api.mint.dto.EventRequest;
import api.mint.dto.EventResponse;
import api.mint.model.Event;
import api.mint.model.Instructor;
import java.time.Duration;

public class EventMapper {

    public static Event toEntity(EventRequest request, Instructor instructor) {
        Event event = new Event();
        event.setStartDate(request.getStartDate());
        event.setEndDate(request.getEndDate());
        event.setEventType(request.getEventType().getValue());
        event.setDescription(request.getDescription());
        event.setInstructor(instructor);

        return event;
    }

    public static EventResponse toResponse(Event event) {
        EventResponse response = new EventResponse();
        response.setId(event.getId());
        response.setStartDate(event.getStartDate());
        response.setEndDate(event.getEndDate());
        response.setEventType(EventType.valueOf(event.getEventType()));
        response.setDescription(event.getDescription());
        response.setInstructorId(event.getInstructor().getId());
        response.setInstructorName(event.getInstructor().getFirstName() + " " + event.getInstructor().getLastName());
        response.setDurationInDays(Duration.between(event.getStartDate(), event.getEndDate()).toDays() + 1);

        return response;
    }
}
