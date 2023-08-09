package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Farmacia {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    String path = "/mnt/extra-drive/Coding/UPE/Prog-2/exercicio_farmacia/farmacia/stock.csv";

    List<Produto> produtos = new ArrayList<>();

    public void loadProducts(){
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
        }catch (
        IOException e){
            System.out.println("A file read error occurred: " + e);
        } catch (
        ParseException e) {
            System.out.println("A Date error occurred: " + e);
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
