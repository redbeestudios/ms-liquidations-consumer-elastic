package prisma.home.phe.adapter.elasticsearch;

import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.adapter.elasticsearch.model.MonthlyLiquidationElasticModel;
import prisma.home.phe.application.port.out.MonthlyLiquidationElasticModelRepository;
import prisma.home.phe.application.port.out.MonthlyLiquidationRepository;
import prisma.home.phe.domain.Liquidation;

@Slf4j
@Repository
public class MonthlyLiquidationElasticsearchAdapter implements MonthlyLiquidationRepository {

  MonthlyLiquidationElasticModelRepository monthlyLiquidationElasticModelRepository;

  public MonthlyLiquidationElasticsearchAdapter(
    final MonthlyLiquidationElasticModelRepository monthlyLiquidationElasticModelRepository) {
    this.monthlyLiquidationElasticModelRepository = monthlyLiquidationElasticModelRepository;
  }

  @Override
  public Liquidation save(final Liquidation liquidation) {
    log.info("Monthly Liquidation {} saved in elasticsearch at {}", liquidation, DateTime.now());

    monthlyLiquidationElasticModelRepository.save(MonthlyLiquidationElasticModel.DomainToMonthlyElasticModel(liquidation));

    return Liquidation.builder()
      .establishmentBrand(liquidation.getEstablishmentBrand())
      .establishmentCuit(liquidation.getEstablishmentCuit())
      .establishmentId(liquidation.getEstablishmentId())
      .fee(liquidation.getFee())
      .financialCost(liquidation.getFinancialCost())
      .grossPay(liquidation.getGrossPay())
      .paymentDate(liquidation.getPaymentDate())
      .netPay(liquidation.getNetPay())
      .build();
  }
}

