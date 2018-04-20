package com.reinaldoveazey.movieme;

public class Place {


    private String name_fil;          // Nome do filme
    private String classificacao;     // Classificação do filme
    private String name_dir;          // Nome do diretor
    private String genero;            // Genero
    private String lançamento;        // Ano de Lançamento

    /**
     * Construtor
     * @param name_fil
     * @param classificação
     * @param name_dir
     * @param genero
     * @param lançamento
     */
    public Place(String name_fil, Integer classificação, String name_dir , String genero, String lançamento) {
        this.name_fil = name_fil;
        this.name_dir = name_dir;
        this.genero = genero;
        this.lançamento = lançamento;
        this.classificacao = classificacao;
    }

    /**
     * Construtor padrão
     */
    public Place() { this(null, null, null, null, null);
    }

    public String getName_fil() {
        return name_fil;
    }

    public void setName_fil(String name_fil) {
        this.name_fil = name_fil;
    }

    public String getname_dir() { return name_dir; }

    public void setname_dir(String name_dir) {
        this.name_dir = name_dir;
    }

    public String getgenero() { return genero; }

    public void setgenero(String genero) {
        this.genero = genero;
    }

    public String getlançamento() { return lançamento; }

    public void setlançamento(String lançamento) {
        this.lançamento = lançamento;
    }

    public String getclassificacao() { return classificacao; }

    public void setclassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
}
