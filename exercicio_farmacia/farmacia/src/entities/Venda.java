package entities;

public class Venda {

    double cartPrice;

    public double totalValue(Produto produto, int quantity){
        produto.setStockQnt(produto.getStockQnt() - quantity);
        System.out.println(produto.getPrice());
        System.out.println(produto.getDiscount());
        return cartPrice += quantity * (produto.getPrice() * (1 - (produto.getDiscount() / 100)));
    }

}
