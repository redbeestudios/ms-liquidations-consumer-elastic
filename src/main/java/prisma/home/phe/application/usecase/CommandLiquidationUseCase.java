package prisma.home.phe.application.usecase;

import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.application.port.in.SaveLiquidationCommand;
import prisma.home.phe.application.port.out.DailyLiquidationRepository;
import prisma.home.phe.application.port.out.MonthlyLiquidationRepository;
import prisma.home.phe.domain.Liquidation;

@Component
@Slf4j
public class CommandLiquidationUseCase implements SaveLiquidationCommand {

  MonthlyLiquidationRepository monthlyLiquidationRepository;
  DailyLiquidationRepository dailyLiquidationRepository;

  public CommandLiquidationUseCase(
    final MonthlyLiquidationRepository monthlyLiquidationRepository, final DailyLiquidationRepository dailyLiquidationRepository) {

    this.monthlyLiquidationRepository = monthlyLiquidationRepository;
    this.dailyLiquidationRepository = dailyLiquidationRepository;

  }

  @Override
  public Liquidation saveDailyLiquidation(final Command liquidation) {
    log.info("Use Case: Save Daily Liquidation {}", liquidation);
    return dailyLiquidationRepository.save(Liquidation.commandToLiquidation(liquidation));
  }

  @Override
  public Liquidation saveMonthlyLiquidation(final Command liquidation) {
    log.info("Use Case: Save Monthly Liquidation {}", liquidation);
    return monthlyLiquidationRepository.save(Liquidation.commandToLiquidation(liquidation));
  }
}
