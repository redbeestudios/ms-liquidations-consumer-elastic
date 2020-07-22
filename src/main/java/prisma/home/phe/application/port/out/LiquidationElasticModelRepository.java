package prisma.home.phe.application.port.out;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import prisma.home.phe.adapter.elasticsearch.model.LiquidationElasticModel;

@Repository
public interface LiquidationElasticModelRepository extends ElasticsearchRepository<LiquidationElasticModel, String> {

}
