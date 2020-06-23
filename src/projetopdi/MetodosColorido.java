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

/**
 *
 * @author Giulia
 */
public class MetodosColorido {
    private Rgb matriz[][] = new Rgb[2][2]; 
    private Rgb matrizResultado[][] = new Rgb[2][2]; 
    private int nLinhas = 1;
    private int nColunas = 1;
    private String tipo = "P3";
    private int limite = 255;
    
    public MetodosColorido(){
        
    }
    
    public MetodosColorido(String nomeArquivo) throws FileNotFoundException, IOException{
        BufferedReader buffRead1 = new BufferedReader(new FileReader(nomeArquivo));
        String aux[] = nomeArquivo.split("\\.");
        
        if("ppm".equals(aux[aux.length-1])){
            String linha = "";
            
            //Tipo do arquivo (P1 == ASC PBM) (P2 == ASC PGM) (P3 == ASC PPM) (P4 == BIN PBM) (P5 == BIN PGM) (P6 == BIN PPM)
            linha = buffRead1.readLine();
            setTipo(linha);
            
            //Linha que contém o número de linhas e de colunas da matriz
            linha = buffRead1.readLine(); 
            setnLinhas(Integer.parseInt(linha.split(" ")[0])); //armazena o número de linhas
            setnColunas(Integer.parseInt(linha.split(" ")[1])); //armazena o número de colunas
            
            //Limite dos valores 0 - 255
            linha = buffRead1.readLine();
            setLimite(Integer.parseInt(linha));
            
            matriz = new Rgb[nLinhas][nColunas];
            
            for(int i = 0; i < nLinhas; i++){
                for(int j = 0; j < nColunas; j++){
                    Rgb novo = new Rgb();
                    linha = buffRead1.readLine();
                    novo.setR(Integer.parseInt(linha));
                    linha = buffRead1.readLine();
                    novo.setG(Integer.parseInt(linha));
                    linha = buffRead1.readLine();
                    novo.setB(Integer.parseInt(linha));
                    
                    matriz[i][j] = novo;
                }
            }
            
            for(int i = 0; i < nLinhas; i++){
                for(int j = 0; j < nColunas; j++){
                    System.out.println("Linha: " + i + " Coluna: " + j);
                    System.out.println("R: " + matriz[i][j].getR());
                    System.out.println("G: " + matriz[i][j].getG());
                    System.out.println("B: " + matriz[i][j].getB());
                }
            }
        }
    }

    public Rgb[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Rgb[][] matriz) {
        this.matriz = matriz;
    }

    public Rgb[][] getMatrizResultado() {
        return matrizResultado;
    }

    public void setMatrizResultado(Rgb[][] matrizResultado) {
        this.matrizResultado = matrizResultado;
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
    
    
    
    
}
