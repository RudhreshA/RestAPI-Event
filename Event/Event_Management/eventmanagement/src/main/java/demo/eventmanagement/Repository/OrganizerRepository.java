package demo.eventmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import demo.eventmanagement.Model.Organizer;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
