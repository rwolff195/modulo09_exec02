package entidades;

public class ProdutoImportado extends Produto{
	
	private Double taxaAlfandega;
	
	public ProdutoImportado() {
		super();
	}

	public ProdutoImportado(String nome, Double preco, Double taxaAlfandega) {
		super(nome, preco);
		this.taxaAlfandega = taxaAlfandega;
	}

	public Double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(Double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}

	public double precototal() {
		return preco + taxaAlfandega;
	}
	
	@Override
	public String etiqueta() {
		return getNome()
			   + " R$ "
			   + String.format("%.2f", precototal())
			   + " (Taxa Alfandega: R$ "+ taxaAlfandega 
			   +")";
	}
}
