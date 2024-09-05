package api.mint.dto;


import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.serde.config.naming.SnakeCaseStrategy;
import java.time.LocalDate;
import java.util.UUID;

@Serdeable(naming = SnakeCaseStrategy.class)
public class InstructorRequest {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private UUID organizationId;

    public InstructorRequest() {}

    public InstructorRequest(String firstName, String lastName, LocalDate birthday, UUID organizationId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthday;
        this.organizationId = organizationId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(UUID organizationId) {
        this.organizationId = organizationId;
    }
}
