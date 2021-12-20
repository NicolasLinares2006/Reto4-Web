/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto4.repository.crud;

import Reto4.model.Peripherals;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author desaextremo
 */
public interface PeripheralsCrudRepository extends MongoRepository<Peripherals, String> {
    public List<Peripherals> findByPriceLessThanEqual(double precio);
}
