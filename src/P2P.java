import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class P2P {
    public static class Message{
        String command;
        Object data;
    }
    List<String> peers = Arrays.asList("localhost:10011");

    DatagramSocket socket;
    BlockingQueue<Message> messageBlockingQueue =
            new LinkedBlockingQueue<Message>();

    private void loop() {
        while(true) {
            try {
                Message msg = messageBlockingQueue.take();
                switch(msg.command) {
                    case "boardcast":
                        boardcast((Block) msg.data);
                        break;
                    case "receivedBoardcast":
                        onReceivedBlock((Block) msg.data);
                        break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void bind() {
        try {
            socket = new DatagramSocket(10010);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void boardcast(Block block) {

    }

    private void onReceivedBlock(Block block) {

    }


}
