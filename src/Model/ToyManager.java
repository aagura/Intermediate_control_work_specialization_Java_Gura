package Model;
import java.util.*;

public class ToyManager implements ToyModel {
    private List<Toy> toys;
    private Random random;
    private FileHandler fileHandler;
    private String resultsFilename;

    public ToyManager(FileHandler fileHandler, String resultsFilename) {
        this.fileHandler = fileHandler;
        this.resultsFilename = resultsFilename;
        this.toys=new ArrayList<>();
        random = new Random();
    }


    @Override
    public void addToy(String name, int weight) {
        int id = toys.isEmpty() ? 1 : toys.get(toys.size() - 1).id + 1;
        toys.add(new Toy(id, name, weight));
        saveToysToFile();
        System.out.println("Игрушка добавлена");
    }
    @Override
    public void removeToy(int id) {
        toys.removeIf(toy -> toy.id == id);
        saveToysToFile();
        System.out.println("Игрушка с номером " + id + " удалена");
    }

    @Override
    public void conductDraw() {
        if (toys.isEmpty()) {
            System.out.println("Розыгрыш провести нельзя - игрушки не внесены");
            return;
        }
        Map<Integer, Toy> toyMap = new HashMap<>();
        for (Toy toy : toys) {
            toyMap.put(toy.id, toy);
        }

        List<Integer> drawIds = new ArrayList<>();
        for (Toy toy : toys) {
            for (int i = 0; i < toy.weight; i++) {
                drawIds.add(toy.id);
            }
        }

        PriorityQueue<Integer> drawQueue = new PriorityQueue<>(drawIds.size(), Comparator.comparingInt(id -> random.nextInt()));
        drawQueue.addAll(drawIds);

        List<String> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Integer drawnId = drawQueue.poll();
            if (drawnId != null) {
                Toy drawnToy = toyMap.get(drawnId);
                if (drawnToy != null) {
                    results.add(drawnToy.name);
                }
            }
        }

        saveResultsToFile(results);
        System.out.println("Розыгрыш проведен, результаты в файле " + resultsFilename);
    }

    @Override
    public Toy getToyById(int id) {
        return toys.stream().filter(toy -> toy.id == id).findFirst().orElse(null);
    }

    @Override
    public List<String> readResultsFromFile() {
        return fileHandler.readResultsFromFile();
    }

    private void saveToysToFile() {
        fileHandler.saveToysToFile(toys);
    }

    private void saveResultsToFile(List<String> results) {
        fileHandler.saveResultsToFile(results);
    }

    @Override
    public List<Toy> readToysFromFile() {
        toys = fileHandler.readToysFromFile(); // Обновляем поле toys
        return toys; // Возвращаем список игрушек
    }

}