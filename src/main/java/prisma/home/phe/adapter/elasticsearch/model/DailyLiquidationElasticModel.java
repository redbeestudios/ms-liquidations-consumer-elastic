package prisma.home.phe.adapter.elasticsearch.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import prisma.home.phe.domain.Liquidation;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(indexName = "daily.liquidation.2020-07-28", createIndex = false)
public class DailyLiquidationElasticModel implements Serializable {

  @Id
  String Id;

  @Field(type= FieldType.Text)
  private String establishmentId;

  @Field(type=FieldType.Date, pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
  private String paymentDay;

  @Field(type=FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||yyyy-MM")
  private Date date;

  @Field(type=FieldType.Text)
  private String brand;

  @Field(type=FieldType.Double)
  private BigDecimal grossPay;

  @Field(type=FieldType.Double)
  private BigDecimal fee;

  @Field(type=FieldType.Double)
  private BigDecimal financialCost;

  @Field(type=FieldType.Double)
  private BigDecimal serviceCost;

  @Field(type=FieldType.Double)
  private BigDecimal taxes;

  @Field(type=FieldType.Double)
  private BigDecimal netPay;

  public static DailyLiquidationElasticModel DomainToDailyElasticModel(Liquidation liquidation){

    Date date = Date.valueOf(liquidation.getPaymentDate());

    return DailyLiquidationElasticModel.builder()
      .establishmentId(liquidation.getEstablishmentId())
      .paymentDay(liquidation.getPaymentDate())
      .date(date)
      .brand(liquidation.getBrand())
      .grossPay(liquidation.getGrossPay())
      .fee(liquidation.getFee())
      .financialCost(liquidation.getFinancialCost())
      .serviceCost(liquidation.getServiceCost())
      .taxes(liquidation.getTaxes())
      .netPay(liquidation.getNetPay())
      .build();
  }

}
