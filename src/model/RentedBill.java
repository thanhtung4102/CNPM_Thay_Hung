/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Hi
 */
public class RentedBill implements Serializable{
    private int id;
    private String des;
    private BookError bookerror;
    private RentedBook rentedbook;
    private Client client;

    public RentedBill() {
        super();
    }

    public RentedBill(int id, String des, BookError bookerror, RentedBook rentedbook, Client client) {
        super();
        this.id = id;
        this.des = des;
        this.bookerror = bookerror;
        this.rentedbook = rentedbook;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public RentedBook getRentedbook() {
        return rentedbook;
    }

    public void setRentedbook(RentedBook rentedbook) {
        this.rentedbook = rentedbook;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
}
