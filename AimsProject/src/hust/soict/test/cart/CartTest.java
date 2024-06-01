package hust.soict.test.cart;

import hust.soict.aims.cart.Cart;
import hust.soict.aims.media.CompactDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        // Create new dvd objects and add them to the cart
        CompactDisc.DigitalVideoDisc dvd1 = new CompactDisc.DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);

        CompactDisc.DigitalVideoDisc dvd2 = new CompactDisc.DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);

        CompactDisc.DigitalVideoDisc dvd3 = new CompactDisc.DigitalVideoDisc("Aladin", "Animation", 18.99f);

        CompactDisc.DigitalVideoDisc[] dvdList = new CompactDisc.DigitalVideoDisc[] { dvd1, dvd2, dvd3 };

        // test searching
        // anOrder.search("The Lion King");
        // anOrder.search("Titanic");

    }
}
