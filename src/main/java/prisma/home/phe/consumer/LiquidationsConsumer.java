package prisma.home.phe.consumer;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.model.kafka.KafkaLiquidations;
import prisma.home.phe.service.elasticsearch.LiquidationService;

@Slf4j
@Service
public class LiquidationsConsumer {

  @Autowired
  LiquidationService liquidationService;

  final LiquidationMapper liquidationMapper = new LiquidationMapper();

  @KafkaListener(topics = {"liquidations"})
  public void eventConsumer(ConsumerRecord<String, KafkaLiquidations> liquidation) throws IOException {
    log.info("Message {} Received from kafka-cluster", liquidation.value());
    liquidationService.save(liquidationMapper.CreateLiquidationES(liquidation.value()));
    log.info("Message saved in ES");
  }


}
