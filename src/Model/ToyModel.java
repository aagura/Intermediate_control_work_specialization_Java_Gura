package Model;
import java.util.List;


public interface ToyModel {

    void addToy(String name, int weight);
    void removeToy(int id);
    void conductDraw();
    Toy getToyById(int id);
    List<String> readResultsFromFile();
    List<Toy> readToysFromFile();
}


