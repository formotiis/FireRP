package views;

import data.DataCenter;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ViewMap extends JFrame implements Observer {

    private JPanel map;
    private DataCenter m;
    private JButton jbArr[][];
    private int length;
    private int width;

    public ViewMap(DataCenter m) {
        this.m = m;
        m.addMapFrame(this);
        map = new JPanel();
        add(map, BorderLayout.CENTER);
        width = m.getMapWidth();
        length = m.getMapLength();
        map.setLayout(new GridLayout(length,width));
        mapInit();

        setPreferredSize(new Dimension(45*width, 40*length));
        setTitle("Fire Emblem RP Tool:Map");

        this.setContentPane(map);
        pack();
        setVisible(true);

    }

    @Override
    public void update(Observable o, Object arg) {
        for(int w =0; w<width;w++){
            for (int l = 0; l<length;l++) {
                jbArr[w][l].setBackground(m.at(w,l).toColor());

                jbArr[w][l].setText(shortened(w,l));
                jbArr[w][l].setToolTipText(desc(w,l));
            }
        }
    }

    private String desc(int w,int l){
        if(m.enAt(w,l)!=null){
            return m.enAt(w,l).getToolTipString();
        }
        return null;
    }

    private String shortened(int w, int l){
        if (m.enAt(w,l)!=null)
        return ""+m.enAt(w,l).toString().charAt(0)+m.enAt(w,l).getEntityID();
        return null;
    }

    private void mapInit(){
        JButton jb;
        jbArr = new JButton[width][length];
        for(int w =0; w<width;w++){
            for (int l = 0; l<length;l++){
                jb = new JButton();
                int finalW = w;
                int finalL = l;
                jb.addActionListener(actionListener -> m.clicked(finalW, finalL));
                map.add(jb);
                jbArr[w][l]=jb;
            }
        }
    }


}
