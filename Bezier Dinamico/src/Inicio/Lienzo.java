package Inicio;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class Lienzo implements GLEventListener{
    public GL gl;
    public GLU glu;
    double[][] puntos;
    double[][] focos;
    public Lienzo(double[][] puntos,double[][] focos){
        this.puntos=puntos;
        this.focos=focos;
    }
    
    public void cambiar(double[][] puntos,double[][] focos){
        this.puntos=puntos;
        this.focos=focos;
    }
    
    @Override
    public void init(GLAutoDrawable drawable) {
        glu=new GLU();
        gl= drawable.getGL();
        gl.glClearColor(0, 0, 0, 0);
        gl.glMatrixMode(gl.GL_PROJECTION);
        glu.gluOrtho2D(-100, 100, -100, 100);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        gl.glLineWidth(5);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glBegin(GL.GL_LINE_STRIP);
            for(int i=0;i<focos.length;i++){
                if(i%2==0){
                    gl.glColor3d(1, 0, 0);
                }else{
                    gl.glColor3d(0, 0, 1);
                }
                gl.glVertex2d(focos[i][0],focos[i][1]);
            }
        gl.glEnd();
        gl.glBegin(GL.GL_LINE_STRIP);
            for(int i=0;i<puntos.length;i++){
                if(i%2==0){
                    gl.glColor3d(0, 1, 1);
                }else{
                    gl.glColor3d(1, 0, 1);
                }
                gl.glVertex2d(puntos[i][0], puntos[i][1]);
            }
        gl.glEnd();
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {}

    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {}
    
}
