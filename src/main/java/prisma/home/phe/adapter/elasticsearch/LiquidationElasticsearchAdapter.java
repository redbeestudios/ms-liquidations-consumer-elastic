package prisma.home.phe.adapter.elasticsearch;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.adapter.elasticsearch.model.LiquidationElasticModel;
import prisma.home.phe.application.port.in.SaveLiquidationCommand;
import prisma.home.phe.application.port.out.LiquidationElasticModelRepository;
import prisma.home.phe.application.port.out.LiquidationRepository;
import prisma.home.phe.domain.Liquidation;

@Slf4j
@Service
public class LiquidationElasticsearchAdapter implements LiquidationRepository {

  LiquidationElasticModelRepository liquidationElasticModelRepository;

  public LiquidationElasticsearchAdapter(LiquidationElasticModelRepository liquidationElasticModelRepository) {
    this.liquidationElasticModelRepository = liquidationElasticModelRepository;
  }

  @Override
  public Liquidation save(final SaveLiquidationCommand.Command liquidation) {
    LiquidationElasticModel liquidationElasticModel = new LiquidationElasticModel();
    liquidationElasticModelRepository.save(liquidationElasticModel.CommandToElasticModel(liquidation));
    log.info("Liquidation Saved {}",liquidation);
    return Liquidation.builder()
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

