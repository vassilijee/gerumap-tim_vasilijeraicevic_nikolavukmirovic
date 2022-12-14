package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.gui.swing.view.painters.ElementView;
import dsw.gerumap.app.gui.swing.view.painters.LinkView;
import dsw.gerumap.app.gui.swing.view.painters.TopicView;
import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.repository.composite.MapNode;
import dsw.gerumap.app.repository.implementation.*;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MindMapView extends JPanel implements ISubscriber {
    private String title;
    private MindMap mindMap;
    private List<ElementView> painters;
    private MindMapView mindMapView = this;
    private MouseController mouseController;
    private Rectangle selection;
    public MindMapView() {
        this.mindMap = null;
        title = "";
        this.painters = new ArrayList<>();
        mouseController = new MouseController();
        addMouseListener(mouseController);
        addMouseMotionListener(mouseController);
    }

    @Override
    public void update(Object object, Object notification) {
        if (notification.equals("RENAME")) {
            repaint();
        } else if (notification.equals("NEW")) {
            if (object instanceof Topic) {
                TopicView topicView = new TopicView((Topic) object);
                painters.add(topicView);
                ((Topic) object).addSubscriber(topicView);
                ((Topic) object).addSubscriber(this);
                JTextField field = new JTextField();
                JOptionPane pane = new JOptionPane(field, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION,
                        null);
                JDialog dialog = pane.createDialog("Tekst");
                dialog.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                        field.requestFocus();
                        field.selectAll();
                    }
                });
                dialog.setVisible(true);
                dialog.dispose();
                Object value = pane.getValue();
                if (value instanceof Integer) {
                    int result = (int) value;
                    if (result == JOptionPane.OK_OPTION) {
                        String tekst = field.getText();
                        topicView.getTopic().setName(tekst);
                    }
                }
                repaint();
            } else if (object instanceof Link) {
                LinkView linkView = new LinkView((Link) object);
                painters.add(linkView);
                ((Link) object).addSubscriber(linkView);
                ((Link) object).addSubscriber(this);
                repaint();
            }
        } else if (notification.equals("REPAINT")) {
            repaint();
        } else if (notification.equals("DELETE")) {
            ElementView e = null;
            for (ElementView ew :
                    painters) {
                if (ew.getElement() == object) {
                    e = ew;
                }
            }
            if (e != null) {
                painters.remove(e);
            }
        }
    }

    public void setMindMap(MindMap mindMap) {
        this.mindMap = mindMap;
        mindMap.addSubscriber(this);
        title = mindMap.getName();
        for (MapNode child :
                mindMap.getChildren()) {
            if (child instanceof Topic) {
                TopicView topicView = new TopicView((Topic) child);
                painters.add(topicView);
                child.addSubscriber(this);
                child.addSubscriber(topicView);
                repaint();
            } else if (child instanceof Link) {
                LinkView linkView = new LinkView((Link) child);
                painters.add(linkView);
                child.addSubscriber(this);
                child.addSubscriber(linkView);
                repaint();
            }
        }
    }

    private class MouseController extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            MainFrame.getInstance().getProjectView().clickedMouse(e.getX(), e.getY(), mindMapView);
        }

        public void mouseReleased(MouseEvent e) {
            MainFrame.getInstance().getProjectView().releasedMouse(e.getX(), e.getY(), mindMapView);
        }

        public void mouseDragged(MouseEvent e) {
            MainFrame.getInstance().getProjectView().draggedMouse(e.getX(), e.getY(), mindMapView);
        }
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ElementView p :
                painters) {
            p.draw(g);
        }
    }
}
