
package library.system;

import java.sql.*;

public class dbconnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public dbconnect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12260075","sql12260075","19970625");
            st=con.createStatement();
        }
        catch(Exception ex){
            System.err.println("Error : "+ex);
            System.out.println("asdasdad");
        }
}
    
    public String getdata(String username){
        String pw;
        try{
            String query="select password from login_details where username='"+username+"';";
            rs=st.executeQuery(query);
            rs.next();
            pw= rs.getString(1);
            return (pw);

        }
        catch(Exception ex){
            System.err.println("Error : "+ex);
        }
        return ("0");

    }
    
    public boolean insert(String username,String password){
        try{
            String query="insert into login_details(username,password) value('"+username+"',"+"'"+password+"');";
            st.execute(query);
            System.out.println("Executed Inserted");
            return true;
        }catch(Exception ex){
            System.err.println(ex);
            return false;
        }
        
    }
    
}


