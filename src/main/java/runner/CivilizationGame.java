package runner;

import controller.GameController;
import view.StartScreen;
import view.CivEnum;
import view.GameScreen;
import model.Map;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.Bandit;

import view.GridFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;


/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    private StartScreen newGame = new StartScreen();
    private Scene scene = new Scene(newGame);

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    public void start(Stage primaryStage) {
        //TODO
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();
        newGame.getStartButton().setOnAction(e -> {
                primaryStage.setScene(startGame());
                primaryStage.show();
            });
    }

    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        //TODO
        Application.launch(args);
    }
    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */

    public Scene startGame() {
        //TODO
        TextInputDialog input = new TextInputDialog("Town Name");
        input.setTitle("A New Settlement");
        input.setHeaderText("You have built a Settlement!");
        input.setContentText("Enter the name of your first town:");
        Optional<String> result = input.showAndWait();
        int gridVal = ((int) newGame.getSlider().getValue());
        Map newMap = GridFX.getMap();

        if (result.isPresent()) {
            if (newGame.getCivList().getSelectionModel().getSelectedItem()
                == CivEnum.ANCIENT_EGYPT) {
                Egypt egypt = new Egypt();
                GameController.setCivilization(egypt);
                newMap.putSettlement(result.get(), egypt, 0, gridVal - 1);
            } else if (newGame.getCivList().getSelectionModel()
                    .getSelectedItem() == CivEnum.QIN_DYNASTY) {
                QinDynasty qin = new QinDynasty();
                GameController.setCivilization(qin);
                newMap.putSettlement(result.get(), qin, 0, gridVal - 1);
            } else if (newGame.getCivList().getSelectionModel()
                .getSelectedItem() == CivEnum.ROMAN_EMPIRE) {
                RomanEmpire rome = new RomanEmpire();
                GameController.setCivilization(rome);
                newMap.putSettlement(result.get(), rome, 0, gridVal - 1);
            } else if (newGame.getCivList().getSelectionModel()
                .getSelectedItem() == null) {
                Egypt egypt = new Egypt();
                GameController.setCivilization(egypt);
                newMap.putSettlement(result.get(), egypt, 0, gridVal - 1);
            }
            GameScreen gs = new GameScreen();
            newMap.addEnemies(new Bandit(), 1);
            gs.update();
            Scene gameScene = new Scene(gs);
            return gameScene;
        } else {
            return scene;
        }
    }
}

