package view;

import controller.GameController;
import model.Convertable;
// import model.MapObject;
// import model.TerrainTile;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;


/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {
    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */
    public WorkerMenu() {
        //TODO
        Button move = new Button("Move");
        addMenuItem(move);
        Button convert = new Button("Convert");
        addMenuItem(convert);

        AudioClip change =
            new AudioClip("File:./src/main/java/view/music/Construct.mp3");

        AudioClip error =
            new AudioClip("File:./src/main/java/view/music/Error.mp3");

        move.setOnAction(e -> {
                GameController.moving();
            });

        convert.setOnAction(e -> {
                if (GameController.getLastClicked().getTile()
                        .getOccupant().isWorker()
                    && ((Convertable) GameController.getLastClicked().getTile()
                            .getOccupant()).canConvert(GameController
                                .getLastClicked().getTile().getType())) {
                    GameController.getLastClicked().getTile().setOccupant(
                        ((Convertable) GameController.getLastClicked()
                            .getTile().getOccupant()).convert());
                    GameController.getLastClicked().updateTileView();
                    GameController.updateResourcesBar();
                    GameController.setLastClicked(null);
                    change.play();
                } else {
                    error.play();
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("This action cannot be performed!");
                    alert.setContentText("The tile you selected can't "
                        + "be converted. Press OK to continue.");
                    alert.showAndWait();
                }
            });
    }
}
