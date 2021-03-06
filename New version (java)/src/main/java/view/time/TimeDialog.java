package view.time;

import javax.swing.*;
import java.awt.event.*;

public class TimeDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JButton ConstantButton;
    private JButton functionButton;
    private JButton aproximatePointsButton;

    private TimeDialog(JTextArea ta) {
        setContentPane(contentPane);
        setModal(true);
        buttonCancel.addActionListener(e -> onCancel());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        ConstantButton.addActionListener(actionEvent -> ConstantDialog.showDialog(ta));
        functionButton.addActionListener(actionEvent -> FunctionDialog.showDialog(ta));
        aproximatePointsButton.addActionListener(actionEvent -> ApproximatePointsNumberDialog.showDialog(ta));
    }


    private void onCancel() {
        this.setVisible(false);    }

    public static void showDialog(JTextArea ta){
        TimeDialog dialog = new TimeDialog(ta);
        dialog.pack();
        dialog.setVisible(true);
    }
}
