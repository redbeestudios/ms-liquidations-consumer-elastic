package prisma.home.phe.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Liquidation {

  private String establishmentId;

  private Timestamp paymentTimestamp;

  private String brand;

  private Double grossPay;

  private Double fee;

  private Double financialCost;

  private Double netPay;

}
