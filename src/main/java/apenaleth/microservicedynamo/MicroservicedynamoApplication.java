package apenaleth.microservicedynamo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroservicedynamoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicedynamoApplication.class, args);

        // TODO Move to properties file
        System.setProperty("aws.accessKeyId", "localtest" );
        System.setProperty("aws.secretKey", "localtest" );
    }

}
