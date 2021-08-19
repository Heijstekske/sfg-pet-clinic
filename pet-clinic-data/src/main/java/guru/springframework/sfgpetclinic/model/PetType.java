package guru.springframework.sfgpetclinic.model;

/**
 * @author NH 2021-08-19
 */
public class PetType extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
