package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoUsado;
import entidades.ProdutoImportado;

public class ProgPrincipal {

	public static void main(String[] args) throws ParseException {
		/*
		Fazer um programa para ler os dados de N produtos (N fornecido pelo usuário). Ao final,
		mostrar a etiqueta de preço de cada produto na mesma ordem em que foram digitados.
		Todo produto possui nome e preço. Produtos importados possuem uma taxa de alfândega, e
		produtos usados possuem data de fabricação.
		Estes dados específicos devem ser acrescentados na etiqueta de preço conforme
		exemplo (próxima página). Para produtos importados, a taxa e alfândega deve ser
		acrescentada ao preço final do produto.
		Favor implementar o programa conforme projeto ao lado.		
		*/
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Produto> produto = new ArrayList<>();
		
		System.out.print("Entre com o numero de Produtos: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++ ) {
			System.out.println();
			System.out.println("Produto numero "+ i +" : ");
			System.out.print("Comum, Usado ou Imprtadado (c/u/i)? ");
			char tipo = sc.next().charAt(0);
			System.out.print("Entre com o nome do Produto: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Entre com o preço do Produto: ");
			double preco = sc.nextDouble();
			
			if (tipo == 'c') {
				produto.add(new Produto(nome, preco));
			}
			else if (tipo == 'u') {
				System.out.print("Entre com a data de fabricação (DD/MM/AAAA): ");
				Date dataFabricacao = sdf.parse(sc.next());
				produto.add(new ProdutoUsado(nome, preco, dataFabricacao));
			}
			else {
				System.out.print("Entre com a Taxa da Alfandega: ");
				double taxaAlfandega = sc.nextDouble();
				produto.add(new ProdutoImportado(nome, preco, taxaAlfandega));
			}		
		}//fim for
		
		System.out.println();
		System.out.println("ETIQUETAS");
		
		for (Produto prod : produto) {
			System.out.println();
			System.out.println(prod.etiqueta());
		}
		
		sc.close();
	}

}
