package dturanski.avro.demo.sink;

import dturanski.avro.demo.domain.User;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@SpringBootApplication
@EnableBinding(Sink.class)
@Slf4j
public class AvroDemoSinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvroDemoSinkApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void process(Message<User> message) {

       log.info("received: {}", message);
    }
}
