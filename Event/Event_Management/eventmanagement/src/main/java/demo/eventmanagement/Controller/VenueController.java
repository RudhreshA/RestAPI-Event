package demo.eventmanagement.Controller;

import demo.eventmanagement.Model.Venue;
import demo.eventmanagement.Service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venue")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @PostMapping("/addVenue")
    public ResponseEntity<Venue> addVenue(@RequestBody Venue venue) {
        return new ResponseEntity<>(venueService.addVenue(venue), HttpStatus.CREATED);
    }

    @GetMapping("/getVenues")
    public ResponseEntity<List<Venue>> getVenues() {
        return new ResponseEntity<>(venueService.getVenues(), HttpStatus.OK);
    }

    @GetMapping("/getVenue/{id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
        Venue venue = venueService.getVenueById(id);
        if (venue != null)
            return new ResponseEntity<>(venue, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateVenue/{id}")
    public ResponseEntity<Venue> updateVenue(@PathVariable Long id, @RequestBody Venue updatedVenue) {
        Venue venue = venueService.updateVenue(id, updatedVenue);
        if (venue != null)
            return new ResponseEntity<>(venue, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteVenue/{id}")
    public ResponseEntity<String> deleteVenue(@PathVariable Long id) {
        return new ResponseEntity<>(venueService.deleteVenue(id), HttpStatus.OK);
    }
}
