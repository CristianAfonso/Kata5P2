package kata5.view;

import java.util.ArrayList;
import kata5.model.Histogram;
import kata5.model.Mail;

public class MailHistogramBuilder {
    
    public static Histogram<String> build(ArrayList<String> mailList){
        Histogram <String> histogram = new Histogram <>();
        for (String mail : mailList){
            Mail email = new Mail(mail);
            histogram.increment(email.getDomain());
        }
        return histogram;
    }
}
