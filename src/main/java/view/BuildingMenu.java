package view;

import controller.GameController;
import model.Building;
import model.Settlement;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;

/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {
    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */
    public BuildingMenu() {
        //TODO
        Button invest = new Button("Invest");
        addMenuItem(invest);
        Button demolish = new Button("Demolish");
        addMenuItem(demolish);

        AudioClip money =
            new AudioClip("File:./src/main/java/view/music/ChaChing.mp3");
        AudioClip destroy =
            new AudioClip("File:./src/main/java/view/music/Explode.mp3");
        AudioClip error =
            new AudioClip("File:./src/main/java/view/music/Error.mp3");

        invest.setOnAction(e -> {
                if (GameController.getLastClicked().getTile().getOccupant()
                        .getOwner().getTreasury().getCoins() >= 25) {
                    GameController.getLastClicked().getTile().getOccupant()
                        .getOwner().getTreasury().spend(25);
                    GameController.updateResourcesBar();
                    money.play();
                } else {
                    error.play();
                    Alert newAlert = new Alert(Alert.AlertType.WARNING);
                    newAlert.setTitle("Warning Dialog");
                    newAlert.setHeaderText("That action cannot be performed!");
                    newAlert.setContentText("You don't have enough gold! "
                        + "Press OK to continue.");
                    newAlert.showAndWait();
                }
            });

        demolish.setOnAction(e -> {
                if (GameController.getLastClicked().getTile()
                        .getOccupant() instanceof Settlement) {
                    if (GameController.getLastClicked().getTile()
                            .getOccupant().getOwner().getNumSettlements() > 1) {
                        ((Building) GameController.getLastClicked().getTile()
                            .getOccupant()).demolish();
                        GameController.getLastClicked().getTile()
                            .setOccupant(null);
                        GameController.getCivilization()
                            .decrementNumSettlements();
                        destroy.play();
                    } else {
                        error.play();
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning Dialog");
                        alert.setHeaderText("That action cannot be performed!");
                        alert.setContentText("You need to keep one settlement!"
                            + " Press OK to continue.");
                        alert.showAndWait();
                    }
                } else if (GameController.getLastClicked().getTile()
                        .getOccupant().isBuilding()) {
                    ((Building) GameController.getLastClicked().getTile()
                        .getOccupant()).demolish();
                    GameController.getLastClicked().getTile()
                        .setOccupant(null);
                    destroy.play();
                }
                GameController.updateResourcesBar();
                GameController.getLastClicked().updateTileView();
            });
    }
}
