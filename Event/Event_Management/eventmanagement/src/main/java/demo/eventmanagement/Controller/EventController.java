package demo.eventmanagement.Controller;

import demo.eventmanagement.Model.Event;
import demo.eventmanagement.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/addEvent")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        return new ResponseEntity<>(eventService.addEvent(event), HttpStatus.CREATED);
    }

    @GetMapping("/getEvents")
    public ResponseEntity<List<Event>> getEvents() {
        return new ResponseEntity<>(eventService.getEvents(), HttpStatus.OK);
    }

    @GetMapping("/getEvent/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        if (event != null)
            return new ResponseEntity<>(event, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateEvent/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        Event event = eventService.updateEvent(id, updatedEvent);
        if (event != null)
            return new ResponseEntity<>(event, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        return new ResponseEntity<>(eventService.deleteEvent(id), HttpStatus.OK);
    }

    @GetMapping("/events/paginate")
    public ResponseEntity<List<Event>> getEventsPaginated(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return new ResponseEntity<>(eventService.getEventsPaginated(page, size), HttpStatus.OK);
    }

    @GetMapping("/events/paginate-sort")
    public ResponseEntity<List<Event>> getEventsPaginatedAndSorted(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "id") String field) {
       return new ResponseEntity<>(eventService.getEventsPaginatedAndSorted(page, size, field), HttpStatus.OK);
   }

   @GetMapping("/byName/{name}")
    public List<Event> getEventsByName(@PathVariable String name) {
        return eventService.getEventsByName(name);
    }

    @GetMapping("/byLocation/{location}")
    public List<Event> getEventsByLocation(@PathVariable String location) {
        return eventService.getEventsByLocation(location);
    }
}
