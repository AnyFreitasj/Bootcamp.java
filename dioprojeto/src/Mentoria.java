public class Mentoria extends Atividade {
    private String mentor;

    public Mentoria(String titulo, String descricao, String mentor) {
        super(titulo, descricao);
        this.mentor = mentor;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    @Override
    public void realizar() {
        System.out.println("Mentoria realizada: " + getTitulo() + " com " + mentor);
    }
}
