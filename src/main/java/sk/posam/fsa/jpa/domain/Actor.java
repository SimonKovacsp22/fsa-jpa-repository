package sk.posam.fsa.jpa.domain;




import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Long id;

    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "last_update")
    LocalDateTime lastUpdated;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "language_actor",joinColumns = @JoinColumn(name = "actor_id"), inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Language> languages = new ArrayList<>();

    public void addLanguage(Language language) {
        if(language != null) {
        languages.add(language);
        }
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public Actor(String firstName, String lastName, LocalDateTime lastUpdated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdated = lastUpdated;
    }

    public Actor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }



    public void addPet(Pet pet) {
        pets.add(pet);
        pet.setOwner(this);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastUpdated=" + lastUpdated +
                ", pets=" + pets +
                ", languages=" + languages +
                '}';
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
        pet.setOwner(null);
    }
}
