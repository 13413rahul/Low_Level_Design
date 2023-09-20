package notificationservice;

public class BridgeMain {
    public static void main(String[] args) {
        QRMessage qrMessage = new QRMessage(new SMS());
        qrMessage.sendMessage();
    }
}
