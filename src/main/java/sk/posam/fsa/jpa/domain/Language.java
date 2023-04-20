package sk.posam.fsa.jpa.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "language")
public class Language {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "language_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @ManyToMany(mappedBy = "languages")
    private List<Actor> actors = new ArrayList<>();

    public Language(String name, LocalDateTime lastUpdate) {
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return String.format("Language{ %s, lastUpdate=%s",name,lastUpdate);
    }

    public Language() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Actor> getActors() {
        return actors;
    }


}
