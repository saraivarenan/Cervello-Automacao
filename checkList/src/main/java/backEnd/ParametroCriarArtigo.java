package backEnd;

public class ParametroCriarArtigo {
	ParametroCriarTopico valoresTopico = new ParametroCriarTopico();
	String tematopico = valoresTopico.getDescricao();
	String idioma="Português";
	String nome = "AutoMatico script";
	String descricao ="Teste criação";
	String palavraChave ="automação";
	String sequencia = "1";
	String conteudo = " Teste Arquivo Qualidade. Automação de teste";
	String caminhoArquivo= "C:\\Users\\10044\\Desktop\\imagens teste\\400x300.png" ;
	
	public String getTematopico() {
		return tematopico;
	}
	public void setTematopico(String tematopico) {
		this.tematopico = tematopico;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
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
	public String getPalavraChave() {
		return palavraChave;
	}
	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getSequencia() {
		return sequencia;
	}
	public void setSequencia(String sequencia) {
		this.sequencia = sequencia;
	}
	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}
	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}
	

			
			
	

}
