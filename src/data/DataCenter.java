package data;

import data.items.Item;
import data.maps.Map;
import data.maps.Square;
import entities.Entity;
import entities.players.Player;
import views.BattleWindow;
import views.ViewMap;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Random;

public class DataCenter extends Observable {

    private boolean comboBoxUpdate;
    private boolean entityUpdate;

    private Map currentMap;
    private JFrame map;

    private Square clic;
    private Action action;

    private Entity selectedEntity;

    private static Random randy;
    private static DataCenter instance;

    public static Random random(){
        if (randy==null){
            randy = new Random();
        }
        return randy;
    }

    public static DataCenter getInstance(){
        return instance;
    }

    public static int nextId=4;

    private ArrayList<Player> players;
    private ArrayList<Entity> entities;

    public DataCenter(Player... players) {
        this.players = new ArrayList<>(Arrays.asList(players));
        this.entities = new ArrayList<>(Arrays.asList(players));
        entityUpdate = false;
        clic = Square.Blocked;
        currentMap = new Map(15,18);
        instance = this;
        comboBoxUpdate = true;
    }

    public Player getPlayer(int slot){
        return players.get(slot);
    }

    public boolean comboBoxUpdate() {
        return comboBoxUpdate;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setClic(Square clic) {
        this.clic = clic;
    }

    public void comboUpdated(){
        comboBoxUpdate = false;
    }

    public void addItem(int slot, Item i){
        players.get(slot).addItem(i);
        comboBoxUpdate = true;
        updated();
    }

    public int getMapLength() {
        return currentMap.getLength();
    }

    public int getMapWidth() {
        return currentMap.getWidth();
    }

    public void clicked (int w, int l){
        if(action == Action.EditMap) {
            currentMap.set(w, l, clic);
            updated();
        } else if (action == Action.PlaceEntity){
            currentMap.placeEntity(selectedEntity, w, l);
            updated();
        } else if (action == Action.AutoPlace){
            if (currentMap.at(w,l)==Square.allySpawn){
                for (int i=0; i>4;i++){
                    Point p = currentMap.nextFreeAllySpawn();
                    if (p!=null)
                    currentMap.placeEntity(players.get(i), p);
                }
            } else if (currentMap.at(w,l)==Square.enemySpawn){
                for (Entity e:entities){
                    if (!e.isPlayer()){
                    Point p = currentMap.nextFreeEnemySpawn();
                    if (p!=null)
                        currentMap.placeEntity(e, p);
                    }
                }

            }
        } else if (action == Action.Battle){
            new BattleWindow(selectedEntity, currentMap.enAt(w,l),
                    (int)currentMap.findEntity(selectedEntity).distance(w,l));
        }
    }

    public Square at(int w, int l){
        return currentMap.at(w,l);
    }

    public void setEquipped(int player, String selected){
        boolean unfound = true;
        if (selected!=null) {
            for (int i = 0; i < 5 && unfound; i++) {
                if (players.get(player).getItems()[i]!=null)
                if (selected.equals(players.get(player).getItems()[i].toString())){
                    players.get(player).equip(i);
                    unfound = false;
                }
            }
        }
    }

    private void checkAndDeleteDead(){
        ArrayList<Entity> delete=new ArrayList<>();
        for(Entity e:entities){
            if (e.isDead()){
                delete.add(e);
            }
        }

        for(Entity e:delete){
            if (e.isDead()){
                entities.remove(e);
                currentMap.removeEntity(currentMap.findEntity(e));
            }
        }
        if (!delete.isEmpty()) {
            entityUpdate = true;
            updated();
        }
    }

    public void setSelectedEntity(Entity selectedEntity) {
        this.selectedEntity = selectedEntity;
    }

    public void exportMap(){
        this.currentMap.writeFile("test.map");
    }

    public void loadMap(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                ".map Files",  "map");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
            this.currentMap.readFile(chooser.getSelectedFile().getName());
            map.dispose();
            new ViewMap(this);
            updated();
        }
    }

    public void addMapFrame(ViewMap vm){
        map = vm;
        addObserver(vm);
    }

    public void addEntity(Entity e){
        this.entities.add(e);
        entityUpdate = true;
        updated();
    }

    private void updated(){
        setChanged();
        notifyObservers();
    }

    public boolean isEntityUpdate() {
        return entityUpdate;
    }

    public void setEntityUpdated() {
        this.entityUpdate = true;
    }

    public ArrayList<Entity> getEntities() {
        checkAndDeleteDead();
        return entities;
    }

    public Entity getSelectedEntity() {
        return selectedEntity;
    }

    public Entity enAt(int w, int l){
        return currentMap.enAt(w, l);
    }

    public void forceRefresh(){
        updated();
    }

    public void useItem(int slot){
        getPlayer(slot).useSelected();
        comboBoxUpdate = true;
        updated();
    }

    //public Entity getEntityByID()
}
