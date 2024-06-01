package hust.soict.test.store;
import hust.soict.aims.media.CompactDisc;
import hust.soict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store items = new Store();

        CompactDisc.DigitalVideoDisc dvd1 = new CompactDisc.DigitalVideoDisc("The Lion King",
        "Animation", "Roger Allers", 87, 19.95f);
        // items.addDVD(dvd1);

        CompactDisc.DigitalVideoDisc dvd2 = new CompactDisc.DigitalVideoDisc("Star Wars",
        "Science Fiction", "George Lucas", 87, 24.95f);
        // items.addDVD(dvd2);

        CompactDisc.DigitalVideoDisc dvd3 = new CompactDisc.DigitalVideoDisc("Aladin", "Animation", 18.99f);
        // items.addDVD(dvd3);

        CompactDisc.DigitalVideoDisc dvd4 = new CompactDisc.DigitalVideoDisc("Titanic");
        // items.removeDVD(dvd4);
        // items.removeDVD(dvd2);
    }
}
