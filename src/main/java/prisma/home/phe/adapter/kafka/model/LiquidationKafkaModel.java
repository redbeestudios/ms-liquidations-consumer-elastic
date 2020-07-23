package prisma.home.phe.adapter.kafka.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.domain.Liquidation;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Slf4j
public class LiquidationKafkaModel implements Serializable {

  private String establishmentId;

  private Timestamp paymentTimestamp;

  private String brand;

  private BigDecimal grossPay;

  private BigDecimal fee;

  private BigDecimal financialCost;

  private BigDecimal netPay;

  public Liquidation toDomain() {

    return Liquidation.builder()
      .establishmentId(establishmentId)
      .paymentTimestamp(paymentTimestamp)
      .brand(brand)
      .grossPay(grossPay)
      .fee(fee)
      .financialCost(financialCost)
      .netPay(netPay)
      .build();
  }
}
