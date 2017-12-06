package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {

    private GridFX newGrid = GridFX.getInstance();
    private static ResourcesMenu resMenu = new ResourcesMenu();
    private static AbstractMenu menu = new StatusMenu();
    private static VBox sideMenu = new VBox(15, menu.getRootNode());

    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        //TODO
        this.setCenter(newGrid);
        this.setTop(getResources().getRootNode());
        this.setLeft(sideMenu);
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
        //TODO
        newGrid.update();
        this.getResources().update();
    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        //TODO
        return resMenu;
    }

    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
        //TODO
        sideMenu.getChildren().remove(menu.getRootNode());
        if (state == GameController.GameState.MILITARY) {
            menu = new MilitaryMenu();
            sideMenu.getChildren().add(menu.getRootNode());
        } else if (state == GameController.GameState.WORKER) {
            menu = new WorkerMenu();
            sideMenu.getChildren().add(menu.getRootNode());
        } else if (state == GameController.GameState.RECRUITING) {
            menu = new RecruitMenu();
            sideMenu.getChildren().add(menu.getRootNode());
        } else if (state == GameController.GameState.BUILDING) {
            menu = new BuildingMenu();
            sideMenu.getChildren().add(menu.getRootNode());
        } else if (state == GameController.GameState.NEUTRAL) {
            menu = new StatusMenu();
            sideMenu.getChildren().add(menu.getRootNode());
        }
    }
}
