package prisma.home.phe.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import prisma.home.phe.application.port.in.SaveLiquidationCommand;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Liquidation {

  private String establishmentId;

  private String paymentDate;

  private String brand;

  private BigDecimal grossPay;

  private BigDecimal fee;

  private BigDecimal financialCost;

  private BigDecimal serviceCost;

  private BigDecimal taxes;

  private BigDecimal netPay;

  public static Liquidation commandToLiquidation(SaveLiquidationCommand.Command command){
    return Liquidation.builder()
      .establishmentId(command.getEstablishmentId())
      .paymentDate(command.getPaymentDate())
      .brand(command.getBrand())
      .grossPay(command.getGrossPay())
      .fee(command.getFee())
      .financialCost(command.getFinancialCost())
      .serviceCost(command.getServiceCost())
      .taxes(command.getTaxes())
      .netPay(command.getNetPay())
      .build();
  }
}
