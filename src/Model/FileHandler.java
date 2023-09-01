package Model;


import java.io.*;
        import java.util.ArrayList;
        import java.util.List;

public class FileHandler {
    private String toysFilename;
    private String resultsFilename;

    public FileHandler(String toysFilename, String resultsFilename) {
        this.toysFilename = toysFilename;
        this.resultsFilename = resultsFilename;
    }

    public List<Toy> readToysFromFile() {
        List<Toy> toys = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(toysFilename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    Toy toy = new Toy(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]));
                    toys.add(toy);
                }
            }
            System.out.println("Файл прочитан");
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл " + toysFilename + ", файл создан заново.");
        }
        return toys;
    }


    public void saveToysToFile(List<Toy> toys) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toysFilename))) {
            for (Toy toy : toys) {
                writer.write(toy.id + " " + toy.name + " " + toy.weight);
                writer.newLine();
            }
            System.out.println("Файл сохранен");
        } catch (IOException e) {
            System.out.println("Не удалось сохранить файл " + toysFilename);
        }
    }

    public void saveResultsToFile(List<String> results) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultsFilename))) {
            for (String result : results) {
                writer.write(result);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Не удалось сохранить файл " + resultsFilename);
        }
    }

    public List<String> readResultsFromFile() {
        List<String> results = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(resultsFilename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                results.add(line);
            }
        } catch (IOException e) {
            System.out.println("Не удалось сохранить файл " + resultsFilename);
        }
        return results;
    }
}