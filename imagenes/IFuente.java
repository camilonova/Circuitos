package imagenes;

import programa.*;
import java.awt.*;
import dialogos.*;

public class IFuente extends IComponente{
	private static final Image Imagen = Toolkit.getDefaultToolkit().getImage("Fuente.gif");

	public IFuente(int x, int y){
		super(x, y, 30, 30);
		nodo1=new INodo(x, y-15);
		nodo2=new INodo(x, y+15);
		Programa.circuito.agregarComponente(this);
	}

	public void mover(int x, int y){
		super.mover(x, y);
		nodo1.mover(x, y-15);
		nodo2.mover(x, y+15);
	}
	
	public void mostrarDialogo(){
		DialogoF.mostrar(this);
	}
	
	public void dibujar(Graphics G){
		G.drawImage(Imagen, 0, 0, this);
		if(seleccionado){
			G.setColor(Color.red);
			G.drawRect(0, 0, 29, 29);
		}
	}
	
	public String toString(){
		return String.valueOf(valor) + " v";
	}
}