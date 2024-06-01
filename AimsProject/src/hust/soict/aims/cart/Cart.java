package hust.soict.aims.cart;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import hust.soict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
//    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();


    public int qtyOrdered = 0;
    /*
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    */
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public int getNumberOfItems() {
        return itemsOrdered.size();
    }

    public String addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        } else if (itemsOrdered.contains(media)) {
            return(media.getTitle() + " is already in the cart!");
        } else {
            qtyOrdered +=1;
            itemsOrdered.add(media);
            return (media.getTitle() + " has been added!");
        }
    }
    public void removeMedia(Media media) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Nothing to remove!");
        } else {
            if (itemsOrdered.remove(media)) {
                System.out.println(media.getTitle() + " has been removed from the cart.");
                qtyOrdered -=1;
            } else {
                System.out.println("Media not found in cart!");
            }
        }
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

    public Media search(String name) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(name)) {
                return media;
            }
        }
        return null;
    }

    public Media search(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered) {
            System.out.println(media);
        }
        System.out.println("Total items: " + qtyOrdered);
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    // Search to remove
    public Media searchToRemove(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public void clearCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Nothing to remove!");
        } else {
            qtyOrdered = 0;
            itemsOrdered.clear();
            System.out.println("Order created.");
            System.out.println("Now your current cart is empty!");
            System.out.println();
        }
    }

    public String placeOrder() {
        if (itemsOrdered.isEmpty()) {
            return "Your cart is empty!";
        } else {
            qtyOrdered = 0;
            itemsOrdered.clear();
            return "Order created!\n" + "Now your cart will be empty!";
        }
    }

    // Sort media in cart
    public void sortMediaByTitle() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();

        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    public void sortMediaByCost() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();

        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
}
