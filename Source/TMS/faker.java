package Source.TMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class faker {

    Connection c;
    Statement s;

    faker(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/travelManagementSystem","root","ashita123456");
            s=c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
