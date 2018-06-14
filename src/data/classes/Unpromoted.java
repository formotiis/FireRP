package data.classes;

import data.Stats;

import java.util.HashMap;

public class Unpromoted {

    public static int capHP = 60;
    public static int capAtk =20;
    public static int capTec =20;
    public static int capVit =20;
    public static int capCha =30;
    public static int capDef =20;
    public static int capRes =20;
    public static int capMvt =15;


    private static Unpromoted instance;

    public static Unpromoted getInstance(){
        if (instance==null) {
            instance = new Unpromoted();
        }
            return instance;
    }

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
}
