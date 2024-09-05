package api.mint.service;

import api.mint.dto.OrganizationRequest;
import api.mint.dto.OrganizationResponse;
import api.mint.dto.UpdateOrganizationRequest;
import api.mint.mapper.OrganizationMapper;
import api.mint.model.Organization;
import api.mint.repository.OrganizationRepository;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<OrganizationResponse> listAll() {
        return organizationRepository.findAll().stream()
                .map(OrganizationMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<OrganizationResponse> findById(UUID id) {
        return organizationRepository.findById(id)
                .map(OrganizationMapper::toResponse);
    }

    @Transactional
    public OrganizationResponse save(OrganizationRequest request) {
        Organization organization = OrganizationMapper.toEntity(request);
        return OrganizationMapper.toResponse(organizationRepository.save(organization));
    }

    @Transactional
    public void delete(UUID id) {
        organizationRepository.deleteById(id);
    }

    @Transactional
    public OrganizationResponse update(UUID id, UpdateOrganizationRequest request) {
        Organization organization = organizationRepository.findById(id).orElseThrow();
        request.getName().ifPresent(organization::setName);
        request.getAddress().ifPresent(organization::setAddress);
        request.getContactEmail().ifPresent(organization::setContactEmail);
        request.getContactPhone().ifPresent(organization::setContactPhone);

        return OrganizationMapper.toResponse(organizationRepository.update(organization));
    }
}
