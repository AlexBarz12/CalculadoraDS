package br.edu.ifro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calculadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getCbOp() {
        return cbOp;
    }

    public void setCbOp(String cbOp) {
        this.cbOp = cbOp;
    }

    public String getLblResultado() {
        return lblResultado;
    }

    public void setLblResultado(String lblResultado) {
        this.lblResultado = lblResultado;
    }
    private String num1;
    private String num2;
    private String cbOp;
    private String lblResultado;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}