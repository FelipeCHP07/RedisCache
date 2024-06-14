package uptc.frw.aparatoselectronicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AparatosElectronicosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AparatosElectronicosApplication.class, args);
        System.out.println("hola mundo cruel");
    }

}
