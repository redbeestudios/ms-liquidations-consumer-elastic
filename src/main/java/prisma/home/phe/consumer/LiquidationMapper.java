package prisma.home.phe.consumer;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.model.elasticsearch.ElasticsearchLiquidations;
import prisma.home.phe.model.kafka.KafkaLiquidations;

@Slf4j
public class LiquidationMapper {

  public ElasticsearchLiquidations CreateLiquidationES(KafkaLiquidations kafkaLiquidation) {
    log.info(kafkaLiquidation.toString());

    ElasticsearchLiquidations esElasticsearchLiquidation = new ElasticsearchLiquidations();
    esElasticsearchLiquidation.setMarca(kafkaLiquidation.getBrand());
    esElasticsearchLiquidation.setPeriodo(StringToDate(kafkaLiquidation.getDay()));
    esElasticsearchLiquidation.setNroEstablecimiento(Long.valueOf(kafkaLiquidation.getEstablishmentId()));
    esElasticsearchLiquidation.setTotalPresentado(new BigDecimal(kafkaLiquidation.getGrossTotal()));
    esElasticsearchLiquidation.setTotalNeto(new BigDecimal(kafkaLiquidation.getNetTotal()));
    esElasticsearchLiquidation.setArancelesPrisma(new BigDecimal(kafkaLiquidation.getTariffsAndFinancialExpensesTotal()));
    esElasticsearchLiquidation.setImpuestos(new BigDecimal(kafkaLiquidation.getTaxesTotal()));
    return esElasticsearchLiquidation;
  }

  private String StringToDate(String Date) {
    String[] formatDate = Date.split("-");
    return (formatDate[2]+"-"+formatDate[1]+"-"+formatDate[0]);
  }
}
