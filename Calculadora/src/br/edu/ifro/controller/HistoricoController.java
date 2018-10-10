/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.controller;

import br.edu.ifro.model.Calculadora;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author 04381210239
 */
public class HistoricoController implements Initializable {

    @FXML
    private TableView<?> tbClienteFis;

    /**
     * Initializes the controller class.
     */
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        listar();
    }    

    @FXML
    private void excluir(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculadora");
        EntityManager em = emf.createEntityManager();
        
        Calculadora calculadora = (Calculadora) tbClienteFis.getSelectionModel().getSelectedItem();
        
        Query query = em.createQuery("SELECT a FROM Calculadora as a WHERE a.id = :id");
        query.setParameter("id", calculadora.getId());
               
        Calculadora a = (Calculadora) query.getSingleResult();
        
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
        listar();
    }
    @FXML
    private void listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculadora");
        EntityManager em = emf.createEntityManager();
                
        Query query = em.createQuery("SELECT a FROM Calculadora as a");

        List<Calculadora> calculadora = query.getResultList();
        
        ObservableList oCalculadora = FXCollections.observableArrayList(calculadora);                                 
        tbClienteFis.setItems(oCalculadora);
    }
    
    
    
}
