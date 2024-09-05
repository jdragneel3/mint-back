package api.mint.dto;

import io.micronaut.serde.annotation.*;
import io.micronaut.serde.config.naming.*;

@Serdeable(naming = SnakeCaseStrategy.class)
public class OrganizationRequest {
    private String name;
    private String address;
    private String contactEmail;
    private String contactPhone;

    public OrganizationRequest() {
    }

    public OrganizationRequest(String name, String address, String contactEmail, String contactPhone) {
        this.name = name;
        this.address = address;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
