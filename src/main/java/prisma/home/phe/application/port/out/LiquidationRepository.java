package prisma.home.phe.application.port.out;

import prisma.home.phe.domain.Liquidation;

public interface LiquidationRepository {

  Liquidation save(Liquidation liquidation);
}
