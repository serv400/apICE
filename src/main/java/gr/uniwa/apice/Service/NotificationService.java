package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.PasswordGen.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNot(String mail,String newPwd){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mail);
        simpleMailMessage.setFrom("apiceuniwa@gmail.com");
        simpleMailMessage.setSubject("APICE UNIWA");
        simpleMailMessage.setText("Γειά! Φαίνεται πως κάτι ξέχασες ...\n \n" +
                "Απέκτησε πρόσβαση στον λογαριασμό σου χρησιμοποιώντας τον εξής προσωρινό κωδικό : \n"+
                newPwd+"\n\n\n Ο κωδικός αυτός παρακαλείτε να αλλάξει μετά την πρόβαση στον λογαριασμό σας.\n"+
                "Για την αλλαγή κατευθυνθείτε ως εξής:"+
                "(ονοματεπώνυμο -> αλλαγή κωδικού πρόσβασης -> υποβολή)");
        javaMailSender.send(simpleMailMessage);
    }
}
