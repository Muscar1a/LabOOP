package hust.soict.screen;

import hust.soict.aims.cart.Cart;
import hust.soict.aims.exception.PlayerException;
import hust.soict.aims.media.Media;
import hust.soict.aims.media.Playable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.function.Predicate;

public class CartScreenController {
    private Cart cart;
    private FilteredList<Media> filteredMediaList;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterID;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private Label lblTotalCost;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue!=null) {
                    updateButtonBar(newValue);
                }
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        filteredMediaList = new FilteredList<>(cart.getItemsOrdered(), null);

        tblMedia.setItems(filteredMediaList);

        lblTotalCost.textProperty().bind(Bindings.format("$%.2f", cart.totalCost()));
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    void showFilteredMedia(String filter) {
        filteredMediaList.setPredicate(new Predicate<Media>() {
            @Override
            public boolean test(Media media) {
                if (filter == null || filter.isEmpty()) {
                    return true;
                }

                if (radioBtnFilterID.isSelected()) {
                    return String.valueOf(media.getId()).contains(filter);
                } else {
                    return media.getTitle().toLowerCase().contains(filter.toLowerCase());
                }
            }
        });
    }

    @FXML
    public void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        Alert alert;
        try {
            alert = new Alert(Alert.AlertType.NONE, media.playGUI());
            alert.setTitle("Playing");
            alert.setHeaderText(null);
            alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
            alert.showAndWait();
        } catch (PlayerException e) {
            alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.showAndWait();
        }

    }

    @FXML
    void placeOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, cart.placeOrder());
        alert.setTitle("Order created");
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}