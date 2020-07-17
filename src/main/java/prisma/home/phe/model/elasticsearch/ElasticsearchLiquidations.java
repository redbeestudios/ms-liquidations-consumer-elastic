package prisma.home.phe.model.elasticsearch;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
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
@Document(indexName = "liquidation.demophe.2020-07", createIndex = false)
public class ElasticsearchLiquidations implements Serializable {
  @Id
  String Id;

  @Field(type= FieldType.Long)
  BigDecimal arancelesPrisma;

  @Field(type=FieldType.Text)
  String marca;

  @Field(type=FieldType.Long)
  Long nroEstablecimiento;

  @Field(type=FieldType.Long)
  BigDecimal totalNeto;

  @Field(type=FieldType.Text)
  String cuit;

  @Field(type=FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
  String periodo;

  @Field(type=FieldType.Long)
  BigDecimal impuestos;

  @Field(type=FieldType.Long)
  BigDecimal totalPresentado;

  @Field(type=FieldType.Text)
  String nombre;


}
