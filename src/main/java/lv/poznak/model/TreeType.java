package lv.poznak.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/** Contains similar data for all trees in forest */
public class TreeType {
  private String name;
  private Color color;
  private String otherTreeData;

  public TreeType(String name, Color color, String otherTreeData) {
    this.name = name;
    this.color = color;
    this.otherTreeData = otherTreeData;
  }

  public void draw(Pane pane, int x, int y) {

    Rectangle rectangle = new Rectangle(x - 1, y, 3, 5);
    rectangle.setFill(Color.BLACK);
    Ellipse ellipse = new Ellipse(x, y - 10, 10, 10);
    ellipse.setFill(color);
    pane.getChildren().addAll(rectangle, ellipse);
  }
}
