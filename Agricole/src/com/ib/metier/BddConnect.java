	package com.ib.metier;

	import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
	import java.util.List;

import com.ib.beans.User;
import com.ib.beans.Comptes;
import com.ib.beans.Operations;
import com.ib.beans.Message;

public class BddConnect {
	
	
	//****************************************************************************************************
	//***** FONCTION PERMETTANT DE RECUPERER L'ENSEMBLE DES USERS DE LA BDD POUR L'AUTHENTIFIACATION *****
	//****************************************************************************************************
	
	public static List<User> findAllUser() {
		
		List<User> users=new ArrayList<User>();
		
        Connection con = null;
        Statement stmt = null;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test", "root", "root");
            stmt = (Statement) con.createStatement();
           
            ResultSet rset = stmt.executeQuery("select * from sac_person");
          
            while (rset.next()) {
            	User user =new User();
            	user.setPerson_id(rset.getInt(1));
                user.setPerson_external_id(rset.getString(2));
                user.setPerson_firstname(rset.getString(3));
                user.setPerson_lastname(rset.getString(4));
                user.setPerson_email(rset.getString(5));
                user.setPerson_password(rset.getString(6));
                user.setPerson_dob(rset.getString(7));
                user.setPerson_token(rset.getString(8));
                user.setPerson_phone_number(rset.getString(9));
                user.setPerson_created_At(rset.getString(10));
                user.setPerson_updated_at(rset.getString(11));
                user.setPerson_advisor_id(rset.getInt(12));
                user.setPerson_is_advisor(rset.getInt(13));
            	
            	users.add(user);
             	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		return users;
	}
	
	
	//************************************************************************************************
	//***** FONCTION PERMETTANT DE RECUPERER L'ENSEMBLE DES OPERATATIONS A PARTIR DE L'ID CLIENT *****
	//************************************************************************************************


	public static List<Operations> findOperation( int idClient) {
	    List<Operations> operations = new ArrayList<Operations>();
	    Connection con = null;
	    Statement stmt = null;
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
	        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test", "root", "root");
	        stmt = (Statement) con.createStatement();
	        ResultSet rset = stmt.executeQuery("select * from sac_operation where ope_account_id="+ idClient);
	        while (rset.next()) {
	        	Operations operation = new Operations();
	        	operation.setOp_id(rset.getInt(1));
	        	operation.setOp_type(rset.getString(2));
	        	operation.setOpe_amount(rset.getInt(3));
	        	operation.setOpDescription(rset.getString(4));
	        	operation.setOpeAccountId(rset.getInt(5));
	        	operation.setOpeCreated(rset.getTimestamp(6));
	        	operation.setOpeUpdated(rset.getTimestamp(7));
	        	operation.setOpe_dispute(rset.getInt(8));
	        	operations.add(operation);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
	
	        if (stmt != null) {
	            try {
	                stmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	
	        if (con != null) {
	            try {
	                con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		return operations;
	}
	


	//******************************************************************************
	//***** FONCTION PERMETTANT DE RECUPERER UN OPERATATION A PARTIR DE SON ID *****
	//******************************************************************************

	public static List<Operations> findOperationId( int idOperation) {
        List<Operations> operations = new ArrayList<Operations>();
        Connection con = null;
        Statement stmt = null;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test", "root", "root");
            stmt = (Statement) con.createStatement();
            ResultSet rset = stmt.executeQuery("select * from sac_operation where ope_id="+ idOperation);
            while (rset.next()) {
            	Operations operation = new Operations();
            	operation.setOp_id(rset.getInt(1));
            	operation.setOp_type(rset.getString(2));
            	operation.setOpe_amount(rset.getInt(3));
            	operation.setOpDescription(rset.getString(4));
            	operation.setOpeAccountId(rset.getInt(5));
            	operation.setOpeCreated(rset.getTimestamp(6));
            	operation.setOpeUpdated(rset.getTimestamp(7));
            	operation.setOpe_dispute(rset.getInt(8));
            	operations.add(operation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		return operations;
	}
	
	//****************************************************
	//***** FONCTION PERMETTANT DE RECUPERER LA DATE *****
	//****************************************************
	
	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
	
	
	//***********************************************************************************
	//***** FONCTION PERMETTANT D'ENVOYER UN MESSAGE A SON CONSEILLER OU SON CLIENT *****
	//***********************************************************************************
	
	public static void ajoutMsg(Message msg ){
		Connection con = null;
        Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test", "root", "root");
            String query = "Insert Into sac_messages VALUES ( null,?,?,?,?)";
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            preparedStmt.setString(1, msg.getMsg_content());
            preparedStmt.setInt(2,msg.getMsg_from() );
            preparedStmt.setInt(3,msg.getMsg_to() );
            preparedStmt.setTimestamp(4,getCurrentTimeStamp());
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            if (stmt != null) {
                try {
                    // Le stmt.close ferme automatiquement le rset.
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	
	//**********************************************************
	//***** FONCTION PERMETTANT DE SUPPRIMER UNE OPERATION *****
	//**********************************************************
	
	public static void suppOperation(int clientID,int num_op ){
		Connection con = null;
        Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test", "root", "root");
            String query = "delete from sac_operation where ope_id=? and ope_account_id=?";
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            preparedStmt.setInt(1, num_op);
            preparedStmt.setInt(2,clientID);
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            if (stmt != null) {
                try {
                    // Le stmt.close ferme automatiquement le rset.
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	
	//*******************************************************************************************
	//***** FONCTION PERMETTANT DE RECUPERER L'ENSEMBLE DES COMPTES A PARTIR DE L'ID CLIENT *****
	//*******************************************************************************************
	
	public static List<Comptes> findCompte( int idClient) {
        List<Comptes> comptes = new ArrayList<Comptes>();
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test", "root", "root");
            stmt = (Statement) con.createStatement();
            ResultSet rset = stmt.executeQuery("select * from sac_accounts where account_customer_id="+ idClient);
            while (rset.next()) {
                Comptes compte = new Comptes();
                compte.setAccount_id(rset.getInt(1));
                compte.setAccount_customer_id(rset.getString(2));
                compte.setAccount_balance(rset.getFloat(3));
                compte.setAccount_type(rset.getString(4));
                compte.setAccount_is_default(rset.getInt(5));
               
                comptes.add(compte);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

           if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

           if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return comptes;
    }
	
	
	//************************************************************************************************
	//***** FONCTION PERMETTANT DE RECUPERER L'ENSEMBLE DES MESSAGES A PARTIR DE L'ID CONSEILLER *****
	//************************************************************************************************
	
	public static List<Message> findMsg( int idConseiller) {
        List<Message> Messages = new ArrayList<Message>();
        Connection con = null;
        Statement stmt = null;
            
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test", "root", "root");
            stmt = (Statement) con.createStatement();
            ResultSet rset = stmt.executeQuery("select * from sac_messages where msg_from = "+ idConseiller + " OR msg_to = "+idConseiller);
            while (rset.next()) {
                Message msg = new Message();              
                msg.setMsg_id(rset.getInt(1));
                msg.setMsg_content(rset.getString(2));
                msg.setMsg_from(rset.getInt(3));
                msg.setMsg_to(rset.getInt(4));
               msg.setMsg_created(rset.getTimestamp(5));
               Messages.add(msg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {

           if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

           if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return Messages;
    }
	
	
	//******************************************************************************************************
	//***** FONCTION PERMETTANT DE RECUPERER L'ENSEMBLE DES CLIENTS D'UN CONSEILLER A PARTIR DE SON ID *****
	//******************************************************************************************************
	
	public static List<User> findClients( int idConseiller) {
        List<User> users = new ArrayList<User>();
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test", "root", "root");
            stmt = (Statement) con.createStatement();
            ResultSet rset = stmt.executeQuery("select * from sac_person where person_advisor_id="+ idConseiller);
            while (rset.next()) {
                User user = new User();
                             
                user.setPerson_id(rset.getInt(1));
                user.setPerson_external_id(rset.getString(2));
                user.setPerson_firstname(rset.getString(3));
                user.setPerson_lastname(rset.getString(4));
                user.setPerson_email(rset.getString(5));
                user.setPerson_password(rset.getString(6));
                user.setPerson_dob(rset.getString(7));
                user.setPerson_token(rset.getString(8));
                user.setPerson_phone_number(rset.getString(9));
                user.setPerson_created_At(rset.getString(10));
                user.setPerson_updated_at(rset.getString(11));
                user.setPerson_advisor_id(rset.getInt(12));
                user.setPerson_is_advisor(rset.getInt(13));
               
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

           if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

           if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }
		
	
	//***************************************************
	//***** FONCTION PERMETTANT D'AJOUTER UN CLIENT *****
	//***************************************************
		
	public static void ajoutUser(int client_external_id, String lastname, String firstname, String email, String password, String dob, String phone, int advisor){
		Connection con = null;
        Statement stmt = null;
        
        Timestamp created = getCurrentTimeStamp();
       
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			 con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test", "root", "root");
			String query = "INSERT INTO sac_person (person_id , person_external_id , person_firstname , person_lastname , person_email , person_password , person_dob , person_phone_number , person_created_At , person_updated_at , person_advisor_id , person_is_advisor )"
					+ "VALUES(null, '"+ client_external_id +"','"+ firstname+"','"+lastname+"','"+email+"','"+password+"','"+dob+"','"+phone+"', '"+created+"', '"+created+"', '"+advisor+"', 0)";
			
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
           
            preparedStmt.executeUpdate();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} finally {
            if (stmt != null) {
                try {
                  
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	//*******************************************************
	//***** FONCTION PERMETTANT D'AJOUTER UNE OPERATION *****
	//*******************************************************
		
	public static void ajoutOperation(String ope_type, float ope_amount, String ope_description, int ope_account_id){
		Connection con = null;
        Statement stmt = null;
        
        Timestamp created = getCurrentTimeStamp();
               
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			 con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test", "root", "root");
			String query = "INSERT INTO sac_operation (ope_id, ope_type , ope_amount , ope_description , ope_account_id , ope_created_at , ope_updated_at, ope_dispute)"
					+ "VALUES(null, '"+ ope_type +"','"+ ope_amount+"','"+ope_description+"','"+ope_account_id+"','"+created+"','"+created+"', 0)";
			
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
           
            preparedStmt.executeUpdate();
           
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} finally {
            if (stmt != null) {
                try {
                  
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	
	//***************************************************
	//***** FONCTION PERMETTANT D'AJOUTER UN COMPTE *****
	//***************************************************
	
	public static void ajoutCompte(String account_customer_id, float account_balance, String account_type, int account_is_default){
		Connection con = null;
        Statement stmt = null;
        	       
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			 con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test", "root", "root");
			String query = "INSERT INTO sac_accounts (account_id , account_customer_id , account_balance , account_type , account_is_default)"
					+ "VALUES(null, '"+ account_customer_id +"','"+ account_balance+"','"+account_type+"','"+account_is_default+"')";
						
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
           
            preparedStmt.executeUpdate();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} finally {
            if (stmt != null) {
                try {
                  
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	
	//************************************************************************************
	//***** FONCTION PERMETTANT DE METTRE A JOUR SES INFORMATIONS EN TANT QUE CLIENT *****
	//************************************************************************************
		
	public static void UpdateUser(int client_id, String lastname, String firstname, String email, String password){
		Connection con = null;
        Statement stmt = null;
        
        
       
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test", "root", "root");
			
			String query = "UPDATE `sac_person` set person_firstname='"+firstname+"', person_lastname='"+lastname+"',person_email='"+email+"', person_password='"+password+"' where person_id='"+client_id+"' ";
			
			//String query = "INSERT INTO users () VALUES('"+ clientid +"','"+ name+"','"+surname+"','"+NewPass+"','0','1','"+token+"')";
							
			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
                 
           
            preparedStmt.executeUpdate();
            	            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} finally {
            if (stmt != null) {
                try {
                  
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	
	//****************************************************************************************
	//***** FONCTION PERMETTANT DE METTRE A JOUR SES INFORMATIONS EN TANT QUE CONSEILLER *****
	//****************************************************************************************
	
	public static void UpdateUserConseiller(int client_external_id, String lastname, String firstname, String email, String password){
		Connection con = null;
        Statement stmt = null;
        
        
       
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/societe_agricole_test", "root", "root");
			
			
			if (firstname!=""){
				
				
				String query = "UPDATE sac_person set person_firstname='"+firstname+"' where person_external_id='"+client_external_id+"' ";
				PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query); 
	            preparedStmt.executeUpdate();
			}
			
			
			
			if (lastname!=""){
				
				String query = "UPDATE sac_person set person_lastname='"+lastname+"' where person_external_id='"+client_external_id+"' ";
				PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query); 
	            preparedStmt.executeUpdate();
			}
			
			if (email!=""){
				
				String query = "UPDATE sac_person set person_email='"+email+"' where person_external_id='"+client_external_id+"' ";
				PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query); 
	            preparedStmt.executeUpdate();
			}
			
			if (password!=""){
				
				String query = "UPDATE sac_person set person_password='"+password+"' where person_external_id='"+client_external_id+"' ";
				PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query); 
	            preparedStmt.executeUpdate();
			}
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} finally {
            if (stmt != null) {
                try {
                  
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
		
}
