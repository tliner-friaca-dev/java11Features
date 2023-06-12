package br.com.java11Features;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NovosMetodosDeArquivo {

	public static void main(String[] args) {
		SpringApplication.run(NovosMetodosDeArquivo.class, args);

		System.out.println("\n----------------------------------------------------------------------------------------------");
		System.out.println("Requisitos para realizar este teste:");
		System.out.println("Criar um diretório no \"C:/\" da máquina com a descrição \"temp\".\n");
		System.out.println("Resultados esperados:");
		System.out.println(" - Criar um arquivo de texto com a descrição \"teste.txt\" no diretório \"C:/temp\".");
		System.out.println(" - Escrever a frase \"Novos Metodos de Arquivo !!!\" no arquivo.");
		System.out.println(" - Ler e exibir no console a frase \"Novos Metodos de Arquivo !!!\", que foi escrita no arquivo.");
		System.out.println(" - Caso o arquivo \"teste.txt\" não exista será criado.");
		System.out.println(" - Caso o arquivo \"teste.txt\" exista será atualizado.");
		System.out.println("----------------------------------------------------------------------------------------------\n");

		// Inicializando o caminho do arquivo com alguns parâmetros
        Path filePath = Paths.get("C:/", "temp", "teste.txt");
  
        try {
            // Escrever o conteúdo no arquivo
            Files.writeString(filePath, "Novos Metodos de Arquivo !!!", StandardOpenOption.CREATE);
  
            // Ler o conteúdo do arquivo
            String conteudo = Files.readString(filePath);
  
            // Printar no console o conteúdo
            System.out.println(conteudo);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}

}
