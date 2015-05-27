package cn.meteor.srs.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by metror on 15/5/21.
 */
public class AddTicketFrame extends JFrame {
    private JLabel jLSeatNum, jLTPrice;
    private JComboBox jComBSeatNum;
    private JTextField jTf1, jTf2;
    private JPanel jPWest, jPCenter;
    JButton jBSubmit, jBCancle;
    public AddTicketFrame(){

        jPWest = new JPanel();
        jPCenter = new JPanel();
        jPWest.setLayout(new GridLayout(3, 1));
        jPCenter.setLayout(new GridLayout(3, 1));

        jComBSeatNum = new JComboBox();
        jTf2 = new JTextField();

        jLSeatNum = new JLabel("座位号:");
        jLTPrice = new JLabel ("票  价:");

        jBCancle = new JButton("取消");
        jBSubmit = new JButton("确定");


        jPWest.add(jLSeatNum);
        jPWest.add(jLTPrice);
        jPWest.add(jBSubmit);


        jPCenter.add(jComBSeatNum);
        jPCenter.add(jTf2);
        jPCenter.add(jBCancle);

        this.add(jPWest, BorderLayout.WEST);
        this.add(jPCenter, BorderLayout.CENTER);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setAlwaysOnTop(true);
        this.setSize(200, 120);
    }

    public JLabel getjLSeatNum() {
        return jLSeatNum;
    }

    public JLabel getjLTPrice() {
        return jLTPrice;
    }

    public JComboBox getjComBSeatNum() {
        return jComBSeatNum;
    }

    public JTextField getjTf1() {
        return jTf1;
    }

    public JTextField getjTf2() {
        return jTf2;
    }

    public JPanel getjPWest() {
        return jPWest;
    }

    public JPanel getjPCenter() {
        return jPCenter;
    }

    public JButton getjBSubmit() {
        return jBSubmit;
    }

    public JButton getjBCancle() {
        return jBCancle;
    }
}
