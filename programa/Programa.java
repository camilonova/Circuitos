package programa;

import creadores.*;
import dialogos.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Programa{
	public static final JFrame Ventana=new JFrame("Circuitos RC");
	public static final JPanel Plano=new JPanel(null);
	public static final JToolBar BComponentes=new JToolBar("Componentes");
	public static final JTextField Res=new JTextField(5);
	public static final JTextField Vol=new JTextField(5);
	public static final JTextField Cor=new JTextField(5);
	public static final Circuito circuito=new Circuito();
	public static Creador creador;

	public static void main(String[] args){
		//Ventana
		Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ventana.setSize(450, 300);
		Ventana.setLocation(200, 150);
		//Plano
		Plano.setBackground(Color.white);
		//Plano.setPreferredSize(new Dimension(400, 300));
		//BComponentes
		JButton JB = new JButton(new ImageIcon("BFuente.gif"));
		JB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent AE){
				if(creador == null){
					creador = new CFuente();
				}
			}
		});
		BComponentes.add(JB);
		JB = new JButton(new ImageIcon("BResistencia.gif"));
		JB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent AE){
				if(creador == null){
					creador=new CResistencia();
				}
			}
		});
		BComponentes.add(JB);
		JB = new JButton(new ImageIcon("BCondensador.gif"));
		JB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent AE){
				if(creador==null){
					creador=new CCondensador();
				}
			}
		});
		BComponentes.add(JB);
		Ventana.getContentPane().add(BComponentes, BorderLayout.NORTH);
		//PInformacion
		Res.setHorizontalAlignment(JTextField.RIGHT);
		Res.setEditable(false);
		Vol.setHorizontalAlignment(JTextField.RIGHT);
		Vol.setEditable(false);
		Cor.setHorizontalAlignment(JTextField.RIGHT);
		Cor.setEditable(false);
		JPanel PInformacion=new JPanel();
		PInformacion.add(new JLabel("Resistencia"));
		PInformacion.add(Res);
		PInformacion.add(new JLabel("Voltaje"));
		PInformacion.add(Vol);
		PInformacion.add(new JLabel("Corriente"));
		PInformacion.add(Cor);
		JB = new JButton("Actualizar");
		JB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent AE){
				Res.setText("1");
				Vol.setText("2");
				Cor.setText("3");
			}
		});
		PInformacion.add(JB);
		Ventana.getContentPane().add(PInformacion, BorderLayout.SOUTH);
		//Arbol
		JSplitPane JSP = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,			
			new JScrollPane(new JTree(circuito)),
			new JScrollPane(Plano));
		JSP.setOneTouchExpandable(true);
		JSP.setDividerLocation(0.25);
		Ventana.getContentPane().add(JSP);
		DialogoR.cargar();
		DialogoF.cargar();
		DialogoC.cargar();
		Ventana.setVisible(true);
	}
}