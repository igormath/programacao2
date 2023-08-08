package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Produto {
    private double price;
    private String description;
    private int stockQnt;
    private Date expiration;
    private Fornecedor fornecedor;

    private double discount;
    public Produto(double price, String description, int stockQnt, Date expiration, Fornecedor fornecedor) {
        this.price = price;
        this.description = description;
        this.stockQnt = stockQnt;
        this.expiration = expiration;
        this.fornecedor = fornecedor;
    }

    public double getDiscount(){
        return 0;
    }

    public String getDescription() {
        return description;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String toString() {
        return description + " - Fabricante: "
                + fornecedor + " - Preço: " +
                price + " - Quantidade em Estoque: " +
                stockQnt + " - Data de vencimento: " +
                sdf.format(expiration) +
                " - Desconto: ";
    }

    public int getStockQnt() {
        return stockQnt;
    }

    public double getPrice() {
        return price;
    }

    public void setStockQnt(int stockQnt) {
        this.stockQnt = stockQnt;
    }

}
