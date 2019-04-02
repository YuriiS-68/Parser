package parser;

import java.util.StringJoiner;

public class Product {
    private Long productId;
    private String name;
    private String productDetailUrl;
    private String currency;
    private String productImage;
    private String productTitle;
    private Double currentMinPrice;
    private Double currentMaxPrice;
    private Double originalMinPrice;
    private Double originalMaxPrice;
    private Integer discount;
    private Integer orders;
    private Store store;

    public Product(Long productId, String name, String productDetailUrl, String currency, String productImage, String productTitle,
                   Double currentMinPrice, Double currentMaxPrice, Double originalMinPrice, Double originalMaxPrice, Integer discount, Integer orders, Store store) {
        this.productId = productId;
        this.name = name;
        this.productDetailUrl = productDetailUrl;
        this.currency = currency;
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.currentMinPrice = currentMinPrice;
        this.currentMaxPrice = currentMaxPrice;
        this.originalMinPrice = originalMinPrice;
        this.originalMaxPrice = originalMaxPrice;
        this.discount = discount;
        this.orders = orders;
        this.store = store;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductDetailUrl() {
        return productDetailUrl;
    }

    public void setProductDetailUrl(String productDetailUrl) {
        this.productDetailUrl = productDetailUrl;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public Double getCurrentMinPrice() {
        return currentMinPrice;
    }

    public void setCurrentMinPrice(Double currentMinPrice) {
        this.currentMinPrice = currentMinPrice;
    }

    public Double getCurrentMaxPrice() {
        return currentMaxPrice;
    }

    public void setCurrentMaxPrice(Double currentMaxPrice) {
        this.currentMaxPrice = currentMaxPrice;
    }

    public Double getOriginalMinPrice() {
        return originalMinPrice;
    }

    public void setOriginalMinPrice(Double originalMinPrice) {
        this.originalMinPrice = originalMinPrice;
    }

    public Double getOriginalMaxPrice() {
        return originalMaxPrice;
    }

    public void setOriginalMaxPrice(Double originalMaxPrice) {
        this.originalMaxPrice = originalMaxPrice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("productId=" + productId)
                .add("name='" + name + "'")
                .add("productDetailUrl='" + productDetailUrl + "'")
                .add("currency='" + currency + "'")
                .add("productImage='" + productImage + "'")
                .add("productTitle='" + productTitle + "'")
                .add("currentMinPrice=" + currentMinPrice)
                .add("currentMaxPrice=" + currentMaxPrice)
                .add("originalMinPrice=" + originalMinPrice)
                .add("originalMaxPrice=" + originalMaxPrice)
                .add("discount=" + discount)
                .add("orders=" + orders)
                .add("store=" + store.getStoreId())
                .toString();
    }
}
