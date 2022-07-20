package package1;

import java.sql.Date;

public class Contato {
    private int id;
    private String nome;
    private String telefone;
    private Date register_date;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Date getRegister_date() {
        return register_date;
    }
    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }
}
