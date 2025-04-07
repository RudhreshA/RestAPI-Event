package demo.eventmanagement.Controller;

import demo.eventmanagement.Model.Organizer;
import demo.eventmanagement.Service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizer")
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;

    @PostMapping("/addOrganizer")
    public ResponseEntity<Organizer> addOrganizer(@RequestBody Organizer organizer) {
        return new ResponseEntity<>(organizerService.addOrganizer(organizer), HttpStatus.CREATED);
    }

    @GetMapping("/getOrganizers")
    public ResponseEntity<List<Organizer>> getOrganizers() {
        return new ResponseEntity<>(organizerService.getOrganizers(), HttpStatus.OK);
    }

    @GetMapping("/getOrganizer/{id}")
    public ResponseEntity<Organizer> getOrganizerById(@PathVariable Long id) {
        Organizer organizer = organizerService.getOrganizerById(id);
        if (organizer != null)
            return new ResponseEntity<>(organizer, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateOrganizer/{id}")
    public ResponseEntity<Organizer> updateOrganizer(@PathVariable Long id, @RequestBody Organizer updatedOrganizer) {
        Organizer organizer = organizerService.updateOrganizer(id, updatedOrganizer);
        if (organizer != null)
            return new ResponseEntity<>(organizer, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteOrganizer/{id}")
    public ResponseEntity<String> deleteOrganizer(@PathVariable Long id) {
        return new ResponseEntity<>(organizerService.deleteOrganizer(id), HttpStatus.OK);
    }
}
