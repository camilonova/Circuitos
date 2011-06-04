package dialogos;

import programa.*;
import imagenes.ICondensador;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class DialogoC {
	private static JDialog Dialogo;
	private static JTextField CajaTexto;
	private static ICondensador CActual;
	
	public static void cargar(){
		Dialogo = new JDialog(Programa.Ventana, "Condensador", true);
		Dialogo.setSize(200, 100);
		Dialogo.setLocation(300, 200);
		CajaTexto = new JTextField(7);
		CajaTexto.setHorizontalAlignment(JTextField.RIGHT);
		JPanel p = new JPanel();
		p.add(new JLabel("Valor = "));
		p.add(CajaTexto);
		p.add(new JLabel("faradios"));
		Dialogo.getContentPane().add(p, BorderLayout.NORTH);
		p = new JPanel();
		JButton JB = new JButton("Aceptar");
		JB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent AE){
				try{
					CActual.valor=Double.parseDouble(CajaTexto.getText());
				}
				catch(Exception E){
				 	JOptionPane.showMessageDialog(Dialogo,"Valor no valido", "Error",JOptionPane.ERROR_MESSAGE);
			 	}
			 	Dialogo.dispose();
			}
		});
		p.add(JB);
		JB = new JButton("Cancelar");
		JB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent AE){
				Dialogo.dispose();
			}
		});
		p.add(JB);
		Dialogo.getContentPane().add(p);
	}
	
	public static void mostrar(ICondensador IC){
		CActual=IC;
		CajaTexto.setText(String.valueOf(IC.valor));
		Dialogo.setVisible(true);
	}
}