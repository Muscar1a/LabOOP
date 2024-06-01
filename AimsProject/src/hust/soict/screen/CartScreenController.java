package hust.soict.screen;

import hust.soict.aims.cart.Cart;
import hust.soict.aims.media.Media;
import hust.soict.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;

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
    private Button btnPlay, btnRemove;

    @FXML
    private void initialize() {
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("Category"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("Title"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("Cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observableValue, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                    private void updateButtonBar(Media media) {
                        btnRemove.setVisible(true);
                        btnPlay.setVisible(media instanceof Playable);
                    }
                }

        );
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }


}
