
package Inicio;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JPanel;

public class Panel extends JPanel{
    public double[][] Focos =new double[4][2]; 
    public double[][] puntos =new double[21][2];
    public double t;
    public int lugar=0;
    public Panel() {
        setLayout(null);
        Lienzo lienzo=new Lienzo(puntos,Focos);
        GLCanvas canvas=new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(lienzo);
        canvas.setBounds(0, 0, 500,500);
        add(canvas);
        canvas.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                if(lugar<Focos.length){
                    for(int i=lugar;i<Focos.length;i++){
                        Focos[i][0]=(e.getX()/2.5)-100;
                        Focos[i][1]=(-e.getY()/2.5)+100;
                    }
                    lugar++;
                    t=0;
                    for(int i=0;i<puntos.length;i++){
                        puntos[i][0]=calcularX(Focos.length,t,Focos,0);
                        puntos[i][1]=calcularY(Focos.length,t,Focos,0);
                        t+=0.05;
                    }
                    lienzo.cambiar(puntos,Focos);
                    canvas.repaint();
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        canvas.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_X){
                    lugar=0;
                    for(int i=0;i<Focos.length;i++){    
                        Focos[i][0]=200;
                        Focos[i][0]=200;
                    }
                    for(int i=0;i<puntos.length;i++){
                        puntos[i][0]=200;
                        puntos[i][0]=200;
                    }
                    lienzo.cambiar(puntos, Focos);
                    canvas.repaint();
                }
                
            }

            @Override
            public void keyReleased(KeyEvent e) {}

        });
    }
    
    public double calcularX(int n,double t,double[][] puntos,int p){
        double punto;
        if(n<=2){
            return (1-t)*puntos[p][0]+(t*puntos[p+1][0]);
        }else{
            return ((1-t)*calcularX(n-1,t,puntos,p))+t*calcularX(n-1,t,puntos,p+1);
        }
    } 
    public double calcularY(int n,double t,double[][] puntos,int p){
        double punto;
        if(n<=2){
            return (1-t)*puntos[p][1]+(t*puntos[p+1][1]);
        }else{
            return ((1-t)*calcularY(n-1,t,puntos,p))+t*calcularY(n-1,t,puntos,p+1);
        }
    } 
}
