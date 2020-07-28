package prisma.home.phe.adapter.elasticsearch;

import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.adapter.elasticsearch.model.LiquidationElasticModel;
import prisma.home.phe.application.port.out.LiquidationElasticModelRepository;
import prisma.home.phe.application.port.out.LiquidationRepository;
import prisma.home.phe.domain.Liquidation;

@Slf4j
@Repository
public class LiquidationElasticsearchAdapter implements LiquidationRepository {

  LiquidationElasticModelRepository liquidationElasticModelRepository;

  public LiquidationElasticsearchAdapter(LiquidationElasticModelRepository liquidationElasticModelRepository) {
    this.liquidationElasticModelRepository = liquidationElasticModelRepository;
  }

  @Override
  public Liquidation save(final Liquidation liquidation) {
    log.info("Liquidation Saved in Elasticsearch{}", liquidation);

    liquidationElasticModelRepository.save(LiquidationElasticModel.DomainToElasticModel(liquidation));

    log.info("Liquidation Saved in Elasticsearch{}", liquidation);

    return Liquidation.builder()
      .brand(liquidation.getBrand())
      .establishmentId(liquidation.getEstablishmentId())
      .fee(liquidation.getFee())
      .financialCost(liquidation.getFinancialCost())
      .grossPay(liquidation.getGrossPay())
      .paymentDay(liquidation.getPaymentDay())
      .netPay(liquidation.getNetPay())
      .build();
  }
}

