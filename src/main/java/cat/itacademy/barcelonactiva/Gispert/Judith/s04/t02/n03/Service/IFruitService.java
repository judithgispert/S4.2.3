package cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n03.Service;

import cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n03.Domain.Fruit;

import java.util.List;

public interface IFruitService {
    public void createFruit(Fruit fruit);
    public Fruit getFruitById(String id);
    public List<Fruit> getFruits();
    public Fruit updateFruit(Fruit newFruit, String id);
    public boolean deleteFruit(String id);
}
