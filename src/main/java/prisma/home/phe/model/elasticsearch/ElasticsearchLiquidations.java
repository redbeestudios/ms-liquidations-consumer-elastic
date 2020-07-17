package prisma.home.phe.model.elasticsearch;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(indexName = "liquidations.demo.phe.2020-07", shards = 2, replicas = 1, refreshInterval = "1s")
public class ElasticsearchLiquidations implements Serializable {
  @Id
  private String Id;

  @Field(type=FieldType.Long)
  private Long establishmentId;

  @Field(type=FieldType.Integer)
  private Integer brandCode;

  @Field(type=FieldType.Text)
  private String brand;

  @Field(type=FieldType.Date)
  private String day;

  @Field(type=FieldType.Long)
  private BigDecimal grossTotal;

  @Field(type=FieldType.Long)
  private BigDecimal tariffsAndFinancialExpensesTotal;

  @Field(type=FieldType.Long)
  private BigDecimal taxesTotal;

  @Field(type=FieldType.Long)
  private BigDecimal netTotal;
}
