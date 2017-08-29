package demo.test;

import com.sun.fox.fk.swagger.properties.SwaggerAutoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConfigTest.class)
@EnableConfigurationProperties(value = {SwaggerAutoConfig.class})
@Configuration
public class ConfigTest {

    @Autowired
    private SwaggerAutoConfig swaggerAutoConfig;

    @Test
    public void hello() {
        swaggerAutoConfig.getEngroup();
        System.out.println("hello world");
    }
}
