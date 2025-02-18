package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author NH 2021-09-16
 */
@Service
@Profile({"default", "mapService"})
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {
   @Override
   public Set<Specialty> findAll() {
      return super.findAll();
   }

   @Override
   public void deleteById(Long id) {
      super.deleteById(id);
   }

   @Override
   public void delete(Specialty object) {
      super.delete(object);
   }

   @Override
   public Specialty save(Specialty object) {
      return super.save(object);
   }

   @Override
   public Specialty findById(Long id) {
      return super.findById(id);
   }
}
