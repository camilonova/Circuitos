package imagenes;

import java.awt.Graphics;

public class IEnlace extends Imagen
	{private INodo nodo1, nodo2;
	public IEnlace(INodo nodo1, INodo nodo2)
		{super(0, 0, 0, 0);
		this.nodo1=nodo1;
		this.nodo2=nodo2;
		actualizar();
		}
	public void actualizar()
		{if(nodo1==null || nodo2==null)
			return;
		x=Math.min(nodo1.x, nodo2.x);
		y=Math.min(nodo1.y, nodo2.y);
		ancho=Math.max(nodo1.x, nodo2.x)-x;
		alto=Math.max(nodo1.y, nodo2.y)-y;
		if(ancho==0)	ancho=1;
		if(alto==0)		alto=1;
		setSize(ancho, alto);
		setLocation(x, y);
		repaint();
		}
	public void dibujar(Graphics G)
		{if(nodo1==null || nodo2==null)
			return;
		if(nodo1.x<=nodo2.x)
			{if(nodo1.y<=nodo2.y)
				G.drawLine(0, 0, ancho-1, alto-1);
			else
				G.drawLine(0, alto-1, ancho-1, 0);
			}
		else
			{if(nodo1.y<=nodo2.y)
				G.drawLine(ancho-1, 0, 0, alto-1);
			else
				G.drawLine(ancho-1, alto-1, 0, 0);
			}
		}
	public void mover(int x, int y){}
	public void borrar()
		{super.borrar();
		nodo1.removerEnlace(this);
		nodo2.removerEnlace(this);
		nodo1=null;
		nodo2=null;
		}
	}