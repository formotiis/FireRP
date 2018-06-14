package data.maps;

import entities.Entity;
import sun.security.util.Length;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Map {
    private int width;
    private int length;

    private Square map[][];
    private Entity enMap[][];

    public Map(int width, int length) {
        this.width = width;
        this.length = length;
        this.map = new Square[width][length];
        this.enMap = new Entity[width][length];
        defaultInit();
    }

    public Square at(int width, int length) {
        return map[width][length];
    }

    public void readFile(String name){
        FileReader flot;
        File file = new File(name);
        BufferedReader flotFiltre;
        try {
            flot = new FileReader(name);
            flotFiltre = new BufferedReader(flot);
            Scanner input = new Scanner(flotFiltre);
            length = input.nextInt();
            width = input.nextInt();
            this.map = new Square[width][length];
            this.enMap = new Entity[width][length];
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < length; j++) {
                    map[i][j]= Square.fromInt(input.nextInt());
                }
            }
        } catch (IOException e) {

        }
    }

    public void writeFile(String name){
        FileWriter flot ;
        PrintWriter flotFiltre ;
        try {
            flot = new FileWriter(name) ;
            flotFiltre = new PrintWriter(new BufferedWriter(flot)) ;
            flotFiltre.println(length);
            flotFiltre.println(width);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < length; j++) {
                    flotFiltre.println(at(i, j).toInt());
                }
            }
            flotFiltre.close() ;
        } catch (IOException e)
        {}

    }

    private void defaultInit(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                map[i][j]= Square.Default;
            }
        }
    }


    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public Point nextFreeEnemySpawn(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (map[i][j]==Square.enemySpawn&&enMap[i][j]==null){
                    return new Point(i,j);
                }
            }
        }
        return null;
    }

    public Point nextFreeAllySpawn(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (map[i][j]==Square.allySpawn&&enMap[i][j]==null){
                    return new Point(i,j);
                }
            }
        }
        return null;
    }

    public void placeEntity(Entity e, Point p) {
        placeEntity(e, p.x, p.y);
    }

    public void placeEntity(Entity e, int x, int y){
        Point p = findEntity(e);
        if (enMap[x][y]==null) {
            if (p != null)
                removeEntity(p.x, p.y);
            enMap[x][y] = e;
        }
    }

    public void removeEntity(int x, int y){
        enMap[x][y] = null;
    }

    public void removeEntity(Point p){
        enMap[p.x][p.y] = null;
    }
    public boolean isAlreadyPlaced(Entity e){
        return findEntity(e)!=null;
    }

    public Entity enAt(int w, int l){
        return enMap[w][l];
    }

    public Point findEntity(Entity e){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (enMap[i][j]==e){
                    return new Point(i,j);
                }
            }
        }
        return null;
    }


    public void set(int w, int l, Square x){
        map[w][l] = x;
    }
}
