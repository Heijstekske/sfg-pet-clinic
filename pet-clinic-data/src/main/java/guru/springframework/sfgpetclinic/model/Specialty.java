package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author NH 2021-09-16
 */
@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity{

    @Column(name = "specialty_description")
    private String specialtyDescription;

    public String getSpecialtyDescription() {
        return specialtyDescription;
    }

    public void setSpecialtyDescription(String specialtyDescription) {
        this.specialtyDescription = specialtyDescription;
    }
}
