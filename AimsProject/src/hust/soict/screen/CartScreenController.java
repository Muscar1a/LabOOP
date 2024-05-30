package hust.soict.screen;

import hust.soict.aims.cart.Cart;
import hust.soict.aims.media.Media;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    private Cart cart;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }
    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private void initialize() {
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("Category"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("Title"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("Cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
    }

}
