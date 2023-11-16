package com.biblioteca;

import java.util.ArrayList;
import java.util.List;

// Classe para representar Livros
class Livro extends ItemBiblioteca {
    private String autor;
    private int ano; // Adicionando o ano
    private boolean disponivel;

    public Livro(String titulo, String codigo, String autor, int ano) {
        super(titulo, codigo);
        this.autor = autor;
        this.ano = ano;
        this.disponivel = true;
    }

    public String getAutor() {
        return autor;
    }


    public int getAno() {
        return ano;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void definirComoIndisponivel() {
        this.disponivel = false;
    }

    

    //idk if I am gonna use this
    public void emprestar() {
        if (disponivel) {
            System.out.println("Livro emprestado: " + getTitulo());
            setDisponivel(false);
        } else {
            System.out.println("Livro indisponível para empréstimo: " + getTitulo());
        }
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + getTitulo() + '\'' +
                ", autor='" + autor + '\'' +
                ", ano=" + ano +
                ", disponivel=" + disponivel +
                '}';
    }

    public List<String[]> obterDadosParaCSV() {
        List<String[]> dados = new ArrayList<>();
        dados.add(new String[]{getTitulo(), getCodigo(), autor, Integer.toString(ano), Boolean.toString(disponivel)});
        return dados;
    }


    public static Livro obterLivroPorCodigo(String codigo) {
    List<String[]> dadosLivros = CsvHandler.verificarECarregarArquivoCSV("livros.csv");

    for (String[] livro : dadosLivros) {
        if (livro.length >= 2 && livro[1].trim().equalsIgnoreCase(codigo)) {
            return new Livro(livro[0].trim(), livro[1].trim(), livro[2].trim(), Integer.parseInt(livro[3].trim()));
        }
    }

    return null; // Retorna null se o livro não for encontrado
}

}
