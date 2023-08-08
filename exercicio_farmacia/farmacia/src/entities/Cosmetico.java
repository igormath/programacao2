package entities;

import java.util.Date;

public class Cosmetico extends Produto{

    private double discount;

    public Cosmetico(double price, String description, int stockQnt, Date expiration, double discount, Fornecedor fornecedor) {
        super(price, description, stockQnt, expiration, fornecedor);
        if (discount > 20){
            this.discount = 20;
        } else {
            this.discount = discount;
        }
    }

    @Override
    public double getDiscount(){
        return discount;
    }
}
