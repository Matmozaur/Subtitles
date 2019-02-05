package view.time;

import controller.manipulators.Manipulator;

import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class AproximatePointsNumberDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSpinner spinner1;
    private JTextArea ta;

    public AproximatePointsNumberDialog(JTextArea ta) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 10, 1);
        spinner1.setModel(model);
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
        int[] A=new int[2];
        Map<Integer,Integer> points=new HashMap<>();
        for(int i = 0; i<(Integer)spinner1.getValue(); i++){
            PointForAproximate.showDialog(A);
            points.put(A[0],A[1]);
        }
        Manipulator.changeByAproximatePolynomial(ta,points);
        this.setVisible(false);
    }

    private void onCancel() {
        this.setVisible(false);
    }

    public static void showDialog(JTextArea ta){
        AproximatePointsNumberDialog dialog = new AproximatePointsNumberDialog(ta);
        dialog.pack();
        dialog.setVisible(true);
    }
}
