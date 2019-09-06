package dturanski.avro.demo.source;

import dturanski.avro.demo.domain.RandomUsers;
import dturanski.avro.demo.domain.User;
import java.time.Duration;
import java.util.function.Supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.schema.avro.AvroSchemaMessageConverter;
import org.springframework.cloud.stream.schema.avro.AvroSchemaServiceManagerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;

@SpringBootApplication
@EnableBinding(Source.class)
public class AvroDemoSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvroDemoSourceApplication.class, args);
    }


    @Bean
    public MessageConverter avroMessageConverter() {
        return new AvroSchemaMessageConverter(new AvroSchemaServiceManagerImpl());
    }


   @Bean
   public Supplier<Flux<Message<User>>> users(){
        return ()-> Flux.interval(Duration.ofSeconds(1))
                .map(i-> MessageBuilder.withPayload(RandomUsers.user())
                        .setHeader(MessageHeaders.CONTENT_TYPE, "application/avro").build())
                .log();
   }

}
