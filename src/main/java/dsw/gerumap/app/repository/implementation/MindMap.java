package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.composite.MapNodeComposite;

public class MindMap extends MapNode {
    public MindMap(String name, MapNode parent) {
        super(name, parent);
    }

//    @Override
//    public void addChild(MapNode child) {
//        if(child != null && child instanceof Element){
//            Element element = (Element) child;
//            if(!this.getChildren().contains(element)){
//                this.getChildren().add(element);
//            }
//        }
//    }
}
