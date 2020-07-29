package prisma.home.phe.application.port.in;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Value;
import prisma.home.phe.domain.Liquidation;

public interface SaveLiquidationCommand {

  Liquidation saveDailyLiquidation(Command liquidation);

  Liquidation saveMonthlyLiquidation(Command liquidation);

  @Value
  @Builder
  class Command {
     String establishmentId;

     String paymentDate;

     String brand;

     BigDecimal grossPay;

     BigDecimal fee;

     BigDecimal financialCost;

     BigDecimal serviceCost;

     BigDecimal taxes;

     BigDecimal netPay;
  }
}
