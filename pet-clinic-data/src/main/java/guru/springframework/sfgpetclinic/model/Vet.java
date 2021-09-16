package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author NH 2021-08-19
 */
public class Vet extends Person{

    private Set<Specialty> vetSpecialties = new HashSet<>();

    public Set<Specialty> getVetSpecialties() {
        return vetSpecialties;
    }

    public void setVetSpecialties(Set<Specialty> vetSpecialties) {
        this.vetSpecialties = vetSpecialties;
    }
}
