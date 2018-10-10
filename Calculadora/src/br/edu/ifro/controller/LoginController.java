/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.controller;

import br.edu.ifro.model.Login;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author 03821526203
 */
public class LoginController {

    @FXML
    private JFXPasswordField txtSenha;
    @FXML
    private Button btnEntrar;
    private Login login;
    @FXML
    private JFXTextField txtUsuario;
       
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    private void abrirMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/Calculadora.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.show();
        Stage st = (Stage) btnEntrar.getScene().getWindow();
        st.close();
         
    }
    
    @FXML
    private void AbrirMenuInicial(ActionEvent event) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculadora");
        EntityManager em = emf.createEntityManager();
        
        
        Query query = em.createQuery("Select f from Login f WHERE f.usuario = :usuario");
        query.setParameter("usuario", txtUsuario.getText());
        
        if (query.getResultList().isEmpty()) {
            JOptionPane.showMessageDialog(null,"digite o cpf correto");
        }
        else {  
            Login f = (Login) query.getSingleResult();        
            if (!f.getSenha().equals(txtSenha.getText())) {                
                JOptionPane.showMessageDialog(null,"senha incorreta");
            }
            else {
                abrirMenu();
                
            } 
}
    }}