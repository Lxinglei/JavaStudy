package cn.meteor.srs.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by metror on 15/5/22.
 */
public class DelTicketFrame extends JFrame {
    private JComboBox jComBUnSolds;
    public DelTicketFrame(){
        jComBUnSolds = new JComboBox();
        this.add(jComBUnSolds, BorderLayout.CENTER);
        this.setSize(100, 50);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public JComboBox getjComBUnSolds() {
        return jComBUnSolds;
    }
}
