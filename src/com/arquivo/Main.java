package com.arquivo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Pedro Neves on 09 setembro, 2022.
 * Follow @pdr0nvs on GitHub.
 */
public class Main {
   public static void main(String[] args) throws IOException {
      int opcao;
      String flag;
      Scanner input = new Scanner(System.in);

      File arquivo = new File(".\\nomes.txt");

      do {
         System.out.println("1- Gravar nome, " +
                            "2- Ler arquivo, " +
                            "3- Apagar todo o arquivo, " +
                            "4- apagar nome especifico");
         opcao = input.nextInt();
         switch (opcao) {
            case 1:
               gravar(arquivo);
               break;
            case 2:
               ler(arquivo);
               break;
            case 3:
               apagarTudo(arquivo);
               break;
            case 4:
               gravar(apagarEspecifico(arquivo), arquivo);
               break;
         }
         System.out.println("Deseja fazer mais manipulações ? [S]/[N]");
         flag = input.nextLine();
      } while (flag.equalsIgnoreCase("S"));
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

   static ArrayList<String> apagarEspecifico(File arq) throws IOException {
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

      apagarTudo(arq);
      leitorLinha.close();
      arquivoLeitura.close();
      return listaDeNomes;
/*
      FileWriter gravarArquivo = new FileWriter(arq,true);
      BufferedWriter escrever = new BufferedWriter(gravarArquivo);

      for (String elem : listaDeNomes) {
         escrever.write(elem);
         escrever.newLine();
         System.out.println(elem);

 */
      }
      static void gravar(ArrayList<String> arrString, File arq) throws IOException {
         FileWriter gravarArquivo = new FileWriter(arq,true);
         BufferedWriter escrever = new BufferedWriter(gravarArquivo);
         for (String nome : arrString) {
            escrever.write(nome);
            escrever.newLine();
         }
         escrever.close();
         gravarArquivo.close();
   }

} // main
