package tiendaOnline;

import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		InterfazTiendaOnline interfaz = new InterfazTiendaOnline();
		SwingUtilities.invokeLater(() -> {
			new InterfazTiendaOnline();
		});
	}
}
 
