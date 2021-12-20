package Reto4.repository;

import Reto4.model.Peripherals;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto4.repository.crud.PeripheralsCrudRepository;

/**
 *
 * @author desaextremo
 */
@Repository
public class PeripheralsRepository {
    @Autowired
    private PeripheralsCrudRepository repository;

    public List<Peripherals> getAll() {
        return repository.findAll();
    }

    public Optional<Peripherals> getClothe(String reference) {
        return repository.findById(reference);
    }
    
    public Peripherals create(Peripherals clothe) {
        return repository.save(clothe);
    }

    public void update(Peripherals clothe) {
        repository.save(clothe);
    }
    
    public void delete(Peripherals clothe) {
        repository.delete(clothe);
    }
    
    public List<Peripherals> productByPrice(double precio) {
	return repository.findByPriceLessThanEqual(precio);
    }
}
