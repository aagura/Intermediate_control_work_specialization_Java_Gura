package Presenter;
import Model.Toy;
import Model.ToyModel;
import View.ToyView;

import java.util.List;

public class ToyPresenterImpl implements ToyPresenter {
    private ToyModel toyModel;
    private ToyView toyView;

    public ToyPresenterImpl(ToyModel toyModel, ToyView toyView) {
        this.toyModel = toyModel;
        this.toyView = toyView;
    }

    @Override
    public void start() {

    }

    @Override
    public void readToysFromFile() {
        List<Toy> toys = toyModel.readToysFromFile();
        toyView.displayToys(toys);
    }

    @Override
    public void addToy(String name, int weight) {
        toyModel.addToy(name, weight);
    }

    @Override
    public void removeToy(int id) {
        toyModel.removeToy(id);
    }

    @Override
    public void conductDraw() {
        toyModel.conductDraw();
    }

    @Override
    public void showResults() {
        List<String> results = toyModel.readResultsFromFile();
        if (results.isEmpty()) {
            toyView.showDrawNotConducted();
        } else {
            toyView.showDrawResults(results);
        }
    }
}
