package prisma.home.phe.service.elasticsearch;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prisma.home.phe.model.elasticsearch.ElasticsearchLiquidations;
import prisma.home.phe.model.kafka.KafkaLiquidations;
import prisma.home.phe.repository.LiquidationsRepository;

@Service
public class LiquidationServiceImpl implements LiquidationService{
  @Autowired
  LiquidationsRepository liquidationsRepository;

  @Override
  public void save(final ElasticsearchLiquidations liquidations) {
    liquidationsRepository.save(liquidations);
  }

}
