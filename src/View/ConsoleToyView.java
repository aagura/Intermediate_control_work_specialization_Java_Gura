package View;

import Model.Toy;

import java.util.List;

public class ConsoleToyView implements ToyView {


    @Override
    public void showDrawResults(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
    }

    @Override
    public void showDrawNotConducted() {
        System.out.println("Розыгрыш не проведен");
    }

    @Override
    public void displayToys(List<Toy> toys) {
        if (toys.isEmpty()) {
            System.out.println("Файл с игрушками пуст.");
        } else {
            System.out.println("Содержимое файла toys.csv:");
            for (Toy toy : toys) {
                System.out.println("ID: " + toy.id + ", Name: " + toy.name + ", Weight: " + toy.weight);
            }
        }
    }
}
