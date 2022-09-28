package com.amdocs.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class Bank1 {

	   public static void main(String[] args) {
		
		 Scanner s=new Scanner(System.in);
		
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					String url="jdbc:oracle:thin:@//localhost:1521/orcl.iiht.tech";
					
					String userName="scott";
					
					String password="tiger";
					
					Connection con=DriverManager.getConnection(url,userName,password);
					
					if(con!=null)
						
					{
						
						System.out.println("connected");
						
					}
					
					else
						
					{
						
						System.out.println("Connection failed");
						
					}
					
				int UserOption;
				do
					
				{
					System.out.println();
					
					System.out.println("1.   Open a new bank account");
					
					System.out.println("2.   Deposit bank account");
					
					System.out.println("3.   Withdraw from bank account");
					 
					System.out.println("4.   Print account balance");
					
					System.out.println("5.   Quit");
					
					System.out.println();
					
					System.out.println("Enter your Option");
					
					UserOption=s.nextInt();
					
					switch(UserOption)
					
					{
					case 1:
						System.out.println("--------------------------------------------------------------------------------------------------------");
						
						System.out.println("Enter customer's account number");
						
						int CustAccount=s.nextInt();
						
						System.out.println("Please enter  customer name");
						
						String CustName=s.next();
						
						System.out.println("Enter a opening balance");
						
						double AccBalance=s.nextDouble();
						
						System.out.println("Enter cusomer phone number");
						
						String CustPhone=s.next();
						
						System.out.println("Enter customer address");
						
						String CustAddress=s.next();
						
						System.out.println("Enter customer Email");
						
						String CustEmail=s.next();
						
						PreparedStatement ps;
						
						ps=con.prepareStatement("insert into BankInfo1 values(?,?,?,?,?,?)");
						
						ps.setInt(1, CustAccount);
						
						ps.setString(2, CustName);
						
						ps.setDouble(3, AccBalance);
						
						ps.setString(4, CustPhone);
						
						ps.setString(5, CustAddress);
						
						ps.setString(6, CustEmail);
						
						ps.executeUpdate();
						
						System.out.println("Account created ");
						
						break;
						
					case 2:
						
						System.out.println("------------------------------------------------------------------------------------------------------");
						
						System.out.println("Enter  account number");
						
						int AccNumber1=s.nextInt();
						
						System.out.println("Enter amount to deposit");
						
						int Amount=s.nextInt();
						
						PreparedStatement ps1=con.prepareStatement("update BankInfo1 set OpeningBalance=OpeningBalance+?"+"where AccountNumber1=?");

						ps1.setInt(1, Amount);
						
						ps1.setInt(2, AccNumber1);
						
						ps1.executeUpdate();
						
						Statement stmt=con.createStatement();
						
						System.out.println("Total Balance");
						System.out.println("-------------------------------------------------------------------------------------------------------");
						
						PreparedStatement ps2=con.prepareStatement("select OpeningBalance from BankInfo1 where AccountNumber1=?");
						
						ps2.setInt(1, AccNumber1);
						
						ResultSet r=ps2.executeQuery();
						
						while(r.next())
						{
							
							System.out.println(r.getInt(1));
						}
						
						break;
						
					case 3:
						
						System.out.println("----------------------------------------------------------------------------------------------------");
						
						System.out.println("enter a account number");
						
						int AccNumber3=s.nextInt();
						
						System.out.println("Enter amount to withdraw");
						
						int Amount1=s.nextInt();
						
						PreparedStatement ps3=con.prepareStatement("update BankInfo1 set OpeningBalance=OpeningBalance-?"+"where AccountNumber1=?");
						
						ps3.setInt(1,Amount1);
						
						ps3.setInt(2, AccNumber3);
						
						ps3.executeUpdate();
						
						Statement stmt1=con.createStatement();
						
						System.out.println("Total Balance");
						System.out.println("----------------------------------------------------------------------------------------------------");
						
						PreparedStatement ps4=con.prepareStatement("select OpeningBalance from BankInfo1 where AccountNumber1=?");
						
						ps4.setInt(1, AccNumber3);
						
						ResultSet rs=ps4.executeQuery();
						
						while(rs.next())
						{
							
							System.out.println(rs.getInt(1));
						}
						
						break;
						
					case 4:
						
						System.out.println("----------------------------------------------------------------------------------------------------");
						
						System.out.println("enter a account number");
						
						int AccNumber4=s.nextInt();
						
						Statement stmt2=con.createStatement();
						
						System.out.println("Account balance");
						System.out.println("----------------------------------------------------------------------------------------------------");
						
						PreparedStatement ps5=con.prepareStatement("select OpeningBalance from BankInfo1 where AccountNumber1=?");
						
						ps5.setInt(1, AccNumber4);
						
						ResultSet rs1=ps5.executeQuery();
						
						while(rs1.next())
						{
							
							System.out.println(rs1.getInt(1));
						}
						
						break;
						
					case 5:
						
						System.out.println("");
						
					break;
					}
				}
					while(UserOption!='6')	;
					
					}
				
				catch(Exception e) {
					e.printStackTrace();
				}
	}
}

	