/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Hi
 */
public class PayBill implements Serializable{
    private int id;
    private int quantityerror;
    private String des;
    private BookError bookerror;
    private PaidBook paidbook;

    public PayBill() {
        super();
    }

    public PayBill(int id, int quantityerror, String des, BookError bookerror, PaidBook paidbook) {
        super();
        this.id = id;
        this.quantityerror = quantityerror;
        this.des = des;
        this.bookerror = bookerror;
        this.paidbook = paidbook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantityerror() {
        return quantityerror;
    }

    public void setQuantityerror(int quantityerror) {
        this.quantityerror = quantityerror;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public BookError getBookerror() {
        return bookerror;
    }

    public void setBookerror(BookError bookerror) {
        this.bookerror = bookerror;
    }

    public PaidBook getPaidbook() {
        return paidbook;
    }

    public void setPaidbook(PaidBook paidbook) {
        this.paidbook = paidbook;
    }
    
    
}
