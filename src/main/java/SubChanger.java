import view.GUI;
import java.awt.*;

class SubChanger {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI frame = new GUI();
            }
        });
    }
}
