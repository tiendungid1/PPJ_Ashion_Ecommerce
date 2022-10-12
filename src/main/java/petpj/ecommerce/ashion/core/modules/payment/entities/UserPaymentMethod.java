package petpj.ecommerce.ashion.core.modules.payment.entities;

import java.time.YearMonth;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import petpj.ecommerce.ashion.core.modules.user.entities.User;
import petpj.ecommerce.ashion.pkgs.helper.YearMonthDateAttributeConverter;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPaymentMethod {
  @Id
  @SequenceGenerator(
      name = "user_payment_method_sequence",
      sequenceName = "user_payment_method_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_payment_method_sequence")
  private Long userPaymentMethodId;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "payment_type_id")
  private PaymentType paymentType;

  private String provider;

  private String accountNumber;

  @Column(columnDefinition = "date")
  @Convert(converter = YearMonthDateAttributeConverter.class)
  private YearMonth expirationDate;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    UserPaymentMethod that = (UserPaymentMethod) o;
    return userPaymentMethodId != null
        && Objects.equals(userPaymentMethodId, that.userPaymentMethodId);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
