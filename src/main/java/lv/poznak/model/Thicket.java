package lv.poznak.model;

import javafx.scene.layout.Pane;
import lv.poznak.memento.ThicketState;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Thicket is composite class */
public class Thicket implements Forest {

  private List<Forest> treeList = new ArrayList<>();

  public void removeTree(Forest forest) {
    treeList.remove(forest);
  }

  public void addTree(Forest forest) {
    treeList.add(forest);
  }

  /**
   * This function is used to save generated thicket state
   * @return saved Thicket state
   */
  public ThicketState save() {
    return new ThicketState(treeList);
  }

  /**
   * This function is used to restore saved thicket state
   * @param thicketState - thicket state to save
   */
  public void restore(ThicketState thicketState) {
    this.treeList = thicketState.getTreeList();
  }

  @Override
  public void draw(Pane pane) {
    for (Iterator<Forest> i = treeList.iterator(); i.hasNext(); ) {
      Tree drawTree = (Tree) i.next();
      drawTree.draw(pane);
    }
  }
}
