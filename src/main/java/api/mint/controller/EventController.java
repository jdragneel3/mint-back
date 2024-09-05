package api.mint.controller;

import api.mint.dto.EventRequest;
import api.mint.dto.EventResponse;
import api.mint.dto.UpdateEventRequest;
import api.mint.service.EventService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @Get("/")
    public HttpResponse<List<EventResponse>> getAllEvents() {
        List<EventResponse> response =  eventService.getAllEvents();
        return HttpResponse.ok(response);
    }

    @Get("/{id}")
    public HttpResponse<EventResponse> getEventById(@PathVariable UUID id) {
        return eventService.findById(id)
                .map(HttpResponse::ok)
                .orElse(HttpResponse.notFound());
    }

    @Get("/instructor/{id}")
    public HttpResponse<List<EventResponse>> getEventByInstructorId(@PathVariable UUID id) {
        List<EventResponse> response =  eventService.getEventsByInstructorId(id);
        return HttpResponse.ok(response);
    }

    @Post("/")
    public HttpResponse<EventResponse> createEvent(@Body EventRequest request) {
        EventResponse eventResponse = eventService.save(request);
        return HttpResponse.created(eventResponse);
    }

    @Patch("/{id}")
    public HttpResponse<EventResponse> updateEvent(@PathVariable UUID id, @Body UpdateEventRequest request) {
        EventResponse eventResponse = eventService.updateEvent(id, request);
        return HttpResponse.ok(eventResponse);
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteEvent(@PathVariable UUID id) {
        eventService.deleteEvent(id);
        return HttpResponse.noContent();
    }
}
