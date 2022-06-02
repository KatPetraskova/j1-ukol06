package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JTextField husyField;
    private JTextField kraliciField;
    private JButton vypocitatButton;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;
    int pocetHlav;
    int pocetNohou;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setLabelFor(husyField);
        add(husyLabel);
        add(husyField);
        husyField.setHorizontalAlignment(JTextField.TRAILING);

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setLabelFor(kraliciField);
        add(kraliciLabel);
        add(kraliciField);
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);

        add(createButtonBar(), "span");

        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setLabelFor(pocetHlavField);
        add(pocetHlavLabel);
        add(pocetHlavField);
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setEditable(false);

        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setLabelFor(pocetNohouField);
        add(pocetNohouLabel);
        add(pocetNohouField);
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouField.setEditable(false);

        pack();

        getRootPane().setDefaultButton(vypocitatButton);
        vypocitatButton.addActionListener(this::handleVypocitat);
    }

    private JPanel createButtonBar() {
        vypocitatButton = new JButton("Vypočítat");

        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        buttonBar.add(vypocitatButton);
        return buttonBar;
    }


    private void handleVypocitat(ActionEvent actionEvent) {

        String husyText = husyField.getText();
        String kraliciText = kraliciField.getText();

        int husyCislo = Integer.parseInt(husyText);
        int kraliciCislo = Integer.parseInt(kraliciText);

        int pocetHlav = (1*husyCislo + 1*kraliciCislo);
        int pocetNohou = (2*husyCislo) + (4*kraliciCislo);

        System.out.println("Počet hlav: " + pocetHlav);
        System.out.println("Počet nohou: " + pocetNohou);

        pocetHlavField.setText(String.valueOf(pocetHlav));
        pocetNohouField.setText(String.valueOf(pocetNohou));

        }
}
