package api.mint.service;

import api.mint.dto.EventRequest;
import api.mint.dto.EventResponse;
import api.mint.dto.UpdateEventRequest;
import api.mint.mapper.EventMapper;
import api.mint.model.Event;
import api.mint.model.Instructor;
import api.mint.repository.EventRepository;
import api.mint.repository.InstructorRepository;
import jakarta.inject.Singleton;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
public class EventService {

    private final EventRepository eventRepository;
    private final InstructorRepository instructorRepository;

    public EventService(EventRepository eventRepository, InstructorRepository instructorRepository) {
        this.eventRepository = eventRepository;
        this.instructorRepository = instructorRepository;
    }

    public List<EventResponse> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(EventMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<EventResponse> findById(UUID id) {
        return eventRepository.findById(id)
                .map(EventMapper::toResponse);
    }

    public List<EventResponse> getEventsByInstructorId(UUID instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        return eventRepository.findByInstructor(instructor)
                .stream().map(EventMapper::toResponse)
                .collect(Collectors.toList());
    }

    public EventResponse save(EventRequest request) {
        Instructor instructor = instructorRepository.findById(request.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        Event event = EventMapper.toEntity(request, instructor);
        return EventMapper.toResponse(eventRepository.save(event));
    }

    public EventResponse updateEvent(UUID id, UpdateEventRequest request) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        request.getStartDate().ifPresent(event::setStartDate);
        request.getEndDate().ifPresent(event::setEndDate);
        request.getEventType().ifPresent(eventType -> event.setEventType(eventType.getValue()));
        request.getDescription().ifPresent(event::setDescription);

        if (request.getInstructorId().isPresent()) {
            Instructor instructor = instructorRepository.findById(request.getInstructorId().get())
                    .orElseThrow(() -> new RuntimeException("Instructor not found"));
            event.setInstructor(instructor);
        }

        return EventMapper.toResponse(event);
    }

    public void deleteEvent(UUID id) {
        eventRepository.deleteById(id);
    }
}
