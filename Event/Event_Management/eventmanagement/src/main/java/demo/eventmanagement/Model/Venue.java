package demo.eventmanagement.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "venues") 
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private int capacity;

    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "venue-event")
    private List<Event> events;

    @Override
    public String toString() {
        return "Venue{id=" + id + ", name='" + name + "', location='" + location + "', capacity=" + capacity + "}";
    }
}
