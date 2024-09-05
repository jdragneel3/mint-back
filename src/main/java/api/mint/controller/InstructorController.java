package api.mint.controller;

import api.mint.dto.InstructorRequest;
import api.mint.dto.InstructorResponse;
import api.mint.dto.UpdateInstructorRequest;
import api.mint.service.InstructorService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Patch;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @Inject
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @Get
    public List<InstructorResponse> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @Get("/{id}")
    public HttpResponse<InstructorResponse> getInstructorById(@PathVariable UUID id) {
        Optional<InstructorResponse> instructor = instructorService.findById(id);
        return instructor.map(HttpResponse::ok)
                .orElse(HttpResponse.notFound());
    }

    @Post
    public HttpResponse<InstructorResponse> createInstructor(@Body InstructorRequest request) {
        InstructorResponse instructor = instructorService.save(request);
        return HttpResponse.created(instructor);
    }

    @Patch("/{id}")
    public HttpResponse<InstructorResponse> updateInstructor(@PathVariable UUID id, @Body UpdateInstructorRequest request) {
        InstructorResponse updatedInstructor = instructorService.updateInstructor(id, request);
        return HttpResponse.ok(updatedInstructor);
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteInstructor(@PathVariable UUID id) {
        instructorService.deleteInstructor(id);
        return HttpResponse.noContent();
    }
}
