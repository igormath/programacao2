package entities;

import java.text.SimpleDateFormat;
import java.util.List;

public class Relatorio {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void generateReport(int index, List<Aula> aulas){
        if (index <= aulas.size()){
            index--;
            System.out.println("---------");
            System.out.println("Discentes presentes na aula de " + aulas.get(index).getDisciplina() + " no dia " + sdf.format(aulas.get(index).getDateClass()));
            for (Discente discente : aulas.get(index).getDiscentes()) {
                System.out.println("CPF: " + discente.getCpf() + " - Nome: " + discente.getName());
            }
        }
    }
}
