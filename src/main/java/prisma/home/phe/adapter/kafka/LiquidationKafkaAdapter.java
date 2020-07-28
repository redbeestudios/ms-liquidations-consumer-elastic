package prisma.home.phe.adapter.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.adapter.kafka.model.LiquidationKafkaModel;
import prisma.home.phe.application.port.in.SaveLiquidationCommand;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@Component
public class LiquidationKafkaAdapter  {

private SaveLiquidationCommand liquidationCommand;

  @Autowired
  ObjectMapper objectMapper;

  public LiquidationKafkaAdapter(SaveLiquidationCommand liquidationCommand) {
    this.liquidationCommand = liquidationCommand;
  }

  @KafkaListener(topics = {"daily.liquidations"})
  public void eventConsumer(ConsumerRecord<String, Object> consumerRecord) {

    log.info("Message {} Received from kafka-cluster", consumerRecord.value());

    LiquidationKafkaModel liquidation = objectMapper.convertValue(consumerRecord.value(), LiquidationKafkaModel.class);

    liquidationCommand.saveLiquidation(SaveLiquidationCommand.Command.builder()
      .establishmentId(liquidation.getEstablishmentId())
      .paymentDay(liquidation.getPaymentDay())
      .brand(liquidation.getBrand())
      .grossPay(liquidation.getGrossPay())
      .fee(liquidation.getFee())
      .financialCost(liquidation.getFinancialCost())
      .serviceCost(liquidation.getServiceCost())
      .taxes(liquidation.getTaxes())
      .netPay(liquidation.getNetPay())
      .build());
  }

}
