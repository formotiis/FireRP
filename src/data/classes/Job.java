package data.classes;

import data.Stats;

import java.util.HashMap;

public interface Job {

    HashMap<Stats, Integer> getGrowth();
    HashMap<Stats, Integer> getBase();
    HashMap<Stats, Integer> getCaps();
    int getPower();
    int getMaxLevel();

}
