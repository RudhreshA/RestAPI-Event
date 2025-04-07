package demo.eventmanagement.Service;

import demo.eventmanagement.Model.Organizer;
import demo.eventmanagement.Repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizerService {

    @Autowired
    private OrganizerRepository organizerRepository;

    public Organizer addOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public List<Organizer> getOrganizers() {
        return organizerRepository.findAll();
    }

    public Organizer getOrganizerById(Long id) {
        return organizerRepository.findById(id).orElse(null);
    }

    public Organizer updateOrganizer(Long id, Organizer updatedOrganizer) {
        Organizer organizer = organizerRepository.findById(id).orElse(null);
        if (organizer != null) {
            organizer.setName(updatedOrganizer.getName());
            return organizerRepository.save(organizer);
        }
        return null;
    }

    public String deleteOrganizer(Long id) {
        if (organizerRepository.existsById(id)) {
            organizerRepository.deleteById(id);
            return "Organizer deleted successfully!";
        }
        return "Organizer not found!";
    }
}
