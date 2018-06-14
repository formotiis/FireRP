package views;

import battles.BattleOracle;
import entities.Entity;

import javax.swing.*;

public class BattleWindow extends JFrame{
    private JLabel aName;
    private JButton battleButton;
    private JButton cancelButton;
    private JLabel dHp;
    private JLabel aHp;
    private JLabel dName;
    private JLabel aWeapon;
    private JLabel dWeapon;
    private JLabel dDmg;
    private JLabel dAcc;
    private JLabel dCrit;
    private JLabel aCrit;
    private JLabel aAcc;
    private JLabel aDmg;
    private JPanel mainPane;

    public BattleWindow(Entity a, Entity d, int r) {

        if (a!=null && d!=null) {
            aName.setText(a.toString());
            dName.setText(d.toString());

            BattleOracle b = BattleOracle.getInstance();

            aHp.setText(a.getCurrentHP() + "/" + a.getMaxHP());
            dHp.setText(d.getCurrentHP() + "/" + d.getMaxHP());
            if (a.hasWeapon())
                aWeapon.setText(a.getEquiped().toString());
            else aWeapon.setText("---");
            if (d.hasWeapon())
                dWeapon.setText(d.getEquiped().toString());
            else dWeapon.setText("---");

            aDmg.setText(b.calcDamages(a, d, r) + " " + b.sDoubleAttack(a, d));
            dDmg.setText(b.calcDamages(d, a, r) + " " + b.sDoubleAttack(d, a));

            aAcc.setText("" + b.accuracy(a, d));
            dAcc.setText("" + b.accuracy(d, a));

            aCrit.setText("" + b.critical(a, d));
            dCrit.setText("" + b.critical(d, a));


            battleButton.addActionListener(e -> {
                System.out.println(b.fight(a, d, r));
                this.dispose();
            });
            cancelButton.addActionListener(e -> this.dispose());

            setContentPane(mainPane);

            pack();
            setVisible(true);
        }
    }
}
