package entities;

public class Fornecedor {
    private String name;

    public Fornecedor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
