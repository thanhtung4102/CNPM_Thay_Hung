 package dao;
import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Client;

public class ClientDAO extends DAO{
	
	/**
	 * search all clients in the tblClient whose name contains the @key
	 * @param key
	 * @return list of client whose name contains the @key
	 */
	public ArrayList<Client> searchClient(String key){
		ArrayList<Client> result = new ArrayList<Client>();
		String sql = "SELECT * FROM tblclient WHERE name LIKE ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + key + "%");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Client client = new Client();
				client.setId(rs.getInt("id"));
				client.setName(rs.getString("name"));
				client.setAddress(rs.getString("address"));
				client.setTel(rs.getString("tel"));
				client.setEmail(rs.getString("email"));
				client.setNote(rs.getString("note"));
				result.add(client);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
	}
}