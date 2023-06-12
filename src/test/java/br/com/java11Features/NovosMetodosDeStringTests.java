package br.com.java11Features;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NovosMetodosDeStringTests {

/* 
	*String
	- isBlank
	- lines
	- repeat
	- strip
	- stripLeading
	- stripTrailing
 */

	@Test
	void isBlank_retornaTrueParaStringVazia_quandoSucesso() {
		var texto = "";
		assertEquals(Boolean.TRUE, texto.isBlank());
	}

	@Test
	void lines_retornaUmStreamDeLinhasExtraidasDeUmaString_quandoSucesso() {
		String texto = "Novos\nMetodos\nDe\nString";
		Stream<String> textoStream = texto.lines();
		List<String> retorno = textoStream.collect(Collectors.toList());
		assertEquals("[Novos, Metodos, De, String]", retorno.toString());
	}
	
	@Test
	void repeat_retornaUmStreamDeLinhasExtraidasDeUmaString_quandoSucesso() {
		var texto = "Novos Metodos de String ";
		var retorno = texto.repeat(2);
		assertEquals("Novos Metodos de String Novos Metodos de String ", retorno);
	}

	@Test
	void strip_retornaUmaStringSemEspacosIniciaisEFinaisEmBranco_quandoSucesso() {
		var texto = "          Novos Metodos de String          ";
		var retorno = texto.strip();
		assertEquals("Novos Metodos de String", retorno);
	}

	@Test
	void stripLeading_retornaUmaStringSemEspacosIniciaisEmBranco_quandoSucesso() {
		var texto = "          Novos Metodos de String          ";
		var retorno = texto.stripLeading();
		assertEquals("Novos Metodos de String          ", retorno);
	}

	@Test
	void stripTrailing_retornaUmaStringSemEspacosFinaisEmBranco_quandoSucesso() {
		var texto = "          Novos Metodos de String          ";
		var retorno = texto.stripTrailing();
		assertEquals("          Novos Metodos de String", retorno);
	}

}
