package cn.meteor.srs.view;

import cn.meteor.srs.domain.Ticket;
import cn.meteor.srs.service.TicketSercice;

import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by metror on 15/5/21.
 */
public class MainFrame extends JFrame implements ActionListener {
    private Boolean flag;
    private TicketSercice ticketSercice = new TicketSercice();
    JLabel jl;
    JPanel jp1, jp2, jp3, jpMain;
    JButton jBtnAddTicket, jBtnDelTicket, jBtnBookingTicket, jBtnRetTicket;
    JButton jBtnQueryAll, jBtnQueryUnSold, jBtnQuerySold;
    JMenuBar jMB;
    JMenu jm1, jm2, jm3;
    JMenuItem jM1I1, jM1I2;
    JMenuItem jM2I1;
    public MainFrame(){
        jMB = new JMenuBar();
//        jl = new JLabel("欢迎进入订票系统");
//        jl.setLocation(150, 100);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jpMain = new JPanel();
        jpMain.setLayout(new GridLayout(3, 1, 1, 1));
        jpMain.setMaximumSize(new Dimension(300, 100));
        jBtnAddTicket = new JButton("添票");
        jBtnAddTicket.addActionListener(this);
        jBtnAddTicket.setActionCommand("addTicket");
        jBtnDelTicket = new JButton("删除票");
        jBtnDelTicket.setActionCommand("delete");
        jBtnDelTicket.addActionListener(this);
        jBtnBookingTicket = new JButton("订票");
        jBtnRetTicket = new JButton("退票");
        jBtnQueryAll = new JButton("查询所有票");
        jBtnQuerySold = new JButton("已售出票");
        jBtnQueryUnSold = new JButton("未售出票");

        jp1.setBackground(Color.black);
        jp1.add(jBtnAddTicket);
        jp1.add(jBtnDelTicket);

        jp2.setBackground(Color.green);
        jp2.add(jBtnQueryAll);
        jp2.add(jBtnQuerySold);
        jp2.add(jBtnQueryUnSold);

        jp3.setBackground(Color.cyan);
        jp3.add(jBtnBookingTicket);
        jp3.add(jBtnRetTicket);

        jm1 = new JMenu("动作");
        jM1I1 = new JMenuItem("退出");
        jm1.add(jM1I1);
        jm2 = new JMenu("帮助");
        jM2I1 = new JMenuItem("关于作者");
        jm2.add(jM2I1);
        jMB.add(jm1);
        jMB.add(jm2);
        this.setJMenuBar(jMB);
//        this.add(jl);
        jpMain.add(jp1);
        jpMain.add(jp2);
        jpMain.add(jp3);
        this.add(jpMain, BorderLayout.CENTER);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setTitle("订票系统");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("addTicket")){
            //this.setEnabled(false);
            final AddTicketFrame addTicketFrame = new AddTicketFrame();
            List<Integer> list = ticketSercice.getUnAddedSeat();
            for (int i=0; i<list.size(); i++){
                addTicketFrame.getjComBSeatNum().addItem(list.get(i).intValue() + "");
                final Ticket tc = new Ticket();


                addTicketFrame.getjBSubmit().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tc.setTicketId(UUID.randomUUID().toString().toUpperCase().replace("-", ""));
                        tc.setSeatNumber(Integer.parseInt(addTicketFrame.getjComBSeatNum().getSelectedItem().toString()));
                        tc.setPrice(Double.parseDouble(addTicketFrame.getjTf2().getText()));
                        ticketSercice.addTicket(tc);
                        System.out.println("Added!");
                        JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                });

                addTicketFrame.getjBCancle().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addTicketFrame.setVisible(false);
                    }
                });
            }
            this.setFocusableWindowState(false);
        }

        if (e.getActionCommand().equals("delete")){
            System.out.println("........");
            List<Ticket> notSoldTickets = ticketSercice.queryNotSold();
            DelTicketFrame delTicketFrame = new DelTicketFrame();
            System.out.println(notSoldTickets.size() + "");
            System.out.println(notSoldTickets.get(0));
            for (int i = 0; i < notSoldTickets.size(); i++) {
                System.out.println(notSoldTickets.get(i).getSeatNumber());
                delTicketFrame.getjComBUnSolds().addItem(notSoldTickets.get(i).getSeatNumber() + "");
            }

        }
    }
}
