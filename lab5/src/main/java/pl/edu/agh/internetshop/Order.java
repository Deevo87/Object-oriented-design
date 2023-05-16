package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.util.*;


public class Order {
    private static final BigDecimal TAX_VALUE = BigDecimal.valueOf(1.23);
	private final UUID id;
    private HashMap<String, Product> products = new HashMap<>(); // changed
    private boolean paid;
    private Shipment shipment;
    private ShipmentMethod shipmentMethod;
    private PaymentMethod paymentMethod;
    private final Discount discount;

    public Order(Product product) {
        this.products.put(product.getName(), product);
        id = UUID.randomUUID();
        paid = false;
        this.discount = new Discount(BigDecimal.valueOf(0));
    }

    public Order(HashMap<String, Product> products, Discount discount) {
        this.products = products;
        this.discount = discount;
        id = UUID.randomUUID();
        paid = false;
    }

    public UUID getId() {
        return id;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isSent() {
        return shipment != null && shipment.isShipped();
    }

    public boolean isPaid() { return paid; }

    public Product getProduct(String productName) {
        return this.products.get(productName);
    }

    public Shipment getShipment() {
        return shipment;
    }

    public BigDecimal getPrice(String productName) {
        return this.products.get(productName).getPrice();
    }

    public BigDecimal getPriceWithTaxes(String productName) {
        return getPrice(productName).multiply(TAX_VALUE).setScale(Product.PRICE_PRECISION, Product.ROUND_STRATEGY);
    }

    public HashMap<String, Product> getProducts() {
        return products;
    } //changed

    public ShipmentMethod getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public void send() {
        boolean sentSuccesful = getShipmentMethod().send(shipment, shipment.getSenderAddress(), shipment.getRecipientAddress());
        shipment.setShipped(sentSuccesful);
    }

    public void pay(MoneyTransfer moneyTransfer) {
        moneyTransfer.setCommitted(getPaymentMethod().commit(moneyTransfer));
        paid = moneyTransfer.isCommitted();
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public BigDecimal getPrice() {
        BigDecimal price = BigDecimal.valueOf(0);
        for (Map.Entry<String, Product> p : this.products.entrySet()) {
            price = price.add(p.getValue().getDiscountedPrice());
        }
        return price; //return 0 when list is empty
    }

    public BigDecimal applyDiscountToOrder(BigDecimal price) {
        return this.discount.applyDiscount(price);
    }

    public BigDecimal getOrderWithDiscount() {
        return applyDiscountToOrder(getPrice());
    }

    @Override
    public boolean equals(Object obj) {
        HashMap<String, Product> object = (HashMap<String, Product>) obj;
        if (this.products.size() != object.size()) {
            return false;
        }
        boolean areEqual = this.products.entrySet().stream().allMatch((p ->
            object.containsKey(p.getKey()) && object.get(p.getKey()).equals(p.getValue()))
        );
        return areEqual;
    }

}
