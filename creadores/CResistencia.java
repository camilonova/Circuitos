package creadores;

import programa.*;
import imagenes.IResistencia;

import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class CResistencia extends Creador{
	public CResistencia(){
		Programa.Plano.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
	}
	
	public void mouseReleased(MouseEvent ME){
		IResistencia IR = new IResistencia(ME.getX(), ME.getY());
		Programa.Plano.add(IR);
		Programa.Plano.add(IR.getNodo1());
		Programa.Plano.add(IR.getNodo2());
		Programa.Plano.repaint();
		Programa.Plano.setCursor(Cursor.getDefaultCursor());
		Programa.Plano.removeMouseListener(this);
		Programa.creador = null;
	}
}