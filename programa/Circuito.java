package programa;

import imagenes.*;

import javax.swing.tree.*;
import java.util.Vector;

public class Circuito extends DefaultTreeModel{
	private Vector resistencias = new Vector();
	private Vector fuentes = new Vector();
	private Vector condensadores = new Vector();
	
	public Circuito(){
		super(new DefaultMutableTreeNode("Circuito"));
		DefaultMutableTreeNode DMTN=(DefaultMutableTreeNode)root;
		DMTN.add(new DefaultMutableTreeNode("Resistencias"));
		DMTN.add(new DefaultMutableTreeNode("Fuentes"));
		DMTN.add(new DefaultMutableTreeNode("Condensadores"));
	}
	
	public void agregarComponente(IComponente IC){
		if(IC instanceof IResistencia){
			resistencias.add(IC);
			insertNodeInto(new DefaultMutableTreeNode(IC),(MutableTreeNode)root.getChildAt(0), 0);
		}
		if(IC instanceof IFuente){
			fuentes.add(IC);
			insertNodeInto(new DefaultMutableTreeNode(IC),(MutableTreeNode)root.getChildAt(1), 0);
		}
		if(IC instanceof ICondensador){
			condensadores.add(IC);
			insertNodeInto(new DefaultMutableTreeNode(IC),(MutableTreeNode)root.getChildAt(2), 0);
		}
	}

	public void removerComponente(IComponente IC)
		{resistencias.remove(IC);
		fuentes.remove(IC);
		condensadores.remove(IC);
		}
	public double resistenciaEqv()
		{return 0;
		}
	public double voltaje()
		{return 0;
		}
	public double corriente()
		{return 0;
		}
	}