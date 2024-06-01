package hust.soict.screen;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;

import hust.soict.aims.media.Book;
import hust.soict.aims.media.DigitalVideoDisc;
import hust.soict.aims.media.Media;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.aims.cart.Cart;




public class CartScreen extends JFrame {

    private static Cart cart = new Cart();

    public CartScreen(Cart cart) {

        super();

        CartScreen.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));

                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public static void main(String[] args) throws LimitExceededException {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Movie 1", "Category 1", 9.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Movie 2", "Category 2", 7.99f);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        String bookTitle = "Book 1";
        String bookCategory = "Category 3";
        float bookCost = 12.99f;
        Book book = new Book(bookTitle, bookCategory, bookCost);

        cart.addMedia(book);

        new CartScreen(cart);
    }

}