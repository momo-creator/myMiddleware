package MyFirstMQ;

public class Message implements Comparable<Message>{
    private int priority;
    private String msg;

    public Message(String msg,int priority){
        this.msg = msg;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msg='" + msg +
                ", priority=" + priority + '\'' +
                '}';
    }


        @Override
    public int compareTo(Message o) {
        return o.priority - this.priority;
    }
}
