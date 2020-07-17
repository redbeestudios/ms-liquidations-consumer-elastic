package prisma.home.phe.consumer;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.model.elasticsearch.ElasticsearchLiquidations;
import prisma.home.phe.model.kafka.KafkaLiquidations;
import prisma.home.phe.service.elasticsearch.LiquidationService;
import prisma.home.phe.service.elasticsearch.LiquidationServiceImpl;

@Slf4j
@Service
public class LiquidationsConsumer {

  @Autowired
  LiquidationService liquidationService;

  final LiquidationMapper liquidationMapper = new LiquidationMapper();

  @KafkaListener(topics = {"liquidations"})
  public void eventConsumer(KafkaLiquidations liquidation) throws IOException {
    log.info("Message {} Received from kafka-cluster", liquidation);
    liquidationService.save(liquidationMapper.CreateLiquidationES(liquidation));
    log.info("Message saved in ES");
  }


}
