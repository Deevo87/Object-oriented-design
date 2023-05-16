package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

public class DiscountTest {
    private String NAME1 = "Pizza";
    private BigDecimal PRICE1 = BigDecimal.valueOf(100);
    private String NAME2 = "Burger";
    private BigDecimal PRICE2 = BigDecimal.valueOf(900);

    private Product getProduct(Discount discount) {
        Product product = new Product(NAME1, PRICE1, discount);
        return product;
    }

    private Order getOrderWithProducts(Discount discount) {
        Product product1 = new Product(NAME1, PRICE1, new Discount(BigDecimal.valueOf(0)));
        Product product2 = new Product(NAME2, PRICE2, new Discount(BigDecimal.valueOf(0)));
        HashMap<String, Product> products = new HashMap<>();
        products.put(product1.getName(), product1);
        products.put(product2.getName(), product2);
        return new Order(products, discount);
    }

    @Test
    public void testIfDiscountGetAppliedToProduct() {
        // given
        Discount discount = new Discount(BigDecimal.valueOf(30));
        Product product = getProduct(discount);

        // when
        BigDecimal expectedPrice = BigDecimal.valueOf(70);

        // then
        assertBigDecimalCompareValue(product.getDiscountedPrice(), expectedPrice); // 70
    }

    @Test
    public void testIfDiscountGetAppliedToOrder() {
        // given
        Discount discount = new Discount(BigDecimal.valueOf(30));
        Order order = getOrderWithProducts(discount);

        // when
        BigDecimal expectedOrderValue = BigDecimal.valueOf(700);

        //then
        assertBigDecimalCompareValue(expectedOrderValue, order.getOrderWithDiscount()); // 700
    }

    @Test
    public void testDiscountWithEmptyOrder() {
        // given
        Discount discount = new Discount(BigDecimal.valueOf(90));
        HashMap<String, Product> emptyHashMap = new HashMap<>();

        // when
        Order order = new Order(emptyHashMap, discount);

        // then
        assertBigDecimalCompareValue(order.getOrderWithDiscount(), new BigDecimal(0)); // 0
    }

    @Test
    public void testOrderWith100Discount() {
        // given
        Discount discount = new Discount(BigDecimal.valueOf(100));
        Product product = getProduct(discount);

        // when
        Order order = getOrderWithProducts(discount);

        // then
        assertBigDecimalCompareValue(product.getDiscountedPrice(), BigDecimal.valueOf(0)); // 0
        assertBigDecimalCompareValue(order.getOrderWithDiscount(), BigDecimal.valueOf(0)); // 0
    }

    @Test
    public void testPriceWithDiscountAbove100() {
        assertThrows(IllegalArgumentException.class, () -> new Product(NAME1, PRICE1, new Discount(BigDecimal.valueOf(123)))); // error
    }

    @Test
    public void testPriceWithNegativeDiscount() {
        assertThrows(IllegalArgumentException.class, () -> new Product(NAME1, PRICE1, new Discount(BigDecimal.valueOf(-1)))); // error
    }

    @Test
    public void checkIfDiscountedProductsAreProperlyAddedToOrder() {
        // given
        Discount discount1 = new Discount(BigDecimal.valueOf(10));
        Discount discount2 = new Discount(BigDecimal.valueOf(50));
        Discount discountForOrder = new Discount(BigDecimal.valueOf(0));

        // when
        Product product1 = new Product(NAME1, PRICE1, discount1); // 90
        Product product2 = new Product(NAME2, PRICE2, discount2); // 450
        HashMap<String, Product> products = new HashMap<>();
        products.put(product1.getName(), product1);
        products.put(product2.getName(), product2);
        Order order = new Order(products, discountForOrder);

        // then
        assertBigDecimalCompareValue(order.getPrice(), BigDecimal.valueOf(540)); // 540
    }
}
