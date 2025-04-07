package demo.eventmanagement.Service;

import demo.eventmanagement.Model.Venue;
import demo.eventmanagement.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    public Venue addVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public List<Venue> getVenues() {
        return venueRepository.findAll();
    }

    public Venue getVenueById(Long id) {
        return venueRepository.findById(id).orElse(null);
    }

    public Venue updateVenue(Long id, Venue updatedVenue) {
        Venue venue = venueRepository.findById(id).orElse(null);
        if (venue != null) {
            venue.setName(updatedVenue.getName());
            venue.setLocation(updatedVenue.getLocation());
            venue.setCapacity(updatedVenue.getCapacity());
            return venueRepository.save(venue);
        }
        return null;
    }

    public String deleteVenue(Long id) {
        if (venueRepository.existsById(id)) {
            venueRepository.deleteById(id);
            return "Venue deleted successfully!";
        }
        return "Venue not found!";
    }
}
