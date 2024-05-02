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
public class RentedBook implements Serializable{
    private int id;
    private Date rentingDate;
    private Date paymentDate;
    private Float priceByDay;
    private String note;
    private Book book;
    private BookError bookerror;

    public RentedBook() {
        super();
    }

    public RentedBook(int id, Date rentingDate, Date paymentDate, Float priceByDay, String note, Book book, BookError bookerror) {
        this.id = id;
        this.rentingDate = rentingDate;
        this.paymentDate = paymentDate;
        this.priceByDay = priceByDay;
        this.note = note;
        this.book = book;
        this.bookerror = bookerror;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRentingDate() {
        return rentingDate;
    }

    public void setRentingDate(Date rentingDate) {
        this.rentingDate = rentingDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Float getPriceByDay() {
        return priceByDay;
    }

    public void setPriceByDay(Float priceByDay) {
        this.priceByDay = priceByDay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookError getBookerror() {
        return bookerror;
    }

    public void setBookerror(BookError bookerror) {
        this.bookerror = bookerror;
    }
    
    
}
