package jdbconnectivity;
import java.sql.*;
import java.util.Scanner;
import java. sql.DriverManager;

public class student {
	
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("enter the name:");
		String name=input.nextLine();
		System.out.println("enter course");
		String course=input.nextLine();
		System.out.println("enter student id");
		int id=input.nextInt();
		System.out.println("enter phone");
		int phone=input.nextInt();
		
		
		
		
		try {
			
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost/comrade","root","");
			
			Statement stat=con.createStatement();
			String sql="insert into details(name,stud_id,course,phone) values(?,?,?,?)";
			PreparedStatement t=con.prepareStatement(sql);
			t.setString(1, name);
			t.setInt(2, id);
			t.setString(3, course);
			t.setInt(4, phone);
			
			
			
			
			t.executeUpdate();
			System.out.println("inserting");
		
			System.out.println("INSERTED!!!");
			
			
		     ResultSet rs=stat.executeQuery(sql);
			
			while(rs.next()) {
				String n=rs.getString("name");
				//String name=rs.getString("first_name");
				//String course=rs.getString("email");
				
	//---------------------------------------
			  System.out.println(n);
				//System.out.println(course);
				//System.out.println(index);
				}
				
				
			
			
		}catch(Exception ex){
			System.out.println(ex);
			
		}
		
			
		}
		

	

}
