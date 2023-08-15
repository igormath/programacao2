package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Siga {

    List<Discente> discentes = new ArrayList<>();
    List<Aula> aulas = new ArrayList<>();

    public List<Aula> getAulas() {
        return aulas;
    }

    //DISCENTE
//    CREATE
    public void createDiscente(String cpf, String name, String email){
        discentes.add(new Discente(cpf, name, email));
    }

//    READ
    public void readDiscente(){
        int index = 1;
        for (Discente discente : discentes) {
            System.out.printf("(%d) ", index);
            System.out.println("CPF: " + discente.getCpf() + " - Nome: " + discente.getName());
            index++;
        }
        System.out.println();
    }

//    UPDATE
    public void updateDiscente(int index, String cpf, String name, String email){
        index--;
        discentes.get(index).setCpf(cpf);
        discentes.get(index).setName(name);
        discentes.get(index).setEmail(email);
    }

//    DELETE
    public void deleteDiscente(int index){
        index--;
        discentes.remove(index);
    }

//AULA
//    CREATE
    public void createAula(String disciplina, Docente docente, Date dateClass){
        aulas.add(new Aula(disciplina, docente, dateClass));
    }

//    READ
    public void readAulas(){
        int index = 1;
        for (Aula aula : aulas) {
            System.out.printf("(%d) ", index);
            System.out.println("Disciplina: " + aula.getDisciplina() + " - Docente: " + aula.getDocente().getName());
            index++;
        }
        System.out.println();
    }
//    UPDATE
    public void updateAula(int index, String disciplina, Docente docente,Date dateClass){
        index--;
        aulas.get(index).setDisciplina(disciplina);
        aulas.get(index).setDocente(docente);
        aulas.get(index).setDateClass(dateClass);
    }

//    DELETE
    public void deleteAula(int index){
        index--;
        aulas.remove(index);
    }

    public void addPresence(int indexDiscente, int indexAula){
        if ((indexDiscente <= discentes.size()) && (indexAula <= aulas.size())){
            indexDiscente--;
            indexAula--;
            aulas.get(indexAula).addAluno(discentes.get(indexDiscente));
        }
    }
}
