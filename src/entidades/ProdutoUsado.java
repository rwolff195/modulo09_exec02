package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto{
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dataFabricacao;
	
	public ProdutoUsado() {
		super();
	}

	public ProdutoUsado(String nome, Double preco, Date dataFabricacao) {
		super(nome, preco);
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataFabrica��o() {
		return dataFabricacao;
	}

	public void setDataFabrica��o(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	@Override
	public String etiqueta() {
		return getNome()
			   + " (usado) R$ "
			   + String.format("%.2f", getPreco())
			   + " (Data de fabrica�a�: "
			   + sdf.format(dataFabricacao) 
			   +")";
	}
}
