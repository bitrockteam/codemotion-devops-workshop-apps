package it.bitrock.codemotionworkshopdemo.model;

public class OrderRequest {

    private final String client;
    private final String resource;

    public OrderRequest(String client, String resource) {
        this.client = client;
        this.resource = resource;
    }

    public String client() {
        return this.client;
    }

    public String resource() {
        return this.resource;
    }

    @Override
    public String toString() {
        return "OrderRequest(" + client + ", " + resource + ")";
    }
}