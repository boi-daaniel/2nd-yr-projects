import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class Dormitory extends JFrame {
    JCheckBox Private, Internet, CableTV, Microwave, Refrigerator;
    JTextArea result;

    Dormitory() {
        setTitle("Dormitory");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Private = new JCheckBox("Private");
        Private.setFocusable(false);
        Internet = new JCheckBox("Internet");
        Internet.setFocusable(false);
        CableTV = new JCheckBox("Cable TV");
        CableTV.setFocusable(false);
        Microwave = new JCheckBox("Microwave");
        Microwave.setFocusable(false);
        Refrigerator = new JCheckBox("Refrigerator");
        Refrigerator.setFocusable(false);

        result = new JTextArea("Shared Room");
        result.setEditable(false);

        // Add ItemListeners to checkboxes
        Private.addItemListener(new CheckBoxListener());
        Internet.addItemListener(new CheckBoxListener());
        CableTV.addItemListener(new CheckBoxListener());
        Microwave.addItemListener(new CheckBoxListener());
        Refrigerator.addItemListener(new CheckBoxListener());

        add(Private);
        add(Internet);
        add(CableTV);
        add(Microwave);
        add(Refrigerator);
        add(result);

        setVisible(true);
    }

    // Inner class for ItemListener
    class CheckBoxListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            updateResult();
        }
    }

    // Method to update the result based on selected checkboxes
    private void updateResult() {
        StringBuilder resultText = new StringBuilder("Shared Room");

        if (Private.isSelected()) {
            resultText.append("\nPrivate");
        }

        if (Internet.isSelected()) {
            resultText.append("\nInternet");
        }

        if (CableTV.isSelected()) {
            resultText.append("\nCable TV");
        }

        if (Microwave.isSelected()) {
            resultText.append("\nMicrowave");
        }

        if (Refrigerator.isSelected()) {
            resultText.append("\nRefrigerator");
        }

        result.setText(resultText.toString());
    }

    public static void main(String[] args) {
        new Dormitory();
    }
}