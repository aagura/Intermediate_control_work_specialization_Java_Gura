package Presenter;



public interface ToyPresenter {
    void start();
    void readToysFromFile();
    void addToy(String name, int weight);
    void removeToy(int id);
    void conductDraw();
    void showResults();
}
