package demo.eventmanagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import demo.eventmanagement.Model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.eventName = :name")
    List<Event> findByName(@Param("name") String name);

    @Query("SELECT e FROM Event e WHERE e.location = :location")
    List<Event> findByLocation(@Param("location") String location);

    @Query("SELECT e FROM Event e WHERE e.id = :id")
    Event findByEventId(@Param("id") Long id);
}
