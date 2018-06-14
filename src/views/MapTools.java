package views;

import data.Action;
import data.DataCenter;
import data.maps.Square;
import entities.Entity;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class MapTools implements Observer{
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton doButton;
    private JPanel mainPane;
    private JComboBox comboBox4;


    private DataCenter m;

    public MapTools(DataCenter m) {
        this.m = m;
        m.addObserver(this);

        initCases();

        comboBox1.addActionListener(e -> {
            JComboBox combo = (JComboBox)e.getSource();
            Action itemName = (Action) combo.getSelectedItem();
            m.setAction(itemName);
        });
        comboBox1.setSelectedItem(Action.EditMap);

        comboBox2.addActionListener(e -> {
            JComboBox combo = (JComboBox)e.getSource();
            Square itemName = (Square) combo.getSelectedItem();
            m.setClic(itemName);
        });
        comboBox2.setSelectedItem(Square.Blocked);

        comboBox4.addActionListener(e -> {
            JComboBox combo = (JComboBox)e.getSource();
            Entity itemName = (Entity) combo.getSelectedItem();
            m.setSelectedEntity(itemName);
        });
        comboBox4.setSelectedItem(m.getPlayer(0));
    }

    public JPanel mainPannel(){
        return this.mainPane;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (m.isEntityUpdate()){
            Entity tmp = m.getSelectedEntity();
            comboBox4.removeAllItems();
                for (Entity e:m.getEntities())
                    comboBox4.addItem(e);
            comboBox4.setSelectedItem(tmp);
            m.setEntityUpdated();
        }
    }

    private void initCases() {
        for (int i = 0; i < Action.values().length; i++) {
            comboBox1.addItem(Action.values()[i]);
        }
        for (int i = 0; i < Square.values().length; i++) {
            comboBox2.addItem(Square.values()[i]);
        }
        for (Entity e : m.getEntities()){
            comboBox4.addItem(e);
        }
    }

}
