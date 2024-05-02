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
public class Bill implements Serializable{
    private int id;
    private String des;
    private Client client;
    private User user;
    private ArrayList<PayBill> Listpaybill;
    private float tongtien;
    private ArrayList<Integer> dsdachonloi = new ArrayList<>();

    public Bill() {
        super();
    }

    public Bill(int id, String des, Client client, User user, ArrayList<PayBill> paybill, float tongtien) {
        super();
        this.id = id;
        this.des = des;
        this.client = client;
        this.user = user;
        this.Listpaybill = paybill;
        this.tongtien = tongtien;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<PayBill> getListpaybill() {
        return Listpaybill;
    }

    public void setListpaybill(ArrayList<PayBill> Listpaybill) {
        this.Listpaybill = Listpaybill;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }

    public ArrayList<Integer> getDsdachonloi() {
        return dsdachonloi;
    }

    public void setDsdachonloi(ArrayList<Integer> dsdachonloi) {
        this.dsdachonloi = dsdachonloi;
    }
    
    
}
