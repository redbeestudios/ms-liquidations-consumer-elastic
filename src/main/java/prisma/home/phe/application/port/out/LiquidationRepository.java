package prisma.home.phe.application.port.out;

import prisma.home.phe.application.port.in.SaveLiquidationCommand;
import prisma.home.phe.domain.Liquidation;

public interface LiquidationRepository {

  Liquidation save(SaveLiquidationCommand.Command liquidation);
}
