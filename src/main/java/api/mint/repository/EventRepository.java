package api.mint.repository;

import api.mint.model.Event;
import api.mint.model.Instructor;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends CrudRepository<Event, UUID> {
    public List<Event> findByInstructor(Instructor instructor);
}
