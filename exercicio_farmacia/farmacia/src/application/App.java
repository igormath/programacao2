package application;

import entities.*;

import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o seu CPF: ");
        String cpf = sc.nextLine();

        Venda venda = new Venda();
        Farmacia farmacia = new Farmacia();
        farmacia.loadProducts();

        int op = 0;
        double totalCartPrice = 0;

        System.out.println("Olá cliente " + cpf + ", escolha um ou mais itens de acordo com o indice: ");
        do {
            int quant = 0;
            int index = 1;
            for (Produto produto : farmacia.getProdutos()) {
                System.out.printf("(" + index + ") ");
                System.out.print(produto);
                System.out.printf("%.1f%%\n", produto.getDiscount());
                index++;
            }
            op = sc.nextInt();
            if (op > 10){
                System.out.println("Escolha invalida!");
            }else{
                System.out.println("Digite a quantidade desejada: ");
                quant = sc.nextInt();
                totalCartPrice = venda.totalValue(farmacia.getProdutos().get(op-1), quant);
                System.out.println("Valor atual do carrinho: " + totalCartPrice);
            }
            System.out.println("Deseja prosseguir? 1 para continuar 0 para finalizar: ");
            op = sc.nextInt();
        }while (op!=0);

        System.out.println("------------------");
        System.out.println("Compra finalizada! Valor total: " + totalCartPrice);
    }
}
