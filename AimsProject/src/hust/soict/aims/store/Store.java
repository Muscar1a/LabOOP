package hust.soict.aims.store;

import java.util.ArrayList;

import hust.soict.aims.media.Media;

public class Store {
    public static final int MAX_NUMBERS_STORE = 1000;
    public ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsInStore.size() < MAX_NUMBERS_STORE) {
            itemsInStore.add(media);
            System.out.println("The disc has been added.");
        } else {
            System.out.println("No more space in store.");
        }
    }

    public void removeMedia(Media media) {
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i).getTitle().equals(media.getTitle())) {
                itemsInStore.remove(i);
                System.out.println("The disc" + media.getTitle() + "has been removed.");
                return;
            }
        }
        System.out.println("The disc is not in the store.");
    }

}
