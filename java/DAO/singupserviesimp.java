package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import Model.singup;

public class singupserviesimp {

	connection m=new connection();
	Connection con=null;
	
	public int create(List<singup> lst) {
		singup reg=lst.get(0);
	//	Connection m=new Connection();
		 con=m.getConnection();
		int i=0;
		
		try {
//			user ----->>>database
			PreparedStatement pstate=con.prepareStatement("insert into petcare values(?,?,?,?)");
			pstate.setString(1,reg.getUsername());
			pstate.setString(2,reg.getPhoneno());
			pstate.setString(3,reg.getEmail());
			System.out.println(reg.getEmail());
			
			pstate.setString(4, reg.getPassword());
			System.out.println(reg.getPassword());
			
		
			i=pstate.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		
		}	
		return i;
		
		
	}
	
	public boolean validateUser(List<singup> lst) {
		boolean b= false;
		singup lobj=lst.get(0);
		Connection con =m.getConnection();
		try {
			
			PreparedStatement pstate=con.prepareStatement("select * from petcare where email=? and password=?");
			
//			System.out.println(lobj.getUsername()+"/t"+lobj.getPassword());
			pstate.setString(1, lobj.getEmail());
			pstate.setString(2, lobj.getPassword());
			ResultSet rs=pstate.executeQuery();
			
//			System.out.println(rs.getString(1)+"\t"+rs.getString(2));
			if (rs.next()) {
				System.out.println(rs.getString(1)+"/t"+rs.getString(2));
				System.out.println();
				b=true;
			}else {
				
				System.out.println("no record..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
		
		
	
		
	}
}
