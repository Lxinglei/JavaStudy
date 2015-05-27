package cn.meteor.srs.domain;

import cn.meteor.srs.commons.Status;

/**
 * Created by metror on 15/5/20.
 */
public class Ticket {
    public static final int MAX_SEAT_NUMBER = 100;
    private String ticketId;
    private double price;
    private int status = Status.NOT_SOLD;
    private int seatNumber;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
