package data.classes.units;

import data.Stats;
import data.classes.Job;
import data.classes.Unpromoted;

import java.util.HashMap;

public class PegasusKnight implements Job{
    public static int baseHP = 14;
    public static int baseAtk = 4;
    public static int baseTec = 5;
    public static int baseVit = 5;
    public static int baseCha = 4;
    public static int baseDef = 3;
    public static int baseRes = 2;
    public static int baseMvt = 7;
    //------------------------------//
    public static int baseGHP = 65;
    public static int baseGAtk = 35;
    public static int baseGTec = 40;
    public static int baseGVit = 40;
    public static int baseGCha = 35;
    public static int baseGDef = 12;
    public static int baseGRes = 35;

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


    public HashMap<Stats, Integer> getFelGrowth() {
        HashMap<Stats, Integer> hm = new HashMap<>();
        hm.put(Stats.Hp, 62);
        hm.put(Stats.Atk, 64);
        hm.put(Stats.Tec, 38);
        hm.put(Stats.Vit, 88);
        hm.put(Stats.Cha, 13);
        hm.put(Stats.Def, 49);
        hm.put(Stats.Res, 64);
        return hm;
    }

    public HashMap<Stats, Integer> getFelBase() {
        HashMap<Stats, Integer> hm = new HashMap<>();
        hm.put(Stats.Hp, 19);
        hm.put(Stats.Atk, 11);
        hm.put(Stats.Tec, 8);
        hm.put(Stats.Vit, 11);
        hm.put(Stats.Cha, 6);
        hm.put(Stats.Def, 7);
        hm.put(Stats.Res, 8);
        hm.put(Stats.Mvt, 7);
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
