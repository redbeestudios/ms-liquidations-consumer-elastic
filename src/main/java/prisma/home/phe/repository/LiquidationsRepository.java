package prisma.home.phe.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import prisma.home.phe.model.elasticsearch.ElasticsearchLiquidations;

@Repository
public interface LiquidationsRepository extends ElasticsearchRepository<ElasticsearchLiquidations, String> {
}
