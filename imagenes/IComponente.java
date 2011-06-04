package imagenes;

import programa.*;

import java.awt.event.*;

public abstract class IComponente extends Imagen{
	protected INodo nodo1, nodo2;
	private int dx, dy;
	public double valor;
	
	public IComponente(int x, int y, int ancho, int alto){
		super(x, y, ancho, alto);
		dx=x;	dy=y;
	}
	
	public abstract void mostrarDialogo();
	
	public INodo getNodo1(){
		return nodo1;
	}
	
	public INodo getNodo2(){
		return nodo2;
	}
	
	public void borrar(){
		super.borrar();
		nodo1.borrar();
		nodo2.borrar();
		Programa.Plano.repaint();
	}
	
	public void keyReleased(KeyEvent KE){
		if(KE.getKeyCode()==KeyEvent.VK_DELETE)
			borrar();
	}
	
	public void mouseClicked(MouseEvent ME){
		if(ME.getClickCount()==2)
			mostrarDialogo();
	}
	
	public void mousePressed(MouseEvent ME){
		dx=ME.getX(); dy=ME.getY();
	}
	
	public void mouseDragged(MouseEvent ME){
		int nx=x+ME.getX()-dx;
		int ny=y+ME.getY()-dy;
		if(nx < (int)(ancho/2) )
			nx=(int)(ancho/2);
		else if(nx+(int)(ancho/2) > getParent().getWidth())
			nx=getParent().getWidth()-(int)(ancho/2);
		if(ny < (int)(alto/2) )
			ny=(int)(alto/2);
		else if(ny+(int)(alto/2) > getParent().getHeight())
			ny=getParent().getHeight()-(int)(alto/2);
		mover(nx, ny);
	}
}