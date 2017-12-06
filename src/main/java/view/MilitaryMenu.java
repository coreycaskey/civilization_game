package view;

import controller.GameController;
import javafx.scene.control.Button;

/**
 * Created by William on 11/11/2016.
 */

public class MilitaryMenu extends AbstractMenu {
    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    public MilitaryMenu() {
        Button attack = new Button("Attack");
        addMenuItem(attack);

        Button move = new Button("Move");
        addMenuItem(move);

        attack.setOnAction(e -> {
                GameController.attacking();
                GameController.updateResourcesBar();
            });

        move.setOnAction(e -> {
                GameController.moving();
            });


    }
}
