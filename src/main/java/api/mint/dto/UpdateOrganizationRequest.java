package api.mint.dto;

import io.micronaut.serde.annotation.*;
import io.micronaut.serde.config.naming.*;
import java.util.Optional;

@Serdeable(naming = SnakeCaseStrategy.class)
public class UpdateOrganizationRequest {
    private Optional<String> name;
    private Optional<String> address;
    private Optional<String> contactEmail;
    private Optional<String> contactPhone;

    public Optional<String> getName() {
        return name;
    }

    public void setName(Optional<String> name) {
        this.name = name;
    }

    public Optional<String> getAddress() {
        return address;
    }

    public void setAddress(Optional<String> address) {
        this.address = address;
    }

    public Optional<String> getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(Optional<String> contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Optional<String> getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(Optional<String> contactPhone) {
        this.contactPhone = contactPhone;
    }
}
