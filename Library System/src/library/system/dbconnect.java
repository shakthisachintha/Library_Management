
package library.system;

import java.sql.*;

public class dbconnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public dbconnect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/snakedb","root","");
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
            String query="select passwd from login_details where email='"+username+"';";
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
    
}


