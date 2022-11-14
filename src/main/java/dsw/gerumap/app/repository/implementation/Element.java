package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.composite.MapNode;

import java.util.ArrayList;
import java.util.List;

public class Element extends MapNode {
    public Element(String name, MapNode parent) {
        super(name, parent);
    }
}
