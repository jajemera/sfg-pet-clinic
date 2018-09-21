package guru.springframework.sfgpetclinic.bootstrap;


import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner
{
    public final OwnerService ownerService;
    public final VetService vetService;

    public DataLoader() {

        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Jei");
        owner1.setLastName("Jemera");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Grace");
        owner2.setLastName("Jemera");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Serah");
        owner3.setLastName("Jemera");

        ownerService.save(owner3);

        Owner owner4 = new Owner();
        owner4.setId(4L);
        owner4.setFirstName("Matthew");
        owner4.setLastName("Jemera");

        ownerService.save(owner4);

        System.out.println("Loading owners...");

        Vet vet1 = new Vet();
        vet1.setId(1001L);
        vet1.setFirstName("Yolanda");
        vet1.setLastName("Arucan");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1002L);
        vet2.setFirstName("Aurora");
        vet2.setLastName("Herico");

        vetService.save(vet2);

        System.out.println("Loading vets");

    }
}
