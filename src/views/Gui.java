package views;

import data.DataCenter;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame{

    private JMenuBar jMenuBar;
    private JMenu jMenu;
    private JMenuItem jMenuItem;

    private DataCenter m;
    private MainWindow mw;

    public Gui(DataCenter m){
        this.m = m;
        this.mw = new MainWindow(m);
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        jMenuBar = new JMenuBar();
        jMenu = new JMenu("Fichier");
        jMenuItem = new JMenuItem("Export Map");
        jMenuItem.addActionListener(actionListener -> m.exportMap());
        jMenu.add(jMenuItem);

        jMenuItem = new JMenuItem("Import Map");
        jMenuItem.addActionListener(actionListener -> m.loadMap());
        jMenu.add(jMenuItem);
        jMenuItem = new JMenuItem("Quitter");

        jMenuItem.addActionListener(actionListener -> System.exit(0));

        jMenu.add(jMenuItem);
        jMenuBar.add(jMenu);


        new Menus(m).setMenus(jMenuBar);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Fire Emblem RP Tool");
        setJMenuBar(jMenuBar);

        this.setContentPane(mw.mainPannel());

        MapTools mp = new MapTools(m);

        JFrame mapTools = new JFrame();
        mapTools.setContentPane(mp.mainPannel());
        mapTools.setPreferredSize(new Dimension(300, 500));
        mapTools.pack();
        mapTools.setVisible(true);
        setPreferredSize(new Dimension(350, 600));

        pack();
        setVisible(true);
        new  ViewMap(m);
    }
}
