package guru.springframework.sfgpetclinic.bootstrap;


import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner
{
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;



    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count  = petTypeService.findAll().size();

        if(count == 0){

            loadData();
        }


    }

    private void loadData() {
        PetType dog =  new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat =  new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Jei");
        owner1.setLastName("Jemera");
        owner1.setAddress("123 main st");
        owner1.setCity("Sacramento");
        owner1.setTelephone("9161231212");

        Pet jeisPet = new Pet();
        jeisPet.setPetType(savedDogPetType);
        jeisPet.setBirthDate(LocalDate.now().minusYears(7));
        jeisPet.setName("Eon");
        owner1.getPets().add(jeisPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Grace");
        owner2.setLastName("Jemera");
        owner1.setAddress("222 main st");
        owner1.setCity("Sacramento");
        owner1.setTelephone("3331231212");

        Pet gracesPet = new Pet();
        gracesPet.setPetType(savedDogPetType);
        gracesPet.setBirthDate(LocalDate.now().minusYears(7));
        gracesPet.setName("Simmy");
        owner2.getPets().add(gracesPet);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Serah");
        owner3.setLastName("Jemera");
        owner1.setAddress("333 main st");
        owner1.setCity("Sacramento");
        owner1.setTelephone("2221231212");

        Pet serahsPet = new Pet();
        serahsPet.setPetType(savedCatPetType);
        serahsPet.setBirthDate(LocalDate.now().minusYears(7));
        serahsPet.setName("lol");
        owner3.getPets().add(serahsPet);

        ownerService.save(owner3);

        Owner owner4 = new Owner();
        owner4.setFirstName("Matthew");
        owner4.setLastName("Jemera");
        owner1.setAddress("444 main st");
        owner1.setCity("Sacramento");
        owner1.setTelephone("1111231212");

        Pet matthewsPet = new Pet();
        matthewsPet.setPetType(savedCatPetType);
        matthewsPet.setBirthDate(LocalDate.now().minusYears(7));
        matthewsPet.setName("robocar");
        owner4.getPets().add(matthewsPet);

        ownerService.save(owner4);

        System.out.println("Loading owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Yolanda");
        vet1.setLastName("Arucan");
        vet1.getSpecialties().add(savedDentistry);
        vet1.getSpecialties().add(savedSurgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Aurora");
        vet2.setLastName("Herico");
        vet2.getSpecialties().add(savedRadiology);
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loading vets");
    }
}
