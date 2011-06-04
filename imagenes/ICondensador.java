package imagenes;

import dialogos.DialogoC;
import programa.*;

import java.awt.*;

public class ICondensador extends IComponente{
	private static final Image Imagen = Toolkit.getDefaultToolkit().getImage("Condensador.gif");
	
	public ICondensador (int x, int y){
		super(x, y, 20, 20);
		nodo1=new INodo(x-4, y+10);
		nodo2=new INodo(x+4, y+10);
		Programa.circuito.agregarComponente(this);
	}
	
	public void mover(int x, int y){
		super.mover(x, y);
		nodo1.mover(x-4, y+10);
		nodo2.mover(x+4, y+10);
	}
	
	public void mostrarDialogo(){
		DialogoC.mostrar(this);
	}
	
	public void dibujar(Graphics G){
		G.drawImage(Imagen, 0, 0, this);
		if(seleccionado){
			G.setColor(Color.red);
			G.drawRect(0, 0, 19, 19);
		}
	}
	
	public String toString(){
		return String.valueOf(valor) + " f";
	}
}