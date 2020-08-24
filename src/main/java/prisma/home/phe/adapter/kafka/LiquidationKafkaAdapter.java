package prisma.home.phe.adapter.kafka;

import java.time.LocalDate;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.adapter.kafka.model.DailyLiquidationKafkaModel;
import prisma.home.phe.adapter.kafka.model.MonthlyLiquidationKafkaModel;
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

  @KafkaListener(topics = {"liquidations"})
  public void DailyLiquidationsConsumer(ConsumerRecord<String, Object> consumerRecord) {

    log.info("Daily Liquidation {} Received from kafka-cluster at {}", consumerRecord.value(),
      LocalDate.now());

    DailyLiquidationKafkaModel liquidation = objectMapper.convertValue(consumerRecord.value(), DailyLiquidationKafkaModel.class);

    liquidationCommand.saveDailyLiquidation(SaveLiquidationCommand.Command.builder()
      .establishmentId(liquidation.getEstablishmentId())
      .establishmentCuit(liquidation.getEstablishmentCuit())
      .paymentDate(liquidation.getPaymentDay())
      .establishmentBrand(liquidation.getEstablishmentBrand())
      .grossPay(liquidation.getGrossPay())
      .fee(liquidation.getFee())
      .financialCost(liquidation.getFinancialCost())
      .serviceCost(liquidation.getServiceCost())
      .taxes(liquidation.getTaxes())
      .netPay(liquidation.getNetPay())
      .build());
  }

  @KafkaListener(topics = {"liquidations.monthly"})
  public void MonthlyLiquidationsConsumer(ConsumerRecord<String, Object> consumerRecord) {

    log.info("MonthLy Liquidation {} Received from kafka-cluster at {}", consumerRecord.value(),
      LocalDate.now());

    MonthlyLiquidationKafkaModel liquidation = objectMapper.convertValue(consumerRecord.value(), MonthlyLiquidationKafkaModel.class);

    liquidationCommand.saveMonthlyLiquidation(SaveLiquidationCommand.Command.builder()
      .establishmentId(liquidation.getEstablishmentId())
      .establishmentCuit(liquidation.getEstablishmentCuit())
      .paymentDate(liquidation.getPaymentMonth())
      .establishmentBrand(liquidation.getEstablishmentBrand())
      .grossPay(liquidation.getGrossPay())
      .fee(liquidation.getFee())
      .financialCost(liquidation.getFinancialCost())
      .serviceCost(liquidation.getServiceCost())
      .taxes(liquidation.getTaxes())
      .netPay(liquidation.getNetPay())
      .build());
  }
}
