package com.tnsif.employemanagement;
import java.sql.*;
import java.util.Scanner;

public class Employedetail {
	
	
		       public static void show() throws Exception{
	              String url="jdbc:mysql://localhost:3306/jdbcdemo";
			      String userName="root";
				  String passWord="root";
				  String query="select *from employe";
				  Connection con=DriverManager.getConnection(url,userName,passWord);
			        Statement st=con.createStatement();
			       ResultSet rs= st.executeQuery(query);
			       rs.next();
			       while(rs.next()) {
			       System.out.println("id is"+rs.getInt(1));
			       System.out.println("name"+rs.getString(2));
			       System.out.println("salary"+rs.getInt(3));
			       System.out.println("designation"+rs.getString(4));
			       System.out.println("location"+rs.getString(5));//about table
			     }
			       con.close();
				}
			public static void insertVar() throws Exception{
		            String url="jdbc:mysql://localhost:3306/jdbcdemo";
					String userName="root";
					String passWord="root";
					Scanner s=new Scanner(System.in);
					System.out.println("enter the employee id:");
					int empid=s.nextInt();
					s.nextLine();
					System.out.println("enter the employe name:");
					String ename=s.nextLine();
					System.out.println("enter the employee salary:");
					int salary=s.nextInt();
					s.nextLine();
				    System.out.println("enter the employe designation:");
					String designation=s.nextLine();
					System.out.println("enter the employe location:");
					String location=s.nextLine();
					String query="insert into employe values ("+ empid+",'"+ename+"',"+salary+",'"+designation +"','"+ location +"');";
					Connection con=DriverManager.getConnection(url,userName,passWord);
			        Statement st=con.createStatement();
			        int rows = st.executeUpdate(query);
			        System.out.println("numbers of rows are affected : "+rows);
			     con.close();
			        }
			  public static void delete() throws Exception{
		                String url="jdbc:mysql://localhost:3306/jdbcdemo";
						String userName="root";
						String passWord="root";
						Scanner s=new Scanner(System.in);
						System.out.println("enter the employe id:");
						int  empid=s.nextInt();
						String query="delete from employe where empid ="+ empid;
						Connection con=DriverManager.getConnection(url,userName,passWord);
				        Statement st=con.createStatement();
				        int rows = st.executeUpdate(query);
				        System.out.println("numbers of rows are affected : "+rows);
				     con.close();
				     }
			  public static void update() throws Exception{
		                String url="jdbc:mysql://localhost:3306/jdbcdemo";
						String userName="root";
						String passWord="root";
						Scanner s= new Scanner(System.in);
		                System.out.println("5->name change");
		                System.out.println("6->salary");
		                System.out.println("7->designation");
		                System.out.println("8->location");
						System.out.println("where want to update");
					int column=s.nextInt(); 
					switch(column) {
					case 5:
						Scanner sc=new Scanner(System.in);
						System.out.println("enter the name");
						String name=sc.nextLine();
						System.out.println("enter the id");
						int id=sc.nextInt();
						String query=" update employe set ename = '"+name+"' where empid ="+ id ;
						Connection con=DriverManager.getConnection(url,userName,passWord);
						Statement st=con.createStatement();
				        int rows = st.executeUpdate(query);
				        con.close();
				        break;
					case 6:
						Scanner cr=new Scanner(System.in);
						System.out.println("enter the salary");
						String salary=cr.nextLine();
						System.out.println("enter the id");
						int i=cr.nextInt();
						String quer=" update employe set salary = '"+salary+"' where empid ="+ i ;
						Connection conn=DriverManager.getConnection(url,userName,passWord);
						Statement sta=conn.createStatement();
				        int row = sta.executeUpdate(quer);
				        conn.close();
				        break;
					case 7:
					    Scanner scr=new Scanner(System.in);
						System.out.println("enter the designation");
						String designation=scr.nextLine();
						System.out.println("enter the id");
						int ide=scr.nextInt();
						String que=" update employe set designation = '"+designation+"' where empid ="+ ide ;
						Connection conne=DriverManager.getConnection(url,userName,passWord);
						Statement stat=conne.createStatement();
				        int ro = stat.executeUpdate(que);
				        conne.close();break;
					case 8: 
						Scanner sce=new Scanner(System.in);
						System.out.println("enter the location");
						String location=sce.nextLine();
						System.out.println("enter the id");
						int idl=sce.nextInt();
						String q=" update employe set location = '"+location+"' where empid ="+ idl ;
						Connection c=DriverManager.getConnection(url,userName,passWord);
						Statement so=c.createStatement();
				        int r = so.executeUpdate(q);
				        c.close();
						break;
					}
			  }
			  public static void main(String[] args) throws Exception {
				System.out.println("1->insert");
				System.out.println("2->delete");
				System.out.println("3->show");
				System.out.println("4->update");
				Scanner s=new Scanner(System.in);
				System.out.println("enter the number");
				  int option=s.nextInt();
				switch (option) {
				case 1:
					insertVar();
					show();
					break;
				case 2:
					delete();
					show();
					break;
				case 3:
					show();
					break;
				case 4:
					update();
					show();
					break;
				}
				System.out.println("do you want to continue:");
				Scanner si=new Scanner(System.in);
				int choose=s.nextInt();
				if(choose==0) {
					System.out.println("enter the number"+option);
				}
				else {
					System.out.println("task completed");
				}
			}

		}



