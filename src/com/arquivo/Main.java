package com.arquivo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by @pdr0nvs on 09 setembro, 2022.
 * Follow @pdr0nvs on GitHub.
 */
public class Main {
   public static void main(String[] args) throws IOException {
      File arquivo = new File(".\\nomes.txt");
      //gravar(arquivo);
      //ler(arquivo);
      //apagarTudo(arquivo);
      apagarEspecifico(arquivo);
   }

   //leitura ok
   static void ler(File arq) throws IOException {
      FileReader arquivoLeitura = new FileReader(arq);
      BufferedReader lerBuffer = new BufferedReader(arquivoLeitura);

      String linha = lerBuffer.readLine();

      while(linha != null){
         System.out.println(linha);
         linha = lerBuffer.readLine();
      }
   }
   //gravação ok
   static void gravar(File arq) throws IOException {
      Scanner input = new Scanner(System.in);
      System.out.println("Informe um nome");
      String nome = input.nextLine();

      FileWriter gravarArquivo = new FileWriter(arq,true);
      BufferedWriter escrever = new BufferedWriter(gravarArquivo);
      escrever.write(nome);
      escrever.newLine();

      escrever.close();
      gravarArquivo.close();

      System.out.println("Nome Gravado");
   }

   // apagar tudo ok
   static void apagarTudo(File arq) throws IOException {
      FileWriter gravarArquivo = new FileWriter(arq,false);
      gravarArquivo.close();
   }

   static void apagarEspecifico(File arq) throws IOException {
      ArrayList<String> listaDeNomes = new ArrayList<>();

      Scanner input = new Scanner(System.in);
      System.out.println("Informe o nome que deseja apagar");
      String nome = input.nextLine();

      FileReader arquivoLeitura = new FileReader(arq);
      BufferedReader leitorLinha = new BufferedReader(arquivoLeitura);
      String linha = leitorLinha.readLine();

      while(linha != null){
         if(!linha.equals(nome)){
            listaDeNomes.add(linha);
         }
         linha = leitorLinha.readLine();
      }

      leitorLinha.close();
      arquivoLeitura.close();
      apagarTudo(arq);

      FileWriter gravarArquivo = new FileWriter(arq,true);
      BufferedWriter escrever = new BufferedWriter(gravarArquivo);

      for (String elem : listaDeNomes) {
         escrever.write(elem);
         escrever.newLine();
         System.out.println(elem);
      }
      gravarArquivo.close();

   }

} // main
