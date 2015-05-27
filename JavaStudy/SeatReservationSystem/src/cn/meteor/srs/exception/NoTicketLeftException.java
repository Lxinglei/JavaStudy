package cn.meteor.srs.exception;

/**
 * Created by metror on 15/5/21.
 */
public class NoTicketLeftException extends Exception{
    public NoTicketLeftException() {
        super();
    }

    public NoTicketLeftException(String message) {
        super(message);
    }
}
