package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author NH 2021-08-19
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person {

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "vet_specialties",
         joinColumns = @JoinColumn(name = "vet_id"),
         inverseJoinColumns = @JoinColumn(name = "speciality_id"))
   private Set<Specialty> vetSpecialties = new HashSet<>();
}
