package hust.soict.aims.media;

import java.util.ArrayList;

import hust.soict.aims.disc.DigitalVideoDisc;

public class PolymorphismTestt {
    private static ArrayList<Media> meida = new ArrayList<Media>();
    public static void main(String[] args) {
        Book book = new Book("Introduction to Python");
        CompactDisc cd = new CompactDisc("Hello World");
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King");

        meida.add(book);
        meida.add(dvd);
        meida.add(cd);
        
        for (Media media : meida) {
            System.out.println(media.getTitle());
        }
    }
}
