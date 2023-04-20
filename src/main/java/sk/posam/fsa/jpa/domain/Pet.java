package sk.posam.fsa.jpa.domain;

import javax.persistence.*;

@Entity
@Table(name = "pet", schema = "public")
@Access(AccessType.FIELD)
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long id;

    @Column
    private String name;
    @Column(name = "num_legs")
    private int numberOfLegs;

    @Column(name = "animal_type")
    private String animalType;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id")
    private Actor owner;

    public Pet(String name, int numberOfLegs, String animalType) {
        this.name = name;
        this.numberOfLegs = numberOfLegs;
        this.animalType = animalType;
    }

    public Pet() {
    }

    public Actor getOwner() {
        return owner;
    }

    public void setOwner(Actor owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfLegs=" + numberOfLegs +
                ", animalType='" + animalType + '\'' +
                '}';
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

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
}
