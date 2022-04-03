package client;
import java.io.IOException;
public class ProduceClient {
    public static void main(String[] args) throws IOException {
        MqClient.produce("Hello middleware");
    }
}