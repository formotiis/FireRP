package views;

import data.DataCenter;
import data.Stats;
import entities.Entity;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class EntityViewer extends JFrame implements Observer{
    private JComboBox Class;
    private JSpinner unitLevel;
    private JSpinner unitExp;
    private JLabel unitName;
    private JSpinner curHP;
    private JSpinner mxHP;
    private JSpinner atkSpin;
    private JSpinner luckSpin;
    private JSpinner skillSpin;
    private JSpinner defSpin;
    private JSpinner resSpin;
    private JSpinner speedSpin;
    private JCheckBox slot0Eq;
    private JComboBox itemList0;
    private JComboBox itemList1;
    private JComboBox itemList2;
    private JComboBox itemList3;
    private JComboBox itemList4;
    private JSpinner item0Charges;
    private JCheckBox slot1Eq;
    private JCheckBox slot2Eq;
    private JCheckBox slot3Eq;
    private JCheckBox slot4Eq;
    private JSpinner mSwordspin;
    private JSpinner mSpearspin;
    private JSpinner mAxespin;
    private JSpinner mBowspin;
    private JSpinner mStaffspin;
    private JSpinner mAnimaspin;
    private JSpinner mDarkspin;
    private JSpinner mLightspin;
    private JLabel mSwordL;
    private JLabel mSpearL;
    private JLabel mAxeL;
    private JLabel mBowL;
    private JLabel mStaffL;
    private JLabel mAnimaL;
    private JLabel mDarkL;
    private JLabel mLightL;
    private JSpinner item1Charges;
    private JSpinner item2Charges;
    private JSpinner item3Charges;
    private JSpinner item4Charges;
    private JPanel mainPane;

    private DataCenter dataCenter;

    private Entity entity;


    public EntityViewer(DataCenter dataCenter, Entity entity) {
        this.dataCenter = dataCenter;
        this.entity = entity;

        unitName.setText(entity.toString());

        Class.addItem("ToDo");

        unitExp.setValue(entity.getExp());
        unitExp.addChangeListener(e -> {entity.setExp((int)((JSpinner)e.getSource()).getValue());dataCenter.forceRefresh();});

        unitLevel.setValue(entity.getLevel());
        unitLevel.addChangeListener(e -> {entity.setLevel((int)((JSpinner)e.getSource()).getValue());dataCenter.forceRefresh();});

        curHP.setValue(entity.getCurrentHP());
        curHP.addChangeListener(e -> {entity.setCurrentHP((int)((JSpinner)e.getSource()).getValue());dataCenter.forceRefresh(); });

        mxHP.setValue(entity.getMaxHP());
        mxHP.addChangeListener(e -> {entity.setStat(Stats.Hp, (int)((JSpinner)e.getSource()).getValue());dataCenter.forceRefresh(); });

        atkSpin.setValue(entity.getAtk());
        atkSpin.addChangeListener(e -> {entity.setStat(Stats.Atk, (int)((JSpinner)e.getSource()).getValue());dataCenter.forceRefresh(); });

        defSpin.setValue(entity.getDef());
        defSpin.addChangeListener(e -> {entity.setStat(Stats.Def, (int)((JSpinner)e.getSource()).getValue());dataCenter.forceRefresh(); });

        skillSpin.setValue(entity.getTec());
        skillSpin.addChangeListener(e -> {entity.setStat(Stats.Tec, (int)((JSpinner)e.getSource()).getValue());dataCenter.forceRefresh(); });

        resSpin.setValue(entity.getRes());
        resSpin.addChangeListener(e -> {entity.setStat(Stats.Res, (int)((JSpinner)e.getSource()).getValue());dataCenter.forceRefresh(); });

        luckSpin.setValue(entity.getCha());
        luckSpin.addChangeListener(e -> {entity.setStat(Stats.Cha, (int)((JSpinner)e.getSource()).getValue());dataCenter.forceRefresh(); });

        speedSpin.setValue(entity.getVit());
        speedSpin.addChangeListener(e -> {entity.setStat(Stats.Vit, (int)((JSpinner)e.getSource()).getValue());dataCenter.forceRefresh(); });

        int t = entity.getEquipedSlot();

        if (t == 0) {slot0Eq.setSelected(true);}
        else if (t==1){slot1Eq.setSelected(true);}
        else if (t==2){slot2Eq.setSelected(true);}
        else if (t==3){slot3Eq.setSelected(true);}
        else if (t==4){slot4Eq.setSelected(true);}
        setContentPane(mainPane);

        pack();
        setVisible(true);


    }

    @Override
    public void update(Observable o, Object arg) {
        curHP.setValue(entity.getCurrentHP());
        mxHP.setValue(entity.getMaxHP());
        atkSpin.setValue(entity.getAtk());
        defSpin.setValue(entity.getDef());
        skillSpin.setValue(entity.getTec());
        resSpin.setValue(entity.getRes());
        luckSpin.setValue(entity.getCha());
        speedSpin.setValue(entity.getVit());
    }
}
