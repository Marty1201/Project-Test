package fxmltableview;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This class contain various method which are used to populate the table view
 * and handling the events of the table view.
 *
 * @author chenxi
 */
public class FXMLTableViewController implements Initializable {

    //define class fields which reflects control fx:id of the table view
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn fName;
    @FXML
    private TableColumn lName;
    @FXML
    private TableColumn emailValue;
    @FXML
    private TextField fNameField;
    @FXML
    private TextField lNameField;
    @FXML
    private TextField emailField;
    @FXML
    private Button add;

    /**
     * show the content of the table，the value of each column cell is reflected
     * the objects' properties inside the ObservableList which had been set on
     * the table view
     */
    public void showList() {
        //the list of person objects to be setted on the table view
        ObservableList<Person> list = FXCollections.observableArrayList();
        //Sets the value of the property cellValueFactory
        //Creates a default PropertyValueFactory to extract the value from a given 
        //TableView row item reflectively, using the given property name
        fName.setCellValueFactory(new PropertyValueFactory("firstName"));
        lName.setCellValueFactory(new PropertyValueFactory("lastName"));
        emailValue.setCellValueFactory(new PropertyValueFactory("email"));
        Person jacob = new Person("chen", "Smithy", "jacob.smithy@example.com");
        Person ethan = new Person("xii", "William", "Xii.william@example.com");
        list.add(jacob);
        list.add(ethan);
        tableView.setItems(list);
        add.getText();
    }

    /**
     * add a Person on the list, with an alert
     * Note: this is a private method but marked as @FXML so it can be
     * accessed by FXML loader.
     * @param event
     */
    @FXML
    private void addPerson(javafx.event.ActionEvent event) {
        ObservableList<Person> data = tableView.getItems();
        if (data.add(new Person(fNameField.getText(), lNameField.getText(), emailField.getText()))) {
            Alert information = new Alert(Alert.AlertType.INFORMATION, "Success", ButtonType.OK);
            information.setTitle("Successful");
            information.showAndWait();
            fNameField.setText("");
            lNameField.setText("");
            emailField.setText("");
        } else {
            Alert error = new Alert(Alert.AlertType.ERROR, "Failed", ButtonType.NO);
            error.setTitle("Failed");
            error.showAndWait();
        }
    }

    /**
     * remove all Person on the list, with a confirmation , choose ok to remove
     * Note: this is a protected method but marked as @FXML so it can be
     * accessed by FXML loader.
     * @param event
     */
    @FXML
    protected void removePerson(javafx.event.ActionEvent event) {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to remove all data from the table?");
        confirmation.setTitle("remove warning");
        confirmation.setHeaderText("please confirm");
        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.isPresent() && result.get().equals(ButtonType.OK)) {
            ObservableList<Person> data = tableView.getItems();
            data.removeAll(data);
        }
    }

    /**
     * perform a post-processing on the table
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'fxml_tableview.fxml'.";
        showList();
    }
}