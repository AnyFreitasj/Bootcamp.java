import java.util.ArrayList;
import java.util.List;

public class Dev {
    private String nome;
    private String email;
    private List<Atividade> atividadesConcluidas;

    public Dev(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.atividadesConcluidas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void concluirAtividade(Atividade atividade) {
        atividadesConcluidas.add(atividade);
        atividade.realizar();
    }

    public List<Atividade> getAtividadesConcluidas() {
        return atividadesConcluidas;
    }
}
