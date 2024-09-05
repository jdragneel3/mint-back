package api.mint.dto;

import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.serde.config.naming.SnakeCaseStrategy;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Serdeable(naming = SnakeCaseStrategy.class)
public class UpdateInstructorRequest {
    private Optional<String> firstName;
    private Optional<String> lastName;
    private Optional<LocalDate> birthDate;
    private Optional<UUID> organizationId;

    public UpdateInstructorRequest() {}

    public UpdateInstructorRequest(Optional<String> firstName, Optional<String> lastName, Optional<LocalDate> birthday, Optional<UUID> organizationId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthday;
        this.organizationId = organizationId;
    }

    public Optional<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(Optional<String> firstName) {
        this.firstName = firstName;
    }

    public Optional<String> getLastName() {
        return lastName;
    }

    public void setLastName(Optional<String> lastName) {
        this.lastName = lastName;
    }

    public Optional<LocalDate> getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Optional<LocalDate> birthDate) {
        this.birthDate = birthDate;
    }

    public Optional<UUID> getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Optional<UUID> organizationId) {
        this.organizationId = organizationId;
    }
}
