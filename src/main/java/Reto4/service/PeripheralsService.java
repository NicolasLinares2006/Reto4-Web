package Reto4.service;

import Reto4.model.Peripherals;
import Reto4.repository.PeripheralsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author desaextremo
 */
@Service
public class PeripheralsService {

    @Autowired
    private PeripheralsRepository repository;

    public List<Peripherals> getAll() {
        return repository.getAll();
    }

    public Optional<Peripherals> getClothe(String reference) {
        return repository.getClothe(reference);
    }

    public Peripherals create(Peripherals accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return repository.create(accesory);
        }
    }

    public Peripherals update(Peripherals accesory) {

        if (accesory.getReference() != null) {
            Optional<Peripherals> accesoryDb = repository.getClothe(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                if (accesory.getBrand() != null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getPresentation() != null) {
                    accesoryDb.get().setPresentation(accesory.getPresentation());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                repository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            repository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Peripherals> productByPrice(double price) {
        return repository.productByPrice(price);
    }

}
