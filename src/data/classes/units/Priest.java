package data.classes.units;

import data.Stats;
import data.classes.Job;
import data.classes.Unpromoted;

import java.util.HashMap;

public class Priest implements Job{
    public static int baseHP = 18;
    public static int baseAtk = 1;
    public static int baseTec = 1;
    public static int baseVit = 2;
    public static int baseCha = 7;
    public static int baseDef = 1;
    public static int baseRes = 5;
    public static int baseMvt = 5;
    //------------------------------//
    public static int baseGHP = 50;
    public static int baseGAtk = 30;
    public static int baseGTec = 35;
    public static int baseGVit = 32;
    public static int baseGCha = 45;
    public static int baseGDef = 8;
    public static int baseGRes = 50;

    public static int levelCap = 20;

    @Override
    public HashMap<Stats, Integer> getGrowth() {
        HashMap<Stats, Integer> hm = new HashMap<>();
        hm.put(Stats.Hp, baseGHP);
        hm.put(Stats.Atk, baseGAtk);
        hm.put(Stats.Tec, baseGTec);
        hm.put(Stats.Vit, baseGVit);
        hm.put(Stats.Cha, baseGCha);
        hm.put(Stats.Def, baseGDef);
        hm.put(Stats.Res, baseGRes);
        return hm;
    }

    @Override
    public HashMap<Stats, Integer> getBase() {
        HashMap<Stats, Integer> hm = new HashMap<>();
        hm.put(Stats.Hp, baseHP);
        hm.put(Stats.Atk, baseAtk);
        hm.put(Stats.Tec, baseTec);
        hm.put(Stats.Vit, baseVit);
        hm.put(Stats.Cha, baseCha);
        hm.put(Stats.Def, baseDef);
        hm.put(Stats.Res, baseRes);
        hm.put(Stats.Mvt, baseMvt);
        return hm;
    }

    @Override
    public HashMap<Stats, Integer> getCaps() {
        return Unpromoted.getInstance().getCaps();
    }


    public HashMap<Stats, Integer> getFloGrowth() {
        HashMap<Stats, Integer> hm = new HashMap<>();
        hm.put(Stats.Hp, 74);
        hm.put(Stats.Atk, 79);
        hm.put(Stats.Tec, 35);
        hm.put(Stats.Vit, 27);
        hm.put(Stats.Cha, 25);
        hm.put(Stats.Def, 50);
        hm.put(Stats.Res, 72);
        return hm;
    }

    public HashMap<Stats, Integer> getFloBase() {
        HashMap<Stats, Integer> hm = new HashMap<>();
        hm.put(Stats.Hp, 26);
        hm.put(Stats.Atk, 9);
        hm.put(Stats.Tec, 5);
        hm.put(Stats.Vit, 6);
        hm.put(Stats.Cha, 7);
        hm.put(Stats.Def, 8);
        hm.put(Stats.Res, 14);
        hm.put(Stats.Mvt, 5);
        return hm;
    }

    @Override
    public int getPower() {
        return 0;
    }

    @Override
    public int getMaxLevel() {
        return levelCap;
    }
}
