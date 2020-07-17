package prisma.home.phe.configuration;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "prisma.home.phe.repository")
public class ElasticsearchConfiguration {

    /**
     * Variable to link property elasticsearch host.
     */
    @Value("${elasticsearch.host}")
    private String host;

    /**
     * Variable to link property elasticsearch port.
     */
    @Value("${elasticsearch.port}")
    private int port;

    /**
     * Bean to define elasticsearch client configuration.
     * @return RestClient Object.
     */
    @Bean
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(host + ":" + port)
                .build();
        return RestClients.create(clientConfiguration).rest();
    }

    /**
     * Bean to define elasticsearch client configuration.
     * @return ElasticRestTemplate. Allows execute index operations.
     */
    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }
}
