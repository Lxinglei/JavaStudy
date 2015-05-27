package cn.meteor.srs.exception;

/**
 * Created by metror on 15/5/21.
 */
public class TicketHaveBeenSoldException extends Exception {
    public TicketHaveBeenSoldException(String message) {
        super(message);
    }

    public TicketHaveBeenSoldException() {
        super();
    }
}
