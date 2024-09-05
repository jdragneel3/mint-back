package api.mint.mapper;

import api.mint.dto.OrganizationRequest;
import api.mint.dto.OrganizationResponse;
import api.mint.model.Organization;

public class OrganizationMapper {

    public static OrganizationResponse toResponse(Organization organization) {
        return new OrganizationResponse(
                organization.getId(),
                organization.getName(),
                organization.getAddress(),
                organization.getContactEmail(),
                organization.getContactPhone()
        );
    }

    public static Organization toEntity(OrganizationRequest request) {
        Organization organization = new Organization();
        organization.setName(request.getName());
        organization.setAddress(request.getAddress());
        organization.setContactEmail(request.getContactEmail());
        organization.setContactPhone(request.getContactPhone());

        return organization;
    }
}
