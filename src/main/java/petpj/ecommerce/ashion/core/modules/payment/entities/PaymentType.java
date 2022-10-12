package petpj.ecommerce.ashion.core.modules.payment.entities;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentType {
  @Id
  @SequenceGenerator(
      name = "payment_type_sequence",
      sequenceName = "payment_type_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_type_sequence")
  private Long paymentTypeId;

  private String value;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    PaymentType that = (PaymentType) o;
    return paymentTypeId != null && Objects.equals(paymentTypeId, that.paymentTypeId);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
