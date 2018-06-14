package tests;

import battles.BattleOracle;
import data.DataCenter;
import data.classes.units.*;
import entities.players.*;
import views.Gui;
import views.ViewMap;

public class Test {
    public static void main(String args[]) {

        DataCenter m = new DataCenter(new Antoine(new Manakete(), 15), new Victor(new Myrmidon(), 6),
                new Fel(new PegasusKnight(), 9), new Flo(new Priest(), 13));

        Gui gui = new Gui(m);

    }
}
