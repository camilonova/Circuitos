package creadores;

import programa.*;
import imagenes.IFuente;

import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class CFuente extends Creador{
	public CFuente(){
		Programa.Plano.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
	}
	public void mouseReleased(MouseEvent ME){
		IFuente IF=new IFuente(ME.getX(), ME.getY());
		Programa.Plano.add(IF);
		Programa.Plano.add(IF.getNodo1());
		Programa.Plano.add(IF.getNodo2());
		Programa.Plano.repaint();
		Programa.Plano.setCursor(Cursor.getDefaultCursor());
		Programa.Plano.removeMouseListener(this);
		Programa.creador=null;
	}
}