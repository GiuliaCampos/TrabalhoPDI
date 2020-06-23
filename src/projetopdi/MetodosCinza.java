/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopdi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Giulia
 */
public class MetodosCinza {
    private int matriz[][] = new int[3][3]; 
    private int matrizResultado[][] = new int[3][3]; 
    private int nLinhas = 1;
    private int nColunas = 1;
    private String tipo = "P2";
    private int limite = 255;

    public MetodosCinza() {
        
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int getnLinhas() {
        return nLinhas;
    }

    public void setnLinhas(int nLinhas) {
        this.nLinhas = nLinhas;
    }

    public int getnColunas() {
        return nColunas;
    }

    public void setnColunas(int nColunas) {
        this.nColunas = nColunas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int[][] getMatrizResultado() {
        return matrizResultado;
    }

    public void setMatrizResultado(int[][] matrizResultado) {
        this.matrizResultado = matrizResultado;
    }

    
    //Método construtor, lê o arquivo e cria a matriz a ser manipulada
    public MetodosCinza(String nomeArquivo) throws FileNotFoundException, IOException{
        BufferedReader buffRead1 = new BufferedReader(new FileReader(nomeArquivo));
        System.out.println(nomeArquivo);
        String aux[] = nomeArquivo.split("\\.");
        
        if("pgm".equals(aux[aux.length-1])){
            String linha = "";

            //Tipo do arquivo (P1 == ASC PBM) (P2 == ASC PGM) (P3 == ASC PPM) (P4 == BIN PBM) (P5 == BIN PGM) (P6 == BIN PPM)
            linha = buffRead1.readLine();
            setTipo(linha);

            //Linha que contém o número de linhas e de colunas da matriz
            linha = buffRead1.readLine();
            if("#".equals(linha.split(" ")[0])){ //Descartar o comentário
                linha = buffRead1.readLine();
            }
            setnColunas(Integer.parseInt(linha.split(" ")[0])); //armazena o número de linhas
            setnLinhas(Integer.parseInt(linha.split(" ")[1])); //armazena o número de colunas

            //Limite dos valores 0 - 255
            linha = buffRead1.readLine();
            setLimite(Integer.parseInt(linha));

            //Alocação da matriz com o nLinhas e nColunas do cabeçalho
            matriz = new int[nLinhas][nColunas]; 

            for(int i = 0; i < nLinhas; i++){
                for(int j = 0; j < nColunas; j++){
                    linha = buffRead1.readLine();
                    matriz[i][j] = Integer.parseInt(linha);
                }
            }
        }
        buffRead1.close();
    }
    
    //Imprimir matriz 
    public void printMatriz(){
        System.out.println("Matriz Original: ");
        for(int i =  0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
        
        System.out.println("Matriz Resultado: ");
        for(int i =  0; i < matrizResultado.length; i++){
            for(int j = 0; j < matrizResultado[i].length; j++){
                System.out.print(matrizResultado[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    //Escrever em arquivo
    public void escreverMatriz(String nomeArquivo) throws FileNotFoundException{
        
        //Pasta onde será armazenado o arquivo
        String caminho =  "C:\\Users\\Giulia\\Documents\\Unesp\\PDI\\";
        //System.out.println(nLinhas + " " + nColunas);
        
        PrintWriter pw = new PrintWriter(nomeArquivo + ".pgm");
        
        //Cabeçalho:
        //P2 (PGM)
        //nLinha Ncoluna
        //limite (0 - 255)
        pw.print("P2\n"+ nLinhas +" "+ nColunas +"\n" + limite +"\n");

        for(int i = 0; i < nLinhas; i++){
            for(int j = 0; j < nColunas; j++){
                pw.print(matrizResultado[i][j] + " ");
            }
        }
        pw.close();
    }
    
    //Tornar imagem negativa
    public void negativoMatriz(){
       matrizResultado = new int[nLinhas][nColunas];
       for(int i = 0; i < nLinhas; i++){
           for(int j = 0; j < nColunas; j++){
               if((255 - matriz[i][j]) < 0) matrizResultado[i][j] = 0;
               else matrizResultado[i][j] = 255 - matriz[i][j];
           }
       }
   }
      
   //Clarear imagem
   public void clarearMatriz(int  valor){
        
        matrizResultado = new int[nLinhas][nColunas];
        
        for(int i = 0; i < nLinhas; i++){
            for(int j = 0; j < nColunas; j++){
                if((matriz[i][j] + valor) > 255) matrizResultado[i][j] = 255;
                else matrizResultado[i][j] =  matriz[i][j] + valor;
            }
        }
    }
    
   //Escurecer Imagem
   public void escurecerMatriz(int  valor){       
        matrizResultado  = new int[nLinhas][nColunas];
        
        for(int i = 0; i < nLinhas; i++){
            for(int j = 0; j < nColunas; j++){
                if((matriz[i][j] - valor) < 0) matrizResultado[i][j] = 0;
                else matrizResultado[i][j] =  matriz[i][j] - valor;
            }
        }
    }
   
   //Fatiamento da Imagem
   public void fatiamentoImagem(int a, int b, int novaTonalidade){
       matrizResultado = new int[nLinhas][nColunas];
       
       for(int i = 0; i < nLinhas; i++){
           for(int j = 0; j < nColunas; j++){
               if(matriz[i][j] >= a && matriz[i][j] <= b){
                   matrizResultado[i][j] = novaTonalidade;
               }
               else{
                   matrizResultado[i][j] = matriz[i][j];
               }
           }
       }
   }
   
   //Tranformação Gama
   public void transfGama(float c, float gama){
       matrizResultado = new int[nLinhas][nColunas];
       
       for(int i = 0; i < nLinhas; i++){
           for(int j = 0; j < nColunas; j++){
               matrizResultado[i][j] = (int)((c*Math.pow(matriz[i][j]/255.0, gama))*255);
           }
       }
   }
   
   public void flipHorizontal(){
       matrizResultado = new int[nLinhas][nColunas];
       int auxLinha, auxColuna;
       
       auxLinha = 0;
       auxColuna = nColunas - 1;
       
       for(int i = 0; i < nLinhas; i++){
           for(int j = 0; j < nColunas; j++){
               matrizResultado[auxLinha][auxColuna] = matriz[i][j];
               auxColuna--;
           }
           auxColuna = nColunas - 1;       
           auxLinha++;
       }
   }
   
   //Girar imagem
   public void girarMatriz(int graus){
        
        if(graus == 90){
            matrizResultado = new int[nColunas][nLinhas];
            for(int i = 0; i < nColunas; i++){
                for(int j = 0; j < nLinhas; j++){
                    matrizResultado[i][j] = matriz[(nLinhas - 1) - j][i];
                }
            }
        }else if(graus == -90){
            matrizResultado = new int[nColunas][nLinhas];
            for(int i = 0; i < nColunas; i++){
                for(int j = 0; j < nLinhas; j++){
                    matrizResultado[i][j] = matriz[j][(nColunas - 1) - i];
                }
            }
        }else if(graus == 180){
            matrizResultado = new int[nLinhas][nColunas];
            for(int i = 0; i < nLinhas; i++){
                for(int j = 0; j < nColunas; j++){
                    matrizResultado[i][j] = matriz[(nLinhas - 1)- i][(nColunas - 1)- j];
                }
            }
        }
    }
}
