/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopdi.ui;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import projetopdi.MetodosCinza;
import projetopdi.MetodosColorido;
import projetopdi.Rgb;

/**
 *
 * @author Giulia
 */
public class IUPrincipal extends javax.swing.JFrame {
    MetodosCinza metodos = new MetodosCinza();
    MetodosColorido metodos2 = new MetodosColorido();
    private boolean pgmPPM; //se pgm 0 senao 1 (ppm)
    public BufferedImage imagem_pgm;
    public BufferedImage imagem_ppm;
    private int nLinhas, nColunas;
    private int nLinhasNova, nColunasNova;
    
    /**
     * Creates new form IUPrincipal
     */
    public IUPrincipal() {
        initComponents();
        menuCinza_.setEnabled(false);
        menuRGB_.setEnabled(false);
        metodoSelecionadoCinza.setEnabled(false);
        metodoSelecionadoColorido.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        menuCinza_ = new javax.swing.JMenu();
        menuRGB_ = new javax.swing.JMenu();
        fileChooserR = new javax.swing.JFileChooser();
        fileChooserG = new javax.swing.JFileChooser();
        fileChooserB = new javax.swing.JFileChooser();
        metodoSelecionadoCinza = new javax.swing.JComboBox<>();
        confirmarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel_imagem = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel_imagemResultado = new javax.swing.JLabel();
        salvarArquivo = new javax.swing.JButton();
        metodoSelecionadoColorido = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        abrir = new javax.swing.JMenuItem();
        sair = new javax.swing.JMenuItem();

        fileChooser.setDialogTitle("Escolher arquivo");

        menuCinza_.setText("jMenu2");

        menuRGB_.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        metodoSelecionadoCinza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escurecer Imagem", "Clarear Imagem", "Girar Imagem", "Tornar Negativo", "Fatiamento", "Transf. Gama", "Flip Horizontal", "Equalização de Histograma", "Laplaciano (4 ao centro)", "Laplaciano (8 ao centro)", "Media", "Binarização" }));
        metodoSelecionadoCinza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metodoSelecionadoCinzaActionPerformed(evt);
            }
        });

        confirmarButton.setText("Confirmar");
        confirmarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jLabel_imagem);

        jScrollPane2.setViewportView(jLabel_imagemResultado);

        salvarArquivo.setText("Salvar em Arquivo");
        salvarArquivo.setEnabled(false);
        salvarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarArquivoActionPerformed(evt);
            }
        });

        metodoSelecionadoColorido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Separar RGB", "Separar CMY", "Separar HSI" }));

        jMenu1.setText("Menu");

        abrir.setText("Abrir imagem");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        jMenu1.add(abrir);

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jMenu1.add(sair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(metodoSelecionadoCinza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(metodoSelecionadoColorido, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(confirmarButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(salvarArquivo)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(metodoSelecionadoCinza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmarButton)
                    .addComponent(salvarArquivo)
                    .addComponent(metodoSelecionadoColorido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        JFileChooser jFile = new JFileChooser();
        int returnVal = jFile.showOpenDialog(this);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jFile.getSelectedFile();
            String a[] = file.getAbsolutePath().split("\\.");
            
            //P2 e P5
            if("pgm".equals(a[a.length-1])){
                menuRGB_.setEnabled(false);
                pgmPPM = false;
                try {
                    nColunasNova = nLinhasNova = 0;
                    metodos = new MetodosCinza(file.getAbsolutePath());
                    nLinhas = metodos.getnLinhas();
                    nColunas = metodos.getnColunas();
                    
                    exibirImagemCinza(metodos.getMatriz());
                    metodoSelecionadoCinza.setEnabled(true);
                    metodoSelecionadoColorido.setEnabled(false);
                    menuCinza_.setEnabled(true);
                } catch (IOException ex) {
                    System.out.println("problem accessing file "+file.getAbsolutePath());
                }
            }
            //P3 e P6
            else if("ppm".equals(a[a.length-1])){;
                menuCinza_.setEnabled(false);
                pgmPPM = true;
                try {
                    nColunasNova = nLinhasNova = 0;
                    metodos2 = new MetodosColorido(file.getAbsolutePath());
                    nLinhas = metodos2.getnLinhas();
                    nColunas = metodos2.getnColunas();
                    metodoSelecionadoColorido.setEnabled(true);
                    metodoSelecionadoCinza.setEnabled(false);
                    
                    exibirImagemColorida(metodos2.getMatriz());
                    
                    
                    //exibirImagemCinza(metodos.getMatriz());
                    //menuCinza_.setEnabled(true);
                } catch (IOException ex) {
                    System.out.println("problem accessing file "+file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_abrirActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        System.exit(0); 
    }//GEN-LAST:event_sairActionPerformed

    private void confirmarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarButtonActionPerformed
        //Escurecer Imagem
        //Clarear Imagem
        //Girar Imagem
        //Tornar Negativo
        //Fatiamento
        //Transf. Gama
        //Flip Horizontal
        //Equalização de Histograma
        //Laplaciano (4 ao centro)
        //Laplaciano (8 ao centro)
        //Media
        //Binarização
        String resultado;
        if(!pgmPPM){ //Imagem Cinza
            resultado = (String) metodoSelecionadoCinza.getSelectedItem();
        }
        else{ //Imagem Colorida
            resultado = (String) metodoSelecionadoColorido.getSelectedItem();
        }
        String nomeArquivo;
        
        if((metodos.getnLinhas() > 1)||(metodos2.getnLinhas() > 1)){
            if(nColunasNova > 1){
                int opcao = Integer.parseInt(JOptionPane.showInputDialog(this, "Deseja seguir editando a imagem resultado?(1 - Sim) (Outro - Não)  "));
                if(opcao == 1){
                    int linhas, colunas;
                    linhas = metodos.getMatrizResultado().length;
                    colunas = metodos.getMatrizResultado()[0].length;
                    
                    int imgResultado [][] = new int[linhas][colunas];
                    imgResultado = metodos.getMatrizResultado();
                    metodos.matrizResultadoNovaMatriz();
                    
                    nLinhas = metodos.getnLinhas();
                    nColunas = metodos.getnColunas();
                    
                    exibirImagemCinza(metodos.getMatriz());
                }
            }
            if(resultado == "Escurecer Imagem"){
                int valor = Integer.parseInt(JOptionPane.showInputDialog(this, "Entre com o valor para escurecer"));
                //verificar se valor é menor que limite
                if(valor > metodos.getLimite()){
                    JOptionPane.showMessageDialog(this, "O valor deve ser entre 0 e " + metodos.getLimite());
                }else{
                    metodos.escurecerMatriz(valor);
                    
                    nLinhasNova = metodos.getMatrizResultado().length;
                    nColunasNova = metodos.getMatrizResultado()[0].length;
                    exibirImagemCinzaResultado(metodos.getMatrizResultado());
                }
            }else if(resultado == "Clarear Imagem"){
                int valor = Integer.parseInt(JOptionPane.showInputDialog(this, "Entre com o valor para clarear"));
                
                if(valor > metodos.getLimite()){
                    JOptionPane.showMessageDialog(this, "O valor deve ser entre 0 e " + metodos.getLimite());
                }else{
                    metodos.clarearMatriz(valor);
                    
                    nLinhasNova = metodos.getMatrizResultado().length;
                    nColunasNova = metodos.getMatrizResultado()[0].length;
                    exibirImagemCinzaResultado(metodos.getMatrizResultado());
                }
                
            }else if(resultado == "Girar Imagem"){
                int numero = Integer.parseInt(JOptionPane.showInputDialog(this, "Entre com o valor para girar: "));
                
                while((numero != 90) || (numero != -90) || (numero != 180)){
                    JOptionPane.showMessageDialog(this, "Valor deve ser: 90, -90 ou 180");
                    numero = Integer.parseInt(JOptionPane.showInputDialog(this, "Entre com o valor para girar: "));
                    if( (numero == 90) || (numero == -90) || (numero == 180)) break;
                }
                
                metodos.girarMatriz(numero);
                
                nLinhasNova = metodos.getMatrizResultado().length;
                nColunasNova = metodos.getMatrizResultado()[0].length;
                exibirImagemCinzaResultado(metodos.getMatrizResultado());
            }else if(resultado == "Tornar Negativo"){
                metodos.negativoMatriz();
                
                nLinhasNova = metodos.getMatrizResultado().length;
                nColunasNova = metodos.getMatrizResultado()[0].length;
                exibirImagemCinzaResultado(metodos.getMatrizResultado());
            }
            else if(resultado == "Fatiamento"){
                int a, b, novaTonalidadeIntervalo;
                boolean aux = true;
                a = b = novaTonalidadeIntervalo = 0;
                while(aux){
                    a = Integer.parseInt(JOptionPane.showInputDialog(this, "Entre com o valor de 'a': "));
                    if((a > metodos.getLimite()) || (a < 0)){
                        a = Integer.parseInt(JOptionPane.showInputDialog(this, "Valor deve ser entre 0 e " + metodos.getLimite()));
                    }
                    else aux = false;
                }
                
                aux = true;
                while(aux){
                    b = Integer.parseInt(JOptionPane.showInputDialog(this, "Entre com o valor de 'b': "));
                    if((b > metodos.getLimite())||(b < 0)){
                        b = Integer.parseInt(JOptionPane.showInputDialog(this, "Valor deve ser entre 0 e " + metodos.getLimite()));
                    }
                    else aux = false;
                }
                
                aux = true;
                while(aux){
                    novaTonalidadeIntervalo = Integer.parseInt(JOptionPane.showInputDialog(this, "Valor da nova tonalidade: "));
                    if((novaTonalidadeIntervalo > metodos.getLimite())||(novaTonalidadeIntervalo < 0)){
                        novaTonalidadeIntervalo = Integer.parseInt(JOptionPane.showInputDialog(this, 
                                "Valor deve ser entre 0 e " + metodos.getLimite()));
                    }
                    else aux = false;
                }
                
                metodos.fatiamentoImagem(a, b, novaTonalidadeIntervalo);
                nLinhasNova = metodos.getMatrizResultado().length;
                nColunasNova = metodos.getMatrizResultado()[0].length;
                exibirImagemCinzaResultado(metodos.getMatrizResultado());
            }
            else if(resultado == "Transf. Gama"){
                float c, gama;
                c = Float.valueOf(JOptionPane.showInputDialog(this, "Valor de c: "));
                gama = Float.valueOf(JOptionPane.showInputDialog(this, "Valor de gama: "));
                
                metodos.transfGama(c, gama);
                nLinhasNova = metodos.getMatrizResultado().length;
                nColunasNova = metodos.getMatrizResultado()[0].length;
                exibirImagemCinzaResultado(metodos.getMatrizResultado());
            }
            else if(resultado == "Flip Horizontal"){
                metodos.flipHorizontal();
                nLinhasNova = metodos.getMatrizResultado().length;
                nColunasNova = metodos.getMatrizResultado()[0].length;
                exibirImagemCinzaResultado(metodos.getMatrizResultado());
            }
            else if(resultado == "Equalização de Histograma"){
                metodos.histograma();
                nLinhasNova = metodos.getMatrizResultado().length;
                nColunasNova = metodos.getMatrizResultado()[0].length;
                exibirImagemCinzaResultado(metodos.getMatrizResultado());
            }
            else if(resultado == "Laplaciano (4 ao centro)"){
                metodos.laplaciano1();
                nLinhasNova = metodos.getMatrizResultado().length;
                nColunasNova = metodos.getMatrizResultado()[0].length;
                exibirImagemCinzaResultado(metodos.getMatrizResultado());
                int opcao = Integer.parseInt(JOptionPane.showInputDialog(this, "Deseja somar com a imagem original? (1- SIM)"));
                if(opcao == 1){
                    JFileChooser salvandoArquivo = new JFileChooser();
                    int opt = salvandoArquivo.showSaveDialog(this);
                    if (opt != JFileChooser.APPROVE_OPTION) return;
                    File salvarArquivoEscolhido = salvandoArquivo.getSelectedFile();
                    File salvarArquivo = new File(salvarArquivoEscolhido.getPath()+".pgm");
                    
                    try {
                        metodos.somarMatrizes(salvarArquivo.getPath());
                    } catch (IOException ex) {
                        Logger.getLogger(IUPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            else if(resultado == "Laplaciano (8 ao centro)"){
                metodos.laplaciano2();
                nLinhasNova = metodos.getMatrizResultado().length;
                nColunasNova = metodos.getMatrizResultado()[0].length;
                exibirImagemCinzaResultado(metodos.getMatrizResultado());
                int opcao = Integer.parseInt(JOptionPane.showInputDialog(this, "Deseja somar com a imagem original? (1- SIM)"));
                if(opcao == 1){
                    JFileChooser salvandoArquivo = new JFileChooser();
                    int opt = salvandoArquivo.showSaveDialog(this);
                    if (opt != JFileChooser.APPROVE_OPTION) return;
                    File salvarArquivoEscolhido = salvandoArquivo.getSelectedFile();
                    File salvarArquivo = new File(salvarArquivoEscolhido.getPath()+".pgm");
                    
                    try {
                        metodos.somarMatrizes(salvarArquivo.getPath());
                    } catch (IOException ex) {
                        Logger.getLogger(IUPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            else if(resultado == "Media"){
                int filtro = Integer.parseInt(JOptionPane.showInputDialog(this, "Insira a dimensão da Janela: "));
                metodos.media(filtro);
                nLinhasNova = metodos.getMatrizResultado().length;
                nColunasNova = metodos.getMatrizResultado()[0].length;
                exibirImagemCinzaResultado(metodos.getMatrizResultado());
            }
            else if(resultado == "Binarização"){
                int valor = Integer.parseInt(JOptionPane.showInputDialog(this, "Insira um valor para a binarização: "));
                metodos.binarizacao(valor);
                nLinhasNova = metodos.getMatrizResultado().length;
                nColunasNova = metodos.getMatrizResultado()[0].length;
                exibirImagemCinzaResultado(metodos.getMatrizResultado());
            }
//------------------------------------------Métodos Coloridos----------------------------------------------------------------------------------------------
            //Métodos Coloridos disponíveis:
            //Separar RGB
            //Separar CMY
            //Separar HSI
            //Cinza - RGB
            else if(resultado == "Separar RGB"){
                if(metodos2.getnLinhas() > 1){
                    metodos2.separarRGB();
                    int matrizR[][] = new int [metodos2.getnLinhas()][metodos2.getnColunas()];
                    matrizR = metodos2.getMatrizR();
                    int matrizG[][] = new int [metodos2.getnLinhas()][metodos2.getnColunas()];
                    matrizG = metodos2.getMatrizG();
                    int matrizB[][] = new int [metodos2.getnLinhas()][metodos2.getnColunas()];
                    matrizB = metodos2.getMatrizB();
                   
                    salvarArquivo(matrizR, "Arquivo Vermelho - R");
                    salvarArquivo(matrizG, "Arquivo Verde - G");
                    salvarArquivo(matrizB, "Arquivo Azul - B");
                    
                }else JOptionPane.showMessageDialog(this, "Abra um arquivo antes");
            }
            else if(resultado == "Separar CMY"){
                metodos2.separaCMY();
                int matrizC[][] = new int [metodos2.getnLinhas()][metodos2.getnColunas()];
                matrizC = metodos2.getMatrizC();
                int matrizM[][] = new int [metodos2.getnLinhas()][metodos2.getnColunas()];
                matrizM = metodos2.getMatrizM();
                int matrizY[][] = new int [metodos2.getnLinhas()][metodos2.getnColunas()];
                matrizY = metodos2.getMatrizY();
                   
                salvarArquivo(matrizC, "Arquivo Ciano - C");
                salvarArquivo(matrizM, "Arquivo Magento - M");
                salvarArquivo(matrizY, "Arquivo Amarelo - Y");
            }
            else if(resultado == "Separar HSI"){
                
            }
            else if(resultado == "Cinza - RGB"){
                int returnValR = fileChooserR.showOpenDialog(this);
                int returnValG = fileChooserG.showOpenDialog(this);
                int returnValB = fileChooserB.showOpenDialog(this);
        
                if ((returnValR == JFileChooser.APPROVE_OPTION) && (returnValG == JFileChooser.APPROVE_OPTION) && (returnValB == JFileChooser.APPROVE_OPTION) ){
                
                    File fileVermelho = fileChooserR.getSelectedFile();
                    File fileVerde = fileChooserG.getSelectedFile();
                    File fileAzul = fileChooserB.getSelectedFile();
                    String nomeArquivoVermelho = fileVermelho.getAbsolutePath();
                    String nomeArquivoVerde = fileVerde.getAbsolutePath();
                    String nomeArquivoAzul = fileAzul.getAbsolutePath();

                    String linhaR = "";
                    String linhaG = "";
                    String linhaB = "";

                    //Tipo do arquivo (P1 == ASC PBM) (P2 == ASC PGM) (P3 == ASC PPM) (P4 == BIN PBM) (P5 == BIN PGM) (P6 == BIN PPM)
                    BufferedReader buffReadR = null;
                    BufferedReader buffReadG = null;
                    BufferedReader buffReadB = null;

                    try {
                        buffReadR = new BufferedReader(new FileReader(nomeArquivoVermelho));
                        linhaR = buffReadR.readLine(); //Tipo

                        buffReadG = new BufferedReader(new FileReader(nomeArquivoVerde));
                        linhaG = buffReadG.readLine();

                        buffReadB = new BufferedReader(new FileReader(nomeArquivoAzul));
                        linhaB = buffReadB.readLine();

                        linhaR = buffReadR.readLine(); //Dimensão
                        linhaG = buffReadG.readLine();
                        linhaB = buffReadB.readLine();

                        nLinhas = Integer.parseInt(linhaR.split(" ")[0]);
                        nColunas = Integer.parseInt(linhaR.split(" ")[1]);

                        linhaR = buffReadR.readLine(); //Limite
                        linhaG = buffReadG.readLine();
                        linhaB = buffReadB.readLine();

                        int limite = Integer.parseInt(linhaR);

                        Rgb[][] matriz = new Rgb[nLinhas][nColunas];

                        for(int i = 0; i < nLinhas; i++){
                            for(int j = 0; j < nColunas; j++){
                                Rgb novo = new Rgb();
                                linhaR = buffReadR.readLine();
                                linhaG = buffReadG.readLine();
                                linhaB = buffReadB.readLine();

                                novo.setR(Integer.parseInt(linhaR));
                                novo.setG(Integer.parseInt(linhaG));
                                novo.setB(Integer.parseInt(linhaB));

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

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(IUPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(IUPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            salvarArquivo.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(this, "Abra um arquivo antes");
        }
        
    }//GEN-LAST:event_confirmarButtonActionPerformed

    private void metodoSelecionadoCinzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metodoSelecionadoCinzaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_metodoSelecionadoCinzaActionPerformed

    private void salvarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarArquivoActionPerformed
        JFileChooser salvandoArquivo = new JFileChooser();
        int opt = salvandoArquivo.showSaveDialog(this);
        if (opt != JFileChooser.APPROVE_OPTION) return;
        File salvarArquivoEscolhido = salvandoArquivo.getSelectedFile();
        File salvarArquivo = new File(salvarArquivoEscolhido.getPath()+".pgm");
        try {
            metodos.escreverMatriz(salvarArquivo.getPath());
        } catch (IOException ex) {
            Logger.getLogger(IUPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salvarArquivoActionPerformed

    private void exibirImagemCinza(int matriz[][]){ 
        imagem_pgm = new BufferedImage(nColunas, nLinhas, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = imagem_pgm.getRaster();
        int num;
        for(int i = 0; i < nLinhas; i++)
            for(int j = 0; j < nColunas; j++){
                num = matriz[i][j];
                raster.setSample(j, i, 0, num);
        }
        jScrollPane1.setSize(imagem_pgm.getWidth(), imagem_pgm.getHeight());           
        setSize(imagem_pgm.getWidth(), imagem_pgm.getHeight());        
        jLabel_imagem.setIcon(new ImageIcon(imagem_pgm));
    }
    
    private void exibirImagemCinzaResultado(int matriz[][]){ 
        imagem_pgm = new BufferedImage(nColunasNova, nLinhasNova, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = imagem_pgm.getRaster();
        int num;

        for(int i = 0; i < nLinhasNova; i++)
            for(int j = 0; j < nColunasNova; j++){
                num = matriz[i][j];
                raster.setSample(j, i, 0, num);
        }
        jScrollPane2.setSize(imagem_pgm.getWidth(), imagem_pgm.getHeight());           
        setSize(imagem_pgm.getWidth(), imagem_pgm.getHeight());        
        jLabel_imagemResultado.setIcon(new ImageIcon(imagem_pgm));
    }
    
    public void exibirImagemColorida(Rgb matriz[][]){
        imagem_ppm = new BufferedImage(nColunas, nLinhas, BufferedImage.TYPE_INT_RGB);
        int r, g, b, rgb;
        
        for(int i = 0; i < nColunas; i++){
            for(int j = 0; j < nLinhas; j++){
                r = matriz[i][j].getR();
                g = matriz[i][j].getG();
                b = matriz[i][j].getB();
                
                Color myColor = new Color(r,g,b);
                rgb = myColor.getRGB();
                
                imagem_ppm.setRGB(j, i, rgb);
            }
        }
        
        jScrollPane1.setSize(imagem_ppm.getWidth(), imagem_ppm.getHeight());
        setSize(imagem_ppm.getWidth(), imagem_ppm.getHeight());
        jLabel_imagem.setIcon(new ImageIcon(imagem_ppm));
    }
    
    public void salvarArquivo(int matriz[][], String texto){
        JFileChooser salvandoArquivo = new JFileChooser();
        salvandoArquivo.setDialogTitle(texto);
        int opt = salvandoArquivo.showSaveDialog(this);
        if (opt != JFileChooser.APPROVE_OPTION) return;
        File salvarArquivoEscolhido = salvandoArquivo.getSelectedFile();
        File salvarArquivo = new File(salvarArquivoEscolhido.getPath()+".pgm");
        try {
            OutputStream salvar = new FileOutputStream(salvarArquivo.getPath());
            String linha = "P2\n"+ matriz.length +" "+ matriz[0].length +"\n" + 255 +"\n";
            byte [] salvando = linha.getBytes();
            salvar.write(salvando);

            for(int i = 0; i < nLinhas; i++){
                for(int j = 0; j < nColunas; j++){
                    salvando = String.valueOf(matriz[i][j]).getBytes();
                    salvar.write(salvando);
                    salvando = "\n".getBytes();
                    salvar.write(salvando);
                }
            }

            salvar.close();
        } catch (IOException ex) {
            Logger.getLogger(IUPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IUPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrir;
    private javax.swing.JButton confirmarButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JFileChooser fileChooserB;
    private javax.swing.JFileChooser fileChooserG;
    private javax.swing.JFileChooser fileChooserR;
    private javax.swing.JLabel jLabel_imagem;
    private javax.swing.JLabel jLabel_imagemResultado;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu menuCinza_;
    private javax.swing.JMenu menuRGB_;
    private javax.swing.JComboBox<String> metodoSelecionadoCinza;
    private javax.swing.JComboBox<String> metodoSelecionadoColorido;
    private javax.swing.JMenuItem sair;
    private javax.swing.JButton salvarArquivo;
    // End of variables declaration//GEN-END:variables
}
