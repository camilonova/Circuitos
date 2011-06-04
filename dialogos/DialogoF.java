package dialogos;

import programa.*;
import imagenes.IFuente;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class DialogoF {
	private static JDialog Dialogo;
	private static JTextField CajaTexto;
	private static IFuente FActual;
	
	public static void cargar(){
		Dialogo = new JDialog(Programa.Ventana, "Fuente", true);
		Dialogo.setSize(200, 100);
		Dialogo.setLocation(300, 200);
		CajaTexto = new JTextField(7);
		CajaTexto.setHorizontalAlignment(JTextField.RIGHT);
		JPanel p = new JPanel();
		p.add(new JLabel("Valor = "));
		p.add(CajaTexto);
		p.add(new JLabel("v"));
		Dialogo.getContentPane().add(p, BorderLayout.NORTH);
		JButton JB = new JButton("Aceptar");
		JB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent AE){
				try{
				 	FActual.valor=Double.parseDouble(CajaTexto.getText());
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
				Dialogo.dispose();}
			});
		p.add(JB);
		Dialogo.getContentPane().add(p);
	}
	
	public static void mostrar(IFuente IF){
		FActual = IF;
		CajaTexto.setText(String.valueOf(IF.valor));
		Dialogo.setVisible(true);
	}
}