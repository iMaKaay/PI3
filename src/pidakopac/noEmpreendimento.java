package pidakopac;

public class noEmpreendimento {
    private String nome_empreendimento;
    private noEmpreendimento noEsq;
    private noEmpreendimento noDir;

    public noEmpreendimento(String _nome) {
        this.nome_empreendimento = _nome;
    }

    public void setNoEsq(noEmpreendimento noEsq) {
        this.noEsq = noEsq;
    }

    public void setNoDir(noEmpreendimento noDir) {
        this.noDir = noDir;
    }

    public String getNome() {
        return nome_empreendimento;
    }

    public noEmpreendimento getNoEsq() {
        return noEsq;
    }

    public noEmpreendimento getNoDir() {
        return noDir;
    }
}
