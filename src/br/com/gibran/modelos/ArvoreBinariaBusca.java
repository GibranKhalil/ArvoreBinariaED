package br.com.gibran.modelos;

public class ArvoreBinariaBusca {

	private Contato raiz;

	static final int CONTADOR_ESPACO = 5;

	public ArvoreBinariaBusca() {
		raiz = null;
	}

	public Contato getRaiz() {
		return raiz;
	}

	public void setRaiz(Contato raiz) {
		this.raiz = raiz;
	}

	public boolean ehVazia() {
		return raiz == null;
	}

	public int pegaQuantidadeNos() {
		return pegaQuantidadeNosDoSubNo(raiz);
	}

	public int pegaQuantidadeNosDoSubNo(Contato noReferencia) {
		if (noReferencia == null) {
			return 0;
		} else {
			return pegaQuantidadeNosDoSubNo(noReferencia.getEsquerdo()) + 1
					+ pegaQuantidadeNosDoSubNo(noReferencia.getDireito());
		}
	}

	public int pegaAlturaDoNo(Contato noReferencia) {
		if (noReferencia == null) {
			return 0;
		} else {
			return pegaAlturaDoSubNo(noReferencia) - 1;
		}
	}

	private int pegaAlturaDoSubNo(Contato noReferencia) {
		if (noReferencia == null) {
			return 0;
		}
		int alturaDireita = pegaAlturaDoSubNo(noReferencia.getDireito()); // 2
		int alturaEsquerda = pegaAlturaDoSubNo(noReferencia.getEsquerdo()); // 0

		return 1 + Math.max(alturaDireita, alturaEsquerda);
	}

	public int pegaAlturaDaArvore() {
		return pegaAlturaDoNo(raiz);
	}

	public int pegaProfundidadeDoNo(Contato noBuscado) {

		if (noBuscado == null) {
			return 0;
		} else {
			return pegaProfundidadeDoNoAteRaiz(raiz, noBuscado) - 1;
		}
	}

	private int pegaProfundidadeDoNoAteRaiz(Contato noReferencia, Contato noBuscado) {
		if (noReferencia == null) {
			return 0;
		} else {
			if (noBuscado.getNome().equals(noReferencia.getNome())) {
				return 1;
			}

			if (noBuscado.getNome().compareTo(noReferencia.getNome()) < noReferencia.getNome().compareTo(noBuscado.getNome())) {
				return 1 + pegaProfundidadeDoNoAteRaiz(noReferencia.getEsquerdo(), noBuscado);
			} else {
				return 1 + pegaProfundidadeDoNoAteRaiz(noReferencia.getDireito(), noBuscado);
			}
		}
	}

	public Contato pegarContatoPorNome(String nomeContato) {
		
		Contato atual = raiz;
		while (atual != null) {
			if (nomeContato.equals(atual.getNome())) {
				return atual;
			} else if (nomeContato.compareTo(atual.getNome()) < atual.getNome().compareTo(nomeContato)) {
				atual = atual.getEsquerdo();
			} else {
				atual = atual.getDireito();
			}
		}
		return null;
	}

	public boolean contem(String valorBuscado) {

		return (pegarContatoPorNome(valorBuscado) != null);
	}

	public void adicionaContato(String nomeAdicionado, String telefoneAdicionado) {
		if (raiz == null) {
			raiz = new Contato(nomeAdicionado, telefoneAdicionado, null, null);
		} else {
			Contato atual = raiz;
			while (true) {
				if (nomeAdicionado.compareTo(atual.getNome()) < atual.getNome().compareTo(nomeAdicionado)) {
					if (atual.getEsquerdo() == null) {
						atual.setEsquerdo(new Contato(nomeAdicionado, telefoneAdicionado, null, null));
						return;
					}
					atual = atual.getEsquerdo();
				} else if (nomeAdicionado.compareTo(atual.getNome()) > atual.getNome().compareTo(nomeAdicionado)) {
					if (atual.getDireito() == null) {
						atual.setDireito(new Contato(nomeAdicionado, telefoneAdicionado, null, null));
						return;
					}
					atual = atual.getDireito();
				} else {
					return; // Valor já existe na árvore, não faz nada
				}
			}
		}
	}

	public void removeContatoPorNome(String nomeARemover) {

		Contato pai = null;
		Contato atual = raiz;
		while (atual != null) {
			if (nomeARemover.equals(atual.getNome())) {
				if (atual.ehFolha()) {
					removerNoFolha(pai, atual);
				} else if (atual.getDireito() == null) {
					removerSoFilhoEsquerdo(pai, atual);
				} else if (atual.getEsquerdo() == null) {
					removerSoFilhoDireito(pai, atual);
				} else {
					Contato sucessor = buscarSucessor(atual);
					String nomeSucessor = sucessor.getNome();
					removeContatoPorNome(nomeSucessor);
					atual.setNome(nomeSucessor);
				}
				return;
			} else if (nomeARemover.compareTo(atual.getNome()) < atual.getNome().compareTo(nomeARemover)) {
				pai = atual;
				atual = atual.getEsquerdo();
			} else {
				pai = atual;
				atual = atual.getDireito();
			}
		}
	}

	private void removerSoFilhoDireito(Contato pai, Contato atual) {
		if (pai == null) {
			raiz = atual.getDireito();
		} else {
			if (pai.getEsquerdo() == atual) {
				pai.setEsquerdo(atual.getDireito());
			} else {
				pai.setDireito(atual.getDireito());
			}
		}
	}

	private void removerSoFilhoEsquerdo(Contato pai, Contato atual) {
		if (pai == null) {
			raiz = atual.getEsquerdo();
		} else {
			if (pai.getEsquerdo() == atual) {
				pai.setEsquerdo(atual.getEsquerdo());
			} else {
				pai.setDireito(atual.getEsquerdo());
			}
		}
	}

	private void removerNoFolha(Contato pai, Contato atual) {
		if (pai == null) {
			raiz = null;
		} else {
			if (pai.getEsquerdo() == atual) {
				pai.setEsquerdo(null);
			} else {
				pai.setDireito(null);
			}
		}
	}

	private Contato buscarSucessor(Contato noAtual) {
		Contato sucessor = noAtual.getDireito();
		while (sucessor.getEsquerdo() != null) {
			sucessor = sucessor.getEsquerdo();
		}
		return sucessor;
	}

	public void imprimirPreOrder() {
		percorrerPreOrder(raiz);
	}

	private void percorrerPreOrder(Contato noReferencia) {
		if (noReferencia != null) {
			System.out.println(noReferencia.getNome());
			percorrerPreOrder(noReferencia.getEsquerdo());
			percorrerPreOrder(noReferencia.getDireito());
		}
	}

	public void imprimirInOrder() { //ordem crescente
		percorrerInOrder(raiz);
	}

	private void percorrerInOrder(Contato noReferencia) {
		if (noReferencia != null) {
			percorrerInOrder(noReferencia.getEsquerdo());
			System.out.println(noReferencia.getNome());
			percorrerInOrder(noReferencia.getDireito());
		}
	}

	public void imprimirPosOrder() {
		percorrerPosOrder(raiz);
	}

	private void percorrerPosOrder(Contato noReferencia) {
		if (noReferencia != null) {
			percorrerPosOrder(noReferencia.getEsquerdo());
			percorrerPosOrder(noReferencia.getDireito());
			System.out.println(noReferencia.getNome());
		}
	}

	public void imprimir2DArvore() {
		print2DUtil(raiz, 0);
	}

	private void print2DUtil(Contato noReferencia, int space) {
		if (noReferencia == null) {
			return;
		}
		space += CONTADOR_ESPACO;
		print2DUtil(noReferencia.getDireito(), space);

		System.out.print("\n");
		for (int i = CONTADOR_ESPACO; i < space; i++)
			System.out.print(" ");
		System.out.print(noReferencia.getNome() + "\n");

		print2DUtil(noReferencia.getEsquerdo(), space);
	}

}
