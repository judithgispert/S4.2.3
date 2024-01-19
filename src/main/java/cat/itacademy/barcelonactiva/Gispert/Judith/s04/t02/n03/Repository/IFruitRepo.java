package cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n03.Repository;

import cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n03.Domain.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFruitRepo extends MongoRepository<Fruit, String>{
}
