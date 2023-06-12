package br.com.java11Features;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VarNoLambdaTests {

	@Test
	void varNoLambda_retornaASomaDosValoresDaLista_quandoSucesso() {
		List<Integer> lista = List.of(1, 2, 3);
		var resultado = lista.stream()
								.collect(Collectors.summingInt((var n) -> n.intValue()));
		assertEquals(6, resultado);
	}

}
