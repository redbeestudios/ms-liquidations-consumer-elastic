package prisma.home.phe.consumer;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.model.elasticsearch.ElasticsearchLiquidations;
import prisma.home.phe.model.kafka.KafkaLiquidations;

@Slf4j
public class LiquidationMapper {

  public ElasticsearchLiquidations CreateLiquidationES(KafkaLiquidations kafkaLiquidation){
    log.info(kafkaLiquidation.toString());

    ElasticsearchLiquidations esElasticsearchLiquidation = new ElasticsearchLiquidations();
    esElasticsearchLiquidation.setBrand(kafkaLiquidation.getBrand());
    esElasticsearchLiquidation.setDay(kafkaLiquidation.getDay());
    esElasticsearchLiquidation.setEstablishmentId(Long.valueOf(kafkaLiquidation.getEstablishmentId()));
    esElasticsearchLiquidation.setGrossTotal(new BigDecimal(kafkaLiquidation.getGrossTotal()));
    esElasticsearchLiquidation.setNetTotal(new BigDecimal(kafkaLiquidation.getNetTotal()));
    esElasticsearchLiquidation.setTariffsAndFinancialExpensesTotal(new BigDecimal(kafkaLiquidation.getTariffsAndFinancialExpensesTotal()));
    esElasticsearchLiquidation.setTaxesTotal(new BigDecimal(kafkaLiquidation.getTaxesTotal()));
    return esElasticsearchLiquidation;
  }
}
