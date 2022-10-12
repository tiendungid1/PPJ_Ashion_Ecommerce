package petpj.ecommerce.ashion.core.modules.product.entities;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
  @Id
  @SequenceGenerator(
      name = "product_sequence",
      sequenceName = "product_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
  private Long productId;

  private String name;

  @Lob private String description;

  private String image;

  @ManyToOne
  @JoinColumn(name = "product_category_id")
  private ProductCategory productCategory;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Product product = (Product) o;
    return productId != null && Objects.equals(productId, product.productId);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
