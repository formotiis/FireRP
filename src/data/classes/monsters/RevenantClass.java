package data.classes.monsters;

import data.Stats;
import data.classes.Job;

import java.util.HashMap;

public class RevenantClass implements Job{
    public static int baseHP = 25;
    public static int baseAtk = 2;
    public static int baseTec = 0;
    public static int baseVit = 0;
    public static int baseCha = 4;
    public static int baseDef = 0;
    public static int baseRes = 0;
    public static int baseMvt = 4;
    //------------------------------//
    public static int baseGHP = 95;
    public static int baseGAtk = 50;
    public static int baseGTec = 30;
    public static int baseGVit = 20;
    public static int baseGCha = 10;
    public static int baseGDef = 10;
    public static int baseGRes = 13;
    //------------------------------//
    public static int capHP = 60;
    public static int capAtk =20;
    public static int capTec =20;
    public static int capVit =20;
    public static int capCha =30;
    public static int capDef =20;
    public static int capRes =20;
    public static int capMvt =15;

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
        HashMap<Stats, Integer> hm = new HashMap<>();
        hm.put(Stats.Hp, capHP);
        hm.put(Stats.Atk, capAtk);
        hm.put(Stats.Tec, capTec);
        hm.put(Stats.Vit, capVit);
        hm.put(Stats.Cha, capCha);
        hm.put(Stats.Def, capDef);
        hm.put(Stats.Res, capRes);
        hm.put(Stats.Mvt, capMvt);
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
