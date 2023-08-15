package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aula {
    private String disciplina;
    private Docente docente;
    private Date dateClass;

    List<Discente> discentes = new ArrayList<>();

    public Aula(String disciplina, Docente docente, Date dateClass) {
        this.disciplina = disciplina;
        this.docente = docente;
        this.dateClass = dateClass;
    }

    public List<Discente> getDiscentes() {
        return discentes;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public void setDateClass(Date dateClass) {
        this.dateClass = dateClass;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public Docente getDocente() {
        return docente;
    }

    public Date getDateClass() {
        return dateClass;
    }


    public void addAluno(Discente discente){
        discentes.add(discente);
    }
}
