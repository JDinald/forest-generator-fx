package lv.poznak.model;

import javafx.scene.layout.Pane;

import java.util.function.Consumer;

/** Tree is composite class leaf, which use builder pattern for creation */
public class Tree implements Forest {
  private int x;
  private int y;
  private final TreeType type;

  private Tree(Builder builder) {
    this.x = builder.x;
    this.y = builder.y;
    this.type = builder.type;
  }

  public static class Builder {
    public int x;
    public int y;
    private final TreeType type;

    public Builder(TreeType treeType) {
      this.type = treeType;
    }

    public Builder with(Consumer<Builder> consumer) {
      consumer.accept(this);
      return this;
    }

    public Tree build() {
      return new Tree(this);
    }
  }

  @Override
  public void draw(Pane pane) {
    type.draw(pane, x, y);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public TreeType getType() {
    return type;
  }
}
