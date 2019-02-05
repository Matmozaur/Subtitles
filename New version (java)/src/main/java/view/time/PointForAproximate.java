package view.time;

import controller.manipulators.Manipulator;

import javax.swing.*;
import java.awt.event.*;

public class PointForAproximate extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSpinner spinner1;
    private JSpinner spinner2;
    int[] A;

    public PointForAproximate(int[] A) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        SpinnerNumberModel model1 = new SpinnerNumberModel(0, 0, 10000000, 1000);
        SpinnerNumberModel model2 = new SpinnerNumberModel(0, -100000, 100000, 100);
        spinner1.setModel(model1);
        spinner2.setModel(model2);
        this.A=A;

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
        A[0]=(Integer)spinner1.getValue();
        A[1]=(Integer)spinner2.getValue();
        this.setVisible(false);
    }

    private void onCancel() {
        this.setVisible(false);
    }

    public static void showDialog(int[] A){
        PointForAproximate dialog = new PointForAproximate(A);
        dialog.pack();
        dialog.setVisible(true);
    }
}
