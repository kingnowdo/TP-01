package com.reinaldoveazey.movieme;

public class Movie {

    private Integer tarjaId;    // id do ícone de classificação indicativa
    private String name;        // nome do filme
    private String nameDir;     // nome do diretor
    private String genero;      // genero do filme
    private Integer ano;        // ano de lancamento do filme

    /**
     * Construtor
     * @param tarjaId Id da imagem (R.drawable.imagem)
     * @param name Nome do filme
     * @param nameDir Nome do diretor
     * @param genero Gênero (Ação, Drama, Comédia, Suspense, Ficção ou Romance)
     * @param ano Ano de lancamento do filme (integer)
     */
    public Movie(Integer tarjaId, String name, String nameDir, String genero, Integer ano) {
        this.tarjaId = tarjaId;
        this.name = name;
        this.nameDir = nameDir;
        this.genero = genero;
        this.ano = ano;
    }

    /**
     * Construtor padrão
     */
    public Movie() {
        this(null, null, null, null, null);
    }


    public Integer getTarjaId() {
        return tarjaId;
    }

    public void setTarjaId(Integer tarjaId) {
        this.tarjaId = tarjaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameDir() {
        return nameDir;
    }

    public void setNameDir(String nameDir) {
        this.nameDir = nameDir;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
