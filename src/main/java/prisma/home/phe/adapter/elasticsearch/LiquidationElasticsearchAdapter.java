package prisma.home.phe.adapter.elasticsearch;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import prisma.home.phe.adapter.elasticsearch.model.LiquidationElasticModel;
import prisma.home.phe.application.port.out.LiquidationElasticModelRepository;
import prisma.home.phe.application.port.out.LiquidationRepository;

@Slf4j
@Service
public class LiquidationElasticsearchAdapter implements LiquidationRepository {

  LiquidationElasticModelRepository liquidationElasticModelRepository;

  @Override
  public void save(final LiquidationElasticModel liquidationElasticModel) {
    liquidationElasticModelRepository.save(liquidationElasticModel);
    log.info("Record saved {}", liquidationElasticModel);
  }
}

