import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.GridLayout;

public class GraphicsLinkedListAD
{
	private GraphicsArrayPD primero, ultimo, actual, anterior;
	private JPanel panel, pane;
	
	public GraphicsLinkedListAD()
	{
		panel = new JPanel();
	}
	public GraphicsArrayPD crearNodo(String figura, int r, int g, int b)
	{
		if(primero == null)
		{
			primero = new GraphicsArrayPD(figura, r, g, b);
			ultimo = primero;
			actual = primero;
			ultimo.setNext(null);
		}
		else
		{
			actual = new GraphicsArrayPD(figura, r, g, b);
			ultimo.setNext(actual); //Link
			ultimo = actual;
			ultimo.setNext(null);
		}
		
		return actual;
	}
	
	public void mostrarFiguras()
	{
		actual = primero;
		panel = new JPanel();
		panel.setLayout(new GridLayout());
		while(actual != null)
		{
			panel.add(actual);
			actual = actual.getNext();
		}
	}
	
	public JPanel getPanel()
	{
		return this.panel;
	}
}