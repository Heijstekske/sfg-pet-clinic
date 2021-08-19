package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

/**
 * @author NH 2021-08-19
 */
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
