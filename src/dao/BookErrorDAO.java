/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.BookError;

/**
 *
 * @author Hi
 */
public class BookErrorDAO extends DAO{
    
            public ArrayList<BookError> ListBookError(int id)
            {
                ArrayList<BookError> result = new ArrayList<BookError>();
                String sql = "SELECT * FROM tblbookerror";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				BookError booke = new BookError();
                                if (rs.getInt("id") != id)
                                {
				booke.setId(rs.getInt("id"));
				booke.setName(rs.getString("nameError"));
				booke.setType(rs.getInt("type"));
				booke.setPrice(rs.getFloat("price"));
				booke.setNote(rs.getString("note"));
				result.add(booke);
                                }
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
            }
            
            public boolean addBookError(BookError boe)
            {
                String sql = "INSERT INTO tblbookerror(nameError, type, price, note) VALUES (?,?,?,?)";
                boolean result = true;
                try{
                        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, boe.getName());
			ps.setInt(2, boe.getType());
			ps.setFloat(3, boe.getPrice());
			ps.setString(4, boe.getNote());

			ps.executeUpdate();
			
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				boe.setId(generatedKeys.getInt(1));
			}
		}catch(Exception e){
                        result = false;
			e.printStackTrace();
		}
                return result;
            }
            
            
}
