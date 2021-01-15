package kata5P2;

import kata5.model.Mail;
import kata5.model.Histogram;
import kata5.view.HistogramDisplay;
import kata5.view.MailHistogramBuilder;
import kata5.view.MailListReader;
import java.io.IOException;
import java.util.List;

public class Kata5P2 {

    public static void main(String[] args) throws IOException {
        Kata5P2 kata5 = new Kata5P2();
        kata5.control();
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
