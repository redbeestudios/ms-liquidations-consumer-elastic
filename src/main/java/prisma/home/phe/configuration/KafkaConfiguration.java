package prisma.home.phe.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import prisma.home.phe.model.kafka.KafkaLiquidations;

@EnableKafka
@Configuration
public class KafkaConfiguration {

  @Value("${spring.kafka.consumer.bootstrap-servers}")
  private final String bootstrapServer="localhost:9092";

  @Value("${spring.kafka.consumer.group-id}")
  private final String groupId="liquidations-group";

  @Bean
  public Map<String, Object> consumerConfigs() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
    props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
    props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, "false");
    return props;
  }

  @Bean
  public ConsumerFactory<String, KafkaLiquidations> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(consumerConfigs(),  new JsonDeserializer<>(),
      new JsonDeserializer<>(KafkaLiquidations.class, false));
  }
  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, KafkaLiquidations> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, KafkaLiquidations>
      factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }


}
