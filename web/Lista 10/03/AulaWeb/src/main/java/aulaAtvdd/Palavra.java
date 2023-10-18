package aulaAtvdd;

public class Palavra {
    private String palavra;
    private boolean palindromo;

    public Palavra(String palavra, boolean palindromo) {
        this.palavra = palavra;
        this.palindromo = palindromo;
    }

    public String getPalavra() {
        return palavra;
    }

    public boolean isPalindromo() {
        return palindromo;
    }
}
