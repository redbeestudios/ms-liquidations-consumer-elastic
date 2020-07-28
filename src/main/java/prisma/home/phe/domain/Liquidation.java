package prisma.home.phe.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Liquidation {

  private String establishmentId;

  private String paymentDay;

  private String brand;

  private BigDecimal grossPay;

  private BigDecimal fee;

  private BigDecimal financialCost;

  private BigDecimal serviceCost;

  private BigDecimal taxes;

  private BigDecimal netPay;

}
