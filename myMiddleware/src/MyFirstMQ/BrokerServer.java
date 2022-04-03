package MyFirstMQ;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class BrokerServer implements Callable<String>{

    public static int SERVICE_PORT = 9999;

    private final Socket socket;

    public BrokerServer(Socket socket){
        this.socket = socket;
    }

    @Override
    public String call() throws Exception {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream())
        ) {
            while(true){
                String str = in.readLine();
                int priority = (str.charAt(str.length()-1))-48;
                if(str == null){
                    continue;
                }
                System.out.println("接收到原始数据：" + str);

                if("CONSUME".equals(str)){
                    //CONSUME表示要消费一条消息
                    //从消息队列中消费一条消息
                    Message message = Broker.consume();
                    out.println(message);
                    out.flush();
                }else {
                    //其他情况都表示生产消息放到消息队列中
                    Broker.produce(str,priority);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(SERVICE_PORT);
        while(true){
            Callable<String> callable = new BrokerServer(server.accept());
            FutureTask<String> futureTask = new FutureTask<>(callable);
            new Thread(futureTask).start();
        }
    }
}
