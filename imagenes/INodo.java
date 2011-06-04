package imagenes;

import java.awt.event.*;
import java.awt.*;
import java.util.Vector;

import programa.*;

import creadores.*;

public class INodo extends Imagen{
	
	private Vector enlaces=new Vector();
	
	public INodo(int x, int y){
		super(x, y, 6, 6);
	}
	
	public void agregarEnlace(Imagen enlace){
		enlaces.add(enlace);
	}
	
	public void removerEnlace(Imagen enlace){
		enlaces.remove(enlace);
	}
	
	public void mover(int x, int y){
		super.mover(x, y);
		for(int i=0; i<enlaces.size(); i++)
			if(enlaces.get(i) instanceof IEnlace)
				((IEnlace)enlaces.get(i)).actualizar();
	}
	
	public void dibujar(Graphics G){
		if(!seleccionado)
			G.setColor(Color.red);
		else
			G.setColor(Color.blue);
		G.fillOval(0, 0, 6, 6);
	}
	
	public void borrar(){
		super.borrar();
		for(int i=0; i<enlaces.size(); i++)
			if(enlaces.get(i) instanceof IEnlace)
				((IEnlace)enlaces.get(i)).borrar();
	}
	
	public void mouseClicked(MouseEvent ME){
		if(Programa.creador instanceof CEnlace)
			{((CEnlace)Programa.creador).enlazar(this);
			return;
		}
		if(Programa.creador!=null)
			return;
		Programa.creador=new CEnlace(this);
	}
}