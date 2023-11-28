package edu.fiuba.algo3.vista.components.boton;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class TextoNombreGladiadorEventHandler implements EventHandler<KeyEvent>{
    private Label verificarNombre;

    private TextField nombre;


    public TextoNombreGladiadorEventHandler(Label verificarNombre, TextField nombre ){
        this.verificarNombre = verificarNombre;
        this.nombre = nombre;
    }

    @Override
    public void handle(KeyEvent keyEvent) {

        //voy a verificar que la letra ingresada sea del  abecedario
        if( esNombreValido( nombre.getText() ) && esUnCodigoValido(keyEvent) && nombre.getText().length() < 10){
            this.verificarNombre.setText("");
        }else{
            this.verificarNombre.setText("El nombre solo puede contener letras y numeros");
        }
    }

    private boolean esUnCodigoValido( KeyEvent keyEvent ){
        return keyEvent.getCode().isLetterKey() || keyEvent.getCode().isWhitespaceKey() || keyEvent.getCode() == KeyCode.BACK_SPACE;
    }
    private boolean esNombreValido(String nombre){
        return nombre.matches("[a-zA-Z]+");
    }

}
