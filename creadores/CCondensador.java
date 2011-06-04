package creadores;

import programa.*;
import imagenes.ICondensador;

import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class CCondensador extends Creador{
	public CCondensador(){
		Programa.Plano.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
	}
	public void mouseReleased(MouseEvent ME){
		ICondensador IC=new ICondensador(ME.getX(), ME.getY());
		Programa.Plano.add(IC);
		Programa.Plano.add(IC.getNodo1());
		Programa.Plano.add(IC.getNodo2());
		Programa.Plano.repaint();
		Programa.Plano.setCursor(Cursor.getDefaultCursor());
		Programa.Plano.removeMouseListener(this);
		Programa.creador=null;
	}
}