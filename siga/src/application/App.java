package application;

import entities.Docente;
import entities.Relatorio;
import entities.Siga;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class App {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Siga siga = new Siga();
        Relatorio relatorio = new Relatorio();

//        CREATE do discente
        siga.createDiscente("737.276.090-95", "Azalre", "Azalre@upe.br");
        siga.createDiscente("048.009.070-04", "Aranbratoy", "Aranbratoy@upe.br");
        siga.createDiscente("287.962.200-07", "Thporal", "Thporal@upe.br");

//        READ do discente
        siga.readDiscente();

//        UPDATE do discente
        siga.updateDiscente(2, "764.739.650-17", "Kiraipen", "Kiraipen@upe.br");
        siga.readDiscente();

//        DELETE do discente
        siga.deleteDiscente(3);
        siga.readDiscente();

//        CREATE da aula
        siga.createAula("Programação II", new Docente("090.489.780-09", "Kaybihel", "Kaybihel@upe.br"), sdf.parse("13/08/2023"));
        siga.createAula("IHC", new Docente("090.489.780-09", "Gilkoilas", "Gilkoilas@upe.br"), sdf.parse("14/08/2023"));
        siga.createAula("Programação I", new Docente("090.489.780-09", "Miwilas", "Miwilas@upe.br"), sdf.parse("25/04/2023"));

//        READ da aula
        siga.readAulas();

//        UPDATE da aula
        siga.updateAula(3, "Matemática Discreta", new Docente("907.891.580-35", "Moben", "Moben@upe.br"), sdf.parse("10/08/2023"));
        siga.readAulas();

//        DELETE da aula
        siga.deleteAula(2);
        siga.readAulas();

//        Adicionando alunos da lista de alunos do SIGA a uma disciplina da lista de disciplinas:
        siga.addPresence(1, 1);
        siga.addPresence(2, 1);

//        Imprimindo o relatório da disciplina:
        relatorio.generateReport(1, siga.getAulas());
    }
}
