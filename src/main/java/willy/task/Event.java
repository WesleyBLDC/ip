package willy.task;

/**
 * Represents the Event
 */
public class Event extends Task {
    private String from;
    private String to;
    private String code;

    /**
     * Creates the Event
     * @param msg contains the msg of the event
     * @param from the from part
     * @param to the to part of the string
     */
    public Event(String msg, String from, String to) {
        super(msg);
        this.from = from;
        this.to = to;
        this.code = "[E]";
    }
    
    /** 
     * @return String
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Returns a string representation of the Event
     */
    @Override
    public String toString() {
        return code + super.toString() + "(" + from + to + ")";
    }

}
