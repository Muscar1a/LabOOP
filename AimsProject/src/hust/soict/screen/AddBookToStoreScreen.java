package hust.soict.screen;

import hust.soict.aims.media.Book;
import hust.soict.aims.store.Store;
import hust.soict.screen.AddItemToStoreScreen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleTextField;
    private JTextField costTextField;

    public AddBookToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected void initComponents() {
        setTitle("Add Book");
        setLayout(new GridLayout(6, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JLabel titleLabel = new JLabel("Title:");
        titleTextField = new JTextField();

        JLabel costLabel = new JLabel("Cost:");
        costTextField = new JTextField();

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleTextField.getText();
                float cost = Float.parseFloat(costTextField.getText());

                Book book = new Book(title, cost);
                store.addMedia(book);

                dispose();
            }
        });

        add(titleLabel);
        add(titleTextField);
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