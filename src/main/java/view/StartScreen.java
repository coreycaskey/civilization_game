package view;

// import model.Civilization;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.collections.FXCollections;
import javafx.scene.control.Slider;
import javafx.scene.control.Button;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {

    private Button start = new Button("Start");
    private static Slider slider = new Slider(5, 20, 1);
    private ListView<CivEnum> lv = new ListView<>(
            FXCollections.observableArrayList(CivEnum.ANCIENT_EGYPT,
            CivEnum.QIN_DYNASTY, CivEnum.ROMAN_EMPIRE));

    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    public StartScreen() {
        //TODO

        ImageView image =
            new ImageView("File:./src/main/java/view/civ_background.png");
        image.setFitHeight(750);
        image.setFitWidth(1000);

        Text text = new Text("Select a Civilization to Begin");
        text.setFont(Font.font("Arial", 25));
        text.setFill(Color.RED);

        Text sliderText = new Text("Change the size of the map!");
        sliderText.setFont(Font.font("Arial", 25));
        sliderText.setFill(Color.RED);

        VBox sliderBox = new VBox();
        sliderBox.getChildren().addAll(sliderText, this.getSlider());
        sliderBox.setAlignment(Pos.CENTER);

        VBox selectCiv = new VBox();
        selectCiv.getChildren().addAll(text, this.getCivList(),
            this.getStartButton());
        selectCiv.setAlignment(Pos.BOTTOM_CENTER);

        VBox menu = new VBox();
        menu.getChildren().addAll(sliderBox, selectCiv);
        menu.setAlignment(Pos.BOTTOM_CENTER);
        menu.setSpacing(20);

        this.getChildren().add(image);
        this.getChildren().add(menu);
        this.setAlignment(menu, Pos.CENTER);
        this.setMargin(menu, new Insets(10, 10, 100, 10));
    }
    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        //TODO
        return start;
    }
    /**
    * return a ListView of CivEnums representing the list of
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        //TODO
        lv.setMaxHeight(100);
        lv.setMaxWidth(300);
        lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        return lv;
    }

    public static Slider getSlider() {
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(1.0);
        slider.setSnapToTicks(true);
        slider.setMinorTickCount(0);
        slider.setMaxWidth(400);
        return slider;
    }

}