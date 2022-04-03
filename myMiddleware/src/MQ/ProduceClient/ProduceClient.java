package MQ.ProduceClient;

import MQ.MqClient.MqClient;

public class ProduceClient {
    public static void main(String[] args) throws Exception{
        MqClient client = new MqClient();
        client.produce("");
    }
}
