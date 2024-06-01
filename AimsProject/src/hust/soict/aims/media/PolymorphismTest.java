package hust.soict.aims.media;

import java.util.ArrayList;

public class PolymorphismTest {
    private static ArrayList<Media> meida = new ArrayList<Media>();
    public static void main(String[] args) {
        Book book = new Book("Introduction to Python");
        CompactDisc cd = new CompactDisc("Hello World");
        CompactDisc.DigitalVideoDisc dvd = new CompactDisc.DigitalVideoDisc("The Lion King");

        meida.add(book);
        meida.add(dvd);
        meida.add(cd);
        
        for (Media media : meida) {
            System.out.println(media.getTitle());
        }
    }
}
