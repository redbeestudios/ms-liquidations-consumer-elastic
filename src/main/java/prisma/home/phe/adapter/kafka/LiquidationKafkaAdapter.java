package prisma.home.phe.adapter.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.adapter.kafka.model.LiquidationKafkaModel;
import prisma.home.phe.application.port.in.SaveLiquidationCommand;

@Slf4j
@Service
public class LiquidationKafkaAdapter  {

private SaveLiquidationCommand liquidationCommand;

  public LiquidationKafkaAdapter(SaveLiquidationCommand liquidationCommand) {
    this.liquidationCommand = liquidationCommand;
  }

  @KafkaListener(topics = {"liquidations"})
  public void eventConsumer(LiquidationKafkaModel liquidation) {
    log.info("Message {} Received from kafka-cluster", liquidation);
    liquidationCommand.saveLiquidation(SaveLiquidationCommand.Command.builder()
      .liquidation(liquidation.toDomain())
      .build());
  }

}
