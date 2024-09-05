package api.mint.controller;

import api.mint.dto.*;
import api.mint.service.OrganizationService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.annotation.Delete;
import jakarta.inject.Inject;
import java.util.List;
import java.util.UUID;

@Controller("/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Inject
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Get("/")
    public List<OrganizationResponse> listAll() {
        return organizationService.listAll();
    }

    @Get("/{id}")
    public HttpResponse<OrganizationResponse> findById(UUID id) {
        return organizationService.findById(id)
                .map(HttpResponse::ok)
                .orElse(HttpResponse.notFound());
    }

    @Post("/")
    public HttpResponse<OrganizationResponse> create(@Body OrganizationRequest request) {
        OrganizationResponse savedOrganization = organizationService.save(request);
        return HttpResponse.created(savedOrganization);
    }

    @Delete("/{id}")
    public HttpResponse delete(UUID id) {
        organizationService.delete(id);
        return HttpResponse.noContent();
    }

    @Patch("/{id}")
    public HttpResponse<OrganizationResponse> update(@PathVariable UUID id, @Body UpdateOrganizationRequest request) {
        OrganizationResponse updatedOrganization = organizationService.update(id, request);
        return HttpResponse.ok(updatedOrganization);
    }
}
