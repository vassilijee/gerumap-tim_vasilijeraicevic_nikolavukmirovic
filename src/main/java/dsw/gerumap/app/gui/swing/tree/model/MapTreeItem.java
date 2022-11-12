package dsw.gerumap.app.gui.swing.tree.model;

import dsw.gerumap.app.repository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MapTreeItem extends DefaultMutableTreeNode {
    private MapNode mapNode;

    public MapTreeItem(MapNode nodeModel) {
        this.mapNode = nodeModel;
    }

    @Override
    public String toString() {
        return mapNode.getName();
    }

    public void setName(String name) {
        this.mapNode.setName(name);
        this.getMapNode().notifySubscribers(this);
    }

    public List<Object> getChildren() {
        List<Object> children = new ArrayList<>();
        for (int i = 0; i < this.getChildCount(); i++){
            children.add(this.getChildAt(i));
        }
        return children;
    }
}
