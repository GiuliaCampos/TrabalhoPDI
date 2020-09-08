# Trabalho de Processamento Digital de Imagens
Desenvolvido em Java, versão 13, com a IDE Apache NetBeans 12.0.

O projeto possui 2 pacotes principais:
- projetopdi - Contém as classes responsáveis pela manipulação das imagens pgm (MetodosCinza.java) e ppm (MetodosColorido.java e Rgb.java) alem da classe principal (ProjetoPDI.java).
- projetopdi.ui - Contém a interface gráfica do projeto e ativação dos métodos.
    
Quando uma imagem é lida, seja pelo processo sequencial ou comandos em arquivos de texto, descritos mais à frente, ela é armazenada na variável ‘matriz’ na classe MetodosCinza, essa matriz é responsável por armazenar a imagem original e após cada transformação, a nova imagem é armazenada em ‘matrizResultado’ para que a imagem original não seja perdida.
Ainda na classe MetodosCinza, todos os atributos da imagem são armazenados, como tipo do arquivo, número de linhas e colunas além dos métodos disponíveis para serem executados em arquivos do tipo PGM. Os métodos disponíveis nesta classe são:
- public MetodosCinza(String nomeArquivo) - construtor, responsável pela leitura da imagem e armazenamento, recebe o arquivo que será lido;
- public void printMatriz() - função auxiliar na classe, que imprime no console a imagem original e resultado;
- public void matrizResultadoNovaMatriz() - função responsável por trocar a imagem resultado para a original, no caso de mais de um processamento na imagem;
- public void negativoMatriz() - método que transforma a imagem armazenada em negativa;
- public void clarearMatriz(int valor) - método responsável por clarear a imagem armazenada, necessita de um valor inteiro para ser somado a imagem;
- public void escurecerMatriz(int valor) - método responsável por escurecer a imagem armazenada, necessita de um valor para ser subtraído da imagem;
- public void fatiamentoImagem(int a, int b, int novaTonalidade) - método responsável por realizar o fatiamento da imagem, recebe um intervalo de ‘a’ até ‘b’ e uma nova tonalidade que esse intervalo receberá;
- public void fatiamento2Imagem(int a, int b, int novaTonalidadeIntervalo, int novaTonalidadeFora) - método responsável pelo fatiamento, recebe um intervalo de ‘a’ até ‘b’, uma nova tonalidade para o intervalo definido e uma nova tonalidade para os pixels de fora do intervalo;
- public void transfGama(float c, float gama) - método responsável por aplicar a transformação gama na imagem, necessita de um valor para o atributo ‘c’ e ‘gama’;
- public void flipHorizontal() - método responsável por realizar um flip horizontal na imagem armazenada;
- public void girarMatriz(int graus) - método responsável por girar a imagem, necessita de um valor em graus (aceita apenas 90º, -90º e 180º);
- public void histograma() - método responsável pela equalização do histograma da imagem armazenada como original;
- public void laplaciano1() - método responsável por aplicar o filtro laplaciano, com o valor 4 no elemento central;
- public void laplaciano2() - método responsável por aplicar o filtro laplaciano, com o valor 8 no elemento central;
- public void somarImagens() - método que soma a imagem original com a imagem resultado;
- public void subtrairImagens() - método que subtrai a imagem resultado da imagem original;
- public void media(int filtro) - método que aplica o filtro da média, necessita de um valor para a dimensão da janela do filtro;
- public void mediana(int filtro) - método que aplica o filtro da mediana, necessita de um valor para a dimensão da janela do filtro;
- public void binarizacao(int valor) - método responsável por realizar a binarização da imagem, necessário um valor para ser o limite da binarização;
- public void multiplicarValor(int valor) - método que multiplica um valor a imagem armazenada, é necessário um valor para ser multiplicado.

Na classe MetodosColoridos.java estão os métodos disponíveis para as imagens PPM. Quando uma imagem colorida é lida, os valores do canal RGB são armazenados seguindo o tipo RGB, disponível na classe Rgb.java. A classe Rgb.java é responsável por armazenar os valores de vermelho, verde e azul de cada pixel. Assim, cada imagem do tipo PPM, é salva na variavel ‘matriz’ da classe MetodosColoridos, cada posição dessa matriz é do tipo Rgb. Como nos processamentos de imagens do tipo PGM, a classe armazena todos os atributos da imagem e ainda uma ‘matrizResultado’ que guarda cada processamento realizado na imagem original. Os métodos disponíveis na classe MetodosColoridos.java, são:
- public MetodosColorido(String nomeArquivo) - método contrutor que lê a imagem e a armazena, assim como os atributos;
- public void separarRGB() - método responsável por extrair os canais vermelho, verde e azul da imagem e armazena-los separadamente;
- public void separaCMY() - Método responsável por extrair os canais ciano, magenta e amarelo da imagem, que antes seguia os padrões RGB, e armazenar cada canal separadamente.

No pacote projetopdi.ui encontra-se a classe UIPrincipal.java, responsável por instanciar os métodos disponíveis para as imagens do tipo PGM e PPM, além de controlar as imagens abertas, leitura de arquivos e salvar as imagens novas após as transformações.

Processamento por arquivo de texto: o arquivo deve ser do tipo txt, cada comando deve estar em uma linha, sem espaços vazios no final de da linha ou do arquivo.

Método - Exemplo Comando o Arquivo
- Leitura de arquivo - leitura C:\Users\strawberries.ppm
- Escrever em arquivo - escrever C:\Users\ imagemTeste
- Escurecer/Subtrair valor - escurecer 100
- Clarear/Somar valor - clarear 100
- Girar - girar -90
- Negativo - negativo
- Fatiamento - fora não há alteração - fatiamento 100 150 255
- Fatiamento - fora recebe outro valor - fatiamento2 100 150 255 0
- Transformação Gama - gama 0.1 1
- Flip Horizontal - flip
- Equalização de Histograma - histograma
- Filtro Laplaciano elemento central 4 - laplaciano 4
- Filtro Laplaciano elemento central 8 - laplaciano 8
- Média - media 5
- Binarização - binarizacao 90
- Soma de imagem original com nova - soma
- Multiplicação de um valor - multiplicacao
- Subtração imagem nova e original - subtracao
- Mediana - mediana 3
- Extrair canais RGB - C:\Users\ arquivoRed arquivoGreen arquivoBlue
- Compor os canais RGB - C:\Users\testeR.pgm C:\Users\testeG.pgm C:\Users\testeB.pgm
- Extrair canis CMY - C:\Users\ arquivoCiano arquivoMagenta arquivoAmarelo
