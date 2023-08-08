package entities;

import java.util.Date;

public class Medicamento extends Produto{

    private double discount;

    public Medicamento(double price, String description, int stockQnt, Date expiration, double discount, Fornecedor fornecedor) {
        super(price, description, stockQnt, expiration, fornecedor);
        if (discount > 10){
            this.discount = 10;
        } else {
            this.discount = discount;
        }
    }

    @Override
    public double getDiscount(){
        return discount;
    }
}
