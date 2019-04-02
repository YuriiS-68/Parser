package parser;

import java.util.StringJoiner;

public class Store {
    private Long storeId;
    private String shopName;
    private String shopUrl;

    Store(Long storeId, String shopName, String shopUrl) {
        this.storeId = storeId;
        this.shopName = shopName;
        this.shopUrl = shopUrl;
    }

    Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Store.class.getSimpleName() + "[", "]")
                .add("storeId=" + storeId)
                .add("shopName='" + shopName + "'")
                .add("shopUrl='" + shopUrl + "'")
                .toString();
    }
}
