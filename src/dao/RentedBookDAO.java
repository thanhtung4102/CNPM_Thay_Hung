/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Book;
import model.BookError;
import model.Client;
import model.RentedBook;

/**
 *
 * @author Hi
 */
public class RentedBookDAO extends DAO{
    public RentedBookDAO(){
        super();
    }
    
    public ArrayList<RentedBook> searchRentedBook(Client c)
    {
        ArrayList<RentedBook> result = new ArrayList<RentedBook>();
	String sql = "SELECT * FROM tblrentedbook WHERE id IN (SELECT idrentedbook FROM tblrentbill WHERE idclient = ? AND isPaid = 0)";
        String sql2 = "SELECT * FROM tblbook WHERE id = ?";
        String sql3 = "SELECT * FROM tblbookerror WHERE id IN (SELECT idbookerror FROM tblrentbill WHERE idrentedbook = ?)";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = Integer.toString(c.getId());
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                RentedBook rb = new RentedBook();
		rb.setId(rs.getInt("id"));
                int idBook = rs.getInt("idBook");
                Book bo = new Book();
                try{
                    PreparedStatement ps2 = con.prepareStatement(sql2);
                    ps2.setString(1, Integer.toString(idBook));
                    ResultSet rs2 = ps2.executeQuery();
                    while (rs2.next()){
                        bo.setName(rs2.getString("name"));
                        bo.setType(rs2.getString("type"));
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                BookError booke = new BookError();
                try{
                    PreparedStatement ps3 = con.prepareStatement(sql3);
                    ps3.setString(1, Integer.toString(rb.getId()));
                    ResultSet rs3 = ps3.executeQuery();
                    while (rs3.next()){
                        if (rs3.getInt("id") != 0)
                        {
			booke.setName(rs3.getString("nameError"));
			booke.setType(rs3.getInt("type"));
			booke.setNote(rs3.getString("note"));
                        }
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                booke.setPrice((float) 0);
                rb.setBookerror(booke);
                rb.setBook(bo);
		rb.setRentingDate(rs.getDate("rentingDay"));
                rb.setPaymentDate(rs.getDate("paymentDay"));
                rb.setPriceByDay(rs.getFloat("priceByDay"));
		rb.setNote(rs.getString("Note"));
                result.add(rb);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return result;
    }
}
