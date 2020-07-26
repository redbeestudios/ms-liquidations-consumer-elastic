package prisma.home.phe.adapter.elasticsearch.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import prisma.home.phe.application.port.in.SaveLiquidationCommand;
import prisma.home.phe.domain.Liquidation;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(indexName = "liquidation.demophe.2020-08", createIndex = true)
public class LiquidationElasticModel implements Serializable {

  @Id
  String Id;

  @Field(type= FieldType.Long)
  private String establishmentId;

  @Field(type=FieldType.Date, pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
  private Long paymentTimestamp;

  @Field(type=FieldType.Text)
  private String brand;

  @Field(type=FieldType.Double)
  private BigDecimal grossPay;

  @Field(type=FieldType.Double)
  private BigDecimal fee;

  @Field(type=FieldType.Double)
  private BigDecimal financialCost;

  @Field(type=FieldType.Double)
  private BigDecimal netPay;

  public LiquidationElasticModel DomainToElasticModel(Liquidation liquidation){
    Instant instant = liquidation.getPaymentTimestamp().toInstant();
    Long liquidationPayDate = instant.toEpochMilli();

    return LiquidationElasticModel.builder()
      .paymentTimestamp(liquidationPayDate)
      .brand(liquidation.getBrand())
      .grossPay(liquidation.getGrossPay())
      .fee(liquidation.getFee())
      .financialCost(liquidation.getFinancialCost())
      .netPay(liquidation.getNetPay())
      .build();
  }

  public LiquidationElasticModel CommandToElasticModel(SaveLiquidationCommand.Command liquidation){
    Instant instant = liquidation.getPaymentTimestamp().toInstant();
    Long liquidationPayDate = instant.toEpochMilli();

    return LiquidationElasticModel.builder()
      .paymentTimestamp(liquidationPayDate)
      .brand(liquidation.getBrand())
      .grossPay(liquidation.getGrossPay())
      .fee(liquidation.getFee())
      .financialCost(liquidation.getFinancialCost())
      .netPay(liquidation.getNetPay())
      .build();
  }

}
