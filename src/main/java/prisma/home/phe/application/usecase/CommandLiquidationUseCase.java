package prisma.home.phe.application.usecase;

import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.application.port.in.SaveLiquidationCommand;
import prisma.home.phe.application.port.out.LiquidationRepository;
import prisma.home.phe.domain.Liquidation;

@Component
@Slf4j
public class CommandLiquidationUseCase implements SaveLiquidationCommand {

  LiquidationRepository liquidationRepository;

  public CommandLiquidationUseCase(final LiquidationRepository liquidationRepository) {
    this.liquidationRepository = liquidationRepository;
  }

  @Override
  public Liquidation saveLiquidation(final Command liquidation) {
    return new Liquidation().builder()
           .brand(liquidation.getBrand())
           .establishmentId(liquidation.getEstablishmentId())
           .fee(liquidation.getFee())
           .financialCost(liquidation.getFinancialCost())
           .grossPay(liquidation.getGrossPay())
           .paymentTimestamp(liquidation.getPaymentTimestamp())
           .netPay(liquidation.getNetPay())
           .build();
  }
}
