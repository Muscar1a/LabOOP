package hust.soict.screen;

import hust.soict.aims.media.CompactDisc;
import hust.soict.aims.media.Track;
import hust.soict.aims.store.Store;
import hust.soict.screen.AddItemToStoreScreen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleTextField;
    private JTextField categoryTextField;
    private JTextField costTextField;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected void initComponents() {
        setTitle("Add Compact Disc");
        setLayout(new GridLayout(9, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JLabel titleLabel = new JLabel("Title:");
        titleTextField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        categoryTextField = new JTextField();

        JLabel costLabel = new JLabel("Cost:");
        costTextField = new JTextField();


        JButton addButton = new JButton("Add Compact Disc");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleTextField.getText();
                String category = categoryTextField.getText();
                float cost = Float.parseFloat(costTextField.getText());

                CompactDisc cd = new CompactDisc(title, category, cost);
                store.addMedia(cd);

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