package prisma.home.phe.application.usecase;

import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.application.port.in.SaveLiquidationCommand;
import prisma.home.phe.application.port.out.LiquidationElasticModelRepository;
import prisma.home.phe.domain.Liquidation;

@Component
@Slf4j
public class CommandLiquidationUseCase implements SaveLiquidationCommand {

  LiquidationElasticModelRepository liquidationModelRepository;

  public CommandLiquidationUseCase(final LiquidationElasticModelRepository liquidationModelRepository) {
    this.liquidationModelRepository = liquidationModelRepository;
  }

  @Override
  public void saveLiquidation(Liquidation liquidation) {
    // :( no se que va aqui en este caso, imagino que son cosas de negocio calculos, transformaciones... etc capaz el "caso de negocio" es/debe ser sendToElastic
  }
}
