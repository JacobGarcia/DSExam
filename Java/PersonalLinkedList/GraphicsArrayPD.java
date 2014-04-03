import javax.swing.*;
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Color;


public class GraphicsArrayPD extends JPanel
{
	String figura;
	int r, g, b;
	
	private GraphicsArrayPD next;
	
	public GraphicsArrayPD(String fig, int R, int G, int B)
	{
		this.figura = fig;
		setSize(400, 400);
		setVisible(true);
		r = R;
		g = G;
		b = B;
	}
	
	public void paintComponent (Graphics graphic)
	{
		super.paintComponent(graphic);
		setBackground(new Color(r, g, b));
		
		if(figura.equals("RECTANGULO"))
		{
			int i = 2;
			for(i=7; i<=50; i++)
			{
				graphic.drawRect(i*2, i*2, 225, 175);
			}
		}
		
		if(figura.equals("CILINDRO"))
		{
			int i = 2;
			for(i=7; i<=50; i++)
			{
				graphic.drawOval(i*2, i*2, 225, 165);
			}
		}
		
		if(figura.equals("CIRCULO"))
		{
			int i;
			for(i=75; i>=2; i--)
			{
				graphic.drawOval(185-i*2, 163-i*2, i*4, i*4);
			}
		}
		
		if(figura.equals("ESP-RECT"))
		{
			int i = 2;
			for(i=7; i<=50; i++)
			{
				graphic.drawRect(i*2, i*2, i*4, i*3);
			}
		}
		
		if(figura.equals("ESP-CIRC"))
		{
			int i;
			for(i=50; i>=2; i--)
			{
				graphic.drawOval(i*2, i*2, i*4, i*4);
			}
		}
		
		if(figura.equals("CUBO"))
		{
			int i = 2;
			for(i=7; i<=50; i++)
			{
				graphic.drawRect(i*2, i*2, 225, 225);
			}
		}
		
		if(figura.equals("ESP-CUBO"))
		{
			int i = 2;
			for(i=7; i<=50; i++)
			{
				graphic.drawRect(i*2, i*2, i*4, i*4);
			}
		}
	}
	
	public void setNext(GraphicsArrayPD dir)
	{
		this.next = dir;
	}
	
	public GraphicsArrayPD getNext()
	{
		return this.next;
	}
}