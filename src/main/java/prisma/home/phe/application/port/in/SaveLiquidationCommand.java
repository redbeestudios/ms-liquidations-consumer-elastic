package prisma.home.phe.application.port.in;

import lombok.Builder;
import lombok.Value;
import prisma.home.phe.domain.Liquidation;

/**
 * Hipoteticamente lo que me envien sean mangos, manzanas, chanchos yo los recibo
 * a través de command, y deberia cambiarlo al objeto del Dominio del UseCase
 *
 * Entonces yo lo veo así kafka consume un msj kafka y me lo envia encapsulado en command,
 * se transforma a liquidation
 */
public interface SaveLiquidationCommand {

  Liquidation saveLiquidation(Command liquidation);

  @Value
  @Builder
  class Command {
    Liquidation liquidation;
  }
}
