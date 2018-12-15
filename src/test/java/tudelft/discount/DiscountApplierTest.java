package tudelft.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiscountApplierTest {
  private ProductDao productDao;
  private Product productHome90;
  private Product productBusiness110;

  @BeforeEach
  void setUp() {
    productDao = mock(ProductDao.class);
    productHome90 = new Product("HOME-Product",100,"HOME");
    productBusiness110 = new Product("BUSINESS-Product",100,"BUSINESS");
  }

  @Test
  void discountForHomeProductsShouldBe90() {
    // given
    final DiscountApplier discountApplier = new DiscountApplier(productDao);
    List<Product> products = Collections.singletonList(productHome90);
    when(productDao.all()).thenReturn(products);

    // when
    discountApplier.setNewPrices();

    // then
    Assertions.assertEquals(90.0, productHome90.getPrice(), 1e-3);
  }

  @Test
  void discountForBusinessProductsShouldBe110() {
    // given
    final DiscountApplier discountApplier = new DiscountApplier(productDao);
    List<Product> products = Collections.singletonList(productBusiness110);
    when(productDao.all()).thenReturn(products);

    // when
    discountApplier.setNewPrices();

    // then
    Assertions.assertEquals(110.0, productBusiness110.getPrice(), 1e-3);
  }
}
