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
//@Cacheable: Es utilizado para almacenar el resultado de la llamada al método en la caché.
//@CacheEvict: Es utilizado para eliminar uno o más elementos obsoletos de la caché.
//@CachePut: Es utilizado para actualizar uno o más elementos de la caché.
//@Caching: Es utilizado para agrupar las anotaciones anteriores, simplificando la configuración.


}
