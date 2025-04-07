package demo.eventmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import demo.eventmanagement.Model.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
}
