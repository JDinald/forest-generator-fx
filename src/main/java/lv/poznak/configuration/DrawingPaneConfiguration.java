package lv.poznak.configuration;

import javafx.scene.layout.Pane;

public class DrawingPaneConfiguration {

  public Pane paneSetup(int x, int y) {
    Pane pane = new Pane();
    pane.setPrefSize(x, y);
    return pane;
  }
}
