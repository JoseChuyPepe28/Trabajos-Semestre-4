package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.Random;

public class Controller {
    @FXML HBox contenedor;
    @FXML AnchorPane padre;
    String [] palabras={"PELOTA","MICROFONO","LIBRO","CUCHARA","SALSA","CHICHARRON","MOUSE"};
    TextField[] arrayTxt=null;
    @FXML protected void initialize(){
        Random random=new Random();
        int aleatorio=random.nextInt(6);
        String palabra = palabras[aleatorio].toLowerCase();
        System.out.println(palabra);
        arrayTxt=new TextField[palabra.length()];
        int ayuda=1;//letras ayuda
        final int[] muere = new int[1];

        for (int x=0;x<palabra.length();x++){
            arrayTxt[x]=new TextField();
            arrayTxt[x].setPrefWidth(50);
            arrayTxt[x].setPrefHeight(50);
            arrayTxt[x].setId("txt-"+x+"-"+palabra.charAt(x));
            arrayTxt[x].setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    TextField textField=(TextField) event.getTarget();
                    String[] nombre=textField.getId().split("-");

                    if (nombre[2].equals(textField.getText())){
                        System.out.println("CORRECTO"+textField.getId());
                        textField.setDisable(true);
                    }else{
                        System.out.println("INCORRECTO"+textField.getId());
                        textField.setText("");
                       // pintarCuerpo();public void pintarCuerpo(){
                        //}
                        muere[0] = muere[0] +1;
                        if (muere[0] ==1){
                            ImageView cabeza=new ImageView(new Image("sample/img/cabeza.png"));
                            cabeza.setFitWidth(70);
                            cabeza.setFitHeight(70);
                            cabeza.setLayoutX(200);
                            cabeza.setLayoutY(150);
                            padre.getChildren().addAll(cabeza);
                        }
                        if (muere[0] ==2){
                            ImageView cuerpo=new ImageView(new Image("sample/img/cuerpo.png"));
                            cuerpo.setFitWidth(70);
                            cuerpo.setFitHeight(70);
                            cuerpo.setLayoutX(198);
                            cuerpo.setLayoutY(205);
                            padre.getChildren().addAll(cuerpo);
                        }
                        if (muere[0] ==3){
                            ImageView brazizq=new ImageView(new Image("sample/img/brazoizq.png"));
                            brazizq.setFitWidth(70);
                            brazizq.setFitHeight(70);
                            brazizq.setLayoutX(185);
                            brazizq.setLayoutY(200);
                            padre.getChildren().addAll(brazizq);
                        }
                        if (muere[0] ==4){
                            ImageView brazder=new ImageView(new Image("sample/img/brazoder.png"));
                            brazder.setFitWidth(70);
                            brazder.setFitHeight(70);
                            brazder.setLayoutX(225);
                            brazder.setLayoutY(200);
                            padre.getChildren().addAll(brazder);
                        }
                        if (muere[0] ==5){
                            ImageView piern1=new ImageView(new Image("sample/img/pernas.png"));
                            piern1.setFitWidth(70);
                            piern1.setFitHeight(70);
                            piern1.setLayoutX(195);
                            piern1.setLayoutY(240);
                            padre.getChildren().addAll(piern1);
                        }
                        if (muere[0] ==6){
                            ImageView piern2=new ImageView(new Image("sample/img/pernas.png"));
                            piern2.setFitWidth(70);
                            piern2.setFitHeight(70);
                            piern2.setLayoutX(212);
                            piern2.setLayoutY(240);
                            padre.getChildren().addAll(piern2);
                        }
                        if (muere[0] ==6){
                            ImageView piern2=new ImageView(new Image("sample/img/pernas.png"));
                            piern2.setFitWidth(70);
                            piern2.setFitHeight(70);
                            piern2.setLayoutX(212);
                            piern2.setLayoutY(240);
                            ImageView morido=new ImageView(new Image("sample/img/murido.png"));
                            morido.setFitWidth(300);
                            morido.setFitHeight(300);
                            morido.setLayoutX(120);
                            morido.setLayoutY(240);
                            padre.getChildren().addAll(piern2,morido);
                        }

                    }
                }
            });
            contenedor.getChildren().add(arrayTxt[x]);
        }
    }

}
