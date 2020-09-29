package gr.uniwa.apice;
import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApIceApplication{
    public static void main(String[] args) {
        SpringApplication.run(ApIceApplication.class, args);
    }

}
