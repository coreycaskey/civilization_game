package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Civilization;


public class ResourcesMenu {

    public static final int PREFHEIGHT = 50;
    private Text stratLevel = new Text();
    private Text resources = new Text();
    private Text settlements = new Text();
    private Text money = new Text();
    private Text food = new Text();
    private Text happiness = new Text();
    private HBox resourceBar = new HBox(15, stratLevel, resources,
            settlements, money, food, happiness);


    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    public ResourcesMenu() {
        //TODO
        resourceBar.setPrefHeight(PREFHEIGHT);
        update();
    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {
        Civilization civ = GameController.getCivilization();

        stratLevel.setText("Strat Level: "
            + civ.getStrategy().getStrategyLevel());
        resources.setText("Resources: " + civ.getResources());
        settlements.setText("Settlements: " + civ.getNumSettlements());
        money.setText("Money: " + civ.getTreasury().getCoins());
        food.setText("Food: " + civ.getFood());
        happiness.setText("Happiness: " + civ.getHappiness());
    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        //TODO
        update();
        return resourceBar;
    }
}