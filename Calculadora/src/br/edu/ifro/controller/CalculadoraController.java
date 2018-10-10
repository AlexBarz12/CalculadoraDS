/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.controller;

import br.edu.ifro.model.Calculadora;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author 03821526203
 */
public class CalculadoraController implements Initializable {

    @FXML
    private TextField txtNum1;
    @FXML
    private TextField txtNum2;
    @FXML
    private ComboBox<String> cbOp;
    @FXML
    private Button btnCalcular;
    @FXML
    private Button btnHistorico;
    @FXML
    private Label lblResultado;

    private Calculadora calculadora;
    
  

   @FXML
    private void Calcular(ActionEvent event) {
       Calcular(cbOp.getSelectionModel().getSelectedItem()) ;
    }
    
    @FXML
    private void Historico(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/Historico.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Listagem");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
        
        @FXML

    private void Calcular(String op) {
        Double num1 = Double.parseDouble(txtNum1.getText());
        Double num2 = Double.parseDouble(txtNum2.getText());
        Double result = null;
        switch (op) {
            case "+":
                result = num1+num2;
                break;
            case "-":
                 result = num1-num2;
                break;
            case "*":
                 result = num1*num2;
                break;
            case "/":
                 result = num1/num2;
                break; 
        }
        
        lblResultado.setText(result.toString());
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculadora");
        EntityManager em = emf.createEntityManager();
        
        calculadora = new Calculadora();
        calculadora.setNum1(txtNum1.getText());
        calculadora.setNum2(txtNum2.getText());
        calculadora.setLblResultado(lblResultado.getText());
        calculadora.setCbOp(cbOp.getSelectionModel().getSelectedItem());

        em.getTransaction().begin();
        
        em.persist(calculadora);
        
        em.getTransaction().commit();
        
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {




    }    
    
}
