package guru.springframework.sfgpetclinic.model;

import java.util.Set;

/**
 * @author NH 2021-08-19
 */
public class Vet extends Person{

    private Set<Specialty> vetSpecialties;

    public Set<Specialty> getVetSpecialties() {
        return vetSpecialties;
    }

    public void setVetSpecialties(Set<Specialty> vetSpecialties) {
        this.vetSpecialties = vetSpecialties;
    }
}
