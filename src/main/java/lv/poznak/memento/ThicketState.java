package lv.poznak.memento;

import lv.poznak.model.Forest;

import java.util.ArrayList;
import java.util.List;
/** This class is for saving state of thicket*/
public class ThicketState {

    private List<Forest> treeList = new ArrayList<>();

    public ThicketState(List<Forest> treeList) {
        this.treeList = treeList;
    }

    public List<Forest> getTreeList() {
        return treeList;
    }
}
