package api.mint.repository;

import api.mint.model.*;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import java.util.UUID;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, UUID> {
}
