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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import projetopdi.ui.IUPrincipal;

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
    private int matrizR[][]; //Matriz com escala de vermelho
    private int matrizG[][]; //Matriz com escala de verde
    private int matrizB[][]; //Matriz com escala de azul
    private int matrizC[][]; //Matriz com escala de ciano
    private int matrizM[][]; //Matriz com escala de magenta
    private int matrizY[][]; //Matriz com escala de amarelo
    private int matrizH[][]; //Matriz com valor de hue
    private int matrizS[][]; //Matriz com valor de Saturação
    private int matrizI[][]; //Matriz com valor de Intensidade
    
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
            if("#".equals(linha.split(" ")[0])){ //Descartar o comentário
                linha = buffRead1.readLine();
            }
            setnColunas(Integer.parseInt(linha.split(" ")[0])); //armazena o número de colunas
            setnLinhas(Integer.parseInt(linha.split(" ")[1])); //armazena o número de linhas
            
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
            
//            for(int i = 0; i < nLinhas; i++){
//                for(int j = 0; j < nColunas; j++){
//                    System.out.println("Linha: " + i + " Coluna: " + j);
//                    System.out.println("R: " + matriz[i][j].getR());
//                    System.out.println("G: " + matriz[i][j].getG());
//                    System.out.println("B: " + matriz[i][j].getB());
//                }
//            }
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

    public int[][] getMatrizR() {
        return matrizR;
    }

    public void setMatrizR(int[][] matrizR) {
        this.matrizR = matrizR;
    }

    public int[][] getMatrizG() {
        return matrizG;
    }

    public void setMatrizG(int[][] matrizG) {
        this.matrizG = matrizG;
    }

    public int[][] getMatrizB() {
        return matrizB;
    }

    public void setMatrizB(int[][] matrizB) {
        this.matrizB = matrizB;
    }

    public int[][] getMatrizC() {
        return matrizC;
    }

    public void setMatrizC(int[][] matrizC) {
        this.matrizC = matrizC;
    }

    public int[][] getMatrizM() {
        return matrizM;
    }

    public void setMatrizM(int[][] matrizM) {
        this.matrizM = matrizM;
    }

    public int[][] getMatrizY() {
        return matrizY;
    }

    public void setMatrizY(int[][] matrizY) {
        this.matrizY = matrizY;
    }

    public int[][] getMatrizH() {
        return matrizH;
    }

    public void setMatrizH(int[][] matrizH) {
        this.matrizH = matrizH;
    }

    public int[][] getMatrizS() {
        return matrizS;
    }

    public void setMatrizS(int[][] matrizS) {
        this.matrizS = matrizS;
    }

    public int[][] getMatrizI() {
        return matrizI;
    }

    public void setMatrizI(int[][] matrizI) {
        this.matrizI = matrizI;
    }
    
    public void separarRGB(){
        matrizR = new int[nLinhas][nColunas];
        matrizG = new int[nLinhas][nColunas];
        matrizB = new int[nLinhas][nColunas];
        
        for(int i = 0; i < nLinhas; i++){
            for(int j = 0; j < nColunas; j++){
                matrizR[i][j] = matriz[i][j].getR();
                matrizG[i][j] = matriz[i][j].getG();
                matrizB[i][j] = matriz[i][j].getB();
            }
        }
   }
    
    public void separaCMY(){
        matrizC = new int[nLinhas][nColunas];
        matrizM = new int[nLinhas][nColunas];
        matrizY = new int[nLinhas][nColunas];
        
        for(int i = 0; i < nLinhas; i++){
            for(int j = 0; j < nColunas; j++){
                matrizC[i][j] = 255 - matriz[i][j].getR();
                matrizM[i][j] = 255 - matriz[i][j].getG();
                matrizY[i][j] = 255 - matriz[i][j].getB();
            }
        }
    }
    
    public void seprarHSI(){
        matrizH = new int[nLinhas][nColunas];
        matrizS = new int[nLinhas][nColunas];
        matrizI = new int[nLinhas][nColunas];
        
        double r, g, b, aux, h, s, i;
        
        for(int k = 0; k < nLinhas; k++){
            for(int j = 0; j < nColunas; j++){
                double aux2 = matriz[k][j].getR() + matriz[k][j].getG() + matriz[k][j].getB();
                r = matriz[k][j].getR()/ aux2;
                g = matriz[k][j].getG()/aux2;
                b = matriz[k][j].getB()/aux2;
                
                aux = (0.5 * ((r - g)+ (r - b)))/(Math.sqrt(((r - g)*(r - g)) + ((r - b)*(g - b))));
                if(aux > 1) aux = 1;
                if(aux < -1) aux = -1;
                h = Math.acos(aux);
                if(b > g) h = 2*Math.PI - h;
                
                if(r <= g && r <=b) s = 1- 3*r;
                else if(g <= r && g <=b) s = 1- 3*g;
                else s = 1- 3*b;
                
                i = (matriz[k][j].getR() + matriz[k][j].getG() + matriz[k][j].getB())/(3 * 255);
                
                matrizH[k][j] = (int)h;
                matrizS[k][j] = (int)s;
                matrizI[k][j] = (int)i;
            }
        }
    }
    
}
