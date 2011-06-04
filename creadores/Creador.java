package creadores;

import programa.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class Creador implements MouseListener{
	public Creador(){
		Programa.Plano.addMouseListener(this);
	}
	public void mouseClicked(MouseEvent ME){
	}
	public void mousePressed(MouseEvent ME){
	}
	public void mouseReleased(MouseEvent ME){
	}
	public void mouseEntered(MouseEvent ME){
	}
	public void mouseExited(MouseEvent ME){
	}
}