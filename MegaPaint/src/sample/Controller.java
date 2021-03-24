package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {
    @FXML Canvas lienzo;
    GraphicsContext context;
    @FXML ColorPicker colorPiker;
    @FXML ComboBox cmbOpciones;
    @FXML Slider slider;
    Color coloPincel=Color.BLACK;
    @FXML protected void initialize(){

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                pintarDibujos(newValue.intValue());
            }
        });
        cmbOpciones.getItems().addAll("Cuadricula","Ajedrez","Estrella", "Estrella doble", "Circulo de la Exentacion");

        context=lienzo.getGraphicsContext2D();
        /*context.fillRect(10,20,100,50);
        context.strokeRect(200,150,200,100);
        context.fillOval(350,350,50,50);*/
    }
    public void pintarDibujos(int valor){
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());
        context.setFill(coloPincel);
        System.out.println(valor);
        if (cmbOpciones.getSelectionModel().getSelectedIndex() == 0) {
            for (int x=1;x<valor+1;x++){
                int div=(int) lienzo.getWidth()/valor;
                context.strokeLine(0,div*x, lienzo.getWidth(),div*x);
                context.strokeLine(div*x,0, div*x,lienzo.getWidth());
            }
        }else if (cmbOpciones.getSelectionModel().getSelectedIndex()==1){
            for (int j = 0; j < valor; j++) {
                int div=(int) lienzo.getWidth()/valor;
                for (int i = 0; i < valor; i++) {
                    if ((j % 2) != 0) {
                        context.strokeRect(2 * div * i, div * j, div, div);
                        context.setStroke(coloPincel);
                        context.setFill(coloPincel);
                        context.fillRect(2 * div * i, div * j, div, div);
                    }
                    if ((i % 2 != 0)) {
                        context.strokeRect(div * i, 2 * div * j, div, div);
                        context.fillRect(div * i, 2 * div * j, div, div);
                    }
                }
            }


        }else if (cmbOpciones.getSelectionModel().getSelectedIndex()==2){
            int radAnch=((int) lienzo.getWidth()/2);
            int radAlt=((int) lienzo.getHeight()/2);
            context.strokeLine(radAnch,0,radAnch,lienzo.getHeight());
            context.strokeLine(0,radAlt,lienzo.getWidth(),radAlt);
            int div=radAnch/valor;
            for (int j=1;j<valor+1;j++){
                context.strokeLine(radAnch,div*j,radAnch+div*j,radAlt);
            }
            for (int j=1;j<valor+1;j++){
                context.strokeLine(div*j,radAnch,radAlt,radAnch+div*j);
            }
            for (int j=1;j<valor+1;j++){
                context.strokeLine(div*j,radAnch,radAlt,radAnch-div*j);
            }
            for (int j=1;j<valor+1;j++){
               context.strokeLine(radAnch*2-div*j,radAlt,radAnch,radAlt+div*j);
            }

        }else if (cmbOpciones.getSelectionModel().getSelectedIndex()==3){
            int radAnch=((int) lienzo.getWidth()/2);
            int radAlt=((int) lienzo.getHeight()/2);
            context.strokeLine(radAnch,0,radAnch,lienzo.getHeight());
            context.strokeLine(0,radAlt,lienzo.getWidth(),radAlt);
            int div=radAnch/valor;
            for (int j=1;j<valor+1;j++){
                context.strokeOval(radAnch,div,400,400);
            }
            for (int j=1;j<valor+1;j++){
                context.strokeOval(div,radAnch,400,400);
            }
            for (int j=1;j<valor+1;j++){
                context.strokeOval(div,radAnch,400,400);
            }
            for (int j=1;j<valor+1;j++){
                context.strokeOval(radAnch,radAlt,400,400);
            }

        }else if (cmbOpciones.getSelectionModel().getSelectedIndex()==4){

            int centh=((int) lienzo.getHeight()/2);
            int centa=((int) lienzo.getWidth()/2);
            int div=centa/valor;
            context.strokeOval(centh-200,centa-300,400,400);
            context.strokeOval(centh-200,centa-300,10,10);
            for (int i=0;i<valor+1;i++){
                context.strokeOval(centh,centa,400,400);
            }

        }

    }
    public void cambiarColor(ActionEvent event){
        coloPincel=colorPiker.getValue();
    }
    public void borrar(ActionEvent event){
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());
        //coloPincel=Color.WHITESMOKE;
    }

    public void arrastrar(MouseEvent event){
        context.setFill(coloPincel);
        context.fillOval(event.getX(),event.getY(),10,10);
    }
}
