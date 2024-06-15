package uptc.frw.aparatoselectronicos.conf;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
//Esta anotación indica que la clase es una clase de configuración de Spring.
// Esto significa que se pueden definir beans en esta clase.
@Configuration
//Esta anotación habilita el soporte de caché en la aplicación Spring. Permite
// el uso de anotaciones como `@Cacheable`, `@CachePut`, y `@CacheEvict` para
// gestionar la caché en los métodos.
@EnableCaching
public class RedisConfig {
    //@Bean`: Define un bean que será administrado por el contenedor de Spring.
    @Bean
    //Define un bean de tipo `RedisCacheManager`, que es el administrador de caché para Redis.
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        //RedisCacheConfiguration: Obtiene la configuración predeterminada de la caché de Redis.
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                //entryTtlEstablece el tiempo de vida (TTL) de las entradas de caché a 1 minuto.
                .entryTtl(Duration.ofMinutes(10))
                // Configura la caché para que no almacene valores `null`.
                .disableCachingNullValues()
                //Configura la serialización de los valores de la caché usando `GenericJackson2JsonRedisSerializer`, que serializa los objetos en formato JSON.
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
       //Crea y devuelve una instancia de `RedisCacheManager` con la configuración especificada.
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(cacheConfiguration)
                .build();
    }
    //@Bean`: Define un bean que será administrado por el contenedor de Spring.
    @Bean
    //Define un bean de tipo `RedisTemplate`. `RedisTemplate` es una plantilla de alto nivel para trabajar con Redis.
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // Establece la fábrica de conexiones de Redis en el `RedisTemplate`. Esto permite que el `RedisTemplate` se conecte a Redis.
        template.setConnectionFactory(redisConnectionFactory);
        //Establece el serializador de las claves como `StringRedisSerializer`, lo que significa que las claves serán serializadas como cadenas.
        template.setKeySerializer(new StringRedisSerializer());
        //stablece el serializador de los valores como `GenericJackson2JsonRedisSerializer`, lo que significa que los valores serán serializados en formato JSON.
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}
