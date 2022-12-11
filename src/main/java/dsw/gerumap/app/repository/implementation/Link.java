package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;

public class Link extends Element{
    private Subject subjectOd;
    private Subject subjectDo;
    public Link(String name, MapNode parent) {
        super(name, parent);
    }
}
