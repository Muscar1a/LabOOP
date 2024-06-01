package hust.soict.screen;

import hust.soict.aims.media.DigitalVideoDisc;
import hust.soict.aims.store.Store;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleTextField;
    private JTextField categoryTextField;
    private JTextField costTextField;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected void initComponents() {
        setTitle("Add DVD");
        setLayout(new GridLayout(7, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);


        JLabel titleLabel = new JLabel("Title:");
        titleTextField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        categoryTextField = new JTextField();

        JLabel costLabel = new JLabel("Cost:");
        costTextField = new JTextField();

        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleTextField.getText();
                String category = categoryTextField.getText();
                float cost = Float.parseFloat(costTextField.getText());

                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost);
                store.addMedia(dvd);

                dispose();
            }
        });

        add(titleLabel);
        add(titleTextField);
        add(categoryLabel);
        add(categoryTextField);
        add(costLabel);
        add(costTextField);
        add(new JLabel());
        add(addButton);
    }

    @Override
    protected void addComponents() {
        pack();
    }

    @Override
    public void showScreen() {
        setVisible(true);
    }
}