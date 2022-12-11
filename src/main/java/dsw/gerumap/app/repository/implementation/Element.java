package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;

import java.awt.*;

public class Element extends MapNode {
    private Color color;
    private int stroke;
    public Element(String name, MapNode parent) {
        super(name, parent);
    }
}
