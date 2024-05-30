package hust.soict.aims.cart;

import java.util.ArrayList;

import hust.soict.aims.disc.DigitalVideoDisc;
import hust.soict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
//    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    /*
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    */
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void removeMedia(Media media) {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getTitle().equals(media.getTitle())) {
                itemsOrdered.remove(i);
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc is not in the cart");
    }

    public float totalCost() {
        float cost = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            cost += itemsOrdered.get(i).getCost();
        }
        return cost;
    }

    public boolean isMatch(String name) {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getTitle().equals(name))
                return true;
        }
        return false;
    }

    public void searchTitle(String name) {
        if (isMatch(name) == true) {
            System.out.println("Item is already in cart!");
        } else {
            System.out.println("Not found");
        }
    }

    public void print() {
        System.out.println("Items in cart: "); 
        System.out.println("Ordered Items:");
        if (itemsOrdered.size() == 0) {
            System.out.println("Cart is empty");
            return;
        }
        for (Media media:itemsOrdered) {
            System.out.println(media.getTitle());
        }
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("-------------------------------");
    }
}
