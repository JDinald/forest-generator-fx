package lv.poznak.configuration;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import lv.poznak.client.ForestGenerator;
import lv.poznak.memento.ThicketState;

public class MenuConfiguration {

  static int CANVAS_SIZE = 700;
  static int TREES_TO_DRAW = 1000;
  static int TREE_TYPES = 3;
  static ForestGenerator forestGenerator;
  static ThicketState savedState;

  public HBox addMenu(Pane pane) {

    HBox hbox = new HBox();
    hbox.setPadding(new Insets(15, 12, 15, 12));
    hbox.setSpacing(10);
    hbox.setStyle("-fx-background-color: white;");

    Button generateButton = new Button("Generate");
    generateButton.setPrefSize(100, 20);
    generateButton.setOnAction(
        e -> {
          forestGenerator = new ForestGenerator();
          pane.getChildren().clear();
          for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
            forestGenerator.plantTree(
                random(50, CANVAS_SIZE),
                random(50, CANVAS_SIZE),
                "Summer Oak",
                Color.GREEN,
                "Oak texture stub");
            forestGenerator.plantTree(
                random(50, CANVAS_SIZE),
                random(50, CANVAS_SIZE),
                "Autumn Oak",
                Color.ORANGE,
                "Autumn Oak texture stub");
            forestGenerator.plantTree(
                random(50, CANVAS_SIZE),
                random(50, CANVAS_SIZE),
                "Sakura",
                Color.PINK,
                "Sakura texture stub");
          }
          forestGenerator.paint(pane);
        });

    Button saveButton = new Button("Save");
    saveButton.setPrefSize(100, 20);
    saveButton.setOnAction(
        e -> {
          savedState = forestGenerator.getThicket().save();
        });

    Button restoreButton = new Button("Restore");
    restoreButton.setPrefSize(100, 20);
    restoreButton.setOnAction(
        e -> {
          pane.getChildren().clear();
          forestGenerator.getThicket().restore(savedState);
          forestGenerator.paint(pane);
        });

    hbox.getChildren().addAll(generateButton, saveButton, restoreButton);

    return hbox;
  }

  private static int random(int min, int max) {
    return min + (int) (Math.random() * ((max - min) + 1));
  }
}
