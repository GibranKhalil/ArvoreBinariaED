package br.com.gibran.modelos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NoTest {

	@Test
	void deveRetornarEhNoFolhaSoFilhoDireito() {
        Contato noUm = new Contato("Alberto", "11964324203", null, null);;
        Contato noQuatro = new Contato("Hugo", "11937894203", noUm, null);
		assertFalse(noQuatro.ehFolha());
		assertTrue(noUm.ehFolha());
	}

	@Test
	void deveRetornarEhNoFolhaSoFilhoEsquerdo() {
        Contato noUm = new Contato("Alberto", "11964324203", null, null);;
        Contato noQuatro = new Contato("Hugo", "11937894203", null, noUm);

		assertFalse(noQuatro.ehFolha());
		assertTrue(noUm.ehFolha());
	}


	@Test
	void deveRetornarEhNoFolhaDoisFilhos() {
        Contato noUm = new Contato("Alberto", "11964324203", null, null);;
        Contato noQuatro = new Contato("Hugo", "11937894203", null, noUm);
        Contato noTres = new Contato("Carlos", "11932594203", noQuatro, noUm);

		assertFalse(noTres.ehFolha());
		assertTrue(noUm.ehFolha());
		assertFalse(noQuatro.ehFolha());
	}

	@Test
	void deveRetornarEhNoFolha() {
        Contato noUm = new Contato("Alberto", "11964324203", null, null);;
		assertTrue(noUm.ehFolha());
	}

}
