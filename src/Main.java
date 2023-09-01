import Model.ToyManager;
import Model.ToyModel;
import Presenter.ToyPresenter;
import Presenter.ToyPresenterImpl;
import View.ConsoleToyView;
import View.ToyView;
import java.util.Scanner;
import Model.FileHandler;

public class Main {
     public static void main(String[] args){
        String toysFilename = "toys.csv";
        String resultsFilename = "dial_results.csv";


        FileHandler fileHandler = new FileHandler(toysFilename, resultsFilename);
        ToyModel toyModel = new ToyManager(fileHandler, resultsFilename);
        ToyView toyView = new ConsoleToyView();
        ToyPresenter toyPresenter = new ToyPresenterImpl(toyModel, toyView);
        toyPresenter.start();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Прочитать файл с игрушками");
            System.out.println("2. Добавить игрушку");
            System.out.println("3. Удалить игрушку");
            System.out.println("4. Провести розыгрыш");
            System.out.println("5. Посмотреть результат розыгрыша");
            System.out.println("6. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    toyPresenter.readToysFromFile();
                    break;
                case 2:
                    System.out.print("Введите название игрушки: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите частоту выпадения: ");
                    int weight = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    toyPresenter.addToy(name, weight);
                    break;
                case 3:
                    System.out.print("Введите ID игрушки для удаления: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    toyPresenter.removeToy(id);
                    break;
                case 4:
                    toyPresenter.conductDraw();
                    break;
                case 5:
                    toyPresenter.showResults();
                    break;
                case 6:
                    // Сохранение данных в файл и выход
                    System.exit(0);
            }
        }
    }
}