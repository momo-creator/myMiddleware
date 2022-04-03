package MyFirstMQ;
import java.util.concurrent.PriorityBlockingQueue;

public class Broker {
    //保存消息数据的容器
    private static PriorityBlockingQueue<Message> messageQuene = new PriorityBlockingQueue<>();

    //生产消息
    public static void produce(String msg, int priority){
        if(messageQuene.offer(new Message(msg,priority))){
            System.out.println("成功向消息处理中心投递消息：" + msg + ",当前暂存的消息数量是：" + messageQuene.size());
        }
        System.out.println("======================");
    }

    //消费消息
    public static Message consume(){
        Message msg = null;
        if(!messageQuene.isEmpty()){
            msg = messageQuene.poll();
            //消费条件满足情况，从消息容器中取出一条消息
            System.out.println("已经消费消息：" + msg + ",当前暂存的消息数量是：" + messageQuene.size());
        }else {
            System.out.println("消息处理中心内没有消息可供消费！");
        }
        System.out.println("=======================");
        return msg;
    }
}
