package prisma.home.phe.application.port.out;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import prisma.home.phe.adapter.elasticsearch.model.DailyLiquidationElasticModel;

public interface DailyLiquidationElasticModelRepository extends ElasticsearchRepository<DailyLiquidationElasticModel, String> {

}
