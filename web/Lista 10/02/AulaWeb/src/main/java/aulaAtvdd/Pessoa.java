package aulaAtvdd;

public class Pessoa {
    private String nome;
    private String endereco;
    private int anoNascimento;
    private boolean aniversarioFeito;

    public Pessoa(String nome, String endereco, int anoNascimento, boolean aniversarioFeito) {
        this.nome = nome;
        this.endereco = endereco;
        this.anoNascimento = anoNascimento;
        this.aniversarioFeito = aniversarioFeito;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public boolean isAniversarioFeito() {
        return aniversarioFeito;
    }
}
