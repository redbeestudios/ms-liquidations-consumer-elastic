package prisma.home.phe.adapter.elasticsearch;

import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.adapter.elasticsearch.model.DailyLiquidationElasticModel;
import prisma.home.phe.application.port.out.DailyLiquidationElasticModelRepository;
import prisma.home.phe.application.port.out.DailyLiquidationRepository;
import prisma.home.phe.domain.Liquidation;

@Slf4j
@Repository
public class DailyLiquidationElasticsearchAdapter implements DailyLiquidationRepository {

  DailyLiquidationElasticModelRepository dailyLiquidationElasticModelRepository;

  public DailyLiquidationElasticsearchAdapter(
    DailyLiquidationElasticModelRepository dailyLiquidationElasticModelRepository) {
    this.dailyLiquidationElasticModelRepository = dailyLiquidationElasticModelRepository;
  }

  @Override
  public Liquidation save(final Liquidation liquidation) {
    log.info("Daily Liquidation Saved in Elasticsearch{}", liquidation);

    dailyLiquidationElasticModelRepository.save(DailyLiquidationElasticModel.DomainToDailyElasticModel(liquidation));

    return Liquidation.builder()
      .brand(liquidation.getBrand())
      .establishmentId(liquidation.getEstablishmentId())
      .fee(liquidation.getFee())
      .financialCost(liquidation.getFinancialCost())
      .grossPay(liquidation.getGrossPay())
      .paymentDate(liquidation.getPaymentDate())
      .netPay(liquidation.getNetPay())
      .build();
  }
}

