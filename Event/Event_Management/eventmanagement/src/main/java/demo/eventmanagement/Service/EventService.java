package demo.eventmanagement.Service;

import demo.eventmanagement.Model.Event;
import demo.eventmanagement.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event != null) {
            event.setEventName(updatedEvent.getEventName());
            event.setLocation(updatedEvent.getLocation());
            event.setDate(updatedEvent.getDate());
            event.setTime(updatedEvent.getTime());
            event.setAvailableSeats(updatedEvent.getAvailableSeats());
            event.setUser(updatedEvent.getUser());
            event.setOrganizer(updatedEvent.getOrganizer());
            event.setVenue(updatedEvent.getVenue());
            return eventRepository.save(event);
        }
        return null;
    }

    public String deleteEvent(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            return "Event deleted successfully!";
        }
        return "Event not found!";
    }

    public List<Event> getEventsPaginated(int page, int size) {
        Page<Event> eventsPage = eventRepository.findAll(PageRequest.of(page, size));
        return eventsPage.getContent();
    }

    public List<Event> getEventsPaginatedAndSorted(int page, int size, String field) {
        Page<Event> eventsPage = eventRepository.findAll(PageRequest.of(page, size, Sort.by(field)));
        return eventsPage.getContent();
    }

    public List<Event> getEventsByName(String name) {
        return eventRepository.findByName(name);
    }

    public List<Event> getEventsByLocation(String location) {
        return eventRepository.findByLocation(location);
    }
}
