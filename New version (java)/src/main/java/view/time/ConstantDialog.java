package view.time;

import controller.manipulators.Manipulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConstantDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSpinner spinner1;
    private JTextArea ta;

    public ConstantDialog(JTextArea ta) {
        setContentPane(contentPane);
        setModal(true);
        SpinnerNumberModel model = new SpinnerNumberModel(0, -100000, 100000, 10);
        spinner1.setModel(model);
        getRootPane().setDefaultButton(buttonOK);
        this.ta=ta;

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

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        Manipulator.changeByConst(ta,(Integer)spinner1.getValue());
        this.setVisible(false);
    }

    private void onCancel() {
       this.setVisible(false);
    }

    public static void showDialog(JTextArea ta){
        ConstantDialog dialog = new ConstantDialog(ta);
        dialog.pack();
        dialog.setVisible(true);
    }
}
