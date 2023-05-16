package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class Discount {
    private static final BigDecimal fullPrice = BigDecimal.valueOf(100);
    private BigDecimal discountValue;

    public Discount(BigDecimal discountValue) {
        if (discountValue.compareTo(BigDecimal.valueOf(0)) < 0 || discountValue.compareTo(fullPrice) > 0) {
            throw new IllegalArgumentException("Discount value is negative or above 100%");
        }
        this.discountValue = discountValue;
    }

    public BigDecimal applyDiscount(BigDecimal price) {
        if (this.discountValue.equals(BigDecimal.valueOf(0))) {
            return price;
        }
        return price.multiply(fullPrice.subtract(discountValue).divide(fullPrice));
    }

    public BigDecimal getDiscountValue() {
        return this.discountValue;
    }
}
