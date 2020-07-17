package prisma.home.phe;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@EmbeddedKafka(topics = {"liquidations"}, partitions = 2)
@TestPropertySource(properties = {"spring.kafka.producer.bootstrap-servers=${spring.embedded.kafka.brokers}",
  "spring.kafka.consumer.bootstrap-servers=${spring.embedded.kafka.brokers}"})
public class LiquidationsConsumerIntegrationTest {

}
