package views;

import data.DataCenter;
import data.items.consumables.*;
import data.items.weapons.monsterweapons.Dragonstone;
import data.items.weapons.monsterweapons.RottenClaw;
import data.items.weapons.monsterweapons.UnstableWretchedAir;
import data.items.weapons.swords.*;
import entities.monsters.Revenant;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;

public class Menus {

    private DataCenter m;

    public Menus(DataCenter m) {
        this.m = m;
    }

    public void setMenus(JMenuBar menubar) {
        JMenu jMenu, addItems;
        for(int i=0;i<4;i++) {
            jMenu = new JMenu(m.getPlayer(i).toString());
            addItems = new JMenu("Add Item");

            consumables(addItems, i);
            weapons(addItems, i);

            jMenu.add(addItems);
            menubar.add(jMenu);
        }

        jMenu = new JMenu("Add Entity");
        entityMenu(jMenu);
        menubar.add(jMenu);
    }

    private void consumables( JMenu jm,int i){
        JMenuItem jMenuItem;
        JMenu jMenu = new JMenu("Consumables");
        jm.add(jMenu);

        jMenuItem = new JMenuItem(Potion.name);
        jMenuItem.addActionListener(actionListener -> m.addItem(i, new Potion()));
        jMenu.add(jMenuItem);
    }

    private void weapons(JMenu jm, int i){

        JMenu jMenu = new JMenu("Weapons");
        swords(jMenu, i );
        monsterWeapons(jMenu, i);
        jm.add(jMenu);
    }

    private void swords(JMenu jm, int i){

        JMenuItem jMenuItem;
        JMenu jMenu = new JMenu("Swords");

        jMenuItem = new JMenuItem(IronSword.name);
        jMenuItem.addActionListener(actionListener -> m.addItem(i, new IronSword()));
        jMenu.add(jMenuItem);
        jMenuItem = new JMenuItem(SlimSword.name);
        jMenuItem.addActionListener(actionListener -> m.addItem(i, new SlimSword()));
        jMenu.add(jMenuItem);

        jMenuItem = new JMenuItem(BraveSword.name);
        jMenuItem.addActionListener(actionListener -> m.addItem(i, new data.items.weapons.swords.BraveSword()));
        jMenu.add(jMenuItem);

        jMenuItem = new JMenuItem(GodSword.name);
        jMenuItem.addActionListener(actionListener -> m.addItem(i, new GodSword()));
        jMenu.add(jMenuItem);

        jMenuItem = new JMenuItem(RuneSword.name);
        jMenuItem.addActionListener(actionListener -> m.addItem(i, new RuneSword()));
        jMenu.add(jMenuItem);

        jMenuItem = new JMenuItem(Wyrmslayer.name);
        jMenuItem.addActionListener(actionListener -> m.addItem(i, new Wyrmslayer()));
        jMenu.add(jMenuItem);



        jm.add(jMenu);
    }

    private void monsterWeapons(JMenu jm, int i){

        JMenuItem jMenuItem;
        JMenu jMenu = new JMenu("Monster Weapons");

        jMenuItem = new JMenuItem(Dragonstone.name);
        jMenuItem.addActionListener(actionListener -> m.addItem(i, new Dragonstone()));
        jMenu.add(jMenuItem);
        jMenuItem = new JMenuItem(RottenClaw.name);
        jMenuItem.addActionListener(actionListener -> m.addItem(i,new RottenClaw()));
        jMenu.add(jMenuItem);
        jMenuItem = new JMenuItem(UnstableWretchedAir.name);
        jMenuItem.addActionListener(actionListener -> m.addItem(i,new UnstableWretchedAir()));
        jMenu.add(jMenuItem);

        jm.add(jMenu);
    }

    private void entityMenu( JMenu jm){

        JMenuItem jMenuItem;

        jMenuItem = new JMenuItem(Revenant.name);
        jMenuItem.addActionListener(actionListener -> m.addEntity(new Revenant()));
        jm.add(jMenuItem);
    }


}
