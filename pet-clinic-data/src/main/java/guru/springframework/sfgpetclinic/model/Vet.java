package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author NH 2021-08-19
 */
@Entity
@Table(name = "vets")
public class Vet extends Person {

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "vet_specialties",
         joinColumns = @JoinColumn(name = "vet_id"),
         inverseJoinColumns = @JoinColumn(name = "speciality_id"))
   private Set<Specialty> vetSpecialties = new HashSet<>();

   public Set<Specialty> getVetSpecialties() {
      return vetSpecialties;
   }

   public void setVetSpecialties(Set<Specialty> vetSpecialties) {
      this.vetSpecialties = vetSpecialties;
   }
}
