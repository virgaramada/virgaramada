package id.co.maybank.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Article application.
 */
@SpringBootApplication(scanBasePackages = "id.co.maybank.demo.*")
public class ArticleApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class, args);
    }
}
