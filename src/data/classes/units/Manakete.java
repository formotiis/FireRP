package data.classes.units;

import data.Stats;
import data.classes.Job;
import data.classes.Unpromoted;

import java.util.HashMap;

public class Manakete implements Job {
    public static int baseHP = 12;
    public static int baseAtk = 0;
    public static int baseTec = 0;
    public static int baseVit = 2;
    public static int baseCha = 6;
    public static int baseDef = 2;
    public static int baseRes = 2;
    public static int baseMvt = 6;
    //------------------------------//
    public static int baseGHP = 95;
    public static int baseGAtk = 40;
    public static int baseGTec = 30;
    public static int baseGVit = 20;
    public static int baseGCha = 25;
    public static int baseGDef = 0;
    public static int baseGRes = 10;

    public static int levelCap = 30;

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

    @Override
    public int getPower() {
        return 2;
    }

    public HashMap<Stats, Integer> getAntoineGrowth() {
        HashMap<Stats, Integer> hm = new HashMap<>();
        hm.put(Stats.Hp, 78);
        hm.put(Stats.Atk, 89);
        hm.put(Stats.Tec, 48);
        hm.put(Stats.Vit, 51);
        hm.put(Stats.Cha, 100);
        hm.put(Stats.Def, 92);
        hm.put(Stats.Res, 18);
        return hm;
    }

    public HashMap<Stats, Integer> getAntoineBase() {
        HashMap<Stats, Integer> hm = new HashMap<>();
        hm.put(Stats.Hp, 21);
        hm.put(Stats.Atk, 11);
        hm.put(Stats.Tec, 9);
        hm.put(Stats.Vit, 12);
        hm.put(Stats.Cha, 20);
        hm.put(Stats.Def, 15);
        hm.put(Stats.Res, 5);
        hm.put(Stats.Mvt, 6);
        return hm;
    }
    @Override
    public int getMaxLevel() {
        return levelCap;
    }
}
