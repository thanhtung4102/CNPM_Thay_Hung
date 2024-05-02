/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import model.Bill;
import model.PayBill;

/**
 *
 * @author Hi
 */
public class BillDAO extends DAO{
    public BillDAO()
    {
        super();
    }
    
    public boolean addBill(Bill b) 
    {
        String sqlAddBill = "INSERT INTO tblbill(idclient, iduser, subtotal, des) VALUES (?,?,?,?)";
        String sqlAddPayBill = "INSERT INTO tblpaybill(idbill, idrentedbook, idbookerror, des) VALUES (?,?,?,?)";
        String sqlAddPaidBook = "INSERT INTO tblpaidbook(idrentedbook, paymentDate, note) VALUES (?,?,?)";
        String sqlUpdateRentedBook = "UPDATE tblrentedbook SET isPaid = 1 WHERE id = ?";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        boolean result = true;
        try
        {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sqlAddBill, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, b.getClient().getId());
            ps.setInt(2, b.getUser().getId());
            ps.setFloat(3, b.getTongtien());
            ps.setString(4, b.getDes());
            
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
		b.setId(generatedKeys.getInt(1));
                for (PayBill pb : b.getListpaybill())
                {
                    ps = con.prepareStatement(sqlAddPaidBook, Statement.RETURN_GENERATED_KEYS);
                    
                    ps.setInt(1, pb.getPaidbook().getRentedbook().getId());
                    ps.setString(2, sdf.format(pb.getPaidbook().getPaymentDate()));
                    ps.setString(3, pb.getPaidbook().getDes());
                    
                    ps.executeUpdate();	
                    
                    ps = con.prepareStatement(sqlUpdateRentedBook, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, pb.getPaidbook().getRentedbook().getId());
                    ps.executeUpdate();	
                    if (pb.getBookerror().getId() != 0){
                        ps = con.prepareStatement(sqlAddPayBill, Statement.RETURN_GENERATED_KEYS);
                    
                        ps.setInt(1, b.getId());
                        ps.setInt(2, pb.getPaidbook().getRentedbook().getId());
                        ps.setInt(3, pb.getBookerror().getId());
                        ps.setString(4, pb.getDes());
                    }
                    else
                    {
                        String sqlAddPayBill2 = "INSERT INTO tblpaybill(idbill, idrentedbook, des) VALUES (?,?,?)";
                        ps = con.prepareStatement(sqlAddPayBill2, Statement.RETURN_GENERATED_KEYS);
                    
                        ps.setInt(1, b.getId());
                        ps.setInt(2, pb.getPaidbook().getRentedbook().getId());
                        ps.setString(3, pb.getDes());
                    }
                    ps.executeUpdate();			
                    generatedKeys = ps.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        pb.setId(generatedKeys.getInt(1));
                    }
                    
                }
        }
            con.commit();
        }catch(Exception e) {
            result = false;			
            try {				
		con.rollback();
            }catch(Exception ex) {
		result = false;
		ex.printStackTrace();
        }
	e.printStackTrace();
	}finally {
            try {				
		con.setAutoCommit(true);
            }catch(Exception ex) {
		result = false;
		ex.printStackTrace();
            }
	}
	return result;
    }
}
