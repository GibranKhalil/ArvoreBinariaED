package br.com.gibran.modelos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArvoreBinariaTest {

	private ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
	private ArvoreBinariaBuilder builder = new ArvoreBinariaBuilder();

	@BeforeEach
	void inicializarArvore() {
		arvore = new ArvoreBinariaBusca();
	}

	@Test
	void deveRetornarEhVaziaSemRaiz() {
		assertTrue(arvore.ehVazia());
	}

	@Test
	void deveRetornarNaoEhVaziaComRaiz() {
        Contato noUm = new Contato("Alberto", "11964324203", null, null);
		arvore.setRaiz(noUm);

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.pegaQuantidadeNos());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(1, arvore.pegaQuantidadeNos());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreComElementos() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		assertEquals(2, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		assertEquals(2, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		assertEquals(3, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		assertEquals(4, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		assertEquals(4, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		assertEquals(5, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertEquals(7, arvore.pegaQuantidadeNos());

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.pegaAlturaDaArvore());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(0, arvore.pegaAlturaDaArvore());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreComElementos() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		assertEquals(1, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		assertEquals(1, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		assertEquals(1, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		assertEquals(2, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		assertEquals(2, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		assertEquals(2, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertEquals(2, arvore.pegaAlturaDaArvore());

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarAlturaSubNosComElementos() {

		arvore = builder.montaArvoreCheiaDoisNiveis();
		Contato noTres = arvore.getRaiz().getEsquerdo();

		assertEquals(1, arvore.pegaAlturaDoNo(noTres));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		Contato noRef = arvore.getRaiz();
		assertEquals(0, arvore.pegaProfundidadeDoNo(noRef));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		Contato noRef = arvore.getRaiz();
		assertEquals(0, arvore.pegaProfundidadeDoNo(noRef));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreComElementos() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		Contato noRef = arvore.getRaiz().getDireito();
		assertEquals(0, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		noRef = arvore.getRaiz().getEsquerdo();
		assertEquals(1, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		noRef = arvore.getRaiz().getDireito();
		assertEquals(1, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		noRef = arvore.getRaiz().getEsquerdo().getEsquerdo();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		noRef = arvore.getRaiz().getDireito().getDireito();
		assertEquals(1, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		noRef = arvore.getRaiz().getDireito().getDireito();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		noRef = arvore.getRaiz().getEsquerdo().getEsquerdo();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarNullSePegarNoArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertNull(arvore.pegarContatoPorNome("Gibran"));
	}

	@Test
	void deveRetornarNullSePegarNoNaoExistente() {
		arvore = builder.montaArvoreSoRaiz();
		assertNull(arvore.pegarContatoPorNome("Felipe"));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertNull(arvore.pegarContatoPorNome("Joaquim"));
	}

	@Test
	void deveRetornarNoSePegarRaiz() {
		arvore = builder.montaArvoreSoRaiz();

		Contato noRetornado = arvore.pegarContatoPorNome("Gibran");

		assertNotNull(noRetornado);
		assertEquals("Gibran", noRetornado.getNome());
	}

	@Test
	void deveRetornarNoSePegarOutroElemento() {
		arvore = builder.montaArvoreCheiaDoisNiveis();

		Contato noRetornado = arvore.pegarContatoPorNome("Gibran");

		assertNotNull(noRetornado);
		assertEquals("Gibran", noRetornado.getNome());
	}

	@Test
	void deveRetornarFalseContemArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertFalse(arvore.contem("gibran"));
	}

	@Test
	void deveRetornarFalseContemNoNaoExistente() {
		arvore = builder.montaArvoreSoRaiz();
		assertFalse(arvore.contem("gibran"));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertFalse(arvore.contem("gibran"));
	}

	@Test
	void deveRetornarTrueContemSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertTrue(arvore.contem("Gibran"));
	}

	@Test
	void deveRetornarNoComtemOutroElemento() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertTrue(arvore.contem("Carlos"));
		assertTrue(arvore.contem("Alberto"));
	}


	@Test
	void adicionarNoArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		arvore.adicionaContato("Alberto", "11964324203");

		assertEquals(0, arvore.pegaAlturaDaArvore());
		assertEquals("Alberto", arvore.getRaiz().getNome());
		assertTrue(arvore.contem("Alberto"));
	}

	@Test
	void adicionarNoArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();

		arvore.adicionaContato("Hugo", "11937894203");

		assertEquals(1, arvore.pegaAlturaDaArvore());
		assertEquals("Gibran", arvore.getRaiz().getNome());
		assertTrue(arvore.contem("Hugo"));
	}

	@Test
	void adicionarNoArvoreComElementosSoFilhoDireito() {

		arvore = builder.montaArvoreRaizFilhoDireito();

		arvore.adicionaContato("Hugo", "11937894203");

		assertEquals(2, arvore.pegaAlturaDaArvore());
		assertEquals("Gibran", arvore.getRaiz().getNome());
		assertTrue(arvore.contem("Hugo"));
	}

	@Test
	void adicionarNoArvoreComElementosSoFilhoEsquerdo() {

		arvore = builder.montaArvoreRaizFilhoEsquerdo();

		arvore.adicionaContato("Carlos", "11932594203");

		assertEquals(1, arvore.pegaAlturaDaArvore());
		assertEquals("Gibran", arvore.getRaiz().getNome());
		assertTrue(arvore.contem("Carlos"));
	}

	@Test
	void adicionarNoArvoreComElementosDoisFilhosDireitoEsquerdo() {

		arvore = builder.montaArvoreCheiaDoisNiveis();

		arvore.adicionaContato("Belchior", "13967897203");

		assertEquals(3, arvore.pegaAlturaDaArvore());
		assertEquals("Gibran", arvore.getRaiz().getNome());
		assertTrue(arvore.contem("Belchior"));
	}

	@Test
	void removerNoArvoreSoRaizValorExiste() {
		arvore = builder.montaArvoreSoRaiz();

		arvore.removeContatoPorNome("Gibran");
		assertFalse(arvore.contem("Gibran"));
		assertNull(arvore.getRaiz());
	}

	@Test
	void removerNoArvoreSoRaizValorNaoExiste() {
		arvore = builder.montaArvoreSoRaiz();

		arvore.removeContatoPorNome("Felipe");
		assertTrue(arvore.contem("Gibran"));
		assertNotNull(arvore.getRaiz());
	}

	@Test
	void removerNoArvoreNaoFolhaSoFilhoDireito() {

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();

		arvore.removeContatoPorNome("Felipe");

		assertEquals("Gibran", arvore.getRaiz().getNome());
		assertFalse(arvore.contem("Felipe"));
		assertEquals(2, arvore.pegaAlturaDaArvore());

	}

	@Test
	void removerNoArvoreNaoFolhaSoFilhoEsquerdo() {

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();

		arvore.removeContatoPorNome("Carlos");

		assertEquals("Gibran", arvore.getRaiz().getNome());
		assertFalse(arvore.contem("Carlos"));
		assertEquals(1, arvore.pegaAlturaDaArvore());
	}

	@Test
	void removerNoArvoreComElementosDoisFilhosDireitoEsquerdo() {

		arvore = builder.montaArvoreCheiaDoisNiveis();

		arvore.removeContatoPorNome("Gibran");
		assertEquals("Martins", arvore.getRaiz().getNome());
		assertFalse(arvore.contem("Gibran"));
	}

	@Test
	void removerNoArvoreEspecialParaExclusao() {

		arvore = builder.montaArvoreEspecialParaExclusao();
		arvore.removeContatoPorNome("Bruno");

		assertEquals("Ana", arvore.getRaiz().getEsquerdo().getNome());
		assertFalse(arvore.contem("Bruno"));
		arvore.imprimir2DArvore();
	}

}
