package view;

import controller.GameController;
// import model.Civilization;
import model.Unit;
import javafx.scene.control.Button;

import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.collections.FXCollections;

import javafx.scene.control.Alert;
import javafx.scene.media.AudioClip;




/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {
    /**
    * recuit menu should have a list of worker/units
    * to choose from. There should also be a select button
    * and the function of the button should be implemented
    *here
    */
    public RecruitMenu() {
        //TODO

        ListView<String> units =
            new ListView<>(FXCollections.observableArrayList(
                "Melee Unit", "Ranged Unit", "Hybrid Unit",
                "Siege Unit", "Settler Unit", "Farmer Unit",
                "Coal Miner Unit", "Angler Unit", "Master Builder Unit"));
        units.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        addMenuItem(units);

        Button select = new Button("Select");
        addMenuItem(select);

        AudioClip error =
            new AudioClip("File:./src/main/java/view/music/Error.mp3");

        Unit melee = GameController.getCivilization().getMeleeUnit();
        Unit ranged = GameController.getCivilization().getRangedUnit();
        Unit hybrid = GameController.getCivilization().getHybridUnit();
        Unit siege = GameController.getCivilization().getSiegeUnit();
        Unit settler =
            GameController.getCivilization().getSettlerUnit("Corey");
        Unit farmer = GameController.getCivilization().getFarmerUnit();
        Unit coalMiner = GameController.getCivilization().getCoalMinerUnit();
        Unit angler = GameController.getCivilization().getAnglerUnit();
        Unit masterBuilder =
            GameController.getCivilization().getMasterBuilderUnit();

        select.setOnAction(e -> {
                if (units.getSelectionModel().getSelectedItem()
                        .equals("Melee Unit") && melee.isAffordable()) {
                    GameController.getLastClicked().getTile().
                        setOccupant(melee);
                    melee.applyInitialCosts();
                    GameController.getLastClicked().updateTileView();
                } else if (units.getSelectionModel().getSelectedItem()
                        .equals("Ranged Unit") && ranged.isAffordable()) {
                    GameController.getLastClicked().getTile()
                        .setOccupant(ranged);
                    ranged.applyInitialCosts();
                    GameController.getLastClicked().updateTileView();
                } else if (units.getSelectionModel().getSelectedItem()
                    .equals("Hybrid Unit") && hybrid.isAffordable()) {
                    GameController.getLastClicked().getTile()
                        .setOccupant(hybrid);
                    hybrid.applyInitialCosts();
                    GameController.getLastClicked().updateTileView();
                } else if (units.getSelectionModel().getSelectedItem()
                    .equals("Siege Unit") && siege.isAffordable()) {
                    GameController.getLastClicked().getTile()
                        .setOccupant(siege);
                    siege.applyInitialCosts();
                    GameController.getLastClicked().updateTileView();
                } else if (units.getSelectionModel().getSelectedItem()
                    .equals("Settler Unit") && settler.isAffordable()) {
                    GameController.getLastClicked().getTile()
                        .setOccupant(settler);
                    settler.applyInitialCosts();
                    GameController.getLastClicked().updateTileView();
                } else if (units.getSelectionModel().getSelectedItem()
                    .equals("Farmer Unit") && farmer.isAffordable()) {
                    GameController.getLastClicked().getTile()
                        .setOccupant(farmer);
                    farmer.applyInitialCosts();
                    GameController.getLastClicked().updateTileView();
                } else if (units.getSelectionModel().getSelectedItem()
                    .equals("Coal Miner Unit") && coalMiner.isAffordable()) {
                    GameController.getLastClicked().getTile()
                        .setOccupant(coalMiner);
                    coalMiner.applyInitialCosts();
                    GameController.getLastClicked().updateTileView();
                } else if (units.getSelectionModel().getSelectedItem()
                    .equals("Angler Unit") && angler.isAffordable()) {
                    GameController.getLastClicked().getTile()
                        .setOccupant(angler);
                    angler.applyInitialCosts();
                    GameController.getLastClicked().updateTileView();
                } else if (units.getSelectionModel().getSelectedItem()
                    .equals("Master Builder Unit")
                    && masterBuilder.isAffordable()) {
                    GameController.getLastClicked().getTile()
                        .setOccupant(masterBuilder);
                    masterBuilder.applyInitialCosts();
                    GameController.getLastClicked().updateTileView();
                } else {
                    error.play();
                    Alert newAlert = new Alert(Alert.AlertType.WARNING);
                    newAlert.setTitle("Warning Dialog");
                    newAlert.setHeaderText("That action cannot be performed!");
                    newAlert.setContentText("You can't afford this unit! "
                        + "Press OK to continue.");
                    newAlert.showAndWait();
                }
                GameController.updateResourcesBar();
                GameController.setLastClicked(null);
            });
    }
}
