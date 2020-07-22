package prisma.home.phe.application.port.out;

import prisma.home.phe.adapter.elasticsearch.model.LiquidationElasticModel;

public interface LiquidationRepository {

  void save(LiquidationElasticModel liquidationElasticModel);
}
