package kata5P2;

import java.io.FileNotFoundException;
import kata5.model.Mail;
import kata5.model.Histogram;
import kata5.view.HistogramDisplay;
import kata5.view.MailHistogramBuilder;
import kata5.view.MailListReaderBD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Kata5P2 {

    public static void main(String[] args) throws IOException {
        Kata5P2 kata5 = new Kata5P2();
        kata5.control();
    }
    
    private ArrayList<String> mailList;
    private Histogram<String> histogram;
    private String url = "jdbc:sqlite:KATA5P2.db";
    MailListReaderBD mrBD = new MailListReaderBD();
    
    private void control() throws IOException {
        connection(url);
        input();
        process();
        output();
    }
    public static void connection(String url){
        Connection con = null;
        try{
            con = DriverManager.getConnection(url);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if (con != null){
                    con.close();
                }
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    private void input() throws IOException{
        mailList = mrBD.read(url);
    }
    
    private void process(){
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    private void output(){
        HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAM",histogram);
        histogramDisplay.execute();
    }
}
