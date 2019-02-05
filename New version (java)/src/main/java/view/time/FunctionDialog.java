package view.time;

import controller.manipulators.Manipulator;

import javax.swing.*;
import java.awt.event.*;

public class FunctionDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSpinner spinner1;
    private JSpinner spinner2;
    JTextArea ta;

    public FunctionDialog(JTextArea ta) {
        setContentPane(contentPane);
        setModal(true);
        SpinnerNumberModel model1 = new SpinnerNumberModel(1.0, -10.0, 10.0, 0.001);
        SpinnerNumberModel model2 = new SpinnerNumberModel(0, -100000, 100000, 100);
        spinner1.setModel(model1);
        spinner2.setModel(model2);
        this.ta=ta;
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        Manipulator.changeByFunction(ta,(Double) spinner1.getValue(),(Integer) spinner2.getValue());
        this.setVisible(false);
    }

    private void onCancel() {
        this.setVisible(false);
    }

    public static void showDialog(JTextArea ta){
        FunctionDialog dialog = new FunctionDialog(ta);
        dialog.pack();
        dialog.setVisible(true);
    }
}
