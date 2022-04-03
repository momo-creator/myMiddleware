package MyFirstMQ;


public class ProduceClient {
    public static void main(String[] args) throws Exception{
        MqClient client = new MqClient();
        client.produce("这是第三条消息，优先级为8"); //根据优先级进行消费，优先级越高越进行优先消费
    }
}

