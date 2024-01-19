package cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n03.Service;

import cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n03.Domain.Fruit;
import cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n03.Repository.IFruitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService implements IFruitService{
    @Autowired
    private IFruitRepo fruitRepo;

    @Override
    public void createFruit(Fruit fruit) {
        fruitRepo.save(fruit);
    }

    @Override
    public Fruit getFruitById(String id) {
        Fruit fruitObj = null;
        Optional<Fruit> fruit = fruitRepo.findById(id)
;        if(fruit.isPresent()){
            fruitObj = fruit.get();
        }
        return fruitObj;
    }

    @Override
    public List<Fruit> getFruits() {
        return fruitRepo.findAll();
    }

    @Override
    public Fruit updateFruit(Fruit newFruit, String id) {
        Fruit fruitObj = null;
        Optional<Fruit> oldFruit = fruitRepo.findById(id);
        if(oldFruit.isPresent()){
            Fruit updatedFruit = oldFruit.get();
            updatedFruit.setName(newFruit.getName());
            updatedFruit.setQuantityKg(newFruit.getQuantityKg());
            fruitObj = fruitRepo.save(updatedFruit);
        }
        return fruitObj;
    }

    @Override
    public boolean deleteFruit(String id) {
        Optional <Fruit> fruitData = fruitRepo.findById(id);
        boolean deleted = false;
        if(fruitData.isPresent()){
            fruitRepo.deleteById(id);
            deleted = true;
        }
        return deleted;
    }
}
