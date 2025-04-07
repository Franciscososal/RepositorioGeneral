package panel;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JLabel;

public class Panel extends JFrame {
	
	public JTextArea textArea = new JTextArea();
	private int x;
    private int y;
    private int f = 15;
    private int c = 15;
    private int total=0;
    private int total2=0;
    private int flagsuma=0;
    private int flagresta=0;
    private int flagmultiplicacion=0;
    private int flagdivision=0;
    private int flagdeterminante=0;
    private int flaginversa=0;
    private int flagproductoescalar=0;
    
    int[][] matriz1 = new int[c][f];
    double[][] minv = new double[c][f];
    int[][] matriz2 = new int[c][f];
    int[][] matriz3 = new int[c][f];
    int[][] adjunta = new int[c][f];
    int[][] aux = new int[c][f];
    double[][] inversa = new double[c][f];
    
    private boolean azul = true;
    private void cambiarcolor() {
    	 if (azul) {
    		 logo.setForeground(Color.WHITE);
             logo.setBackground(Color.BLUE);
         } else {
        	 logo.setForeground(Color.BLUE);
        	 logo.setBackground(Color.WHITE);
         }
         azul = !azul;
    }
    
   
	private JTextField textFieldEnUso = null;
    
    private void insertarNumeroEnTextField(String numero) {
        if (textFieldEnUso != null) {
            String textoActual = textFieldEnUso.getText();
            textFieldEnUso.setText(textoActual + numero);
        }
    }
    
    private JTextField AtextFieldEnUso = null;
    
    private void AinsertarNumeroEnTextField(String numero) {
        if (AtextFieldEnUso != null) {
            String textoActual = AtextFieldEnUso.getText();
            AtextFieldEnUso.setText(textoActual + numero);
        }
    }
    		
    public void division() {
        inversa2();
        StringBuilder matrizString = new StringBuilder();
        if (total2 != 0) {
            double[][] resultado = new double[f][c];

            for (int i = 0; i < f; i++) {
                for (int j = 0; j < c; j++) {
                    for (int k = 0; k < f; k++) {
                        resultado[i][j] += matriz1[i][k] * inversa[k][j];
                    }
                }
            }
            
            for (int i = 0; i < f; i++) {
                for (int j = 0; j < c; j++) {
                    matrizString.append(String.format("%.2f", resultado[i][j])).append(" ");
                }
                matrizString.append("\n");
            }

        } else {

            matrizString.append("Error en matriz 2: La determinante da 0\\n");
        }
        

        mat3.setText(matrizString.toString());
    }



    
    
    
    public void productoescalar() {
        ceroycero.setBackground(new Color(255, 255, 0));
        Aceroycero.setBackground(new Color(255, 255,  0));
        int[][] aux1 = new int[c][f];
        int[][] aux2 = new int[c][f];
        
        if (f==2 && c==2) {
            for (int x = 0; x < 2; x++) {
                for (int y = 0; y < 2; y++) {
                    aux1[x][y] =  matriz1[x][y]*matriz2[0][0]; 
                }
            }
            
            for (int x = 0; x < 2; x++) {
                for (int y = 0; y < 2; y++) {
                    aux2[x][y] =  matriz2[x][y]*matriz1[0][0]; 
                }
            }
            

            StringBuilder matrizString = new StringBuilder();
            matrizString.append("Matriz 1 producto escalar:\n");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    matrizString.append(String.format("%d", aux1[i][j])).append(" ");
                }
                matrizString.append("\n");
            }

            matrizString.append("Matriz 2 producto escalar:\n");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    matrizString.append(String.format("%d", aux2[i][j])).append(" ");
                }
                matrizString.append("\n");
            }

            mat3.setText(matrizString.toString());

        } 
        if (f==3 && c==3) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    aux1[x][y] =  matriz1[x][y]*matriz2[0][0]; 
                }
            }
            
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    aux2[x][y] =  matriz2[x][y]*matriz1[0][0]; 
                }
            }
            

            StringBuilder matrizString = new StringBuilder();
            matrizString.append("Matriz 1 producto escalar:\n");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrizString.append(String.format("%d", aux1[i][j])).append(" ");
                }
                matrizString.append("\n");
            }

            matrizString.append("Matriz 2 producto escalar:\n");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrizString.append(String.format("%d", aux2[i][j])).append(" ");
                }
                matrizString.append("\n");
            }

            mat3.setText(matrizString.toString());

        } 
        if (f==4 && c==4) {
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    aux1[x][y] =  matriz1[x][y]*matriz2[0][0]; 
                }
            }
            
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    aux2[x][y] =  matriz2[x][y]*matriz1[0][0]; 
                }
            }
            

            StringBuilder matrizString = new StringBuilder();
            matrizString.append("Matriz 1 producto escalar:\n");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrizString.append(String.format("%d", aux1[i][j])).append(" ");
                }
                matrizString.append("\n");
            }

            matrizString.append("Matriz 2 producto escalar:\n");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrizString.append(String.format("%d", aux2[i][j])).append(" ");
                }
                matrizString.append("\n");
            }

            mat3.setText(matrizString.toString());

        } 
    }
    public void inversa2() {
        double[][] adjunta;
        determinante2();
        StringBuilder matrizString = new StringBuilder();

        if (total == 0) {
            matrizString.append("Error en matriz 1: La determinante da 0\n");
        } else {
            if (f == 3 && c == 3) {
                double[][] cofactores = new double[3][3];
                cofactores[0][0] = matriz1[1][1] * matriz1[2][2] - matriz1[1][2] * matriz1[2][1];
                cofactores[0][1] = -(matriz1[1][0] * matriz1[2][2] - matriz1[1][2] * matriz1[2][0]);
                cofactores[0][2] = matriz1[1][0] * matriz1[2][1] - matriz1[1][1] * matriz1[2][0];

                cofactores[1][0] = -(matriz1[0][1] * matriz1[2][2] - matriz1[0][2] * matriz1[2][1]);
                cofactores[1][1] = matriz1[0][0] * matriz1[2][2] - matriz1[0][2] * matriz1[2][0];
                cofactores[1][2] = -(matriz1[0][0] * matriz1[2][1] - matriz1[0][1] * matriz1[2][0]);

                cofactores[2][0] = matriz1[0][1] * matriz1[1][2] - matriz1[0][2] * matriz1[1][1];
                cofactores[2][1] = -(matriz1[0][0] * matriz1[1][2] - matriz1[0][2] * matriz1[1][0]);
                cofactores[2][2] = matriz1[0][0] * matriz1[1][1] - matriz1[0][1] * matriz1[1][0];

                adjunta = new double[3][3];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        adjunta[x][y] = cofactores[y][x] / total;
                    }
                }

                inversa = new double[3][3];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        inversa[x][y] = adjunta[x][y];
                    }
                }
            } else if (f == 2 && c == 2) {
                adjunta = new double[2][2];
                adjunta[0][0] = matriz1[1][1];
                adjunta[0][1] = -matriz1[0][1];
                adjunta[1][0] = -matriz1[1][0];
                adjunta[1][1] = matriz1[0][0];

                inversa = new double[2][2];
                double determinante = total;
                for (int x = 0; x < 2; x++) {
                    for (int y = 0; y < 2; y++) {
                        inversa[x][y] = adjunta[x][y] / determinante;
                    }
                }
            } else if (f == 4 && c == 4) {
                adjunta = new double[4][4];

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        double[][] submatriz = new double[3][3];
                        int subi = 0, subj = 0;
                        for (int k = 0; k < 4; k++) {
                            if (k == i) continue;
                            subj = 0;
                            for (int l = 0; l < 4; l++) {
                                if (l == j) continue;
                                submatriz[subi][subj] = matriz1[k][l];
                                subj++;
                            }
                            subi++;
                        }

                        double determinanteSubmatriz = submatriz[0][0] * (submatriz[1][1] * submatriz[2][2] - submatriz[1][2] * submatriz[2][1])
                                                     - submatriz[0][1] * (submatriz[1][0] * submatriz[2][2] - submatriz[1][2] * submatriz[2][0])
                                                     + submatriz[0][2] * (submatriz[1][0] * submatriz[2][1] - submatriz[1][1] * submatriz[2][0]);

                        adjunta[i][j] = Math.pow(-1, i + j) * determinanteSubmatriz;
                    }
                }

                double determinante = total;
                inversa = new double[4][4];
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        inversa[i][j] = adjunta[j][i] / determinante;
                    }
                }
            }
        }

        if (total2 == 0) {
            matrizString.append("Error en matriz 2: La determinante da 0\n");
        } else {
            if (f == 3 && c == 3) {
                double[][] Acofactores = new double[3][3];
                Acofactores[0][0] = matriz2[1][1] * matriz2[2][2] - matriz2[1][2] * matriz2[2][1];
                Acofactores[0][1] = -(matriz2[1][0] * matriz2[2][2] - matriz2[1][2] * matriz2[2][0]);
                Acofactores[0][2] = matriz2[1][0] * matriz2[2][1] - matriz2[1][1] * matriz2[2][0];

                Acofactores[1][0] = -(matriz2[0][1] * matriz2[2][2] - matriz2[0][2] * matriz2[2][1]);
                Acofactores[1][1] = matriz2[0][0] * matriz2[2][2] - matriz2[0][2] * matriz2[2][0];
                Acofactores[1][2] = -(matriz2[0][0] * matriz2[2][1] - matriz2[0][1] * matriz2[2][0]);

                Acofactores[2][0] = matriz2[0][1] * matriz2[1][2] - matriz2[0][2] * matriz2[1][1];
                Acofactores[2][1] = -(matriz2[0][0] * matriz2[1][2] - matriz2[0][2] * matriz2[1][0]);
                Acofactores[2][2] = matriz2[0][0] * matriz2[1][1] - matriz2[0][1] * matriz2[1][0];

                adjunta = new double[3][3];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        adjunta[x][y] = Acofactores[y][x] / total2;
                    }
                }

                inversa = new double[3][3];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        inversa[x][y] = adjunta[x][y];
                    }
                }
            } else if (f == 2 && c == 2) {
                adjunta = new double[2][2];
                adjunta[0][0] = matriz2[1][1];
                adjunta[0][1] = -matriz2[0][1];
                adjunta[1][0] = -matriz2[1][0];
                adjunta[1][1] = matriz2[0][0];

                inversa = new double[2][2];
                double determinante = total2;
                for (int x = 0; x < 2; x++) {
                    for (int y = 0; y < 2; y++) {
                        inversa[x][y] = adjunta[x][y] / determinante;
                    }
                }
            } else if (f == 4 && c == 4) {
                adjunta = new double[4][4];

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        double[][] submatriz = new double[3][3];
                        int subi = 0, subj = 0;
                        for (int k = 0; k < 4; k++) {
                            if (k == i) continue;
                            subj = 0;
                            for (int l = 0; l < 4; l++) {
                                if (l == j) continue;
                                submatriz[subi][subj] = matriz2[k][l];
                                subj++;
                            }
                            subi++;
                        }

                        double determinanteSubmatriz = submatriz[0][0] * (submatriz[1][1] * submatriz[2][2] - submatriz[1][2] * submatriz[2][1])
                                                     - submatriz[0][1] * (submatriz[1][0] * submatriz[2][2] - submatriz[1][2] * submatriz[2][0])
                                                     + submatriz[0][2] * (submatriz[1][0] * submatriz[2][1] - submatriz[1][1] * submatriz[2][0]);

                        adjunta[i][j] = Math.pow(-1, i + j) * determinanteSubmatriz;
                    }
                }

                double determinante = total2;
                inversa = new double[4][4];
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        inversa[i][j] = adjunta[j][i] / determinante;
                    }
                }
            }
        }

        mat3.setText(matrizString.toString());
    }

    public void inversa() {
        double[][] adjunta;
        double[][] inversa;
        determinante2();
        StringBuilder matrizString = new StringBuilder();

        if (total == 0) {
            matrizString.append("Error en matriz 1: La determinante da 0\n");
        } else {
            if (f == 3 && c == 3) {
                double[][] cofactores = new double[3][3];
                cofactores[0][0] = matriz1[1][1] * matriz1[2][2] - matriz1[1][2] * matriz1[2][1];
                cofactores[0][1] = -(matriz1[1][0] * matriz1[2][2] - matriz1[1][2] * matriz1[2][0]);
                cofactores[0][2] = matriz1[1][0] * matriz1[2][1] - matriz1[1][1] * matriz1[2][0];

                cofactores[1][0] = -(matriz1[0][1] * matriz1[2][2] - matriz1[0][2] * matriz1[2][1]);
                cofactores[1][1] = matriz1[0][0] * matriz1[2][2] - matriz1[0][2] * matriz1[2][0];
                cofactores[1][2] = -(matriz1[0][0] * matriz1[2][1] - matriz1[0][1] * matriz1[2][0]);

                cofactores[2][0] = matriz1[0][1] * matriz1[1][2] - matriz1[0][2] * matriz1[1][1];
                cofactores[2][1] = -(matriz1[0][0] * matriz1[1][2] - matriz1[0][2] * matriz1[1][0]);
                cofactores[2][2] = matriz1[0][0] * matriz1[1][1] - matriz1[0][1] * matriz1[1][0];

                adjunta = new double[3][3];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        adjunta[x][y] = cofactores[y][x] / total;
                    }
                }

                inversa = new double[3][3];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        inversa[x][y] = adjunta[x][y];
                    }
                }

                matrizString.append("Inversa de la matriz 1:\n");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        matrizString.append(String.format("%.2f", inversa[i][j])).append(" ");
                    }
                    matrizString.append("\n");
                }
            } else if (f == 2 && c == 2) {
                adjunta = new double[2][2];
                adjunta[0][0] = matriz1[1][1];
                adjunta[0][1] = -matriz1[0][1];
                adjunta[1][0] = -matriz1[1][0];
                adjunta[1][1] = matriz1[0][0];

                inversa = new double[2][2];
                double determinante = total;
                for (int x = 0; x < 2; x++) {
                    for (int y = 0; y < 2; y++) {
                        inversa[x][y] = adjunta[x][y] / determinante;
                    }
                }

                matrizString.append("Inversa de la matriz 1:\n");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        matrizString.append(String.format("%.2f", inversa[i][j])).append(" ");
                    }
                    matrizString.append("\n");
                }
            } else if (f == 4 && c == 4) {
                adjunta = new double[4][4];

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        double[][] submatriz = new double[3][3];
                        int subi = 0, subj = 0;
                        for (int k = 0; k < 4; k++) {
                            if (k == i) continue;
                            subj = 0;
                            for (int l = 0; l < 4; l++) {
                                if (l == j) continue;
                                submatriz[subi][subj] = matriz1[k][l];
                                subj++;
                            }
                            subi++;
                        }

                        double determinanteSubmatriz = submatriz[0][0] * (submatriz[1][1] * submatriz[2][2] - submatriz[1][2] * submatriz[2][1])
                                                     - submatriz[0][1] * (submatriz[1][0] * submatriz[2][2] - submatriz[1][2] * submatriz[2][0])
                                                     + submatriz[0][2] * (submatriz[1][0] * submatriz[2][1] - submatriz[1][1] * submatriz[2][0]);

                        adjunta[i][j] = Math.pow(-1, i + j) * determinanteSubmatriz;
                    }
                }

                double determinante = total;
                inversa = new double[4][4];
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        inversa[i][j] = adjunta[j][i] / determinante;
                    }
                }

                matrizString.append("Inversa de la matriz 1:\n");
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        matrizString.append(String.format("%.2f", inversa[i][j])).append(" ");
                    }
                    matrizString.append("\n");
                }
            }
        }

        matrizString.append("\n");

        if (total2 == 0) {
            matrizString.append("Error en matriz 2: La determinante da 0\n");
        } else {
            if (f == 3 && c == 3) {
                double[][] Acofactores = new double[3][3];
                Acofactores[0][0] = matriz2[1][1] * matriz2[2][2] - matriz2[1][2] * matriz2[2][1];
                Acofactores[0][1] = -(matriz2[1][0] * matriz2[2][2] - matriz2[1][2] * matriz2[2][0]);
                Acofactores[0][2] = matriz2[1][0] * matriz2[2][1] - matriz2[1][1] * matriz2[2][0];

                Acofactores[1][0] = -(matriz2[0][1] * matriz2[2][2] - matriz2[0][2] * matriz2[2][1]);
                Acofactores[1][1] = matriz2[0][0] * matriz2[2][2] - matriz2[0][2] * matriz2[2][0];
                Acofactores[1][2] = -(matriz2[0][0] * matriz2[2][1] - matriz2[0][1] * matriz2[2][0]);

                Acofactores[2][0] = matriz2[0][1] * matriz2[1][2] - matriz2[0][2] * matriz2[1][1];
                Acofactores[2][1] = -(matriz2[0][0] * matriz2[1][2] - matriz2[0][2] * matriz2[1][0]);
                Acofactores[2][2] = matriz2[0][0] * matriz2[1][1] - matriz2[0][1] * matriz2[1][0];

                adjunta = new double[3][3];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        adjunta[x][y] = Acofactores[y][x] / total2;
                    }
                }

                inversa = new double[3][3];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        inversa[x][y] = adjunta[x][y];
                    }
                }

                matrizString.append("Inversa de la matriz 2:\n");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        matrizString.append(String.format("%.2f", inversa[i][j])).append(" ");
                    }
                    matrizString.append("\n");
                }
            } else if (f == 2 && c == 2) {
                adjunta = new double[2][2];
                adjunta[0][0] = matriz2[1][1];
                adjunta[0][1] = -matriz2[0][1];
                adjunta[1][0] = -matriz2[1][0];
                adjunta[1][1] = matriz2[0][0];

                inversa = new double[2][2];
                double determinante = total2;
                for (int x = 0; x < 2; x++) {
                    for (int y = 0; y < 2; y++) {
                        inversa[x][y] = adjunta[x][y] / determinante;
                    }
                }

                matrizString.append("Inversa de la matriz 2:\n");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        matrizString.append(String.format("%.2f", inversa[i][j])).append(" ");
                    }
                    matrizString.append("\n");
                }
            } else if (f == 4 && c == 4) {
                adjunta = new double[4][4];

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        double[][] submatriz = new double[3][3];
                        int subi = 0, subj = 0;
                        for (int k = 0; k < 4; k++) {
                            if (k == i) continue;
                            subj = 0;
                            for (int l = 0; l < 4; l++) {
                                if (l == j) continue;
                                submatriz[subi][subj] = matriz2[k][l];
                                subj++;
                            }
                            subi++;
                        }

                        double determinanteSubmatriz = submatriz[0][0] * (submatriz[1][1] * submatriz[2][2] - submatriz[1][2] * submatriz[2][1])
                                                     - submatriz[0][1] * (submatriz[1][0] * submatriz[2][2] - submatriz[1][2] * submatriz[2][0])
                                                     + submatriz[0][2] * (submatriz[1][0] * submatriz[2][1] - submatriz[1][1] * submatriz[2][0]);

                        adjunta[i][j] = Math.pow(-1, i + j) * determinanteSubmatriz;
                    }
                }

                double determinante = total2;
                inversa = new double[4][4];
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        inversa[i][j] = adjunta[j][i] / determinante; 
                    }
                }

                matrizString.append("Inversa de la matriz 2:\n");
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        matrizString.append(String.format("%.2f", inversa[i][j])).append(" ");
                    }
                    matrizString.append("\n");
                }
            }
            
        }
        mat3.setText(matrizString.toString());
        
    }

    public void determinante2() {
        if (f == 2 && c == 2) {
            total = matriz1[0][0] * matriz1[1][1] - matriz1[0][1] * matriz1[1][0];
            total2 = matriz2[0][0] * matriz2[1][1] - matriz2[0][1] * matriz2[1][0];
        } else if (f == 3 && c == 3) {
            total = matriz1[0][0] * (matriz1[1][1] * matriz1[2][2] - matriz1[1][2] * matriz1[2][1])
                    - matriz1[0][1] * (matriz1[1][0] * matriz1[2][2] - matriz1[1][2] * matriz1[2][0])
                    + matriz1[0][2] * (matriz1[1][0] * matriz1[2][1] - matriz1[1][1] * matriz1[2][0]);

            total2 = matriz2[0][0] * (matriz2[1][1] * matriz2[2][2] - matriz2[1][2] * matriz2[2][1])
                    - matriz2[0][1] * (matriz2[1][0] * matriz2[2][2] - matriz2[1][2] * matriz2[2][0])
                    + matriz2[0][2] * (matriz2[1][0] * matriz2[2][1] - matriz2[1][1] * matriz2[2][0]);
        } else if (f == 4 && c == 4) {
            total = matriz1[0][0] * (matriz1[1][1] * (matriz1[2][2] * matriz1[3][3] - matriz1[2][3] * matriz1[3][2]) -
                                     matriz1[1][2] * (matriz1[2][1] * matriz1[3][3] - matriz1[2][3] * matriz1[3][1]) +
                                     matriz1[1][3] * (matriz1[2][1] * matriz1[3][2] - matriz1[2][2] * matriz1[3][1]))
                   - matriz1[0][1] * (matriz1[1][0] * (matriz1[2][2] * matriz1[3][3] - matriz1[2][3] * matriz1[3][2]) -
                                     matriz1[1][2] * (matriz1[2][0] * matriz1[3][3] - matriz1[2][3] * matriz1[3][0]) +
                                     matriz1[1][3] * (matriz1[2][0] * matriz1[3][2] - matriz1[2][2] * matriz1[3][0]))
                   + matriz1[0][2] * (matriz1[1][0] * (matriz1[2][1] * matriz1[3][3] - matriz1[2][3] * matriz1[3][1]) -
                                     matriz1[1][1] * (matriz1[2][0] * matriz1[3][3] - matriz1[2][3] * matriz1[3][0]) +
                                     matriz1[1][3] * (matriz1[2][0] * matriz1[3][1] - matriz1[2][1] * matriz1[3][0]))
                   - matriz1[0][3] * (matriz1[1][0] * (matriz1[2][1] * matriz1[3][2] - matriz1[2][2] * matriz1[3][1]) -
                                     matriz1[1][1] * (matriz1[2][0] * matriz1[3][2] - matriz1[2][2] * matriz1[3][0]) +
                                     matriz1[1][2] * (matriz1[2][0] * matriz1[3][1] - matriz1[2][1] * matriz1[3][0]));

            total2 = matriz2[0][0] * (
                    matriz2[1][1] * (matriz2[2][2] * matriz2[3][3] - matriz2[2][3] * matriz2[3][2]) -
                    matriz2[1][2] * (matriz2[2][1] * matriz2[3][3] - matriz2[2][3] * matriz2[3][1]) +
                    matriz2[1][3] * (matriz2[2][1] * matriz2[3][2] - matriz2[2][2] * matriz2[3][1])
                  )
                  - matriz2[0][1] * (
                    matriz2[1][0] * (matriz2[2][2] * matriz2[3][3] - matriz2[2][3] * matriz2[3][2]) -
                    matriz2[1][2] * (matriz2[2][0] * matriz2[3][3] - matriz2[2][3] * matriz2[3][0]) +
                    matriz2[1][3] * (matriz2[2][0] * matriz2[3][2] - matriz2[2][2] * matriz2[3][0])
                  )
                  + matriz2[0][2] * (
                    matriz2[1][0] * (matriz2[2][1] * matriz2[3][3] - matriz2[2][3] * matriz2[3][1]) -
                    matriz2[1][1] * (matriz2[2][0] * matriz2[3][3] - matriz2[2][3] * matriz2[3][0]) +
                    matriz2[1][3] * (matriz2[2][0] * matriz2[3][1] - matriz2[2][1] * matriz2[3][0])
                  )
                  - matriz2[0][3] * (
                    matriz2[1][0] * (matriz2[2][1] * matriz2[3][2] - matriz2[2][2] * matriz2[3][1]) -
                    matriz2[1][1] * (matriz2[2][0] * matriz2[3][2] - matriz2[2][2] * matriz2[3][0]) +
                    matriz2[1][2] * (matriz2[2][0] * matriz2[3][1] - matriz2[2][1] * matriz2[3][0])
                  );

        }
    }


    
	public void determinante()
  	{

		String palabra;
		String palabra2;
		String textoCompleto;

  			if(f==2 && c==2)
  			{
  				total = matriz1[0][0] * matriz1[1][1] - matriz1[0][1] * matriz1[1][0];
  				total2 = matriz2[0][0] * matriz2[1][1] - matriz2[0][1] * matriz2[1][0];
  				palabra = "determinante de la matriz1: " + total + "\n";
  				palabra2 = "determinante de la matriz2: " + total2 + "\n";
  				textoCompleto = palabra + palabra2;
  				mat3.setText(textoCompleto);
  			}
  			else if(f==3 && c==3)
  			{
  				 total = matriz1[0][0] * (matriz1[1][1] * matriz1[2][2] - matriz1[1][2] * matriz1[2][1])
  			              - matriz1[0][1] * (matriz1[1][0] * matriz1[2][2] - matriz1[1][2] * matriz1[2][0])
  			              + matriz1[0][2] * (matriz1[1][0] * matriz1[2][1] - matriz1[1][1] * matriz1[2][0]);

  	  	  		total2 = matriz2[0][0] * (matriz2[1][1] * matriz2[2][2] - matriz2[1][2] * matriz2[2][1])
  			              - matriz2[0][1] * (matriz2[1][0] * matriz2[2][2] - matriz2[1][2] * matriz2[2][0])
  			              + matriz2[0][2] * (matriz2[1][0] * matriz2[2][1] - matriz2[1][1] * matriz2[2][0]);
  	  	  		
  				mat3.setText("determinante de la matriz1: ");
  				palabra = "determinante de la matriz1: " + total + "\n";
  	  			palabra2 = "determinante de la matriz2: " + total2 + "\n";
  	  			textoCompleto = palabra + palabra2;
				mat3.setText(textoCompleto);
  			}
  			else if (f == 4 && c == 4) {
  				int a = matriz1[0][0];
  		        int b = matriz1[0][1];
  		        int c = matriz1[0][2];
  		        int d = matriz1[0][3];
  		        int e = matriz1[1][0];
  		        int f = matriz1[1][1];
  		        int g = matriz1[1][2];
  		        int h = matriz1[1][3];
  		        int i = matriz1[2][0];
  		        int j = matriz1[2][1];
  		        int k = matriz1[2][2];
  		        int l = matriz1[2][3];
  		        int m = matriz1[3][0];
  		        int n = matriz1[3][1];
  		        int o = matriz1[3][2];
  		        int p = matriz1[3][3];
  		        
  		        
  		        total = a * (f * (k * p - o * l) - g * (j * p - n * l) + h * (j * o - n * k))
  		                - b * (e * (k * p - o * l) - g * (i * p - m * l) + h * (i * o - m * k))
  		                + c * (e * (j * p - n * l) - f * (i * p - m * l) + h * (i * n - m * j))
  		                - d * (e * (j * o - n * k) - f * (i * o - m * k) + g * (i * n - m * j));
  		        


  				
  				
  		    int Aa = matriz2[0][0];
  	        int Ab = matriz2[0][1];
  	        int Ac = matriz2[0][2];
  	        int Ad = matriz2[0][3];
  	        int Ae = matriz2[1][0];
  	        int Af = matriz2[1][1];
  	        int Ag = matriz2[1][2];
  	        int Ah = matriz2[1][3];
  	        int Ai = matriz2[2][0];
  	        int Aj = matriz2[2][1];
  	        int Ak = matriz2[2][2];
  	        int Al = matriz2[2][3];
  	        int Am = matriz2[3][0];
  	        int An = matriz2[3][1];
  	        int Ao = matriz2[3][2];
  	        int Ap = matriz2[3][3];
  	        
  	        total2 = Aa * (Af * (Ak * Ap - Ao * Al) - Ag * (Aj * Ap - An * Al) + Ah * (Aj * Ao - An * Ak))
  	                - Ab * (Ae * (Ak * Ap - Ao * Al) - Ag * (Ai * Ap - Am * Al) + Ah * (Ai * Ao - Am * Ak))
  	                + Ac * (Ae * (Aj * Ap - An * Al) - Af * (Ai * Ap - Am * Al) + Ah * (Ai * An - Am * Aj))
  	                - Ad * (Ae * (Aj * Ao - An * Ak) - Af * (Ai * Ao - Am * Ak) + Ag * (Ai * An - Am * Aj));
  	        
  			        

  			    palabra = "determinante de la matriz1: " + total + "\n";
  			    palabra2 = "determinante de la matriz2: " + total2 + "\n";
  			    textoCompleto = palabra + palabra2;
  			    mat3.setText(textoCompleto);
  			}

  		
  	}
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ceroycero;
	private JTextField ceroyuno;
	private JTextField unoycero;
	private JTextField dosycero;
	private JTextField tresycero;
	private JTextField tresyuno;
	private JTextField dosyuno;
	private JTextField unoyuno;
	private JTextField tresydos;
	private JTextField dosydos;
	private JTextField unoydos;
	private JTextField ceroydos;
	private JTextField ceroytres;
	private JTextField unoytres;
	private JTextField dosytres;
	private JTextField tresytres;
	private JTextField Aceroycero;
	private JTextField Aunoycero;
	private JTextField Adosycero;
	private JTextField Atresycero;
	private JTextField Aceroyuno;
	private JTextField Aunoyuno;
	private JTextField Adosyuno;
	private JTextField Atresyuno;
	private JTextField Aceroydos;
	private JTextField Aunoydos;
	private JTextField Adosydos;
	private JTextField Atresydos;
	private JTextField Atresytres;
	private JTextField Adosytres;
	private JTextField Aunoytres;
	private JTextField Aceroytres;
	private JButton Aflechaderecha;
	private JButton Abotondel1;
	private JButton Abotondel2;
	private JButton Abotondel3;
	private JButton Abotondel4;
	private JButton Abotondel5;
	private JButton Abotondel6;
	private JButton Abotondel7;
	private JButton Abotondel8;
	private JButton Abotondel9;
	private JButton Abotondel0;
	private JLabel logo;
	private JTextArea mat3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel frame = new Panel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	
	public Panel() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setBounds(100, 100, 600, 700);
		    contentPane = new JPanel();
		    contentPane.setBackground(new Color(0, 0, 0)); 
		    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		    setContentPane(contentPane);
		    contentPane.setLayout(null);
		    setLocationRelativeTo(null);
		    
		    c = 4;
		    f = 4;
		    for (x = 0; x < c; x++) {
		        for (y = 0; y < f; y++) {
		            matriz1[x][y] = 0;
		        }
		    }

		    for (x = 0; x < c; x++) {
		        for (y = 0; y < f; y++) {
		            matriz2[x][y] = 0;
		        }
		    }

		    mat3 = new JTextArea();
		    mat3.setForeground(Color.BLACK);
		    mat3.setBackground(Color.WHITE);
		    mat3.setFont(new Font("Tahoma", Font.PLAIN, 10)); 
		    mat3.setEditable(false);
		    mat3.setFocusable(false); 
		    mat3.setLineWrap(true); 
		    mat3.setWrapStyleWord(true);
		    mat3.setBounds(423, 22, 153, 184);
		    mat3.setBorder(BorderFactory.createLineBorder(new Color(255, 128, 0)));
		    contentPane.add(mat3);
		
        
		JButton botondel1 = new JButton("1");
		botondel1.setForeground(new Color(255, 255, 255));
		botondel1.setBounds(10, 266, 50, 50);
		contentPane.add(botondel1);	
		botondel1.setBackground(new Color(77, 77, 77));
		botondel1.setFont(new Font("Arial", Font.BOLD, 24));
		botondel1.setBorder(BorderFactory.createLineBorder(new Color(200, 0, 0), 2));//------------borde rojo---------
		botondel1.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { botondel1.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { botondel1.setBackground(new Color(77, 77, 77)); }
		    });
		botondel1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        insertarNumeroEnTextField("1");
		    }
		});



		
		JButton botondel2 = new JButton("2");
		botondel2.setForeground(new Color(255, 255, 255));
		botondel2.setBounds(70, 266, 50, 50);
		contentPane.add(botondel2);
		botondel2.setBackground(new Color(77, 77, 77));
		botondel2.setFont(new Font("Arial", Font.BOLD, 24));
		botondel2.setBorder(BorderFactory.createLineBorder(new Color(200, 0, 0), 2)); //------------borde rojo---------
		botondel2.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { botondel2.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { botondel2.setBackground(new Color(77, 77, 77)); }
		    });
		botondel2.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	insertarNumeroEnTextField("2");
		    }
		});

		
		
		
		JButton botondel3 = new JButton("3");
		botondel3.setForeground(new Color(255, 255, 255));
		botondel3.setBounds(130, 266, 50, 50);
		contentPane.add(botondel3);
		botondel3.setBackground(new Color(77, 77, 77));
		botondel3.setFont(new Font("Arial", Font.BOLD, 24));
		botondel3.setBorder(BorderFactory.createLineBorder(new Color(200, 0, 0), 2));//------------borde rojo---------
		botondel3.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { botondel3.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { botondel3.setBackground(new Color(77, 77, 77)); }
		});
		botondel3.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	insertarNumeroEnTextField("3");
		    }
		});

		
		
		JButton botondel4 = new JButton("4");
		botondel4.setForeground(new Color(255, 255, 255));
		botondel4.setBounds(10, 327, 50, 50);
		contentPane.add(botondel4);
		botondel4.setBackground(new Color(77, 77, 77));
		botondel4.setFont(new Font("Arial", Font.BOLD, 24));
		botondel4.setBorder(BorderFactory.createLineBorder(new Color(200, 0, 0), 2));//------------borde rojo---------
		botondel4.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { botondel4.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { botondel4.setBackground(new Color(77, 77, 77)); }
		   });
		botondel4.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	insertarNumeroEnTextField("4");
		    }
		});

		
		
		JButton botondel5 = new JButton("5");
		botondel5.setForeground(new Color(255, 255, 255));
		botondel5.setBounds(70, 327, 50, 50);
		contentPane.add(botondel5);
		botondel5.setBackground(new Color(77, 77, 77));
		botondel5.setFont(new Font("Arial", Font.BOLD, 24));
		botondel5.setBorder(BorderFactory.createLineBorder(new Color(200, 0, 0), 2));//------------borde rojo---------
		botondel5.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { botondel5.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { botondel5.setBackground(new Color(77, 77, 77)); }
		   });
		botondel5.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	insertarNumeroEnTextField("5");
		    }
		});

		
		
		JButton botondel6 = new JButton("6");
		botondel6.setForeground(new Color(255, 255, 255));
		botondel6.setBounds(130, 327, 50, 50);
		contentPane.add(botondel6);
		botondel6.setBackground(new Color(77, 77, 77));
		botondel6.setFont(new Font("Arial", Font.BOLD, 24));
		botondel6.setBorder(BorderFactory.createLineBorder(new Color(200, 0, 0), 2));//------------borde rojo---------
		botondel6.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { botondel6.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { botondel6.setBackground(new Color(77, 77, 77)); }
		   });
		botondel6.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	insertarNumeroEnTextField("6");
		    }
		});

		
		
		JButton botondel7 = new JButton("7");
		botondel7.setForeground(new Color(255, 255, 255));
		botondel7.setBounds(10, 388, 50, 50);
		contentPane.add(botondel7);
		botondel7.setBackground(new Color(77, 77, 77));
		botondel7.setFont(new Font("Arial", Font.BOLD, 24));
		botondel7.setBorder(BorderFactory.createLineBorder(new Color(200, 0, 0), 2));//------------borde rojo---------
		botondel7.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { botondel7.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { botondel7.setBackground(new Color(77, 77, 77)); }
		    });
		botondel7.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	insertarNumeroEnTextField("7");
		    }
		});

		
		
		JButton botondel8 = new JButton("8");
		botondel8.setForeground(new Color(255, 255, 255));
		botondel8.setBackground(new Color(77, 77, 77));
		botondel8.setBounds(70, 388, 50, 50);
		contentPane.add(botondel8);
		botondel8.setFont(new Font("Arial", Font.BOLD, 24));
		botondel8.setBorder(BorderFactory.createLineBorder(new Color(200, 0, 0), 2));//------------borde rojo---------
		botondel8.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { botondel8.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { botondel8.setBackground(new Color(77, 77, 77)); }
		   });
		botondel8.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	insertarNumeroEnTextField("8");
		    }
		});

		
		
		
		JButton botondel9 = new JButton("9");
		botondel9.setForeground(new Color(255, 255, 255));
		botondel9.setBounds(130, 388, 50, 50);
		contentPane.add(botondel9);
		botondel9.setBackground(new Color(77, 77, 77));
		botondel9.setFont(new Font("Arial", Font.BOLD, 24));
		botondel9.setBorder(BorderFactory.createLineBorder(new Color(200, 0, 0), 2));//------------borde rojo---------
		botondel9.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { botondel9.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { botondel9.setBackground(new Color(77, 77, 77)); }
		    });
		botondel9.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	insertarNumeroEnTextField("9");
		    }
		});

		
		
		JButton botondel0 = new JButton("0");
		botondel0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botondel0.setForeground(new Color(255, 255, 255));
		botondel0.setBounds(10, 447, 50, 89);
		contentPane.add(botondel0);
		botondel0.setBackground(new Color(77, 77, 77));
		botondel0.setFont(new Font("Arial", Font.BOLD, 24));
		botondel0.setBorder(BorderFactory.createLineBorder(new Color(200, 0, 0), 2)); //------------borde rojo---------
		botondel0.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { botondel0.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { botondel0.setBackground(new Color(77, 77, 77)); }
		    });
		botondel0.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	insertarNumeroEnTextField("0");
		    }
		});
		
		Abotondel1 = new JButton("1");
		Abotondel1.setForeground(Color.WHITE);
		Abotondel1.setFont(new Font("Arial", Font.BOLD, 24));
		Abotondel1.setBackground(new Color(77, 77, 77));
		Abotondel1.setBounds(201, 266, 50, 50);
		Abotondel1.setBorder(BorderFactory.createLineBorder(new Color(255, 128, 0), 2)); //------------borde narnja---------
		contentPane.add(Abotondel1);
		Abotondel1.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { Abotondel1.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { Abotondel1.setBackground(new Color(77, 77, 77)); }
		    });
		Abotondel1.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	AinsertarNumeroEnTextField("1");
		    }
		});
		
		Abotondel2 = new JButton("2");
		Abotondel2.setForeground(Color.WHITE);
		Abotondel2.setFont(new Font("Arial", Font.BOLD, 24));
		Abotondel2.setBackground(new Color(77, 77, 77));
		Abotondel2.setBounds(262, 266, 50, 50);
		Abotondel2.setBorder(BorderFactory.createLineBorder(new Color(255, 128, 0), 2)); //------------borde narnja---------
		contentPane.add(Abotondel2);
		Abotondel2.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { Abotondel2.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { Abotondel2.setBackground(new Color(77, 77, 77)); }
		    });
		Abotondel2.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	AinsertarNumeroEnTextField("2");
		    }
		});
		
		Abotondel3 = new JButton("3");
		Abotondel3.setForeground(Color.WHITE);
		Abotondel3.setFont(new Font("Arial", Font.BOLD, 24));
		Abotondel3.setBackground(new Color(77, 77, 77));
		Abotondel3.setBounds(322, 266, 50, 50);
		Abotondel3.setBorder(BorderFactory.createLineBorder(new Color(255, 128, 0), 2)); //------------borde narnja---------
		contentPane.add(Abotondel3);
		Abotondel3.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { Abotondel3.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { Abotondel3.setBackground(new Color(77, 77, 77)); }
		    });
		Abotondel3.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	AinsertarNumeroEnTextField("3");
		    }
		});
		
		Abotondel4 = new JButton("4");
		Abotondel4.setForeground(Color.WHITE);
		Abotondel4.setFont(new Font("Arial", Font.BOLD, 24));
		Abotondel4.setBackground(new Color(77, 77, 77));
		Abotondel4.setBounds(201, 327, 50, 50);
		Abotondel4.setBorder(BorderFactory.createLineBorder(new Color(255, 128, 0), 2)); //------------borde narnja---------
		contentPane.add(Abotondel4);
		Abotondel4.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { Abotondel4.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { Abotondel4.setBackground(new Color(77, 77, 77)); }
		    });
		Abotondel4.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	AinsertarNumeroEnTextField("4");
		    }
		});
		
		Abotondel5 = new JButton("5");
		Abotondel5.setForeground(Color.WHITE);
		Abotondel5.setFont(new Font("Arial", Font.BOLD, 24));
		Abotondel5.setBackground(new Color(77, 77, 77));
		Abotondel5.setBounds(262, 327, 50, 50);
		Abotondel5.setBorder(BorderFactory.createLineBorder(new Color(255, 128, 0), 2)); //------------borde narnja---------
		contentPane.add(Abotondel5);
		Abotondel5.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { Abotondel5.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { Abotondel5.setBackground(new Color(77, 77, 77)); }
		    });
		Abotondel5.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	AinsertarNumeroEnTextField("5");
		    }
		});
		
		Abotondel6 = new JButton("6");
		Abotondel6.setForeground(Color.WHITE);
		Abotondel6.setFont(new Font("Arial", Font.BOLD, 24));
		Abotondel6.setBackground(new Color(77, 77, 77));
		Abotondel6.setBounds(322, 327, 50, 50);
		Abotondel6.setBorder(BorderFactory.createLineBorder(new Color(255, 128, 0), 2)); //------------borde narnja---------
		contentPane.add(Abotondel6);
		Abotondel6.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { Abotondel6.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { Abotondel6.setBackground(new Color(77, 77, 77)); }
		    });
		Abotondel6.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	AinsertarNumeroEnTextField("6");
		    }
		});
		
		Abotondel7 = new JButton("7");
		Abotondel7.setForeground(Color.WHITE);
		Abotondel7.setFont(new Font("Arial", Font.BOLD, 24));
		Abotondel7.setBackground(new Color(77, 77, 77));
		Abotondel7.setBounds(201, 388, 50, 50);
		Abotondel7.setBorder(BorderFactory.createLineBorder(new Color(255, 128, 0), 2)); //------------borde narnja---------
		contentPane.add(Abotondel7);
		Abotondel7.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { Abotondel7.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { Abotondel7.setBackground(new Color(77, 77, 77)); }
		    });
		Abotondel7.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	AinsertarNumeroEnTextField("7");
		    }
		});
		
		Abotondel8 = new JButton("8");
		Abotondel8.setForeground(Color.WHITE);
		Abotondel8.setFont(new Font("Arial", Font.BOLD, 24));
		Abotondel8.setBackground(new Color(77, 77, 77));
		Abotondel8.setBounds(262, 388, 50, 50);
		Abotondel8.setBorder(BorderFactory.createLineBorder(new Color(255, 128, 0), 2)); //------------borde narnja---------
		contentPane.add(Abotondel8);
		Abotondel8.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { Abotondel8.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { Abotondel8.setBackground(new Color(77, 77, 77)); }
		    });
		Abotondel8.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	AinsertarNumeroEnTextField("8");
		    }
		});
		
		Abotondel9 = new JButton("9");
		Abotondel9.setForeground(Color.WHITE);
		Abotondel9.setFont(new Font("Arial", Font.BOLD, 24));
		Abotondel9.setBackground(new Color(77, 77, 77));
		Abotondel9.setBounds(322, 388, 50, 50);
		Abotondel9.setBorder(BorderFactory.createLineBorder(new Color(255, 128, 0), 2)); //------------borde narnja---------
		contentPane.add(Abotondel9);
		Abotondel9.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { Abotondel9.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { Abotondel9.setBackground(new Color(77, 77, 77)); }
		    });
		Abotondel9.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	AinsertarNumeroEnTextField("9");
		    }
		});
		
		Abotondel0 = new JButton("0");
		Abotondel0.setForeground(Color.WHITE);
		Abotondel0.setFont(new Font("Arial", Font.BOLD, 24));
		Abotondel0.setBackground(new Color(77, 77, 77));
		Abotondel0.setBounds(322, 447, 50, 89);
		Abotondel0.setBorder(BorderFactory.createLineBorder(new Color(255, 128, 0), 2));//------------borde narnja---------
		contentPane.add(Abotondel0);
		Abotondel0.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { Abotondel0.setBackground(new Color(100, 100, 100)); }
		    @Override public void mouseExited(MouseEvent e) { Abotondel0.setBackground(new Color(77, 77, 77)); }
		    });
		Abotondel0.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	AinsertarNumeroEnTextField("0");
		    }
		});
		
		
		
		JButton ce = new JButton("C");
		ce.setBounds(70, 449, 242, 87);
		contentPane.add(ce);
		ce.setForeground(new Color(255, 255, 255));
		ce.setFont(new Font("Arial", Font.BOLD, 30));
		ce.setBackground(new Color(0, 150, 225));
		ce.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { ce.setBackground(new Color(30, 180, 255)); }
		    @Override public void mouseExited(MouseEvent e) { ce.setBackground(new Color(0, 150, 225)); }
		    @Override public void mouseClicked(MouseEvent e) {
		for(int x = 0 ; x < f ; x ++)
		{
			for(int y = 0 ; y < c ; y ++)
			{
				matriz1[x][y]=0;
				matriz2[x][y]=0;
			}
		}
		ceroycero.setText(null);
		ceroyuno.setText(null);
		ceroydos.setText(null);
		ceroytres.setText(null);
		unoycero.setText(null);
		unoyuno.setText(null);
		unoydos.setText(null);
		unoytres.setText(null);
		dosycero.setText(null);
		dosyuno.setText(null);
		dosydos.setText(null);
		dosytres.setText(null);
		tresycero.setText(null);
		tresyuno.setText(null);
		tresydos.setText(null);
		tresytres.setText(null);
		
		Aceroycero.setText(null);
		Aceroyuno.setText(null);
		Aceroydos.setText(null);
		Aceroytres.setText(null);
		Aunoycero.setText(null);
		Aunoyuno.setText(null);
		Aunoydos.setText(null);
		Aunoytres.setText(null);
		Adosycero.setText(null);
		Adosyuno.setText(null);
		Adosydos.setText(null);
		Adosytres.setText(null);
		Atresycero.setText(null);
		Atresyuno.setText(null);
		Atresydos.setText(null);
		Atresytres.setText(null);
		}
		});
	

        
		JButton suma = new JButton("+");
		suma.setBounds(516, 373, 60, 152);
		contentPane.add(suma);
		suma.setFont(new Font("Arial", Font.BOLD, 24));
		suma.setForeground(new Color(255, 255, 255));
		suma.setBackground(new Color(0, 220, 235));
		suma.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { suma.setBackground(new Color(30, 250, 255)); }
		    @Override public void mouseExited(MouseEvent e) { suma.setBackground(new Color(0, 220, 235)); }
		    @Override public void mouseClicked(MouseEvent e) {
		    	flagsuma=1;
		    	flagresta=0;
		    	flagdivision=0;
		    	flagmultiplicacion=0;
		    	flaginversa=0;
		    	flagdeterminante=0;
		    	flagproductoescalar=0;
		         }
		 });
		
		JButton resta = new JButton("-");
		resta.setBounds(447, 373, 60, 152);
		contentPane.add(resta);
		resta.setFont(new Font("Arial", Font.BOLD, 35));
		resta.setForeground(new Color(255, 255, 255));
		resta.setBackground(new Color(0, 220, 235));
		resta.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { resta.setBackground(new Color(30, 250, 255)); }
		    @Override public void mouseExited(MouseEvent e) { resta.setBackground(new Color(0, 220, 235)); }
		    @Override public void mouseClicked(MouseEvent e) {
		    	flagsuma=0;
		    	flagresta=1;
		    	flagdivision=0;
		    	flagmultiplicacion=0;
		    	flaginversa=0;
		    	flagdeterminante=0;
		    	flagproductoescalar=0;
		}
		});
		
		JButton multiplicar = new JButton("x");
		multiplicar.setBounds(447, 217, 129, 71);
		contentPane.add(multiplicar);
		multiplicar.setFont(new Font("Arial", Font.BOLD, 24));
		multiplicar.setForeground(new Color(255, 255, 255));
		multiplicar.setBackground(new Color(0, 220, 235));
		multiplicar.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { multiplicar.setBackground(new Color(30, 250, 255)); }
		    @Override public void mouseExited(MouseEvent e) { multiplicar.setBackground(new Color(0, 220, 235)); }
		    @Override public void mouseClicked(MouseEvent e) {
		    	flagsuma=0;
		    	flagresta=0;
		    	flagdivision=0;
		    	flagmultiplicacion=1;
		    	flaginversa=0;
		    	flagdeterminante=0;
		    	flagproductoescalar=0;
		}
		});
		
		
		
		JButton dividir = new JButton("%");
		dividir.setBounds(447, 295, 129, 71);
		contentPane.add(dividir);
		dividir.setFont(new Font("Arial", Font.BOLD, 24));
		dividir.setForeground(new Color(255, 255, 255));
		dividir.setBackground(new Color(0, 220, 235));
		dividir.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { dividir.setBackground(new Color(30, 250, 255)); }
		    @Override public void mouseExited(MouseEvent e) { dividir.setBackground(new Color(0, 220, 235)); }
		    @Override public void mouseClicked(MouseEvent e) {
		    	flagsuma=0;
		    	flagresta=0;
		    	flagdivision=1;
		    	flagmultiplicacion=0;
		    	flaginversa=0;
		    	flagdeterminante=0;
		    	flagproductoescalar=0;
		    }
		});
		
		JButton multesc = new JButton("(λ)");
		multesc.setBounds(382, 217, 55, 110);
		contentPane.add(multesc);
		multesc.setFont(new Font("Arial", Font.BOLD, 18));
		multesc.setForeground(new Color(255, 255, 255));
		multesc.setBackground(new Color(0, 220, 235));
		multesc.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { multesc.setBackground(new Color(30, 250, 255)); }
		    @Override public void mouseExited(MouseEvent e) { multesc.setBackground(new Color(0, 220, 235)); }
		    @Override public void mouseClicked(MouseEvent e) {
		    	flagsuma=0;
		    	flagresta=0;
		    	flagdivision=0;
		    	flagmultiplicacion=0;
		    	flaginversa=0;
		    	flagdeterminante=0;
		    	flagproductoescalar=1;
		    }
		});
		
		
		
		JButton inversa = new JButton("Inv");
		inversa.setBounds(382, 339, 55, 110);
		contentPane.add(inversa);
		inversa.setFont(new Font("Arial", Font.BOLD, 14));
		inversa.setForeground(new Color(255, 255, 255));
		inversa.setBackground(new Color(0, 220, 235));
		inversa.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { inversa.setBackground(new Color(30, 250, 255)); }
		    @Override public void mouseExited(MouseEvent e) { inversa.setBackground(new Color(0, 220, 235)); }
		    @Override public void mouseClicked(MouseEvent e) { 
		    	flagsuma=0;
		    	flagresta=0;
		    	flagdivision=0;
		    	flagmultiplicacion=0;
		    	flaginversa=1;
		    	flagdeterminante=0;
		    	flagproductoescalar=0;
		    }
		});
		
		JButton determinante = new JButton("Det");
		determinante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		determinante.setBounds(382, 460, 55, 110);
		contentPane.add(determinante);
		determinante.setFont(new Font("Arial", Font.BOLD, 13));
		determinante.setForeground(new Color(255, 255, 255));
		determinante.setBackground(new Color(0, 220, 235));
		determinante.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { determinante.setBackground(new Color(30, 250, 255)); }
		    @Override public void mouseExited(MouseEvent e) { determinante.setBackground(new Color(0, 220, 235)); }
		    @Override public void mouseClicked(MouseEvent e) { 
		    	flagsuma=0;
		    	flagresta=0;
		    	flagdivision=0;
		    	flagmultiplicacion=0;
		    	flaginversa=0;
		    	flagdeterminante=1;
		    	flagproductoescalar=0;
		    	}
		});

















		
		JButton igual = new JButton("=");
        igual.setBounds(447, 532, 129, 38);
        contentPane.add(igual);
        igual.setFont(new Font("Arial", Font.BOLD, 24));
		igual.setForeground(new Color(255, 255, 255));
		igual.setBackground(new Color(0, 150, 225));
		igual.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { igual.setBackground(new Color(30, 180, 255)); }
		    @Override public void mouseExited(MouseEvent e) { igual.setBackground(new Color(0, 150, 225)); }
		    @Override public void mouseClicked(MouseEvent e) {
		    	
		    	if(c==2 && f==2)
		    	{
		    		String posceroycero = ceroycero.getText();
					int valorceroycero = Integer.parseInt(posceroycero);
					matriz1[0][0] = valorceroycero;
					String posceroyuno = ceroyuno.getText();
					int valorceroyuno = Integer.parseInt(posceroyuno);
					matriz1[0][1] = valorceroyuno;
					
					String posunoycero= unoycero.getText();
					int valorunoycero = Integer.parseInt(posunoycero);
					matriz1[1][0] = valorunoycero;
					String posunoyuno= unoyuno.getText();
					int valorunoyuno = Integer.parseInt(posunoyuno);
					matriz1[1][1] = valorunoyuno;
					
					
					String Aposceroycero = Aceroycero.getText();
					int Avalorceroycero = Integer.parseInt(Aposceroycero);
					matriz2[0][0] = Avalorceroycero;
					String Aposceroyuno = Aceroyuno.getText();
					int Avalorceroyuno = Integer.parseInt(Aposceroyuno);
					matriz2[0][1] = Avalorceroyuno;
					
					String Aposunoycero= Aunoycero.getText();
					int Avalorunoycero = Integer.parseInt(Aposunoycero);
					matriz2[1][0] = Avalorunoycero;
					String Aposunoyuno= Aunoyuno.getText();
					int Avalorunoyuno = Integer.parseInt(Aposunoyuno);
					matriz2[1][1] = Avalorunoyuno;
		    	}
		    	if(c==3 && f==3)
		    	{
		    		String posceroycero = ceroycero.getText();
					int valorceroycero = Integer.parseInt(posceroycero);
					matriz1[0][0] = valorceroycero;
					String posceroyuno = ceroyuno.getText();
					int valorceroyuno = Integer.parseInt(posceroyuno);
					matriz1[0][1] = valorceroyuno;
					String posceroydos = ceroydos.getText();
					int valorceroydos = Integer.parseInt(posceroydos);
					matriz1[0][2] = valorceroydos;
					
					String posunoycero= unoycero.getText();
					int valorunoycero = Integer.parseInt(posunoycero);
					matriz1[1][0] = valorunoycero;
					String posunoyuno= unoyuno.getText();
					int valorunoyuno = Integer.parseInt(posunoyuno);
					matriz1[1][1] = valorunoyuno;
					String posunoydos= unoydos.getText();
					int valorunoydos = Integer.parseInt(posunoydos);
					matriz1[1][2] = valorunoydos;
					
					String posdosycero= dosycero.getText();
					int valordosycero = Integer.parseInt(posdosycero);
					matriz1[2][0] = valordosycero;
					String posdosyuno= dosyuno.getText();
					int valordosyuno = Integer.parseInt(posdosyuno);
					matriz1[2][1] = valordosyuno;
					String posdosydos= dosydos.getText();
					int valordosydos = Integer.parseInt(posdosydos);
					matriz1[2][2] = valordosydos;
					
					
		    		String Aposceroycero = Aceroycero.getText();
					int Avalorceroycero = Integer.parseInt(Aposceroycero);
					matriz2[0][0] = Avalorceroycero;
					String Aposceroyuno = Aceroyuno.getText();
					int Avalorceroyuno = Integer.parseInt(Aposceroyuno);
					matriz2[0][1] = Avalorceroyuno;
					String Aposceroydos = Aceroydos.getText();
					int Avalorceroydos = Integer.parseInt(Aposceroydos);
					matriz2[0][2] = Avalorceroydos;
					
					String Aposunoycero= Aunoycero.getText();
					int Avalorunoycero = Integer.parseInt(Aposunoycero);
					matriz2[1][0] = Avalorunoycero;
					String Aposunoyuno= Aunoyuno.getText();
					int Avalorunoyuno = Integer.parseInt(Aposunoyuno);
					matriz2[1][1] = Avalorunoyuno;
					String Aposunoydos= Aunoydos.getText();
					int Avalorunoydos = Integer.parseInt(Aposunoydos);
					matriz2[1][2] = Avalorunoydos;
					
					String Aposdosycero= Adosycero.getText();
					int Avalordosycero = Integer.parseInt(Aposdosycero);
					matriz2[2][0] = Avalordosycero;
					String Aposdosyuno= Adosyuno.getText();
					int Avalordosyuno = Integer.parseInt(Aposdosyuno);
					matriz2[2][1] = Avalordosyuno;
					String Aposdosydos= Adosydos.getText();
					int Avalordosydos = Integer.parseInt(Aposdosydos);
					matriz2[2][2] = Avalordosydos;
		    	}
		    	if(c==4 && f==4)
		    	{
		    		String posceroycero = ceroycero.getText();
					int valorceroycero = Integer.parseInt(posceroycero);
					matriz1[0][0] = valorceroycero;
					String posceroyuno = ceroyuno.getText();
					int valorceroyuno = Integer.parseInt(posceroyuno);
					matriz1[0][1] = valorceroyuno;
					String posceroydos = ceroydos.getText();
					int valorceroydos = Integer.parseInt(posceroydos);
					matriz1[0][2] = valorceroydos;
					
					String posceroytres = ceroytres.getText();
					int valorceroytres = Integer.parseInt(posceroytres);
					matriz1[0][3] = valorceroytres;
					
					String posunoycero= unoycero.getText();
					int valorunoycero = Integer.parseInt(posunoycero);
					matriz1[1][0] = valorunoycero;
					String posunoyuno= unoyuno.getText();
					int valorunoyuno = Integer.parseInt(posunoyuno);
					matriz1[1][1] = valorunoyuno;
					String posunoydos= unoydos.getText();
					int valorunoydos = Integer.parseInt(posunoydos);
					matriz1[1][2] = valorunoydos;
					String posunoytres= unoytres.getText();
					int valorunoytres = Integer.parseInt(posunoytres);
					matriz1[1][3] = valorunoytres;
					
					String posdosycero= dosycero.getText();
					int valordosycero = Integer.parseInt(posdosycero);
					matriz1[2][0] = valordosycero;
					String posdosyuno= dosyuno.getText();
					int valordosyuno = Integer.parseInt(posdosyuno);
					matriz1[2][1] = valordosyuno;
					String posdosydos= dosydos.getText();
					int valordosydos = Integer.parseInt(posdosydos);
					matriz1[2][2] = valordosydos;
					String posdosytres= dosytres.getText();
					int valordosytres = Integer.parseInt(posdosytres);
					matriz1[2][3] = valordosytres;
					
					String postresycero= tresycero.getText();
					int valortresycero = Integer.parseInt(postresycero);
					matriz1[3][0] = valortresycero;
					String postresyuno= tresyuno.getText();
					int valortresyuno = Integer.parseInt(postresyuno);
					matriz1[3][1] = valortresyuno;
					String postresydos= tresydos.getText();
					int valortresydos = Integer.parseInt(postresydos);
					matriz1[3][2] = valortresydos;
					String postresytres= tresytres.getText();
					int valortresytres = Integer.parseInt(postresytres);
					matriz1[3][3] = valortresytres;
					
					
					String Aposceroycero = Aceroycero.getText();
					int Avalorceroycero = Integer.parseInt(Aposceroycero);
					matriz2[0][0] = Avalorceroycero;
					String Aposceroyuno = Aceroyuno.getText();
					int Avalorceroyuno = Integer.parseInt(Aposceroyuno);
					matriz2[0][1] = Avalorceroyuno;
					String Aposceroydos = Aceroydos.getText();
					int Avalorceroydos = Integer.parseInt(Aposceroydos);
					matriz2[0][2] = Avalorceroydos;
					String Aposceroytres = Aceroytres.getText();
					int Avalorceroytres = Integer.parseInt(Aposceroytres);
					matriz2[0][3] = Avalorceroytres;
					
					String Aposunoycero= Aunoycero.getText();
					int Avalorunoycero = Integer.parseInt(Aposunoycero);
					matriz2[1][0] = Avalorunoycero;
					String Aposunoyuno= Aunoyuno.getText();
					int Avalorunoyuno = Integer.parseInt(Aposunoyuno);
					matriz2[1][1] = Avalorunoyuno;
					String Aposunoydos= Aunoydos.getText();
					int Avalorunoydos = Integer.parseInt(Aposunoydos);
					matriz2[1][2] = Avalorunoydos;
					String Aposunoytres= Aunoytres.getText();
					int Avalorunoytres = Integer.parseInt(Aposunoytres);
					matriz2[1][3] = Avalorunoytres;
					
					String Aposdosycero= Adosycero.getText();
					int Avalordosycero = Integer.parseInt(Aposdosycero);
					matriz2[2][0] = Avalordosycero;
					String Aposdosyuno= Adosyuno.getText();
					int Avalordosyuno = Integer.parseInt(Aposdosyuno);
					matriz2[2][1] = Avalordosyuno;
					String Aposdosydos= Adosydos.getText();
					int Avalordosydos = Integer.parseInt(Aposdosydos);
					matriz2[2][2] = Avalordosydos;
					String Aposdosytres= Adosytres.getText();
					int Avalordosytres = Integer.parseInt(Aposdosytres);
					matriz2[2][3] = Avalordosytres;
					
					String Apostresycero= Atresycero.getText();
					int Avalortresycero = Integer.parseInt(Apostresycero);
					matriz2[3][0] = Avalortresycero;
					String Apostresyuno= Atresyuno.getText();
					int Avalortresyuno = Integer.parseInt(Apostresyuno);
					matriz2[3][1] = Avalortresyuno;
					String Apostresydos= Atresydos.getText();
					int Avalortresydos = Integer.parseInt(Apostresydos);
					matriz2[3][2] = Avalortresydos;
					String Apostresytres= Atresytres.getText();
					int Avalortresytres = Integer.parseInt(Apostresytres);
					matriz2[3][3] = Avalortresytres;
		    	}
				
		    	if(flagsuma==1)
		    	{
		    		for (int x = 0; x < f; x++) {
			             for (int y = 0; y < c; y++) {
			                 matriz3[x][y] = matriz1[x][y] + matriz2[x][y];
			             }
			         }
		    		flagsuma=0;

			    	  StringBuilder sb = new StringBuilder();
			          for (int x = 0; x < f; x++) {
			              for (int y = 0; y < c; y++) {
			                  sb.append(matriz3[x][y]).append("       ");
			              }
			              sb.append("\n");
			          }
			          mat3.setText(sb.toString());
			          for(int x = 0 ; x < f ; x ++)
			  		{
			  			for(int y = 0 ; y < c ; y ++)
			  			{
			  				matriz3[x][y]=0;
			  			}
			  		}
		    	}
		    	if(flagresta==1)
		    	{
		    		for(int x = 0 ; x < f ; x ++)
		    		{
		    			for(int y = 0 ; y < c ; y ++)
		    			{
		    				matriz3[x][y]=matriz1[x][y]-matriz2[x][y];
		    			}
		    		}
		    		flagresta=0;
		    		StringBuilder sb = new StringBuilder();
			          for (int x = 0; x < f; x++) {
			              for (int y = 0; y < c; y++) {
			                  sb.append(matriz3[x][y]).append("       ");
			              }
			              sb.append("\n");
			          }
			          mat3.setText(sb.toString());
			          for(int x = 0 ; x < f ; x ++)
			  		{
			  			for(int y = 0 ; y < c ; y ++)
			  			{
			  				matriz3[x][y]=0;
			  			}
			  		}
		    	}
		    	if(flagmultiplicacion==1)
		    	{
		    		for(int x = 0 ; x < f ; x ++)
		    		{
		    			for(int y = 0 ; y < c ; y ++)
		    			{
		    				matriz3[x][y]+=matriz1[x][y]*matriz2[x][y];
		    			}
		    		}
		    		flagmultiplicacion=0;
		    		StringBuilder sb = new StringBuilder();
			          for (int x = 0; x < f; x++) {
			              for (int y = 0; y < c; y++) {
			                  sb.append(matriz3[x][y]).append("       ");
			              }
			              sb.append("\n");
			          }
			          mat3.setText(sb.toString());
			          for(int x = 0 ; x < f ; x ++)
			  		{
			  			for(int y = 0 ; y < c ; y ++)
			  			{
			  				matriz3[x][y]=0;
			  			}
			  		}
		    	}
		    	if(flagdeterminante==1)
		    	{
		    		determinante();
		    		flagdeterminante=0;
		    	}
		    	if(flaginversa==1)
		    	{
		    		inversa();
		    		flaginversa=0;
		    	}
		    	if(flagproductoescalar==1)
		    	{
		    		productoescalar();
		    		flagproductoescalar=0;
		    	}
		    	if(flagdivision==1)
		    	{
		    		division();
		    		flagdivision=0;
		    	}
		     }
		 });
		
		
		//---------CERO
		ceroycero = new JTextField();
		ceroycero.setBounds(10, 22, 35, 38);
		contentPane.add(ceroycero);
		ceroycero.setColumns(10);
		ceroycero.setEditable(false);
		ceroycero.setBackground(new Color(200, 0, 0));
		textFieldEnUso = ceroycero;
		
		ceroyuno = new JTextField();
		ceroyuno.setColumns(10);
		ceroyuno.setBounds(55, 22, 35, 38);
		contentPane.add(ceroyuno);
		ceroyuno.setEditable(false);
				
		ceroydos = new JTextField();
		ceroydos.setColumns(10);
		ceroydos.setBounds(100, 22, 35, 38);
		contentPane.add(ceroydos);
		ceroydos.setEditable(false);
		
	
		ceroytres = new JTextField();
		ceroytres.setColumns(10);
		ceroytres.setBounds(145, 22, 35, 38);
		contentPane.add(ceroytres);
		ceroytres.setEditable(false); 
		
		//---------UNO
		unoycero = new JTextField();
		unoycero.setColumns(10);
		unoycero.setBounds(10, 71, 35, 38);
		contentPane.add(unoycero);
		unoycero.setEditable(false); 
		
		unoyuno = new JTextField();
		unoyuno.setColumns(10);
		unoyuno.setBounds(55, 71, 35, 38);
		contentPane.add(unoyuno);
		unoyuno.setEditable(false);
		
		unoydos = new JTextField();
		unoydos.setColumns(10);
		unoydos.setBounds(100, 71, 35, 38);
		contentPane.add(unoydos);
		unoydos.setEditable(false);
	
		unoytres = new JTextField();
		unoytres.setColumns(10);
		unoytres.setBounds(145, 71, 35, 38);
		contentPane.add(unoytres);
		unoytres.setEditable(false);
		
		//---------DOS
		dosycero = new JTextField();
		dosycero.setColumns(10);
		dosycero.setBounds(10, 120, 35, 38);
		contentPane.add(dosycero);
		dosycero.setEditable(false);
		
		dosyuno = new JTextField();
		dosyuno.setColumns(10);
		dosyuno.setBounds(55, 120, 35, 38);
		contentPane.add(dosyuno);
		dosyuno.setEditable(false);
		
		dosydos = new JTextField();
		dosydos.setColumns(10);
		dosydos.setBounds(100, 120, 35, 38);
		dosydos.setEditable(false);
		contentPane.add(dosydos);
		
		dosytres = new JTextField();
		dosytres.setColumns(10);
		dosytres.setBounds(145, 120, 35, 38);
		contentPane.add(dosytres);
		dosytres.setEditable(false);
		
		//---------TRES
		tresycero = new JTextField();
		tresycero.setColumns(10);
		tresycero.setBounds(10, 169, 35, 38);
		contentPane.add(tresycero);
		tresycero.setEditable(false);
		
		tresyuno = new JTextField();
		tresyuno.setColumns(10);
		tresyuno.setBounds(55, 169, 35, 38);
		contentPane.add(tresyuno);
		tresyuno.setEditable(false);
		
		tresydos = new JTextField();
		tresydos.setColumns(10);
		tresydos.setBounds(100, 169, 35, 38);
		contentPane.add(tresydos);
		tresydos.setEditable(false);
		
		tresytres = new JTextField();
		tresytres.setColumns(10);
		tresytres.setBounds(145, 169, 35, 38);
		contentPane.add(tresytres);
		tresytres.setEditable(false);
		
		//---------ACERO
				Aceroycero = new JTextField();
				Aceroycero.setEditable(false);
				Aceroycero.setColumns(10);
				Aceroycero.setBounds(232, 22, 35, 38);
				Aceroycero.setBackground(new Color(255, 128, 0));
				contentPane.add(Aceroycero);
				AtextFieldEnUso = Aceroycero;
				
				Aceroyuno = new JTextField();
				Aceroyuno.setEditable(false);
				Aceroyuno.setColumns(10);
				Aceroyuno.setBounds(277, 22, 35, 38);
				contentPane.add(Aceroyuno);
				
				Aceroydos = new JTextField();
				Aceroydos.setEditable(false);
				Aceroydos.setColumns(10);
				Aceroydos.setBounds(319, 22, 35, 38);
				contentPane.add(Aceroydos);
				
				Aceroytres = new JTextField();
				Aceroytres.setEditable(false);
				Aceroytres.setColumns(10);
				Aceroytres.setBounds(364, 22, 35, 38);
				contentPane.add(Aceroytres);
				
				//---------AUNO
				Aunoycero = new JTextField();
				Aunoycero.setEditable(false);
				Aunoycero.setColumns(10);
				Aunoycero.setBounds(232, 71, 35, 38);
				contentPane.add(Aunoycero);
				
				Aunoyuno = new JTextField();
				Aunoyuno.setEditable(false);
				Aunoyuno.setColumns(10);
				Aunoyuno.setBounds(277, 71, 35, 38);
				contentPane.add(Aunoyuno);
				
				Aunoydos = new JTextField();
				Aunoydos.setEditable(false);
				Aunoydos.setColumns(10);
				Aunoydos.setBounds(319, 71, 35, 38);
				contentPane.add(Aunoydos);
				
				Aunoytres = new JTextField();
				Aunoytres.setEditable(false);
				Aunoytres.setColumns(10);
				Aunoytres.setBounds(364, 71, 35, 38);
				contentPane.add(Aunoytres);
				
				//---------ADOS
				Adosycero = new JTextField();
				Adosycero.setEditable(false);
				Adosycero.setColumns(10);
				Adosycero.setBounds(232, 120, 35, 38);
				contentPane.add(Adosycero);
				
				Adosyuno = new JTextField();
				Adosyuno.setEditable(false);
				Adosyuno.setColumns(10);
				Adosyuno.setBounds(277, 120, 35, 38);
				contentPane.add(Adosyuno);
				
				Adosydos = new JTextField();
				Adosydos.setEditable(false);
				Adosydos.setColumns(10);
				Adosydos.setBounds(319, 120, 35, 38);
				contentPane.add(Adosydos);
				
				Adosytres = new JTextField();
				Adosytres.setEditable(false);
				Adosytres.setColumns(10);
				Adosytres.setBounds(364, 120, 35, 38);
				contentPane.add(Adosytres);
				
				//---------ATRES
				Atresycero = new JTextField();
				Atresycero.setEditable(false);
				Atresycero.setColumns(10);
				Atresycero.setBounds(232, 169, 35, 38);
				contentPane.add(Atresycero);
				
				Atresyuno = new JTextField();
				Atresyuno.setEditable(false);
				Atresyuno.setColumns(10);
				Atresyuno.setBounds(277, 169, 35, 38);
				contentPane.add(Atresyuno);
				
				Atresydos = new JTextField();
				Atresydos.setEditable(false);
				Atresydos.setColumns(10);
				Atresydos.setBounds(319, 168, 35, 38);
				contentPane.add(Atresydos);
				
				Atresytres = new JTextField();
				Atresytres.setEditable(false);
				Atresytres.setColumns(10);
				Atresytres.setBounds(364, 169, 35, 38);
				contentPane.add(Atresytres);
				
				
				
		
		JButton flechaderecha = new JButton("mat1→");
		flechaderecha.setFont(new Font("Impact", Font.PLAIN, 23));
		flechaderecha.setBounds(382, 581, 94, 71);
		flechaderecha.setForeground(Color.WHITE);
		flechaderecha.setBackground(new Color(200, 0, 0));
		flechaderecha.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		contentPane.add(flechaderecha);
		flechaderecha.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { flechaderecha.setBackground(new Color(170, 0, 0)); }
		    @Override public void mouseExited(MouseEvent e) { flechaderecha.setBackground(new Color(200, 0, 0)); }
		});
		flechaderecha.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if(f==4 && c==4)
		    	{
		    		if (textFieldEnUso == ceroycero) {
			            textFieldEnUso = ceroyuno;
			            ceroycero.setBackground(new Color(255, 255, 255));//------------fondo blancomat1---------
			            ceroyuno.setBackground(new Color(200, 0, 0));//------------fondo rojomat1---------
			        } else if (textFieldEnUso == ceroyuno) {
			            textFieldEnUso = ceroydos;
			            ceroyuno.setBackground(new Color(255, 255, 255));
			            ceroydos.setBackground(new Color(200, 0, 0));
			        } else if (textFieldEnUso == ceroydos) {
			            textFieldEnUso = ceroytres;
			            ceroydos.setBackground(new Color(255, 255, 255));
			            ceroytres.setBackground(new Color(200, 0, 0));
			        } else if (textFieldEnUso == ceroytres) {
			        	textFieldEnUso = unoycero;
			            ceroytres.setBackground(new Color(255, 255, 255));
			            unoycero.setBackground(new Color(200, 0, 0));
			        } else if (textFieldEnUso == unoycero) {
			        	textFieldEnUso = unoyuno;
			            unoycero.setBackground(new Color(255, 255, 255));
			            unoyuno.setBackground(new Color(200, 0, 0));
			        } else if (textFieldEnUso == unoyuno) {
			        	textFieldEnUso = unoydos;
			            unoyuno.setBackground(new Color(255, 255, 255));
			            unoydos.setBackground(new Color(200, 0, 0));
			        } else if (textFieldEnUso == unoydos) {
			        	textFieldEnUso = unoytres;
			            unoydos.setBackground(new Color(255, 255, 255));
			            unoytres.setBackground(new Color(200, 0, 0));
			        } else if (textFieldEnUso == unoytres) {
			        	textFieldEnUso = dosycero;
			            unoytres.setBackground(new Color(255, 255, 255));
			            dosycero.setBackground(new Color(200, 0, 0));
			        } else if (textFieldEnUso == dosycero) {
			        	textFieldEnUso = dosyuno;
			            dosycero.setBackground(new Color(255, 255, 255));
			            dosyuno.setBackground(new Color(200, 0, 0));
			        } else if (textFieldEnUso == dosyuno) {
			        	textFieldEnUso = dosydos;
			            dosyuno.setBackground(new Color(255, 255, 255));
			            dosydos.setBackground(new Color(200, 0, 0));
			        } else if (textFieldEnUso == dosydos) {
			        	textFieldEnUso = dosytres;
			            dosydos.setBackground(new Color(255, 255, 255));
			            dosytres.setBackground(new Color(200, 0, 0));
			        } else if (textFieldEnUso == dosytres) {
			        	textFieldEnUso = tresycero;
			            dosytres.setBackground(new Color(255, 255, 255));
			            tresycero.setBackground(new Color(200, 0, 0));
			        } else if (textFieldEnUso == tresycero) {
			        	textFieldEnUso = tresyuno;
			            tresycero.setBackground(new Color(255, 255, 255));
			            tresyuno.setBackground(new Color(200, 0, 0));
			        } else if (textFieldEnUso == tresyuno) {
			        	textFieldEnUso = tresydos;
			            tresyuno.setBackground(new Color(255, 255, 255));
			            tresydos.setBackground(new Color(200, 0, 0));
			        } else if (textFieldEnUso == tresydos) {
			        	textFieldEnUso = tresytres;
			            tresydos.setBackground(new Color(255, 255, 255));
			            tresytres.setBackground(new Color(200, 0, 0));
			        } else if (textFieldEnUso == tresytres) {
			        	textFieldEnUso = ceroycero;
			            tresytres.setBackground(new Color(255, 255, 255));
			            ceroycero.setBackground(new Color(200, 0, 0));
			        }
		    	}
			        if(f==3 && c==3)
			    	{
			    		if (textFieldEnUso == ceroycero) {
				            textFieldEnUso = ceroyuno;
				            ceroycero.setBackground(new Color(255, 255, 255));
				            ceroyuno.setBackground(new Color(200, 0, 0));
				        } else if (textFieldEnUso == ceroyuno) {
				            textFieldEnUso = ceroydos;
				            ceroyuno.setBackground(new Color(255, 255, 255));
				            ceroydos.setBackground(new Color(200, 0, 0));
				        } else if (textFieldEnUso == ceroydos) {
				            textFieldEnUso = unoycero;
				            ceroydos.setBackground(new Color(255, 255, 255));
				            unoycero.setBackground(new Color(200, 0, 0));
				        } else if (textFieldEnUso == unoycero) {
				        	textFieldEnUso = unoyuno;
				            unoycero.setBackground(new Color(255, 255, 255));
				            unoyuno.setBackground(new Color(200, 0, 0));
				        } else if (textFieldEnUso == unoyuno) {
				        	textFieldEnUso = unoydos;
				            unoyuno.setBackground(new Color(255, 255, 255));
				            unoydos.setBackground(new Color(200, 0, 0));
				        } else if (textFieldEnUso == unoydos) {
				        	textFieldEnUso = dosycero;
				            unoydos.setBackground(new Color(255, 255, 255));
				            dosycero.setBackground(new Color(200, 0, 0));
				        } else if (textFieldEnUso == dosycero) {
				        	textFieldEnUso = dosyuno;
				            dosycero.setBackground(new Color(255, 255, 255));
				            dosyuno.setBackground(new Color(200, 0, 0));
				        } else if (textFieldEnUso == dosyuno) {
				        	textFieldEnUso = dosydos;
				            dosyuno.setBackground(new Color(255, 255, 255));
				            dosydos.setBackground(new Color(200, 0, 0));
				        } else if (textFieldEnUso == dosydos) {
				        	textFieldEnUso = ceroycero;
				            dosydos.setBackground(new Color(255, 255, 255));
				            ceroycero.setBackground(new Color(200, 0, 0));
				        }
			    	}
			        if(f==2 && c==2)
			    	{
			    		if (textFieldEnUso == ceroycero) {
				            textFieldEnUso = ceroyuno;
				            ceroycero.setBackground(new Color(255, 255, 255));
				            ceroyuno.setBackground(new Color(200, 0, 0));
				        } else if (textFieldEnUso == ceroyuno) {
				            textFieldEnUso = unoycero;
				            ceroyuno.setBackground(new Color(255, 255, 255));
				            unoycero.setBackground(new Color(200, 0, 0));
				        } else if (textFieldEnUso == unoycero) {
				        	textFieldEnUso = unoyuno;
				            unoycero.setBackground(new Color(255, 255, 255));
				            unoyuno.setBackground(new Color(200, 0, 0));
				        }  else if (textFieldEnUso == unoyuno) {
				        	textFieldEnUso = ceroycero;
				            unoyuno.setBackground(new Color(255, 255, 255));
				            ceroycero.setBackground(new Color(200, 0, 0));
				        } 
			    	}
		    	
		    }
		    	
		});
		
		Aflechaderecha = new JButton("mat2→");
		Aflechaderecha.setForeground(Color.WHITE);
		Aflechaderecha.setFont(new Font("Impact", Font.PLAIN, 23));
		Aflechaderecha.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		Aflechaderecha.setBackground(new Color(255, 128, 0));
		Aflechaderecha.setBounds(482, 581, 94, 71);
		contentPane.add(Aflechaderecha);
		Aflechaderecha.addMouseListener(new MouseAdapter() {
		    @Override public void mouseEntered(MouseEvent e) { Aflechaderecha.setBackground(new Color(255, 100, 0)); }
		    @Override public void mouseExited(MouseEvent e) { Aflechaderecha.setBackground(new Color(255, 128, 0)); }
		});
		Aflechaderecha.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if(f==4 && c==4)
		    	{
		    		if (AtextFieldEnUso == Aceroycero) {
		    		    AtextFieldEnUso = Aceroyuno;
		    		    Aceroycero.setBackground(new Color(255, 255, 255));//------------fondo blancomat2---------
		    		    Aceroyuno.setBackground(new Color(255, 128, 0));//------------fondo rojomat2---------
		    		} else if (AtextFieldEnUso == Aceroyuno) {
		    		    AtextFieldEnUso = Aceroydos;
		    		    Aceroyuno.setBackground(new Color(255, 255, 255));
		    		    Aceroydos.setBackground(new Color(255, 128, 0));
		    		} else if (AtextFieldEnUso == Aceroydos) {
		    		    AtextFieldEnUso = Aceroytres;
		    		    Aceroydos.setBackground(new Color(255, 255, 255));
		    		    Aceroytres.setBackground(new Color(255, 128, 0));
		    		} else if (AtextFieldEnUso == Aceroytres) {
		    		    AtextFieldEnUso = Aunoycero;
		    		    Aceroytres.setBackground(new Color(255, 255, 255));
		    		    Aunoycero.setBackground(new Color(255, 128, 0));
		    		} else if (AtextFieldEnUso == Aunoycero) {
		    		    AtextFieldEnUso = Aunoyuno;
		    		    Aunoycero.setBackground(new Color(255, 255, 255));
		    		    Aunoyuno.setBackground(new Color(255, 128, 0));
		    		} else if (AtextFieldEnUso == Aunoyuno) {
		    		    AtextFieldEnUso = Aunoydos;
		    		    Aunoyuno.setBackground(new Color(255, 255, 255));
		    		    Aunoydos.setBackground(new Color(255, 128, 0));
		    		} else if (AtextFieldEnUso == Aunoydos) {
		    		    AtextFieldEnUso = Aunoytres;
		    		    Aunoydos.setBackground(new Color(255, 255, 255));
		    		    Aunoytres.setBackground(new Color(255, 128, 0));
		    		} else if (AtextFieldEnUso == Aunoytres) {
		    		    AtextFieldEnUso = Adosycero;
		    		    Aunoytres.setBackground(new Color(255, 255, 255));
		    		    Adosycero.setBackground(new Color(255, 128, 0));
		    		} else if (AtextFieldEnUso == Adosycero) {
		    		    AtextFieldEnUso = Adosyuno;
		    		    Adosycero.setBackground(new Color(255, 255, 255));
		    		    Adosyuno.setBackground(new Color(255, 128, 0));
		    		} else if (AtextFieldEnUso == Adosyuno) {
		    		    AtextFieldEnUso = Adosydos;
		    		    Adosyuno.setBackground(new Color(255, 255, 255));
		    		    Adosydos.setBackground(new Color(255, 128, 0));
		    		} else if (AtextFieldEnUso == Adosydos) {
		    		    AtextFieldEnUso = Adosytres;
		    		    Adosydos.setBackground(new Color(255, 255, 255));
		    		    Adosytres.setBackground(new Color(255, 128, 0));
		    		} else if (AtextFieldEnUso == Adosytres) {
		    		    AtextFieldEnUso = Atresycero;
		    		    Adosytres.setBackground(new Color(255, 255, 255));
		    		    Atresycero.setBackground(new Color(255, 128, 0));
		    		} else if (AtextFieldEnUso == Atresycero) {
		    		    AtextFieldEnUso = Atresyuno;
		    		    Atresycero.setBackground(new Color(255, 255, 255));
		    		    Atresyuno.setBackground(new Color(255, 128, 0));
		    		} else if (AtextFieldEnUso == Atresyuno) {
		    		    AtextFieldEnUso = Atresydos;
		    		    Atresyuno.setBackground(new Color(255, 255, 255));
		    		    Atresydos.setBackground(new Color(255, 128, 0));
		    		} else if (AtextFieldEnUso == Atresydos) {
		    		    AtextFieldEnUso = Atresytres;
		    		    Atresydos.setBackground(new Color(255, 255, 255));
		    		    Atresytres.setBackground(new Color(255, 128, 0));
		    		} else if (AtextFieldEnUso == Atresytres) {
		    		    AtextFieldEnUso = Aceroycero;
		    		    Atresytres.setBackground(new Color(255, 255, 255));
		    		    Aceroycero.setBackground(new Color(255, 128, 0));
		    		}

		    	}
			        if(f==3 && c==3)
			    	{
			    		if (AtextFieldEnUso == Aceroycero) {
			    			AtextFieldEnUso = Aceroyuno;
				            Aceroycero.setBackground(new Color(255, 255, 255));
				            Aceroyuno.setBackground(new Color(255, 128, 0));
				        } else if (AtextFieldEnUso == Aceroyuno) {
				        	AtextFieldEnUso = Aceroydos;
				            Aceroyuno.setBackground(new Color(255, 255, 255));
				            Aceroydos.setBackground(new Color(255, 128, 0));
				        } else if (AtextFieldEnUso == Aceroydos) {
				        	AtextFieldEnUso = Aunoycero;
				            Aceroydos.setBackground(new Color(255, 255, 255));
				            Aunoycero.setBackground(new Color(255, 128, 0));
				        } else if (AtextFieldEnUso == Aunoycero) {
				        	AtextFieldEnUso = Aunoyuno;
				            Aunoycero.setBackground(new Color(255, 255, 255));
				            Aunoyuno.setBackground(new Color(255, 128, 0));
				        } else if (AtextFieldEnUso == Aunoyuno) {
				        	AtextFieldEnUso = Aunoydos;
				            Aunoyuno.setBackground(new Color(255, 255, 255));
				            Aunoydos.setBackground(new Color(255, 128, 0));
				        } else if (AtextFieldEnUso == Aunoydos) {
				        	AtextFieldEnUso = Adosycero;
				            Aunoydos.setBackground(new Color(255, 255, 255));
				            Adosycero.setBackground(new Color(255, 128, 0));
				        } else if (AtextFieldEnUso == Adosycero) {
				        	AtextFieldEnUso = Adosyuno;
				            Adosycero.setBackground(new Color(255, 255, 255));
				            Adosyuno.setBackground(new Color(255, 128, 0));
				        } else if (AtextFieldEnUso == Adosyuno) {
				        	AtextFieldEnUso = Adosydos;
				            Adosyuno.setBackground(new Color(255, 255, 255));
				            Adosydos.setBackground(new Color(255, 128, 0));
				        } else if (AtextFieldEnUso == Adosydos) {
				        	AtextFieldEnUso = Aceroycero;
				            Adosydos.setBackground(new Color(255, 255, 255));
				            Aceroycero.setBackground(new Color(255, 128, 0));
				        }
			    	}
			        if(f==2 && c==2)
			    	{
			    		if (AtextFieldEnUso == Aceroycero) {
			    			AtextFieldEnUso = Aceroyuno;
				            Aceroycero.setBackground(new Color(255, 255, 255));
				            Aceroyuno.setBackground(new Color(255, 128, 0));
				        } else if (AtextFieldEnUso == Aceroyuno) {
				        	AtextFieldEnUso = Aunoycero;
				            Aceroyuno.setBackground(new Color(255, 255, 255));
				            Aunoycero.setBackground(new Color(255, 128, 0));
				        } else if (AtextFieldEnUso == Aunoycero) {
				        	AtextFieldEnUso = Aunoyuno;
				            Aunoycero.setBackground(new Color(255, 255, 255));
				            Aunoyuno.setBackground(new Color(255, 128, 0));
				        }  else if (AtextFieldEnUso == Aunoyuno) {
				        	AtextFieldEnUso = Aceroycero;
				            Aunoyuno.setBackground(new Color(255, 255, 255));
				            Aceroycero.setBackground(new Color(255, 128, 0));
				        } 
			    	}
		    	
		    }
		    	
		});
		
		
		
		JButton btn4x4 = new JButton("4x4");
		btn4x4.setForeground(Color.WHITE);
		btn4x4.setFont(new Font("Arial", Font.BOLD, 15));
		btn4x4.setBackground(new Color(0, 150, 225));
		btn4x4.setBounds(253, 217, 119, 38);
		contentPane.add(btn4x4);
		btn4x4.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	textFieldEnUso = ceroycero;
		    	AtextFieldEnUso = Aceroycero;
		    	ceroycero.setBackground(new Color(200, 0, 0));
		    	Aceroycero.setBackground(new Color(255, 128, 0));
		    	f=4;
		    	c=4;
		    	tresytres.setEnabled(true);
		    	tresytres.setBackground(new java.awt.Color(255, 255, 255));
		    	tresydos.setEnabled(true);
		    	tresydos.setBackground(new java.awt.Color(255, 255, 255));
		    	tresyuno.setEnabled(true);
		    	tresyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	tresycero.setEnabled(true);
		    	tresycero.setBackground(new java.awt.Color(255, 255, 255));

		    	dosytres.setEnabled(true);
		    	dosytres.setBackground(new java.awt.Color(255, 255, 255));
		    	dosydos.setEnabled(true);
		    	dosydos.setBackground(new java.awt.Color(255, 255, 255));
		    	dosyuno.setEnabled(true);
		    	dosyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	dosycero.setEnabled(true);
		    	dosycero.setBackground(new java.awt.Color(255, 255, 255));

		    	unoytres.setEnabled(true);
		    	unoytres.setBackground(new java.awt.Color(255, 255, 255));
		    	unoydos.setBackground(new java.awt.Color(255, 255, 255));
		    	unoydos.setEnabled(true);
		    	unoyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	unoyuno.setEnabled(true);
		    	unoycero.setBackground(new java.awt.Color(255, 255, 255));
		    	unoycero.setEnabled(true);

		    	ceroytres.setEnabled(true);
		    	ceroytres.setBackground(new java.awt.Color(255, 255, 255));
		    	ceroydos.setEnabled(true);
		    	ceroydos.setBackground(new java.awt.Color(255, 255, 255));
		    	ceroyuno.setEnabled(true);
		    	ceroyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	ceroycero.setEnabled(true);

		    	Atresytres.setEnabled(true);
		    	Atresytres.setBackground(new java.awt.Color(255, 255, 255));
		    	Atresydos.setEnabled(true);
		    	Atresydos.setBackground(new java.awt.Color(255, 255, 255));
		    	Atresyuno.setEnabled(true);
		    	Atresyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	Atresycero.setEnabled(true);
		    	Atresycero.setBackground(new java.awt.Color(255, 255, 255));

		    	Adosytres.setEnabled(true);
		    	Adosytres.setBackground(new java.awt.Color(255, 255, 255));
		    	Adosydos.setEnabled(true);
		    	Adosydos.setBackground(new java.awt.Color(255, 255, 255));
		    	Adosyuno.setEnabled(true);
		    	Adosyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	Adosycero.setEnabled(true);
		    	Adosycero.setBackground(new java.awt.Color(255, 255, 255));

		    	Aunoytres.setEnabled(true);
		    	Aunoytres.setBackground(new java.awt.Color(255, 255, 255));
		    	Aunoydos.setBackground(new java.awt.Color(255, 255, 255));
		    	Aunoydos.setEnabled(true);
		    	Aunoyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	Aunoyuno.setEnabled(true);
		    	Aunoycero.setBackground(new java.awt.Color(255, 255, 255));
		    	Aunoycero.setEnabled(true);

		    	Aceroytres.setEnabled(true);
		    	Aceroytres.setBackground(new java.awt.Color(255, 255, 255));
		    	Aceroydos.setEnabled(true);
		    	Aceroydos.setBackground(new java.awt.Color(255, 255, 255));
		    	Aceroyuno.setEnabled(true);
		    	Aceroyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	Aceroycero.setEnabled(true);

		    }
		});
		
		
		JButton btn3x3 = new JButton("3x3");
		btn3x3.setForeground(Color.WHITE);
		btn3x3.setFont(new Font("Arial", Font.BOLD, 15));
		btn3x3.setBackground(new Color(0, 150, 225));
		btn3x3.setBounds(131, 217, 120, 38);
		contentPane.add(btn3x3);
		btn3x3.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	textFieldEnUso = ceroycero;
		    	AtextFieldEnUso = Aceroycero;
				ceroycero.setBackground(new Color(200, 0, 0));
				Aceroycero.setBackground(new Color(255, 128, 0));
		    	f=3;
		    	c=3;
		    	tresytres.setEditable(false); 
		    	tresytres.setBackground(new java.awt.Color(200, 200, 200));
		    	tresytres.setText(null); 
		    	tresydos.setEditable(false);   
		    	tresydos.setBackground(new java.awt.Color(200, 200, 200));
		    	tresydos.setText(null); 
		    	tresyuno.setEditable(false);  
		    	tresyuno.setBackground(new java.awt.Color(200, 200, 200));
		    	tresyuno.setText(null);
		    	tresycero.setEditable(false);  
		    	tresycero.setBackground(new java.awt.Color(200, 200, 200));
		    	tresycero.setText(null);

		    	dosytres.setEditable(false); 
		    	dosytres.setBackground(new java.awt.Color(200, 200, 200));
		    	dosytres.setText(null);
		    	dosydos.setEnabled(true);   
		    	dosydos.setBackground(new java.awt.Color(255, 255, 255));
		    	dosyuno.setEnabled(true);   
		    	dosyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	dosycero.setEnabled(true);  
		    	dosycero.setBackground(new java.awt.Color(255, 255, 255));
		    	
		    	unoytres.setEditable(false);  
		    	unoytres.setBackground(new java.awt.Color(200, 200, 200));  
		    	unoytres.setText(null);
		    	unoydos.setBackground(new java.awt.Color(255, 255, 255));
		    	unoydos.setEnabled(true);  
		    	unoyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	unoyuno.setEnabled(true);  
		    	unoycero.setBackground(new java.awt.Color(255, 255, 255));
		    	unoycero.setEnabled(true); 
		    	
		    	ceroytres.setEditable(false); 
		    	ceroytres.setBackground(new java.awt.Color(200, 200, 200));
		    	ceroytres.setText(null);
		    	ceroydos.setEnabled(true);   
		    	ceroydos.setBackground(new java.awt.Color(255, 255, 255));
		    	ceroyuno.setEnabled(true);  
		    	ceroyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	ceroycero.setEnabled(true);  
		    	
		    	Atresytres.setEditable(false); 
		    	Atresytres.setBackground(new java.awt.Color(200, 200, 200));
		    	Atresytres.setText(null); 
		    	Atresydos.setEditable(false);   
		    	Atresydos.setBackground(new java.awt.Color(200, 200, 200));
		    	Atresydos.setText(null); 
		    	Atresyuno.setEditable(false);  
		    	Atresyuno.setBackground(new java.awt.Color(200, 200, 200));
		    	Atresyuno.setText(null);
		    	Atresycero.setEditable(false);  
		    	Atresycero.setBackground(new java.awt.Color(200, 200, 200));
		    	Atresycero.setText(null);

		    	Adosytres.setEditable(false); 
		    	Adosytres.setBackground(new java.awt.Color(200, 200, 200));
		    	Adosytres.setText(null);
		    	Adosydos.setEnabled(true);   
		    	Adosydos.setBackground(new java.awt.Color(255, 255, 255));
		    	Adosyuno.setEnabled(true);   
		    	Adosyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	Adosycero.setEnabled(true);  
		    	Adosycero.setBackground(new java.awt.Color(255, 255, 255));
		    	
		    	Aunoytres.setEditable(false);  
		    	Aunoytres.setBackground(new java.awt.Color(200, 200, 200));  
		    	Aunoytres.setText(null);
		    	Aunoydos.setBackground(new java.awt.Color(255, 255, 255));
		    	Aunoydos.setEnabled(true);  
		    	Aunoyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	Aunoyuno.setEnabled(true);  
		    	Aunoycero.setBackground(new java.awt.Color(255, 255, 255));
		    	Aunoycero.setEnabled(true); 
		    	
		    	Aceroytres.setEditable(false); 
		    	Aceroytres.setBackground(new java.awt.Color(200, 200, 200));
		    	Aceroytres.setText(null);
		    	Aceroydos.setEnabled(true);   
		    	Aceroydos.setBackground(new java.awt.Color(255, 255, 255));
		    	Aceroyuno.setEnabled(true);  
		    	Aceroyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	Aceroycero.setEnabled(true);  
		    }
		});
		
		JButton btn2x2 = new JButton("2x2");
		btn2x2.setForeground(Color.WHITE);
		btn2x2.setFont(new Font("Arial", Font.BOLD, 15));
		btn2x2.setBackground(new Color(0, 150, 225));
		btn2x2.setBounds(10, 217, 120, 38);
		contentPane.add(btn2x2);
		btn2x2.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	textFieldEnUso = ceroycero;
		    	AtextFieldEnUso = Aceroycero;
				ceroycero.setBackground(new Color(200, 0, 0));
				Aceroycero.setBackground(new Color(255, 128, 0));
		    	f=2;
		    	c=2;
		    	tresytres.setEditable(false); 
		    	tresytres.setBackground(new java.awt.Color(200, 200, 200));
		    	tresytres.setText(null); 
		    	tresydos.setEditable(false);   
		    	tresydos.setBackground(new java.awt.Color(200, 200, 200));
		    	tresydos.setText(null); 
		    	tresyuno.setEditable(false);  
		    	tresyuno.setBackground(new java.awt.Color(200, 200, 200));
		    	tresyuno.setText(null);
		    	tresycero.setEditable(false);  
		    	tresycero.setBackground(new java.awt.Color(200, 200, 200));
		    	tresycero.setText(null);

		    	dosytres.setEditable(false); 
		    	dosytres.setBackground(new java.awt.Color(200, 200, 200));
		    	dosytres.setText(null);
		    	dosydos.setEditable(false); 
		    	dosydos.setBackground(new java.awt.Color(200, 200, 200));
		    	dosydos.setText(null);
		    	dosyuno.setEditable(false); 
		    	dosyuno.setBackground(new java.awt.Color(200, 200, 200));
		    	dosyuno.setText(null);
		    	dosycero.setEditable(false); 
		    	dosycero.setBackground(new java.awt.Color(200, 200, 200));
		    	dosycero.setText(null);
		    	
		    	unoytres.setEditable(false);  
		    	unoytres.setBackground(new java.awt.Color(200, 200, 200));  
		    	unoytres.setText(null);
		    	unoydos.setEditable(false);
		    	unoydos.setBackground(new java.awt.Color(200, 200, 200));
		    	unoydos.setText(null);
		    	unoyuno.setEnabled(true);  
		    	unoyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	unoycero.setEnabled(true); 
		    	unoycero.setBackground(new java.awt.Color(255, 255, 255));
		    	
		    	ceroytres.setEditable(false); 
		    	ceroytres.setBackground(new java.awt.Color(200, 200, 200));
		    	ceroytres.setText(null);
		    	ceroydos.setEditable(false);    
		    	ceroydos.setBackground(new java.awt.Color(200, 200, 200));
		    	ceroydos.setText(null);
		    	ceroyuno.setEnabled(true);  
		    	ceroyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	ceroycero.setEnabled(true);  
		    	
		    	Atresytres.setEditable(false); 
		    	Atresytres.setBackground(new java.awt.Color(200, 200, 200));
		    	Atresytres.setText(null); 
		    	Atresydos.setEditable(false);   
		    	Atresydos.setBackground(new java.awt.Color(200, 200, 200));
		    	Atresydos.setText(null); 
		    	Atresyuno.setEditable(false);  
		    	Atresyuno.setBackground(new java.awt.Color(200, 200, 200));
		    	Atresyuno.setText(null);
		    	Atresycero.setEditable(false);  
		    	Atresycero.setBackground(new java.awt.Color(200, 200, 200));
		    	Atresycero.setText(null);

		    	Adosytres.setEditable(false); 
		    	Adosytres.setBackground(new java.awt.Color(200, 200, 200));
		    	Adosytres.setText(null);
		    	Adosydos.setEditable(false); 
		    	Adosydos.setBackground(new java.awt.Color(200, 200, 200));
		    	Adosydos.setText(null);
		    	Adosyuno.setEditable(false); 
		    	Adosyuno.setBackground(new java.awt.Color(200, 200, 200));
		    	Adosyuno.setText(null);
		    	Adosycero.setEditable(false); 
		    	Adosycero.setBackground(new java.awt.Color(200, 200, 200));
		    	Adosycero.setText(null);
		    	
		    	Aunoytres.setEditable(false);  
		    	Aunoytres.setBackground(new java.awt.Color(200, 200, 200));  
		    	Aunoytres.setText(null);
		    	Aunoydos.setEditable(false);
		    	Aunoydos.setBackground(new java.awt.Color(200, 200, 200));
		    	Aunoydos.setText(null);
		    	Aunoyuno.setEnabled(true);  
		    	Aunoyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	Aunoycero.setEnabled(true); 
		    	Aunoycero.setBackground(new java.awt.Color(255, 255, 255));
		    	
		    	Aceroytres.setEditable(false); 
		    	Aceroytres.setBackground(new java.awt.Color(200, 200, 200));
		    	Aceroytres.setText(null);
		    	Aceroydos.setEditable(false);    
		    	Aceroydos.setBackground(new java.awt.Color(200, 200, 200));
		    	Aceroydos.setText(null);
		    	Aceroyuno.setEnabled(true);  
		    	Aceroyuno.setBackground(new java.awt.Color(255, 255, 255));
		    	Aceroycero.setEnabled(true);   	
		    }
		});
		
		
		
		
		
		
		logo = new JLabel("CALCUMATRON");
		logo.setBounds(10, 547, 362, 105);
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setFont(new Font("Arial", Font.BOLD, 30));
        getContentPane().add(logo, BorderLayout.CENTER);
        logo.setOpaque(true); 
        getContentPane().add(logo, BorderLayout.CENTER);
        
        JButton btnSalir = new JButton("◀"); 
        btnSalir.setBounds(0, 0, 90, 17);
        btnSalir.setBackground(new Color(77, 77, 77));
        btnSalir.setForeground(Color.WHITE); 
        contentPane.add(btnSalir);

        


        Timer stimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	cambiarcolor();
            }
        });
        stimer.start();
    }
	}