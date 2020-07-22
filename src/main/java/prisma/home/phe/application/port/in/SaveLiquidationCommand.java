package prisma.home.phe.application.port.in;

import prisma.home.phe.domain.Liquidation;

public interface SaveLiquidationCommand {

  void saveLiquidation(Liquidation liquidation);

}
