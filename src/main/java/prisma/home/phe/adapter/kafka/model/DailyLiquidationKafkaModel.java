package prisma.home.phe.adapter.kafka.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class DailyLiquidationKafkaModel implements Serializable {

  private String establishmentId;

  private String paymentDay;

  private String establishmentBrand;

  private String establishmentCuit;

  private BigDecimal grossPay;

  private BigDecimal fee;

  private BigDecimal financialCost;

  private BigDecimal serviceCost;

  private BigDecimal taxes;

  private BigDecimal netPay;

  public Liquidation toDomain() {

    return Liquidation.builder()
      .establishmentId(establishmentId)
      .paymentDate(paymentDay)
      .establishmentBrand(establishmentBrand)
      .establishmentCuit(establishmentCuit)
      .grossPay(grossPay)
      .fee(fee)
      .financialCost(financialCost)
      .serviceCost(serviceCost)
      .taxes(taxes)
      .netPay(netPay)
      .build();
  }
}
