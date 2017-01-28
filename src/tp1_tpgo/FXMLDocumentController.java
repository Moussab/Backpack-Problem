/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp1_tpgo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author golden Boy
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private ImageView logo;
    @FXML
    private ImageView imgObj;
    @FXML
    private TextField spinPoid;
    @FXML
    private TextField spinValeur;
    @FXML
    private Label labelVal;
    @FXML
    private Label LabelPoid;
    @FXML
    private AnchorPane anchors;
    @FXML
    private ImageView img00;
    @FXML
    private ImageView img21;
    @FXML
    private ImageView img33;
    
    private Objets objets = new Objets();

    @FXML
    private SplitPane backGround;
    
    private int idObject=0;
    @FXML
    private AnchorPane infoAnchors;
    @FXML
    private Label labelVal1;
    @FXML
    private Label LabelPoid1;
    @FXML
    private Label idVal;
    @FXML
    private Label idPoid;
    @FXML
    private ImageView img01;
    @FXML
    private ImageView img30;
    @FXML
    private ImageView img20;
    @FXML
    private ImageView img10;
    @FXML
    private ImageView img11;
    @FXML
    private ImageView img31;
    @FXML
    private ImageView img02;
    @FXML
    private ImageView img12;
    @FXML
    private ImageView img22;
    @FXML
    private ImageView img32;
    @FXML
    private ImageView img03;
    @FXML
    private ImageView img13;
    @FXML
    private ImageView img23;
    private  int[][]  tab ;
    @FXML
    private Button btnValider;
    private int poidMax=0;
    @FXML
    private ImageView sacImg;
    private int valMax=0;
    
    public FXMLDocumentController() {
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void objAction(ActionEvent event) {
        imgObj.setImage(new Image(FXMLDocumentController.class.getResource("obj.png").toExternalForm()));   
        labelVal.setVisible(true);
        spinValeur.setVisible(true);
        btnValider.setVisible(false);
        btnValider.setDisable(true);
    }

    @FXML
    private void sacAction(ActionEvent event) {
        imgObj.setImage(new Image(FXMLDocumentController.class.getResource("sac.png").toExternalForm()));   
        labelVal.setVisible(false);
        spinValeur.setVisible(false);
        btnValider.setDisable(false);
        btnValider.setVisible(true);
        
       
    }

    @FXML
    private void runAction(ActionEvent event) {
        int  c=objets.getObjImages().size();
        if(poidMax > 0){
            tab = new int[c+1][poidMax+1];
            for(int i=0;i<=c;i++ ){
                for (int j=0;j<=poidMax;j++){
                    if(i==0 || j==0){
                        tab[i][j]=0;
                    } else if(j<Integer.parseInt(objets.getObjImages().get(i-1).getPoid())){
                        tab[i][j]=tab[i-1][j];
                    }else{
                        tab[i][j]= Math.max(tab[i-1][j],tab[i-1][j-Integer.parseInt(objets.getObjImages().get(i-1).getPoid())]+Integer.parseInt(objets.getObjImages().get(i-1).getValeur()));
                    }
                }
            }
            valMax=tab[c][poidMax];
            btnValider.setText("resultat");
            btnValider.setDisable(false);
            btnValider.setVisible(true);
            int j=poidMax;
            int i=c;
            while(j>0 && tab[i][j]==tab[i][j-1]){
                   j--;
               }
            while(j>0){
               while(i>1 && tab[i][j]==tab[i-1][j]){
                   i--;
               } 
               j=j-Integer.parseInt(objets.getObjImages().get(i-1).getPoid());
               if(j>=0){
                   objets.getImages().add(objets.getObjImages().get(i-1));
               }
               i--;
            }
           /* for( i=0;i<=c;i++ ){
                for ( j=0;j<=poidMax;j++){
                    System.out.print(tab[i][j]+"\t");
                }
                System.out.println();
            }
            System.out.println("val final == "+tab[c][poidMax]);*/
            for(ObjectImage obj : objets.getImages()){
                switch(obj.getI()){
                    case 0 : switch(obj.getJ()){
                                case 0 :animate(img00);break;
                                case 1 :animate(img01);break; 
                                case 2 :animate(img02);break;
                                case 3 :animate(img03);break;
                            }break;
                    case 1 : switch(obj.getJ()){
                                case 0 :animate(img10);break;
                                case 1 :animate(img11);break; 
                                case 2 :animate(img12);break;
                                case 3 :animate(img13);break;
                            }break;
                    case 2 : switch(obj.getJ()){
                                case 0 :animate(img20);break;
                                case 1 :animate(img21);break; 
                                case 2 :animate(img22);break;
                                case 3 :animate(img23);break;
                            }break;
                    case 3 : switch(obj.getJ()){
                                case 0 :animate(img30);break;
                                case 1 :animate(img31);break; 
                                case 2 :animate(img32);break;
                                case 3 :animate(img33);break;
                            }break;
                }
            }
        } 
    }

    @FXML
    private void closeAction(ActionEvent event) {
        Stage quitter = (Stage) ((Node) event.getSource()).getScene().getWindow();
        quitter.close();
    }


    @FXML
    private void overimg33(DragEvent event) {
        if (event.getGestureSource() != img33 && event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
    }

    @FXML
    private void dropedimg33(DragEvent event) {
        if(spinValeur.getText().isEmpty() || spinPoid.getText().isEmpty()) return;
        ObjectImage objectImage = new ObjectImage(String.valueOf(spinValeur.getText()), String.valueOf(spinPoid.getText()),3,3);       
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            objectImage.setId(db.getString());
            objets.addImage(objectImage);
            img33.setImage(imgObj.getImage());
            success = true;
            event.setDropCompleted(success);
            event.consume();
        }
        
    }

    @FXML
    private void sourceobj(MouseEvent event) {
        Dragboard db = imgObj.startDragAndDrop(TransferMode.ANY);
        idObject++;
        ClipboardContent content = new ClipboardContent();
        content.putString(String.valueOf(idObject));
        db.setContent(content);
        event.consume();
    }

    @FXML
    private void doneobj(DragEvent event) {
        if (event.getTransferMode() == TransferMode.MOVE) {
            animate2(imgObj);
            spinPoid.setText("");
            spinValeur.setText("");
       }
        event.consume();
    }

    @FXML
    private void mouseExited33(MouseEvent event) {
        infoAnchors.setVisible(false);
        idPoid.setText("");
        idVal.setText("");
        event.consume();
    }

    @FXML
    private void mouseEntred33(MouseEvent event) {
        ObjectImage obj =objets.ifExist(3,3);
        if(obj!=null && !obj.getPoid().isEmpty() && !obj.getPoid().isEmpty() ){
            infoAnchors.setVisible(true);
            idPoid.setText(obj.getPoid());
            idVal.setText(obj.getValeur());
        }
        event.consume();
    }

    

    @FXML
    private void dropedimg00(DragEvent event) {
        if(spinValeur.getText().isEmpty() || spinPoid.getText().isEmpty()) return;
        ObjectImage objectImage = new ObjectImage(String.valueOf(spinValeur.getText()), String.valueOf(spinPoid.getText()),0,0);       
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            objectImage.setId(db.getString());
            objets.addImage(objectImage);
            img00.setImage(imgObj.getImage());
            success = true;
            event.setDropCompleted(success);
            event.consume();
        }
    }


    @FXML
    private void dropedimg01(DragEvent event) {
        if(spinValeur.getText().isEmpty() || spinPoid.getText().isEmpty()) return;
        ObjectImage objectImage = new ObjectImage(String.valueOf(spinValeur.getText()), String.valueOf(spinPoid.getText()),0,1);       
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            objectImage.setId(db.getString());
            objets.addImage(objectImage);
            img01.setImage(imgObj.getImage());
            success = true;
            event.setDropCompleted(success);
            event.consume();
        }
    }

   

    @FXML
    private void dropedimg30(DragEvent event) {
        if(spinValeur.getText().isEmpty() || spinPoid.getText().isEmpty()) return;
        ObjectImage objectImage = new ObjectImage(String.valueOf(spinValeur.getText()), String.valueOf(spinPoid.getText()),3,0);       
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            objectImage.setId(db.getString());
            objets.addImage(objectImage);
            img30.setImage(imgObj.getImage());
            success = true;
            event.setDropCompleted(success);
            event.consume();
        }
    }

    

    @FXML
    private void dropedimg20(DragEvent event) {
        if(spinValeur.getText().isEmpty() || spinPoid.getText().isEmpty()) return;
        ObjectImage objectImage = new ObjectImage(String.valueOf(spinValeur.getText()), String.valueOf(spinPoid.getText()),2,0);       
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            objectImage.setId(db.getString());
            objets.addImage(objectImage);
            img20.setImage(imgObj.getImage());
            success = true;
            event.setDropCompleted(success);
            event.consume();
        }
    }


    @FXML
    private void dropedimg10(DragEvent event) {
        if(spinValeur.getText().isEmpty() || spinPoid.getText().isEmpty()) return;
        ObjectImage objectImage = new ObjectImage(String.valueOf(spinValeur.getText()), String.valueOf(spinPoid.getText()),1,0);       
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            objectImage.setId(db.getString());
            objets.addImage(objectImage);
            img10.setImage(imgObj.getImage());
            success = true;
            event.setDropCompleted(success);
            event.consume();
        }
    }

   

    @FXML
    private void dropedimg11(DragEvent event) {
        if(spinValeur.getText().isEmpty() || spinPoid.getText().isEmpty()) return;
        ObjectImage objectImage = new ObjectImage(String.valueOf(spinValeur.getText()), String.valueOf(spinPoid.getText()),1,1);       
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            objectImage.setId(db.getString());
            objets.addImage(objectImage);
            img11.setImage(imgObj.getImage());
            success = true;
            event.setDropCompleted(success);
            event.consume();
        }
    }

    

    @FXML
    private void dropedimg21(DragEvent event) {
        if(spinValeur.getText().isEmpty() || spinPoid.getText().isEmpty()) return;
        ObjectImage objectImage = new ObjectImage(String.valueOf(spinValeur.getText()), String.valueOf(spinPoid.getText()),2,1);       
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            objectImage.setId(db.getString());
            objets.addImage(objectImage);
            img21.setImage(imgObj.getImage());
            success = true;
            event.setDropCompleted(success);
            event.consume();
        }
    }


    @FXML
    private void dropedimg31(DragEvent event) {
        if(spinValeur.getText().isEmpty() || spinPoid.getText().isEmpty()) return;
        ObjectImage objectImage = new ObjectImage(String.valueOf(spinValeur.getText()), String.valueOf(spinPoid.getText()),3,1);       
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            objectImage.setId(db.getString());
            objets.addImage(objectImage);
            img31.setImage(imgObj.getImage());
            success = true;
            event.setDropCompleted(success);
            event.consume();
        }
    }


    @FXML
    private void dropedimg02(DragEvent event) {
        if(spinValeur.getText().isEmpty() || spinPoid.getText().isEmpty()) return;
        ObjectImage objectImage = new ObjectImage(String.valueOf(spinValeur.getText()), String.valueOf(spinPoid.getText()),0,2);       
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            objectImage.setId(db.getString());
            objets.addImage(objectImage);
            img02.setImage(imgObj.getImage());
            success = true;
            event.setDropCompleted(success);
            event.consume();
        }
    }

    

    @FXML
    private void dropedimg12(DragEvent event) {
        if(spinValeur.getText().isEmpty() || spinPoid.getText().isEmpty()) return;
        ObjectImage objectImage = new ObjectImage(String.valueOf(spinValeur.getText()), String.valueOf(spinPoid.getText()),1,2);       
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            objectImage.setId(db.getString());
            objets.addImage(objectImage);
            img12.setImage(imgObj.getImage());
            success = true;
            event.setDropCompleted(success);
            event.consume();
        }
    }


    @FXML
    private void dropedimg22(DragEvent event) {
        if(spinValeur.getText().isEmpty() || spinPoid.getText().isEmpty()) return;
        ObjectImage objectImage = new ObjectImage(String.valueOf(spinValeur.getText()), String.valueOf(spinPoid.getText()),2,2);       
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            objectImage.setId(db.getString());
            objets.addImage(objectImage);
            img22.setImage(imgObj.getImage());
            success = true;
            event.setDropCompleted(success);
            event.consume();
        }
    }


    @FXML
    private void dropedimg32(DragEvent event) {
        if(spinValeur.getText().isEmpty() || spinPoid.getText().isEmpty()) return;
        ObjectImage objectImage = new ObjectImage(String.valueOf(spinValeur.getText()), String.valueOf(spinPoid.getText()),3,2);       
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            objectImage.setId(db.getString());
            objets.addImage(objectImage);
            img32.setImage(imgObj.getImage());
            success = true;
            event.setDropCompleted(success);
            event.consume();
        }
    }

    

    @FXML
    private void dropedimg03(DragEvent event) {
        if(spinValeur.getText().isEmpty() || spinPoid.getText().isEmpty()) return;
        ObjectImage objectImage = new ObjectImage(String.valueOf(spinValeur.getText()), String.valueOf(spinPoid.getText()),0,3);       
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            objectImage.setId(db.getString());
            objets.addImage(objectImage);
            img03.setImage(imgObj.getImage());
            success = true;
            event.setDropCompleted(success);
            event.consume();
        }
    }

    @FXML
    private void dropedimg13(DragEvent event) {
        if(spinValeur.getText().isEmpty() || spinPoid.getText().isEmpty()) return;
        ObjectImage objectImage = new ObjectImage(String.valueOf(spinValeur.getText()), String.valueOf(spinPoid.getText()),1,3);       
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            objectImage.setId(db.getString());
            objets.addImage(objectImage);
            img13.setImage(imgObj.getImage());
            success = true;
            event.setDropCompleted(success);
            event.consume();
        }
    }

    @FXML
    private void dropedimg23(DragEvent event) {
        if(spinValeur.getText().isEmpty() || spinPoid.getText().isEmpty()) return;
        ObjectImage objectImage = new ObjectImage(String.valueOf(spinValeur.getText()), String.valueOf(spinPoid.getText()),2,3);       
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            objectImage.setId(db.getString());
            objets.addImage(objectImage);
            img23.setImage(imgObj.getImage());
            success = true;
            event.setDropCompleted(success);
            event.consume();
        }
    }
   

    @FXML
    private void overimg00(DragEvent event) {
        
         if (event.getGestureSource() != img00 && event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
    }

    @FXML
    private void overimg01(DragEvent event) {
         if (event.getGestureSource() != img01 && event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
    }

    @FXML
    private void overimg30(DragEvent event) {
         if (event.getGestureSource() != img30 && event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
    }

    @FXML
    private void overimg20(DragEvent event) {
         if (event.getGestureSource() != img20 && event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
    }

    @FXML
    private void overimg10(DragEvent event) {
         if (event.getGestureSource() != img10 && event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
    }

    @FXML
    private void overimg11(DragEvent event) {
         if (event.getGestureSource() != img11 && event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
    }

    @FXML
    private void overimg21(DragEvent event) {
         if (event.getGestureSource() != img21 && event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
    }

    @FXML
    private void overimg31(DragEvent event) {
         if (event.getGestureSource() != img31 && event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
    }

    @FXML
    private void overimg02(DragEvent event) {
         if (event.getGestureSource() != img02 && event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
    }

    @FXML
    private void overimg12(DragEvent event) {
         if (event.getGestureSource() != img12 && event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
    }

    @FXML
    private void overimg22(DragEvent event) {
         if (event.getGestureSource() != img22 && event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
    }

    @FXML
    private void overimg32(DragEvent event) {
         if (event.getGestureSource() != img32 && event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
    }

    @FXML
    private void overimg03(DragEvent event) {
         if (event.getGestureSource() != img03 && event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
    }

    @FXML
    private void overimg13(DragEvent event) {
         if (event.getGestureSource() != img13 && event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
    }

    @FXML
    private void overimg23(DragEvent event) {
         if (event.getGestureSource() != img23 && event.getDragboard().hasString()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
    }
    public void animate (ImageView img){
        TranslateTransition translateTransition =
        new TranslateTransition(Duration.millis(500), img);
        translateTransition.setFromX(img.getLayoutX());
        translateTransition.setToX(300-img.getLayoutX());
        translateTransition.setFromY(img.getLayoutY());
        translateTransition.setToY(100-img.getLayoutY());
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(false);
        ScaleTransition scaleTransition =
        new ScaleTransition(Duration.millis(400), img);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(7);
        scaleTransition.setToY(7);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
        FadeTransition ft = new FadeTransition(Duration.millis(400), img);
        ft.setFromValue(1.0);
        ft.setToValue(0);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
        translateTransition,
        scaleTransition,ft);
        sequentialTransition.setCycleCount(1);
        sequentialTransition.setAutoReverse(true);
        sequentialTransition.play();
    }
     public void animate2 (ImageView img){
        ScaleTransition scaleTransition =
        new ScaleTransition(Duration.millis(400), img);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(2);
        scaleTransition.setToY(2);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }
   
     @FXML
    private void entredimg11(DragEvent event) {
    }

    @FXML
    private void exitedimg11(DragEvent event) {
    }
    
    @FXML
    private void entredimg23(DragEvent event) {
    }

    @FXML
    private void exitedimg23(DragEvent event) {
    }
    
    
    @FXML
    private void entredimg13(DragEvent event) {
    }

    @FXML
    private void exitedimg13(DragEvent event) {
    }

    @FXML
    private void entredimg32(DragEvent event) {
    }

    @FXML
    private void exitedimg32(DragEvent event) {
    }
    @FXML
    private void entredimg03(DragEvent event) {
    }

    @FXML
    private void exitedimg03(DragEvent event) {
    }
    
    @FXML
    private void entredimg22(DragEvent event) {
    }

    @FXML
    private void exitedimg22(DragEvent event) {
    }
    
    @FXML
    private void entredimg31(DragEvent event) {
    }

    @FXML
    private void exitedimg31(DragEvent event) {
    }
    
    @FXML
    private void entredimg12(DragEvent event) {
    }

    @FXML
    private void exitedimg12(DragEvent event) {
    }
    
    @FXML
    private void entredimg02(DragEvent event) {
    }

    @FXML
    private void exitedimg02(DragEvent event) {
    }
    @FXML
    private void entredimg21(DragEvent event) {
    }

    @FXML
    private void exitedimg21(DragEvent event) {
    }
    
    @FXML
    private void entredimg10(DragEvent event) {
    }

    @FXML
    private void exitedimg10(DragEvent event) {
    }
    @FXML
    private void entredimg20(DragEvent event) {
    }

    @FXML
    private void exitedimg20(DragEvent event) {
    }
     @FXML
    private void entredimg30(DragEvent event) {
    }

    @FXML
    private void exitedimg30(DragEvent event) {
    }
    
    @FXML
    private void entredimg01(DragEvent event) {
    }

    @FXML
    private void exitedimg01(DragEvent event) {
    }
    @FXML
    private void entredimg00(DragEvent event) {
    }

    @FXML
    private void exitedimg00(DragEvent event) {
    }
    
    @FXML
    private void entredimg33(DragEvent event) {
        
    }

    @FXML
    private void exitedimg33(DragEvent event) {
        
    }
    

    @FXML
    private void mouseEntred30(MouseEvent event) {
        ObjectImage obj =objets.ifExist(3,0);
        if(obj!=null && !obj.getPoid().isEmpty() && !obj.getPoid().isEmpty() ){
            infoAnchors.setVisible(true);
            idPoid.setText(obj.getPoid());
            idVal.setText(obj.getValeur());
        }
        event.consume();
    }

    @FXML
    private void mouseEntred20(MouseEvent event) {
        ObjectImage obj =objets.ifExist(2,0);
        if(obj!=null && !obj.getPoid().isEmpty() && !obj.getPoid().isEmpty() ){
            infoAnchors.setVisible(true);
            idPoid.setText(obj.getPoid());
            idVal.setText(obj.getValeur());
        }
        event.consume();
    }

    @FXML
    private void mouseEntred21(MouseEvent event) {
        ObjectImage obj =objets.ifExist(2,1);
        if(obj!=null && !obj.getPoid().isEmpty() && !obj.getPoid().isEmpty() ){
            infoAnchors.setVisible(true);
            idPoid.setText(obj.getPoid());
            idVal.setText(obj.getValeur());
        }
        event.consume();
    }

    @FXML
    private void mouseEntred31(MouseEvent event) {
        ObjectImage obj =objets.ifExist(3,1);
        if(obj!=null && !obj.getPoid().isEmpty() && !obj.getPoid().isEmpty() ){
            infoAnchors.setVisible(true);
            idPoid.setText(obj.getPoid());
            idVal.setText(obj.getValeur());
        }
        event.consume();
    }

    @FXML
    private void mouseEntred22(MouseEvent event) {
        ObjectImage obj =objets.ifExist(2,2);
        if(obj!=null && !obj.getPoid().isEmpty() && !obj.getPoid().isEmpty() ){
            infoAnchors.setVisible(true);
            idPoid.setText(obj.getPoid());
            idVal.setText(obj.getValeur());
        }
        event.consume();
    }

    @FXML
    private void mouseEntred23(MouseEvent event) {
        ObjectImage obj =objets.ifExist(2,3);
        if(obj!=null && !obj.getPoid().isEmpty() && !obj.getPoid().isEmpty() ){
            infoAnchors.setVisible(true);
            idPoid.setText(obj.getPoid());
            idVal.setText(obj.getValeur());
        }
        event.consume();
    }
    @FXML
    private void mouseEntred03(MouseEvent event) {
         ObjectImage obj =objets.ifExist(0,3);
        if(obj!=null && !obj.getPoid().isEmpty() && !obj.getPoid().isEmpty() ){
            infoAnchors.setVisible(true);
            idPoid.setText(obj.getPoid());
            idVal.setText(obj.getValeur());
        }
        event.consume();
    }
    
    @FXML
    private void mouseEntred13(MouseEvent event) {
         ObjectImage obj =objets.ifExist(1,3);
        if(obj!=null && !obj.getPoid().isEmpty() && !obj.getPoid().isEmpty() ){
            infoAnchors.setVisible(true);
            idPoid.setText(obj.getPoid());
            idVal.setText(obj.getValeur());
        }
        event.consume();
    }
    @FXML
    private void mouseEntred00(MouseEvent event) {
         ObjectImage obj =objets.ifExist(0,0);
        if(obj!=null && !obj.getPoid().isEmpty() && !obj.getPoid().isEmpty() ){
            infoAnchors.setVisible(true);
            idPoid.setText(obj.getPoid());
            idVal.setText(obj.getValeur());
        }
        event.consume();
    }

    @FXML
    private void mouseEntred01(MouseEvent event) {
         ObjectImage obj =objets.ifExist(0,1);
        if(obj!=null && !obj.getPoid().isEmpty() && !obj.getPoid().isEmpty() ){
            infoAnchors.setVisible(true);
            idPoid.setText(obj.getPoid());
            idVal.setText(obj.getValeur());
        }
        event.consume();
    }
    
    @FXML
    private void mouseEntred12(MouseEvent event) {
         ObjectImage obj =objets.ifExist(1,2);
        if(obj!=null && !obj.getPoid().isEmpty() && !obj.getPoid().isEmpty() ){
            infoAnchors.setVisible(true);
            idPoid.setText(obj.getPoid());
            idVal.setText(obj.getValeur());
        }
        event.consume();
    }
    
    @FXML
    private void mouseEntred11(MouseEvent event) {
         ObjectImage obj =objets.ifExist(1,1);
        if(obj!=null && !obj.getPoid().isEmpty() && !obj.getPoid().isEmpty() ){
            infoAnchors.setVisible(true);
            idPoid.setText(obj.getPoid());
            idVal.setText(obj.getValeur());
        }
        event.consume();
    }
    
    @FXML
    private void mouseEntred10(MouseEvent event) {
         ObjectImage obj =objets.ifExist(1,0);
        if(obj!=null && !obj.getPoid().isEmpty() && !obj.getPoid().isEmpty() ){
            infoAnchors.setVisible(true);
            idPoid.setText(obj.getPoid());
            idVal.setText(obj.getValeur());
        }
        event.consume();
    }
    
     @FXML
    private void mouseEntred02(MouseEvent event) {
         ObjectImage obj =objets.ifExist(0,2);
        if(obj!=null && !obj.getPoid().isEmpty() && !obj.getPoid().isEmpty() ){
            infoAnchors.setVisible(true);
            idPoid.setText(obj.getPoid());
            idVal.setText(obj.getValeur());
        }
        event.consume();
    }
    private void mouseExited00(MouseEvent event) {
        infoAnchors.setVisible(false);
        idPoid.setText("");
        idVal.setText("");
        event.consume();
    }


    private void mouseExited01(MouseEvent event) {
        infoAnchors.setVisible(false);
        idPoid.setText("");
        idVal.setText("");
        event.consume();
    }


    private void mouseExited30(MouseEvent event) {
        infoAnchors.setVisible(false);
        idPoid.setText("");
        idVal.setText("");
        event.consume();
    }

    private void mouseExited20(MouseEvent event) {
        infoAnchors.setVisible(false);
        idPoid.setText("");
        idVal.setText("");
        event.consume();
    }

    private void mouseExited10(MouseEvent event) {
        infoAnchors.setVisible(false);
        idPoid.setText("");
        idVal.setText("");
        event.consume();
    }

    

    private void mouseExited11(MouseEvent event) {
        infoAnchors.setVisible(false);
        idPoid.setText("");
        idVal.setText("");
        event.consume();
    }


    private void mouseExited21(MouseEvent event) {
        infoAnchors.setVisible(false);
        idPoid.setText("");
        idVal.setText("");
        event.consume();
    }

    private void mouseExited31(MouseEvent event) {
        infoAnchors.setVisible(false);
        idPoid.setText("");
        idVal.setText("");
        event.consume();
    }

    private void mouseExited02(MouseEvent event) {
        infoAnchors.setVisible(false);
        idPoid.setText("");
        idVal.setText("");
        event.consume();
    }


    private void mouseExited12(MouseEvent event) {
        infoAnchors.setVisible(false);
        idPoid.setText("");
        idVal.setText("");
        event.consume();
    }

    

    private void mouseExited22(MouseEvent event) {
        infoAnchors.setVisible(false);
        idPoid.setText("");
        idVal.setText("");
        event.consume();
    }

    private void mouseExited32(MouseEvent event) {
        infoAnchors.setVisible(false);
        idPoid.setText("");
        idVal.setText("");
        event.consume();
    }

    private void mouseExited03(MouseEvent event) {
        infoAnchors.setVisible(false);
        idPoid.setText("");
        idVal.setText("");
        event.consume();
    }

    

    private void mouseExited13(MouseEvent event) {
        infoAnchors.setVisible(false);
        idPoid.setText("");
        idVal.setText("");
        event.consume();
    }

    
    private void mouseExited23(MouseEvent event) {
        infoAnchors.setVisible(false);
        idPoid.setText("");
        idVal.setText("");
        event.consume();
    }

    @FXML
    private void btnAction(ActionEvent event) throws IOException {
        if(btnValider.getText()!="resultat"){
            if(!spinPoid.getText().isEmpty()){
                poidMax=Integer.parseInt(spinPoid.getText());
                animate2(sacImg);
                objAction(event);
                spinPoid.setText("");
            }
        }else{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("resultat.fxml"));
            Parent  parent = (Parent) loader.load();
            ResultatController aceuil_med =loader.getController();
            aceuil_med.init(objets,valMax);
            Scene acceuil_scene = new Scene (parent);
            Stage app_acceuil = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_acceuil.setScene(acceuil_scene);
            app_acceuil.show();
            btnValider.setText("Valider");
            btnValider.setVisible(false);
            btnValider.setDisable(true);
        }
        
    }

   
}
