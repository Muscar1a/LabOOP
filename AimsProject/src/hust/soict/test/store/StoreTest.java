package hust.soict.test.store;
import hust.soict.aims.disc.DigitalVideoDisc;
import hust.soict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store items = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc ("The Lion King",
        "Animation", "Roger Allers", 87, 19.95f);
        // items.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
        "Science Fiction", "George Lucas", 87, 24.95f);
        // items.addDVD(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        // items.addDVD(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Titanic");
        // items.removeDVD(dvd4);
        // items.removeDVD(dvd2);
    }
}
