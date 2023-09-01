package View;

import Model.Toy;

import java.util.List;

public interface ToyView {
    void showDrawResults(List<String> results);
    void showDrawNotConducted();
    void displayToys(List<Toy> toys);
}

