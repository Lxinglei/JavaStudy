package cn.meteor.srs.service;

import cn.meteor.srs.commons.Condition;
import cn.meteor.srs.commons.Operation;
import cn.meteor.srs.dao.TicketDao;
import cn.meteor.srs.domain.Ticket;
import cn.meteor.srs.exception.NoTicketLeftException;
import org.junit.Test;

import java.util.List;

/**
 * Created by metror on 15/5/20.
 */
public class TicketSercice {
    private TicketDao ticketDao = new TicketDao();
    @Test
    public Boolean addTicket(Ticket tc){
        return ticketDao.add(tc);
    }
    @Test
    public void deleteTicket(){
        Ticket tc = new Ticket();
        tc.setTicketId("1002");
        ticketDao.delete(tc);
    }
    public void nnsubscribeTicket(Ticket tc){
        ticketDao.update(tc, Operation.UNSUBSCRIBE);
    }
    @Test
    public void queryAll(){
        System.out.println(ticketDao.queryAll() + "");
    }
    public void querySold(){

    }
    public List<Ticket> queryNotSold(){
        return ticketDao.find(Condition.NOT_SOLD);
    }
    @Test
    public void queryByTicketId(){
        Ticket tc = new Ticket();
        tc.setTicketId("1002");
        System.out.println(ticketDao.findByTicketId(tc.getTicketId()));
    }

    @Test
    public void booking() throws NoTicketLeftException {
        List<Ticket> notSoldTickets = ticketDao.find(Condition.NOT_SOLD);
        System.out.println("Size: " + notSoldTickets.size());
        if (notSoldTickets.size() <= 0){
            throw new NoTicketLeftException("票已售完!");
        }else {
            ticketDao.update(null, Operation.BOOKING);
        }
    }

    @Test
    public void RetTicket(){
        Ticket tc = ticketDao.findBySeatNumber(1);
        ticketDao.update(tc, Operation.UNSUBSCRIBE);
    }
    @Test
    public void TestgetNum(){
        System.out.println(ticketDao.findUnAddedSeat());
    }

    public List<Integer> getUnAddedSeat(){
        return ticketDao.findUnAddedSeat();
    }
}
