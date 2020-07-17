package prisma.home.phe.model.kafka;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class KafkaLiquidations implements Serializable {

  private Integer establishmentId;
  private Integer brandCode;
  private String brand;
  private String day;
  private Double grossTotal;
  private Double tariffsAndFinancialExpensesTotal;
  private Double taxesTotal;
  private Double netTotal;

}
