package creadores;

import programa.*;
import imagenes.IEnlace;
import imagenes.INodo;

import java.awt.event.*;
import java.awt.*;
import javax.swing.JPanel;

public class CEnlace extends Creador implements MouseMotionListener{
	private INodo nodo1;
	private int dx, dy;
	private JPanel preEnlace;
	
	public CEnlace(final INodo nodo1){
		System.out.println("inicio " + nodo1);
		this.nodo1 = nodo1;
		Programa.Plano.setCursor(new Cursor(Cursor.HAND_CURSOR));
		preEnlace = new JPanel(){
			public void paintComponent(Graphics G){
				super.paintComponent(G);
				G.setColor(Color.blue);
				G.drawLine(nodo1.centro()[0], nodo1.centro()[1],dx, dy);
			}
		};
		preEnlace.setOpaque(false);
		preEnlace.setSize(Programa.Plano.getWidth(), Programa.Plano.getHeight());
		preEnlace.setLocation(0, 0);
		Programa.Plano.add(preEnlace, -1);
		Programa.Plano.addMouseMotionListener(this);
	}

	public void enlazar(INodo nodo2){
		System.out.println("fin " + nodo2);
		IEnlace enlace = new IEnlace(nodo1, nodo2);
		Programa.Plano.add(enlace);
		nodo1.agregarEnlace(enlace);
		nodo2.agregarEnlace(enlace);
		remover();
	}
	
	public void mouseClicked(MouseEvent ME){
		remover();
	}
	
	public void mouseMoved(MouseEvent ME){
		dx=ME.getX();	dy=ME.getY();
		preEnlace.repaint();
	}
	
	public void mouseDragged(MouseEvent ME){
	}
	
	private void remover(){
		Programa.Plano.setCursor(Cursor.getDefaultCursor());
		Programa.Plano.remove(preEnlace);
		Programa.Plano.removeMouseListener(this);
		Programa.Plano.removeMouseMotionListener(this);
		Programa.creador=null;
		Programa.Plano.repaint();
	}
}