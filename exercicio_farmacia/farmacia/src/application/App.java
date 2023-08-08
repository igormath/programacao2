package application;

import entities.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String path = "/mnt/extra-drive/Coding/UPE/Prog-2/exercicio_farmacia/farmacia/stock.csv";

        List<Produto> produtos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while (line != null){
                String[] lineArray = line.split(",");

                if (lineArray[0].equalsIgnoreCase("medicamento")){
                    produtos.add(new Medicamento(Double.parseDouble(lineArray[1]), lineArray[2], Integer.parseInt(lineArray[3]), sdf.parse(lineArray[4]), Double.parseDouble(lineArray[5]), new Fornecedor(lineArray[6])));
                } else if (lineArray[0].equalsIgnoreCase("cosmético")){
                    produtos.add(new Cosmetico(Double.parseDouble(lineArray[1]), lineArray[2], Integer.parseInt(lineArray[3]), sdf.parse(lineArray[4]), Double.parseDouble(lineArray[5]), new Fornecedor(lineArray[6])));
                }
                line = br.readLine();
            }
        }catch (IOException e){
            System.out.println("A file read error occurred: " + e);
        } catch (ParseException e) {
            System.out.println("A Date error occurred: " + e);
        }

        System.out.println("Digite o seu CPF: ");
        String cpf = sc.nextLine();

        Venda venda = new Venda();

        int op = 0;
        double totalCartPrice = 0;

        System.out.println("Olá cliente " + cpf + ", escolha um ou mais itens de acordo com o indice: ");
        do {
            int quant = 0;
            int index = 1;
            for (Produto produto : produtos) {
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
                totalCartPrice = venda.totalValue(produtos.get(op-1), quant);
                System.out.println("Valor atual do carrinho: " + totalCartPrice);
            }
            System.out.println("Deseja prosseguir? 1 para continuar 0 para finalizar: ");
            op = sc.nextInt();
        }while (op!=0);

        System.out.println("------------------");
        System.out.println("Compra finalizada! Valor total: " + totalCartPrice);
    }
}
