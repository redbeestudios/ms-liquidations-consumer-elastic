package prisma.home.phe.service.elasticsearch;

import prisma.home.phe.model.elasticsearch.ElasticsearchLiquidations;

public interface LiquidationService {

    void save(ElasticsearchLiquidations liquidations);

}
