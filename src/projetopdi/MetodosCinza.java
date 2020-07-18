/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopdi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
            setnColunas(Integer.parseInt(linha.split(" ")[0])); //armazena o número de colunas
            setnLinhas(Integer.parseInt(linha.split(" ")[1])); //armazena o número de linhas

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
    public void escreverMatriz(String arquivo) throws FileNotFoundException, IOException{
        OutputStream salvar = new FileOutputStream(arquivo);
        String linha = "P2\n"+ nColunas +" "+ nLinhas +"\n" + limite +"\n";
        byte [] salvando = linha.getBytes();
        salvar.write(salvando);
        
        for(int i = 0; i < nLinhas; i++){
            for(int j = 0; j < nColunas; j++){
                salvando = String.valueOf(matrizResultado[i][j]).getBytes();
                salvar.write(salvando);
                salvando = "\n".getBytes();
                salvar.write(salvando);
            }
        }
        
        salvar.close();
    }
    
    public void matrizResultadoNovaMatriz(){
        nLinhas = matrizResultado.length;
        nColunas = matrizResultado[0].length;
        matriz = new int [nLinhas][nColunas];
        matriz = matrizResultado;
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
   
   //Equalização do Histogtama
   public void histograma(){
       double pr, auxpr;
       int aux = 0; 
       int nj;
       matrizResultado = new int[nLinhas][nColunas];
       double histograma[] = new double[limite+1];
       
       for(int i = 0; i < limite; i++){
           histograma[i] = 0;
       }
       
       for(int i = 0; i < nLinhas; i++){
           for(int j = 0; j < nColunas; j++){
               aux = matriz[i][j];
               histograma[aux]++;
           }
       }
       
       for(int i = 0; i < limite+1; i++){
           histograma[i] = histograma[i] / (nLinhas*nColunas);
       }
       
       auxpr = 0;
       for(int i = 0; i < limite+1; i++){
           pr = histograma[i];
           histograma[i] = (limite - 1) * (auxpr + pr);
           auxpr += pr;
       }
      
       aux = 0;
       for(int i = 0; i < nLinhas; i++){
           for(int j = 0; j < nColunas; j++){
               aux = matriz[i][j];
               matrizResultado[i][j] = (int) histograma[aux];
           }
       }
   }
   
   //Filtro Laplaciano com filtro 4 ao centro
   public void laplaciano1(){
       int soma = 0;
       matrizResultado = new int[nLinhas][nColunas];
       for(int i = 0; i < nLinhas; i++){
           for(int j = 0; j < nColunas; j++){
               if((i - 1) >= 0){
                   soma += (-1)*(matriz[i-1][j]);
               }
               if((i+1) < nLinhas - 1){
                   soma += (-1)*(matriz[i+1][j]);
               }
               if((j-1) >= 0){
                   soma += (-1)*(matriz[i][j-1]);
               }
               if((j+1) < nColunas - 1){
                   soma += (-1)*(matriz[i][j+1]);
               }
               soma += 4*(matriz[i][j]);
               soma = soma/4;
               if(soma > 255) matriz[i][j] = 255;
               else matrizResultado[i][j] = soma;
               soma = 0;
           }
       }
   }
   
   //Filtro Laplaciano com filtro 8 ao centro
   public void laplaciano2(){
       int soma = 0;
       matrizResultado = new int[nLinhas][nColunas];
       for(int i = 0; i < nLinhas; i++){
           for(int j = 0; j < nColunas; j++){
               if(((i-1) >= 0)&&((j-1) >= 0)){
                   soma += (-1)*matriz[i-1][j-1];
               }
               if((i-1) >= 0){
                   soma += (-1)*matriz[i-1][j];
               }
               if((j-1) >= 0){
                   soma += (-1)*matriz[i][j-1];
               }
               if(((i+1) < nLinhas) && ((j+1) < nColunas)){
                   soma += (-1)*matriz[i+1][j+1];
               }
               if((i+1) < nLinhas){
                   soma += (-1)*matriz[i+1][j];
               }
               if((j+1) < nColunas){
                   soma += (-1)*matriz[i][j+1];
               }
               soma  += 8*matriz[i][j];
               soma = soma/8;
               if(soma > 255) matriz[i][j] = 255;
               else matrizResultado[i][j] = soma;
               soma = 0;
           }
       }
   }
   
    public void somarMatrizes(String arquivo) throws FileNotFoundException, IOException{
        int matrizNova[][] = new int [nLinhas][nColunas];
        for(int i = 0; i < nLinhas; i++){
            for(int j = 0; j < nColunas; j++){
                
                if((matriz[i][j] + matrizResultado[i][j]) >= 255){
                    matrizNova[i][j] = matriz[i][j];
                }
                else if(matriz[i][j] + matrizResultado[i][j] <= 0){
                    matrizNova[i][j] = matriz[i][j];
                }
                else matrizNova[i][j] = matriz[i][j] + matrizResultado[i][j];
            }
        }
        
        OutputStream salvar = new FileOutputStream(arquivo);
        String linha = "P2\n"+ nColunas +" "+ nLinhas +"\n" + limite +"\n";
        byte [] salvando = linha.getBytes();
        salvar.write(salvando);
        
        for(int i = 0; i < nLinhas; i++){
            for(int j = 0; j < nColunas; j++){
                salvando = String.valueOf(matrizNova[i][j]).getBytes();
                salvar.write(salvando);
                salvando = "\n".getBytes();
                salvar.write(salvando);
            }
        }
        
        salvar.close();
   }
    
   public void media(int filtro){
       matrizResultado = new int[nLinhas][nColunas];
       int auxFiltro = (int)filtro/2;
       int soma = 0;
       int media = filtro*filtro;
       
       for(int i = 0; i < nLinhas; i++){
           for(int j = 0; j < nColunas; j++){
               for(int auxI = -auxFiltro; auxI < filtro - auxFiltro; auxI++){
                   for(int auxJ = -auxFiltro; auxJ < filtro - auxFiltro; auxJ++){
                       if((i+auxI >= 0)&&(i+auxI < nLinhas)){
                           if((j+auxJ >= 0)&&(j+auxJ < nColunas)){
                               soma += matriz[i+auxI][j+auxJ];
                           }
                       }
                   }
               }
               if((int)(soma/media) > 255) matrizResultado[i][j] = 255;
               else matrizResultado[i][j] = (int)(soma/media);
               soma = 0;
           }
       }
   }
   
   public void binarizacao(int valor){
       matrizResultado = new int[nLinhas][nColunas];
       
       for(int i = 0; i < nLinhas; i++){
           for(int j = 0; j < nColunas; j++){
               if(matriz[i][j] >= valor) matrizResultado[i][j] = 255;
               else matrizResultado[i][j] = 0;
           }
       }
   }
   
}
