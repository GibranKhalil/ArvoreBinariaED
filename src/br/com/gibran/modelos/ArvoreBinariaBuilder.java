package br.com.gibran.modelos;

public class ArvoreBinariaBuilder {

	private ArvoreBinariaBusca arvore;

	public ArvoreBinariaBusca montaArvoreVazia() {
		this.arvore = new ArvoreBinariaBusca();
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreSoRaiz() {
		Contato noCinco = new Contato("Gibran", "11964594203", null, null);
		arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizFilhoDireito() {
		Contato noSete = new Contato("Felipe", "11964844203", null, null);
		Contato noCinco = new Contato("Gibran", "11964594203", noSete, null);
		arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizFilhoEsquerdo() {
		Contato noTres = new Contato("Carlos", "11932594203", null, null);
        Contato noCinco = new Contato("Gibran", "11964594203", null, noTres);
		arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizFilhoDireitoEsquerdo() {
        Contato noSete = new Contato("Felipe", "11964844203", null, null);
        Contato noTres = new Contato("Carlos", "11932594203", null, null);
        Contato noCinco = new Contato("Gibran", "11964594203", noSete, noTres);
		arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizDoisFilhoDireitoUmEsquerdo() {
		Contato noOito = new Contato("Belchior", "13967897203" , null, null);
		Contato noSete = new Contato("Felipe", "11964844203", noOito, null);
		Contato noTres = new Contato("Carlos", "11932594203", null, null);
		Contato noCinco = new Contato("Gibran", "11964594203", noSete, noTres);
		arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizUmFilhoDireitoDoisEsquerdo() {
		Contato noSete = new Contato("Felipe", "11964844203", null, null);
		Contato noUm = new Contato("Alberto", "11964324203", null, null);
		Contato noTres = new Contato("Carlos", "11932594203", null, noUm);
		Contato noCinco = new Contato("Gibran", "11964594203", noSete, noTres);
		arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizDoisFilhoDireitoDoisEsquerdo() {
		Contato noUm = new Contato("Alberto", "11964324203", null, null);
		Contato noTres = new Contato("Carlos", "11932594203", null, noUm);
		Contato noOito = new Contato("Belchior", "13967897203" , null, null);
		Contato noSete = new Contato("Felipe", "11964844203", noOito, null);
		Contato noCinco = new Contato("Gibran", "11964594203", noSete, noTres);
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreCheiaDoisNiveis() {
		Contato noUm = new Contato("Alberto", "11964324203", null, null);
		Contato noQuatro = new Contato("Hugo", "11937894203", null, null);
		Contato noTres = new Contato("Carlos", "11932594203", noQuatro, noUm);
		Contato noOito = new Contato("Belchior", "13967897203" , null, null);
		Contato noSeis = new Contato("Martins", "11884344203" ,null, null);
		Contato noSete = new Contato("Felipe", "11964844203", noOito, noSeis);
		Contato noCinco = new Contato("Gibran", "11964594203", noSete, noTres);
		arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreEspecialParaExclusao() {

		arvore = new ArvoreBinariaBusca();

		arvore.adicionaContato("Bruno", "11-9876-5432");
		arvore.adicionaContato("Carlos", "12-3456-7890");
		arvore.adicionaContato("Daniela", "12-9012-3456");
		arvore.adicionaContato("Ana", "11-1234-5678");
		arvore.adicionaContato("Eduardo", "13-5678-9012");
		arvore.adicionaContato("Felipe", "13-2345-6789");
		arvore.adicionaContato("Gabriela", "14-7890-1234");
		arvore.adicionaContato("Henrique", "14-4567-8901");
		arvore.adicionaContato("Isabela", "15-1234-5678");
		arvore.adicionaContato("João", "15-9876-5432");
		arvore.adicionaContato("Julia", "16-3456-7890");
		arvore.adicionaContato("Leonardo", "16-9012-3456");
		return arvore;


	}

}
