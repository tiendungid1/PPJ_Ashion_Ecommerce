package petpj.ecommerce.ashion.core.modules.user.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.Hibernate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Address {

  @Id
  @SequenceGenerator(
      name = "address_sequence",
      sequenceName = "address_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
  private Long addressId;

  private String unitNumber;
  private String streetName;
  private String city;
  private String state;

  @OneToMany(mappedBy = "address")
  @Exclude
  private Set<UserAddress> userAddresses = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Address address = (Address) o;
    return addressId != null && Objects.equals(addressId, address.addressId);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
