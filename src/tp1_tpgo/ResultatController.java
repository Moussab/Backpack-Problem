/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp1_tpgo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author golden Boy
 */
public class ResultatController implements Initializable {
    @FXML
    private Label idResult;
    @FXML
    private TableView<ObjectImage> tabView;
    @FXML
    private TableColumn<ObjectImage, String> idCol;
    @FXML
    private TableColumn<ObjectImage, String> poidCol;
    @FXML
    private TableColumn<ObjectImage, String> valCol;
    private ObservableList<ObjectImage> data ;

    /**
     * Initializes the controller class.
     */
    public ResultatController() {
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void closeAction(ActionEvent event) {
        Stage quitter = (Stage) ((Node) event.getSource()).getScene().getWindow();
        quitter.close();
    }
    public void init(Objets objets ,int val){
        idResult.setText(String.valueOf(val));
        data=FXCollections.observableList(objets.getImages());
        valCol.setCellValueFactory(new PropertyValueFactory <ObjectImage, String> ("valeur"));
        poidCol.setCellValueFactory(new PropertyValueFactory <ObjectImage, String> ("poid"));
        idCol.setCellValueFactory(new PropertyValueFactory <ObjectImage, String> ("id"));
        tabView.setItems(data);
    }
}
