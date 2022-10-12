package petpj.ecommerce.ashion.core.modules.product.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategory {
  @Id
  @SequenceGenerator(
      name = "product_category_sequence",
      sequenceName = "product_category_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_category_sequence")
  private Long productCategoryId;

  private String categoryName;

  @ManyToOne
  @JoinColumn(name = "parent_category_id")
  @JsonIgnore
  @NotFound(action = NotFoundAction.IGNORE)
  private ProductCategory parentCategory;

  @JsonInclude(Include.NON_EMPTY)
  @OneToMany(mappedBy = "parentCategory", fetch = FetchType.EAGER)
  private Set<ProductCategory> subCategory = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    ProductCategory that = (ProductCategory) o;
    return productCategoryId != null && Objects.equals(productCategoryId, that.productCategoryId);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
