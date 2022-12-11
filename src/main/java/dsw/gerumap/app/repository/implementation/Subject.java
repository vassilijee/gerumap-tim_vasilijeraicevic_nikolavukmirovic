package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;

public class Subject extends Element{
    private String name;
    private int x;
    private int y;
    private int h, w;
    public Subject(String name, MapNode parent, int a, int b) {
        super(name, parent);
        this.x = a;
        this.y = b;
    }
}
