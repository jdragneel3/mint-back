package api.mint.mapper;

import api.mint.dto.InstructorRequest;
import api.mint.dto.InstructorResponse;
import api.mint.model.Instructor;
import api.mint.model.Organization;

public class InstructorMapper {

    public static InstructorResponse toResponse(Instructor instructor) {
        return new InstructorResponse(
                instructor.getId(),
                instructor.getFirstName(),
                instructor.getLastName(),
                instructor.getBirthDate(),
                instructor.getOrganization().getId()
        );
    }

    public static Instructor toEntity(InstructorRequest instructorRequest, Organization organization) {
        Instructor instructor = new Instructor();
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setBirthDate(instructorRequest.getBirthDate());
        instructor.setOrganization(organization);

        return instructor;
    }
}
