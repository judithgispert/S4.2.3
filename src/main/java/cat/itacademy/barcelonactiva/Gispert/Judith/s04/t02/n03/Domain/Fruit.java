package cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n03.Domain;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fruits")
public class Fruit {
    @Id
    private String id;

    private String name;
    private float quantityKg;

    public Fruit(){}
    public Fruit (String name, float quantityKg){
        this.name = name;
        this.quantityKg = quantityKg;
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public float getQuantityKg(){
        return quantityKg;
    }
    public void setName (String name){
        this.name = name;
    }
    public void setQuantityKg(float quantityKg){
        this.quantityKg = quantityKg;
    }

    @Override
    public String toString(){
        return "Id: " + id + ", Name: " + name + ", Quantity KG: " + quantityKg + "KG";
    }

}
