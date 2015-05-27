package cn.meteor.srs.dao;

import cn.meteor.srs.commons.Condition;
import cn.meteor.srs.commons.Operation;
import cn.meteor.srs.commons.Status;
import cn.meteor.srs.domain.Ticket;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.testng.annotations.Test;

import javax.xml.soap.Node;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by metror on 15/5/20.
 */
public class TicketDao {
    private String path = "/Users/metror/ticket.xml";

    public Boolean add(Ticket tc) {
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(path);
            Element root = doc.getRootElement();
            Element ticketEle = root.addElement("ticket");
            ticketEle.addAttribute("id", tc.getTicketId());
            ticketEle.addAttribute("price", tc.getPrice() + "");
            ticketEle.addAttribute("seatnumber", tc.getSeatNumber() + "");
            ticketEle.addAttribute("status", tc.getStatus() + "");


            OutputFormat format = new OutputFormat("\t", true);//缂╄繘浣跨敤\t锛屾槸鍚︽崲琛岋紝浣跨敤鏄紒
            format.setTrimText(true);//娓呯┖鍘熸湁鐨勬崲琛屽拰缂╄繘

            // 鍒涘缓XmlWriter
            XMLWriter writer;
            try {
                writer = new XMLWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(path), "UTF-8"), format);
                writer.write(doc);
                writer.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public void delete(Ticket tc) {
        String tId = tc.getTicketId();
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(path);
            Element root = doc.getRootElement();
            List<Node> nodeList = doc.selectNodes("//ticket");
            for (int i = 0; i < nodeList.size(); i++) {
                Element e = (Element) nodeList.get(i);
                if (e.attributeValue("id").equals(tId)) {
                    System.out.println("find...");
                    System.out.println(doc);
                    root.remove(e);
                    System.out.println(doc);
                    System.out.println("find.d..");
                    break;
                }
            }
            OutputFormat format = new OutputFormat("\t", true);
            format.setTrimText(true);

            // 鍒涘缓XmlWriter
            XMLWriter writer;
            try {
                writer = new XMLWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(path), "UTF-8"), format);
                writer.write(doc);
                writer.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Ticket tc, int operation) {

        switch (operation){
            case Operation.UNSUBSCRIBE:
                tc.setStatus(Status.NOT_SOLD);
                break;
            case Operation.BOOKING:
                tc = findFirstUnSold();
                tc.setStatus(Status.SOLD);
                break;

        }

        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(path);
            Element root = doc.getRootElement();
            List<Node> nodeList = doc.selectNodes("//ticket");
            for (int i = 0; i < nodeList.size(); i++) {
                Element e = (Element) nodeList.get(i);
                if (e.attributeValue("id").equals(tc.getTicketId())) {
                    System.out.println("正在修改状态...");
                    System.out.println(doc);
                    e.attribute("status").setValue(tc.getStatus() + "");
                    System.out.println(doc);
                    System.out.println("状态修改完毕..");
                    break;
                }
            }
            OutputFormat format = new OutputFormat("\t", true);//缂╄繘浣跨敤\t锛屾槸鍚︽崲琛岋紝浣跨敤鏄紒
            format.setTrimText(true);//娓呯┖鍘熸湁鐨勬崲琛屽拰缂╄繘

            // 鍒涘缓XmlWriter
            XMLWriter writer;
            try {
                writer = new XMLWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(path), "UTF-8"), format);
                writer.write(doc);
                writer.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    public Ticket findFirstUnSold(){
        return find(Condition.NOT_SOLD).get(0);
    }

    public List<Ticket> queryAll() {
        List<Ticket> list = new ArrayList<Ticket>();
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(path);
            List<Node> nodeList = doc.selectNodes("//ticket");
            for (int i = 0; i < nodeList.size(); i++) {
                Element e = (Element) nodeList.get(i);
                Ticket tc = new Ticket();
                String strStatus = e.attributeValue("status");
                int status = Integer.parseInt(strStatus);
                if (status == Status.NOT_SOLD) {
                    status = Status.NOT_SOLD;
                } else {
                    status = Status.SOLD;
                }
                tc.setTicketId(e.attributeValue("id"));
                tc.setPrice(Double.parseDouble(e.attributeValue("price")));
                tc.setSeatNumber(Integer.parseInt(e.attributeValue("seatnumber")));
                tc.setStatus(status);

                list.add(tc);
            }


        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Ticket findByTicketId(String tId) {
        Ticket tc = new Ticket();
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(path);
            List<Node> nodeList = doc.selectNodes("//ticket");
            for (int i = 0; i < nodeList.size(); i++) {
                Element e = (Element) nodeList.get(i);
                if (e.attributeValue("id").equals(tId)) {
                    String strStatus = e.attributeValue("status");
                    int status = Integer.parseInt(strStatus);
                    if (status == Status.NOT_SOLD) {
                        status = Status.NOT_SOLD;
                    } else {
                        status = Status.SOLD;
                    }
                    tc.setTicketId(e.attributeValue("id"));
                    tc.setPrice(Double.parseDouble(e.attributeValue("price")));
                    tc.setSeatNumber(Integer.parseInt(e.attributeValue("seatnumber")));
                    tc.setStatus(status);
                    break;
                }
            }

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        return tc;
    }

    public List<Ticket> find(int condition){
        List<Ticket> list = new ArrayList<Ticket>();
        Ticket tc = new Ticket();
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(path);
            List<Node> nodeList = doc.selectNodes("//ticket");
            for (int i = 0; i < nodeList.size(); i++) {
                Element e = (Element) nodeList.get(i);
                if (e.attributeValue("status").equals(Integer.toString(condition))) {
                    String strStatus = e.attributeValue("status");
                    int status = Integer.parseInt(strStatus);
                    if (status == Status.NOT_SOLD) {
                        status = Status.NOT_SOLD;
                    } else {
                        status = Status.SOLD;
                    }
                    tc.setTicketId(e.attributeValue("id"));
                    tc.setPrice(Double.parseDouble(e.attributeValue("price")));
                    tc.setStatus(status);
                    System.out.println(tc);
                    if (condition == Condition.NOT_SOLD){
                        if (tc.getStatus() == Status.NOT_SOLD)
                            list.add(tc);
                    }else if (condition == Condition.SOLD){
                        if (tc.getStatus() == Status.SOLD)
                            list.add(tc);
                    }
                }
            }

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Ticket findBySeatNumber(int sm){
        Ticket tc = new Ticket();
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(path);
            List<Node> nodeList = doc.selectNodes("//ticket");
            for (int i = 0; i < nodeList.size(); i++) {
                Element e = (Element) nodeList.get(i);
                if (e.attributeValue("seatnumber").equals(Integer.toString(sm))) {
                    String strStatus = e.attributeValue("status");
                    int status = Integer.parseInt(strStatus);
                    if (status == Status.NOT_SOLD) {
                        status = Status.NOT_SOLD;
                    } else {
                        status = Status.SOLD;
                    }
                    tc.setTicketId(e.attributeValue("id"));
                    tc.setPrice(Double.parseDouble(e.attributeValue("price")));
                    tc.setSeatNumber(Integer.parseInt(e.attributeValue("seatnumber")));
                    tc.setStatus(status);
                    break;
                }
            }

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        return tc;
    }
    public ArrayList<Integer> findUnAddedSeat(){
        int[] array = new int[Ticket.MAX_SEAT_NUMBER + 1];
        array[0] = -1;
        List<Ticket> ticketList = queryAll();
        for (int j=1; j<array.length; j++){
            for (int i = 0; i < ticketList.size(); i++) {
                Ticket tc = ticketList.get(i);
                int seatNumber = tc.getSeatNumber();
                if (seatNumber == j){
                    array[j] = -1;
                    break;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0){
                list.add(new Integer(i));
            }
        }
        return list;

    }

}
