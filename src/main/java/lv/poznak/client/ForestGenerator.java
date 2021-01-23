package lv.poznak.client;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import lv.poznak.factory.TreeFactory;
import lv.poznak.model.Thicket;
import lv.poznak.model.Tree;
import lv.poznak.model.TreeType;

/** Flyweight pattern client */
public class ForestGenerator {

  private Thicket thicket = new Thicket();

  public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
    TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
    Tree tree =
        new Tree.Builder(type)
            .with(
                builder -> {
                  builder.x = x;
                  builder.y = y;
                })
            .build();
    thicket.addTree(tree);
  }

  public Thicket getThicket() {
    return thicket;
  }

  public void paint(Pane pane) {
    thicket.draw(pane);
  }
}
