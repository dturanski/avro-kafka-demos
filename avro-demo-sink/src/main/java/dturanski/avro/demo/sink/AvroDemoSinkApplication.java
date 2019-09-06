package dturanski.avro.demo.sink;

import dturanski.avro.demo.domain.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class AvroDemoSinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvroDemoSinkApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void process(byte[] bytes) {
        System.out.println(bytes);
    }
}
