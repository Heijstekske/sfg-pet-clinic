package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author NH 2021-08-19
 */

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

   @Column(name = "pet_name")
   private String petName;

   @ManyToOne
   @JoinColumn(name = "type_id")
   private PetType petType;

   @ManyToOne
   @JoinColumn(name = "owner_id")
   private Owner owner;

   @Column(name = "birth_date")
   private LocalDate birthday;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
   private Set<Visit> visits = new HashSet<>();

   public Set<Visit> getVisits() {
      return visits;
   }

   public void setVisits(Set<Visit> visits) {
      this.visits = visits;
   }

   public String getPetName() {
      return petName;
   }

   public void setPetName(String petName) {
      this.petName = petName;
   }

   public PetType getPetType() {
      return petType;
   }

   public void setPetType(PetType petType) {
      this.petType = petType;
   }

   public Owner getOwner() {
      return owner;
   }

   public void setOwner(Owner owner) {
      this.owner = owner;
   }

   public LocalDate getBirthday() {
      return birthday;
   }

   public void setBirthday(LocalDate birthday) {
      this.birthday = birthday;
   }
}
