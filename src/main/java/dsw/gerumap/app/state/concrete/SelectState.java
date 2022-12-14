package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.gui.swing.view.painters.ElementView;
import dsw.gerumap.app.state.State;


public class SelectState extends State {
    @Override
    public void clickedMouse(int x, int y, MindMapView m) {
        //m.getSelected().clear();
        super.clickedMouse(x, y, m);
        m.getSelection().setFrame(x, y, 2, 2);
    }

    @Override
    public void draggedMouse(int x, int y, MindMapView m) {
        super.draggedMouse(x, y, m);
        int x1 = (int) m.getSelection().getX();
        int y1 = (int) m.getSelection().getY();
//        neki pokusaj matematike da bi radilo crtanje na sve strane
//        sada radi samo od gornjeg levog coska ka desnom donjem
//        int px = Math.min(x1, x);
//        int py = Math.min(y1, y);
//        int pw = Math.abs(x1 - x);
//        int ph = Math.abs(y1 - y);

        //System.out.println("(" + x + ", " + y + ")");
        m.getSelection().setFrame(x1, y1, x - x1, y - y1);
        m.repaint();
    }

    @Override
    public void releasedMouse(int x, int y, MindMapView m) {
        super.releasedMouse(x, y, m);
        for (ElementView elementView : m.getPainters()) {
            if (elementView.getS().intersects(m.getSelection())) {
                System.out.printf("\n" + elementView.getElement().getName());
                m.getSelected().add(elementView);
            }
        }
    }
}
