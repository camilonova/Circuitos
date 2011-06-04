package imagenes;

import dialogos.DialogoR;
import programa.*;

import java.awt.*;

public class IResistencia extends IComponente{
	private static final Image Imagen = Toolkit.getDefaultToolkit().getImage("Resistencia.gif");
	
	public IResistencia(int x, int y){
		super(x, y, 30, 20);
		nodo1=new INodo(x-15, y);
		nodo2=new INodo(x+15, y);
		Programa.circuito.agregarComponente(this);
	}
	
	public void mover(int x, int y){
		super.mover(x, y);
		nodo1.mover(x-15, y);
		nodo2.mover(x+15, y);
	}
	
	public void mostrarDialogo(){
		DialogoR.mostrar(this);
	}
	
	public void dibujar(Graphics G){
		G.drawImage(Imagen, 0, 0, this);
		if(seleccionado){
			G.setColor(Color.red);
			G.drawRect(0, 0, 29, 19);
		}
	}
	
	public String toString(){
		return String.valueOf(valor) + " omn";
	}
}