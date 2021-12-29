package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author NH 2021-08-31
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            LoadData();
        }

        }

        private void LoadData () {
            PetType dog = new PetType();
            dog.setName("Dog");
            PetType savedDogPetType = petTypeService.save(dog);

            PetType cat = new PetType();
            cat.setName("Cat");
            PetType savedCatPetType = petTypeService.save(cat);

            System.out.println("Loaded Pettypes");

            Specialty radiology = new Specialty();
            radiology.setSpecialtyDescription("radiology");
            Specialty savedRadiologySpeciality = specialtyService.save(radiology);

            Specialty surgery = new Specialty();
            surgery.setSpecialtyDescription("surgery");
            Specialty savedSurgerySpeciality = specialtyService.save(surgery);

            Specialty dentistry = new Specialty();
            dentistry.setSpecialtyDescription("dentistry");
            Specialty savedDentistrySpeciality = specialtyService.save(dentistry);

            System.out.println("Loaded Specialities");

            Owner owner1 = new Owner();
            owner1.setFirstName("Micheal");
            owner1.setLastName("Weston");
            owner1.setAddress("123 Brickerel");
            owner1.setCity("Miami");
            owner1.setTelephone("1231231234");

            Pet mikesPet = new Pet();
            mikesPet.setPetType(savedDogPetType);
            mikesPet.setOwner(owner1);
            mikesPet.setBirthday(LocalDate.now());
            mikesPet.setPetName("Rosco");
            owner1.getPets().add(mikesPet);

            ownerService.save(owner1);

            Owner owner2 = new Owner();
            owner2.setFirstName("Fiona");
            owner2.setLastName("Glenanne");
            owner1.setAddress("123 Brickerel");
            owner1.setCity("Miami");
            owner1.setTelephone("1231231234");

            Pet fionasPet = new Pet();
            fionasPet.setPetType(savedCatPetType);
            fionasPet.setOwner(owner2);
            fionasPet.setBirthday(LocalDate.now());
            fionasPet.setPetName("Prince");
            owner2.getPets().add(fionasPet);

            ownerService.save(owner2);

            Visit catVisit = new Visit();
            catVisit.setPet(fionasPet);
            catVisit.setDate(LocalDate.now());
            catVisit.setDescription("Sneezy Kitty");

            visitService.save(catVisit);
            System.out.println("Loaded Visits");

            System.out.println("Loaded Owners....");

            Vet vet1 = new Vet();
            vet1.setFirstName("Sam");
            vet1.setLastName("Axe");
            vet1.getVetSpecialties().add(savedDentistrySpeciality);

            vetService.save(vet1);

            Vet vet2 = new Vet();
            vet2.setFirstName("Jessie");
            vet2.setLastName("Porter");
            vet2.getVetSpecialties().add(savedRadiologySpeciality);

            vetService.save(vet2);

            System.out.println("Loaded Vets.....");
        }
    }
