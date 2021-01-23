package lv.poznak;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lv.poznak.configuration.DrawingPaneConfiguration;
import lv.poznak.configuration.MenuConfiguration;

public class App extends Application {

  private MenuConfiguration menuConfiguration = new MenuConfiguration();
  private DrawingPaneConfiguration drawingPaneConfiguration = new DrawingPaneConfiguration();

  private Pane drawingPane = drawingPaneConfiguration.paneSetup(800, 800);
  private HBox mainMenu = menuConfiguration.addMenu(drawingPane);

  @Override
  public void start(Stage primaryStage) {
    BorderPane applicationBody = new BorderPane();

    applicationBody.setTop(mainMenu);
    applicationBody.setCenter(drawingPane);

    Scene scene = new Scene(applicationBody);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Forest generator");

    primaryStage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
