package ifpb.dac.domain;

import java.io.Serializable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 10/05/2018, 07:25:57
 */
public class Cliente implements Serializable {

    private int id;
    private String nome;
    private String cpf;

    public Cliente() {
    }

    private Cliente(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public static Cliente of(int id, String nome, String cpf) {
        return new Cliente(id, nome, cpf);
    }

    public static Cliente of(String nome, String cpf) {
        return of(-1, nome, cpf);
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
