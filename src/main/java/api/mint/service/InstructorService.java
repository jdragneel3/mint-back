package api.mint.service;

import api.mint.dto.InstructorRequest;
import api.mint.dto.InstructorResponse;
import api.mint.dto.UpdateInstructorRequest;
import api.mint.mapper.InstructorMapper;
import api.mint.model.Instructor;
import api.mint.model.Organization;
import api.mint.repository.InstructorRepository;
import api.mint.repository.OrganizationRepository;
import jakarta.inject.Singleton;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final OrganizationRepository organizationRepository;

    public InstructorService(InstructorRepository instructorRepository, OrganizationRepository organizationRepository) {
        this.instructorRepository = instructorRepository;
        this.organizationRepository = organizationRepository;
    }

    public List<InstructorResponse> getAllInstructors() {
        return instructorRepository.findAll().stream()
                .map(InstructorMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<InstructorResponse> findById(UUID id) {
        return instructorRepository.findById(id)
                .map(InstructorMapper::toResponse);
    }

    public InstructorResponse save(InstructorRequest request) {
        Organization organization = organizationRepository.findById(request.getOrganizationId())
                .orElseThrow(() -> new RuntimeException("Organization not found"));
        Instructor instructor = InstructorMapper.toEntity(request, organization);
        return InstructorMapper.toResponse(instructorRepository.save(instructor));
    }

    public InstructorResponse updateInstructor(UUID id, UpdateInstructorRequest request) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        request.getFirstName().ifPresent(instructor::setFirstName);
        request.getLastName().ifPresent(instructor::setLastName);
        request.getBirthDate().ifPresent(instructor::setBirthDate);
        request.getOrganizationId().ifPresent(organizationId -> {
            Organization organization = organizationRepository.findById(organizationId)
                    .orElseThrow(() -> new RuntimeException("Organization not found"));
            instructor.setOrganization(organization);
        });

        return InstructorMapper.toResponse(instructor);
    }

    public void deleteInstructor(UUID id) {
        instructorRepository.deleteById(id);
    }
}
