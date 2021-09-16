package guru.springframework.sfgpetclinic.model;

/**
 * @author NH 2021-09-16
 */
public class Specialty extends BaseEntity{
    private String specialtyDescription;

    public String getSpecialtyDescription() {
        return specialtyDescription;
    }

    public void setSpecialtyDescription(String specialtyDescription) {
        this.specialtyDescription = specialtyDescription;
    }
}
