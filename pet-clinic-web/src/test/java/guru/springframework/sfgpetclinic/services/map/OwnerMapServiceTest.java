package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;

import static guru.springframework.sfgpetclinic.model.Owner.*;
import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

   OwnerMapService ownerMapService;

   private final Long OWNER_ID = 1L;
   private final Long OWNER2_ID = 2L;
   private final String OWNER_LASTNAME = "Smith";

   @BeforeEach
   void setUp() {

      ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
      ownerMapService.save(builder().id(OWNER_ID).lastName(OWNER_LASTNAME).build());
   }

   @Test
   void findAll() {
      Set<Owner> ownerSet = ownerMapService.findAll();

      assertEquals(1, ownerSet.size());
   }

   @Test
   void findById() {
      Owner owner = ownerMapService.findById(OWNER_ID);

      assertEquals(OWNER_ID, owner.getId());
   }

   @Test
   void saveExistingId() {

      Owner owner2 = Owner.builder().id(OWNER2_ID).build();

      Owner savedOwner = ownerMapService.save(owner2);

      assertEquals(OWNER2_ID, savedOwner.getId());
   }

   @Test
   void saveNoId() {

      Owner savedOwner  = ownerMapService.save(Owner.builder().build());

      assertNotNull(savedOwner);
      assertNotNull(savedOwner.getId());
   }

   @Test
   void deleteById() {
     ownerMapService.deleteById(OWNER_ID);

     assertEquals(0, ownerMapService.findAll().size());

   }

   @Test
   void delete() {

      ownerMapService.delete(ownerMapService.findById(OWNER_ID));

      assertEquals(0, ownerMapService.findAll().size());
   }

   @Test
   void findByLastName() {
      Owner smith = ownerMapService.findByLastName(OWNER_LASTNAME);

      assertNotNull(smith);
      assertEquals(OWNER_ID, smith.getId());
   }

   @Test
   void findByLastNameNotFound() {
      Owner smith = ownerMapService.findByLastName("Foo");

      assertNull(smith);
   }
}