package kata4;

import kata4.model.Mail;
import kata4.model.Histogram;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;
import java.io.IOException;
import java.util.List;

public class Kata4 {

    public static void main(String[] args) throws IOException {
        Kata4 kata4 = new Kata4();
        kata4.control();
    }
    
    private List<Mail> mailList;
    private Histogram<String> histogram;
    
    private void control() throws IOException {
        input();
        process();
        output();
    }
    
    private void input() throws IOException{
        String fileName = new String("email.txt");
        mailList = MailListReader.read(fileName);
    }
    
    private void process(){
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    private void output(){
        HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAM",histogram);
        histogramDisplay.execute();
    }
}
