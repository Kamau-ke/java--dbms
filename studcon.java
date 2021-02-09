package jdbconnectivity;

import java.util.Scanner;
import java.sql.*;

interface Example{
	void student();
	void insertjdbc();
	void deletejdbc();
	void updatejdbc();
	
}

public class studcon implements Example {
	public  String name;
	public  String course;
	public  int phone;
	public  int id;
	Connection con;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			
		studcon ep=new studcon();
		 ep.student();
		 ep.insertjdbc();
		 ep.deletejdbc();
		 ep.updatejdbc();
	   

	}

	@Override
	public void student() {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		Scanner ring=new Scanner(System.in);
		System.out.println("----------------");
		System.out.println("| 1: student registration|");
		System.out.println("| 2: new student         |");
		System.out.println("| 3: student deletion    |");
		System.out.println("| 4: update details      |");
		
		System.out.println("ENTER YOUR CHOICE!!!!");
		int choice=input.nextInt();
		
		if(choice==1)
		{
		
			System.out.println("name:");
			 this.name=ring.nextLine();
			System.out.println("course");
			 this.course=ring.nextLine();
			System.out.println("Student id");
			 this.id=input.nextInt();
			System.out.println("Student phone");
			 this.phone=input.nextInt();
			
			   insertjdbc();
		}
		if(choice==2) {
			System.out.println("name:");
			String name=ring.nextLine();
			System.out.println("course");
			String course=ring.nextLine();
			System.out.println("Student phone");
			int phone=input.nextInt();
			System.out.println("Student id");
			int id=input.nextInt();
			//System.out.println("year of birth");
			//int birth=input.nextInt();
			
	}if(choice==3) {
			System.out.print("ARE YOU SURE! Y/N");
			
			//Scanner scanner = new Scanner(System.in);
			String tet= ring.nextLine(); 
			switch(tet)
			  {
			case "y":
				System.out.println("name:");
				 this.name=ring.nextLine();
				deletejdbc();
				System.out.print("DELETED!!");
				
				
				break;
			case "n":
				System.out.print("TERMINATED!!"); 
			 }
					  }	
	if(choice==4) {
		System.out.println("ENTER THE NAME");
		this.name=ring.nextLine();
		System.out.println("ENTER PHONE NUMBER");
		this.phone=input.nextInt();
		
		updatejdbc(); 
	}
				}
				
	
	
	     public void insertjdbc() {
	    	 try {
	    		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost/stud" ,"root", "");
	    		 Statement stat=con.createStatement();
	    		 String sq="insert into details (name,stud_id,course,phone) values(?,?,?,?)";
	    		 PreparedStatement t=con.prepareStatement(sq);
	 			t.setString(1, name);
	 			t.setInt(2, id);
	 			t.setString(3, course);
	 			t.setInt(4, phone);
	 			System.out.println("CONNECTED");
	 			
	 			t.executeUpdate();
	 			con.close();
	 			System.out.println("UPDATED!!");
	    		 
	    	 }catch(Exception ex) {
	    		 System.out.println(ex);
	    	 }
	    	 
	}
	     public void deletejdbc() {
	    	 try {
	    		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost/stud" ,"root", "");
	    		 Statement stat=con.createStatement();
	    	 String ql="delete from details where name=?";
	    	 PreparedStatement t=con.prepareStatement(ql);
	    	 t.setString(1, name);
	    	 t.executeUpdate();
	    	 }catch(Exception ed) {
	    		 ed.printStackTrace();
	    	 }
	    	 
	     }
	     public void updatejdbc() {
	    	 try {
	    	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost/stud" ,"root", "");
    		 Statement stat=con.createStatement();
    		 String up="update  details set phone=? where name=?";
    		 PreparedStatement s=con.prepareStatement(up);
    		 s.setInt(1, phone);
    		 s.setString(2, name);
    		
    		 s.executeUpdate();
    		 
	    	 }catch(Exception er) {
	    		 er.printStackTrace();
	    	 }
	     }

}
