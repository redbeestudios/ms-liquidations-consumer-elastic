package prisma.home.phe.adapter.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.adapter.kafka.model.LiquidationKafkaModel;
import prisma.home.phe.application.port.in.SaveLiquidationCommand;

@Slf4j
@Component
public class LiquidationKafkaAdapter  {

private SaveLiquidationCommand liquidationCommand;

  public LiquidationKafkaAdapter(SaveLiquidationCommand liquidationCommand) {
    this.liquidationCommand = liquidationCommand;
  }

  @KafkaListener(topics = {"liquidations"})
  public void eventConsumer(LiquidationKafkaModel liquidation) {
    log.info("Message {} Received from kafka-cluster", liquidation);
    liquidationCommand.saveLiquidation(SaveLiquidationCommand.Command.builder()
      .brand(liquidation.getBrand())
      .establishmentId(liquidation.getEstablishmentId())
      .fee(liquidation.getFee())
      .financialCost(liquidation.getFinancialCost())
      .grossPay(liquidation.getGrossPay())
      .paymentTimestamp(liquidation.getPaymentTimestamp())
      .netPay(liquidation.getNetPay())
      .build());
  }

}
