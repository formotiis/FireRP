package views;

import data.DataCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class MainWindow implements Observer{
    private JProgressBar progressBar1;
    private JComboBox comboBox1;
    private JButton useButton1;
    private JProgressBar progressBar2;
    private JComboBox comboBox2;
    private JButton useButton2;
    private JProgressBar progressBar3;
    private JProgressBar progressBar4;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JButton useButton4;
    private JButton useButton3;
    private JPanel mainPane;
    private JLabel player1Name;
    private JLabel player2Name;
    private JLabel player3Name;
    private JLabel player4Name;
    private JProgressBar expBar1;
    private JProgressBar expBar2;
    private JProgressBar expBar3;
    private JProgressBar expBar4;
    private JPanel mapField;


    private DataCenter m;

    public MainWindow(DataCenter m) {
        this.m = m;
        m.addObserver(this);

        hpBarsInit();

        player1Name.setText(m.getPlayer(0).toString());
        player2Name.setText(m.getPlayer(1).toString());
        player3Name.setText(m.getPlayer(2).toString());
        player4Name.setText(m.getPlayer(3).toString());

        initCombo();

        update(m,this);

    }

    public JPanel mainPannel(){
        return this.mainPane;
    }


    @Override
    public void update(Observable o, Object arg) {
        if (m.comboBoxUpdate()){
            comboBox1.removeAllItems();
            for (int i=0;i<5;i++){
                if(m.getPlayer(0).getItems()[i]!=null)
                comboBox1.addItem(m.getPlayer(0).getItems()[i].toString());
            }
            comboBox2.removeAllItems();
            for (int i=0;i<5;i++){
                if(m.getPlayer(1).getItems()[i]!=null)
                    comboBox2.addItem(m.getPlayer(1).getItems()[i].toString());
            }
            comboBox3.removeAllItems();
            for (int i=0;i<5;i++){
                if(m.getPlayer(2).getItems()[i]!=null)
                    comboBox3.addItem(m.getPlayer(2).getItems()[i].toString());
            }
            comboBox4.removeAllItems();
            for (int i=0;i<5;i++){
                if(m.getPlayer(3).getItems()[i]!=null)
                    comboBox4.addItem(m.getPlayer(3).getItems()[i].toString());
            }
            m.comboUpdated();
        }
        updateHpProgress();
    }

    private void updateHpProgress(){
        progressBar1.setMaximum(m.getPlayer(0).getMaxHP());
        progressBar2.setMaximum(m.getPlayer(1).getMaxHP());
        progressBar3.setMaximum(m.getPlayer(2).getMaxHP());
        progressBar4.setMaximum(m.getPlayer(3).getMaxHP());
        progressBar1.setString(m.getPlayer(0).getCurrentHP()+"/"+m.getPlayer(0).getMaxHP());
        progressBar1.setValue(m.getPlayer(0).getCurrentHP());
        progressBar2.setString(m.getPlayer(1).getCurrentHP()+"/"+m.getPlayer(1).getMaxHP());
        progressBar2.setValue(m.getPlayer(1).getCurrentHP());
        progressBar3.setString(m.getPlayer(2).getCurrentHP()+"/"+m.getPlayer(2).getMaxHP());
        progressBar3.setValue(m.getPlayer(2).getCurrentHP());
        progressBar4.setString(m.getPlayer(3).getCurrentHP()+"/"+m.getPlayer(3).getMaxHP());
        progressBar4.setValue(m.getPlayer(3).getCurrentHP());

        expBar1.setString(m.getPlayer(0).getExp()+"/100");
        expBar1.setValue(m.getPlayer(0).getExp());
        expBar2.setString(m.getPlayer(1).getExp()+"/100");
        expBar2.setValue(m.getPlayer(1).getExp());
        expBar3.setString(m.getPlayer(2).getExp()+"/100");
        expBar3.setValue(m.getPlayer(2).getExp());
        expBar4.setString(m.getPlayer(3).getExp()+"/100");
        expBar4.setValue(m.getPlayer(3).getExp());
    }

    private void hpBarsInit(){
        progressBar1.setMinimum(0);
        progressBar2.setMinimum(0);
        progressBar3.setMinimum(0);
        progressBar4.setMinimum(0);
        expBar1.setMinimum(0);
        expBar1.setMaximum(100);
        expBar1.setForeground(Color.blue);

        expBar2.setMinimum(0);
        expBar2.setMaximum(100);
        expBar3.setMinimum(0);
        expBar3.setMaximum(100);
        expBar4.setMinimum(0);
        expBar4.setMaximum(100);


        updateHpProgress();
        progressBar1.setStringPainted(true);
        progressBar2.setStringPainted(true);
        progressBar3.setStringPainted(true);
        progressBar4.setStringPainted(true);
    }

    private void initCombo(){
        comboBox1.addActionListener(e -> {
            JComboBox combo = (JComboBox)e.getSource();
            String itemName = (String)combo.getSelectedItem();
            m.setEquipped(0,itemName);
        });
        useButton1.addActionListener(e -> {
            m.useItem(0);
        });

        comboBox2.addActionListener(e -> {
            JComboBox combo = (JComboBox)e.getSource();
            String itemName = (String)combo.getSelectedItem();
            m.setEquipped(1,itemName);
        });
        useButton2.addActionListener(e -> {
            m.useItem(1);
        });

        comboBox3.addActionListener(e -> {
            JComboBox combo = (JComboBox)e.getSource();
            String itemName = (String)combo.getSelectedItem();
            m.setEquipped(2,itemName);
        });
        useButton3.addActionListener(e -> {
            m.useItem(2);
        });
        comboBox4.addActionListener(e -> {
            JComboBox combo = (JComboBox)e.getSource();
            String itemName = (String)combo.getSelectedItem();
            m.setEquipped(3,itemName);
        });
        useButton4.addActionListener(e -> {
            m.useItem(3);
        });
    }
}
