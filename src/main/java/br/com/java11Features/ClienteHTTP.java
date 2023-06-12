package br.com.java11Features;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClienteHTTP {

	public static void main(String[] args) {
		SpringApplication.run(ClienteHTTP.class, args);

		System.out.println("\n--------------------------------------------------------------------------------------------------------------");
		System.out.println("Orientações para os testes:");
		System.out.println("Na construção do HttpRequest existem 4 opções.");
		System.out.println("Para testar cada um dos métodos (get, post, delete) descomente o bloco de código referente ao método desejado.");
		System.out.println("Deixe descomentado um método por vez.");
		System.out.println("--------------------------------------------------------------------------------------------------------------\n");
		
		try {

			HttpRequest request = HttpRequest.newBuilder()
												
												.GET()
												.uri(URI.create("https://postman-echo.com/get"))
												

												/* 
												.GET() // Requisição get com retorno em xml
												.uri(URI.create("https://apichallenges.herokuapp.com/todos"))
												.header("Accept", "application/xml")
												 */

												/* 
												.POST(BodyPublishers.ofString("{\"Java 11\": \"Features\"}"))
												.uri(URI.create("https://postman-echo.com/post"))
												 */

												/* 
												.DELETE()
												.uri(URI.create("https://postman-echo.com/delete"))
 												*/
												.timeout(Duration.ofSeconds(5))
												.build();



			HttpClient httpClient = HttpClient.newBuilder()
									.connectTimeout(Duration.ofSeconds(5))
									.followRedirects(Redirect.NORMAL)
									.build();

			HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

			System.out.println("Corpo da resposta:\n" + response.body());
			System.out.println("");
			System.out.println("Status da resposta:\n" + response.statusCode());
			System.out.println("");
			System.out.println("Headers da resposta:\n" + response.headers());
			System.out.println("");
			System.out.println("Versão da resposta:\n" + response.version());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
