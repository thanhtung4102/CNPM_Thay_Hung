/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Hi
 */
public class PaidBook implements Serializable{
    private Date paymentDate;
    private String des;
    private RentedBook rentedbook;
    private Float subtotal;

    public PaidBook() {
        super();
    }

    public PaidBook(Date paymentDate, String des, RentedBook rentedbook, Float subtotal) {
        super();
        this.paymentDate = paymentDate;
        this.des = des;
        this.rentedbook = rentedbook;
        this.subtotal = subtotal;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public RentedBook getRentedbook() {
        return rentedbook;
    }

    public void setRentedbook(RentedBook rentedbook) {
        this.rentedbook = rentedbook;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public void setPaymentDate(java.util.Date utilDate) {
        this.paymentDate = convertUtilDateToSqlDate(utilDate);
    }
    
    public static java.sql.Date convertUtilDateToSqlDate(java.util.Date date) {
             return new java.sql.Date(date.getTime());
    }

}
