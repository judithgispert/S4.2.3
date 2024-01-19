package cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n03.Controller;

import cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n03.Domain.Fruit;
import cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n03.Service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @PostMapping("/addFruit")
    public ResponseEntity<String> addFruit(@RequestBody Fruit fruit){
        fruitService.createFruit(fruit);
        return new ResponseEntity<>("Fruit created.", HttpStatus.OK);
    }

    @GetMapping("/getFruit/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable ("id") String id){
        Fruit fruit = fruitService.getFruitById(id);
        if(fruit != null){
            return new ResponseEntity<>(fruit, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/getAllFruits")
    public ResponseEntity<List<Fruit>> getAllFruits(){
        List<Fruit> fruits = fruitService.getFruits();
        if(fruits.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fruits, HttpStatus.OK);
    }

    @PutMapping("/updateFruit/{id}")
    public ResponseEntity<String> updateFruit(@PathVariable ("id") String id, @RequestBody Fruit newFruit){
        Fruit fruit = fruitService.updateFruit(newFruit, id);
        if(fruit != null){
            return new ResponseEntity<>("Updated fruit.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Fruit not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteFruit/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable ("id") String id){
        boolean deleted = fruitService.deleteFruit(id);
        if(!deleted){
            return new ResponseEntity<>("Fruit not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Deleted.", HttpStatus.OK);
    }
}
