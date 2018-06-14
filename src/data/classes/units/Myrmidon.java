package data.classes.units;

import data.Stats;
import data.classes.Job;
import data.classes.Unpromoted;

import java.util.HashMap;

public class Myrmidon implements Job {
    public static int baseHP = 16;
    public static int baseAtk = 4;
    public static int baseTec = 9;
    public static int baseVit = 10;
    public static int baseCha = 6;
    public static int baseDef = 2;
    public static int baseRes = 0;
    public static int baseMvt = 5;
    //------------------------------//
    public static int baseGHP = 70;
    public static int baseGAtk = 35;
    public static int baseGTec = 40;
    public static int baseGVit = 40;
    public static int baseGCha = 30;
    public static int baseGDef = 15;
    public static int baseGRes = 20;
    //------------------------------//

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

    public HashMap<Stats, Integer> getVictorGrowth() {
        HashMap<Stats, Integer> hm = new HashMap<>();
        hm.put(Stats.Hp, 21);
        hm.put(Stats.Atk, 93);
        hm.put(Stats.Tec, 72);
        hm.put(Stats.Vit, 96);
        hm.put(Stats.Cha, 82);
        hm.put(Stats.Def, 15);
        hm.put(Stats.Res, 34);
        return hm;
    }

    public HashMap<Stats, Integer> getVictorBase() {
        HashMap<Stats, Integer> hm = new HashMap<>();
        hm.put(Stats.Hp, 23);
        hm.put(Stats.Atk, 9);
        hm.put(Stats.Tec, 12);
        hm.put(Stats.Vit, 14);
        hm.put(Stats.Cha, 10);
        hm.put(Stats.Def, 2);
        hm.put(Stats.Res, 1);
        hm.put(Stats.Mvt, 5);
        return hm;
    }

    @Override
    public int getPower() {
        return 2;
    }
    @Override
    public int getMaxLevel() {
        return levelCap;
    }
}
