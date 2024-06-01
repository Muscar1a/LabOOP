package hust.soict.screen;

import hust.soict.aims.store.Store;

import javax.swing.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        initComponents();
        addComponents();
    }

    protected abstract void initComponents();

    protected abstract void addComponents();

    public abstract void showScreen();
}