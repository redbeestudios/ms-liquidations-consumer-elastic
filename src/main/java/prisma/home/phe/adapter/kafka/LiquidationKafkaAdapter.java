package prisma.home.phe.adapter.kafka;

import java.time.LocalDate;

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
  public void DailyLiquidationsConsumer(ConsumerRecord<String, Object> consumerRecord) {

    log.info("Daily Liquidation {} Received from kafka-cluster at {}", consumerRecord.value(),
      LocalDate.now());

    LiquidationKafkaModel liquidation = objectMapper.convertValue(consumerRecord.value(), LiquidationKafkaModel.class);

    liquidationCommand.saveDailyLiquidation(SaveLiquidationCommand.Command.builder()
      .establishmentId(liquidation.getEstablishmentId())
      .paymentDate(liquidation.getPaymentDate())
      .brand(liquidation.getBrand())
      .grossPay(liquidation.getGrossPay())
      .fee(liquidation.getFee())
      .financialCost(liquidation.getFinancialCost())
      .serviceCost(liquidation.getServiceCost())
      .taxes(liquidation.getTaxes())
      .netPay(liquidation.getNetPay())
      .build());
  }

  @KafkaListener(topics = {"monthly.liquidations"})
  public void MonthlyLiquidationsConsumer(ConsumerRecord<String, Object> consumerRecord) {

    log.info("MonthLy Liquidation {} Received from kafka-cluster at {}", consumerRecord.value(),
      LocalDate.now());

    LiquidationKafkaModel liquidation = objectMapper.convertValue(consumerRecord.value(), LiquidationKafkaModel.class);

    liquidationCommand.saveMonthlyLiquidation(SaveLiquidationCommand.Command.builder()
      .establishmentId(liquidation.getEstablishmentId())
      .paymentDate(liquidation.getPaymentDate())
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
