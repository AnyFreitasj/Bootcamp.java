import java.util.ArrayList;
import java.util.List;

public class Bootcamp {
    private String nome;
    private String descricao;
    private List<Curso> cursos;
    private List<Mentoria> mentorias;
    private List<Dev> devs;

    public Bootcamp(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.cursos = new ArrayList<>();
        this.mentorias = new ArrayList<>();
        this.devs = new ArrayList<>();
    }

    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void adicionarMentoria(Mentoria mentoria) {
        mentorias.add(mentoria);
    }

    public void adicionarDev(Dev dev) {
        devs.add(dev);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public List<Mentoria> getMentorias() {
        return mentorias;
    }

    public List<Dev> getDevs() {
        return devs;
    }
}
