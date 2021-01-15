package kata5.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MailListReaderBD {
    private Connection connect(String url){
        Connection con = null;
        try{
            con = DriverManager.getConnection(url);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
    
    public ArrayList<String> read(String url){
        ArrayList<String> list = new ArrayList<>();
        String sql = "SELECT mail FROM eMAIL";
        try(Connection con  = this.connect(url);
            Statement stmt  = con.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            while(rs.next()){
                list.add(rs.getString("mail"));
            }
        }catch (SQLException e){
                System.out.println(e.getMessage());
        }
        return list;
    }
}
