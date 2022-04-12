public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Receiver started");
        DataReceiver receiver = new DataReceiver();
        GUI giu = new GUI(receiver);
    }
}