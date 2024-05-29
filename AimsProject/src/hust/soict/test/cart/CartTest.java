package hust.soict.test.cart;

import hust.soict.aims.cart.Cart;
import hust.soict.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        DigitalVideoDisc[] dvdList = new DigitalVideoDisc[] { dvd1, dvd2, dvd3 };

        // test searching
        // anOrder.search("The Lion King");
        // anOrder.search("Titanic");

    }
}
