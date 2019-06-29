package locadora.model;

public class Actor {
    private String name;
    private String papel;

    public Actor() {}

    public Actor(String name, String papel) {
        this.name = name;
        this.papel = papel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }    
    
}
