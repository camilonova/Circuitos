package imagenes;

import javax.swing.*;

import programa.*;

import java.awt.event.*;
import java.awt.Graphics;

public abstract class Imagen extends JPanel	implements MouseListener, MouseMotionListener, KeyListener{
	protected int x, y, ancho, alto;
	protected boolean seleccionado;
	public Imagen(int x, int y, int ancho, int alto)
		{this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setOpaque(false);
		setLocation(x-(int)(ancho/2), y-(int)(alto/2));
		setSize(ancho, alto);
		repaint();
		}
	public abstract void dibujar(Graphics G);
	public void setSeleccionado(boolean valor)
		{seleccionado=valor;
		if(seleccionado)
			requestFocus();
		repaint();
		}
	public int[] centro()
		{int[] r=new int[2];
		r[0]=x;	r[1]=y;
		return r;
		}
	public void mover(int x, int y)
		{this.x=x;
		this.y=y;
		setLocation(x-(int)(ancho/2), y-(int)(alto/2));
		repaint();
		}
	public void borrar()
		{Programa.Plano.remove(this);}
	public void mouseClicked(MouseEvent ME){}
	public void mouseReleased(MouseEvent ME){}
	public void mouseEntered(MouseEvent ME)
		{setSeleccionado(true);}
	public void mouseExited(MouseEvent ME)
		{setSeleccionado(false);}
	public void mouseMoved(MouseEvent ME){}
	public void mousePressed(MouseEvent ME){}
	public void mouseDragged(MouseEvent ME){}
	public void keyPressed(KeyEvent KE){}
	public void keyReleased(KeyEvent KE){}
	public void keyTyped(KeyEvent KE){}
	public void paintComponent(Graphics G)
		{super.paintComponent(G);
		dibujar(G);
		}
	}