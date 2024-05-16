package hust.soict.aims.cart;

import java.util.ArrayList;

import hust.soict.aims.disc.DigitalVideoDisc;
import hust.soict.aims.media.Media;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

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

    public void search(String name) {
        if (isMatch(name) == true) {
            System.out.println("Item is already in cart!");
        } else {
            System.out.println("Not found");
        }
    }

}
