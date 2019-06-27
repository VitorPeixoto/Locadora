package locadora.model;

public class Movie {
    private int id;
    private String name;
    private int ano;
    private String sinopse;
    private String diretor;

    public Movie() {}

    public Movie(int id, String name, int ano, String sinopse, String diretor) {
        this.id = id;
        this.name = name;
        this.ano = ano;
        this.sinopse = sinopse;
        this.diretor = diretor;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    
    
}
