package prisma.home.phe.adapter.elasticsearch.model;

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
import prisma.home.phe.domain.Liquidation;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(indexName = "monthly.liquidation.2020-07", createIndex = false)
public class MonthlyLiquidationElasticModel implements Serializable {

  @Id
  String Id;

  @Field(type= FieldType.Text)
  private String establishmentId;

  @Field(type=FieldType.Text)
  private String paymentMonth;

  @Field(type=FieldType.Date, format = DateFormat.custom)
  private String date;

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

  public static MonthlyLiquidationElasticModel DomainToMonthlyElasticModel(Liquidation liquidation){

    return MonthlyLiquidationElasticModel.builder()
      .establishmentId(liquidation.getEstablishmentId())
      .paymentMonth(liquidation.getPaymentDate().split("-")[1])
      .date(liquidation.getPaymentDate())
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
