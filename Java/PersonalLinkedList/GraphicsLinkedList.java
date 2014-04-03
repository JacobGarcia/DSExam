import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicsLinkedList extends JFrame implements ActionListener
{
	private JMenuBar mbFiguras;
	private JMenuItem miRectangulo, miCirculo, miSalir, miCilindro, miEspiralRectangulo, miEspiralCirculo, miCubo, miEspiralCubo, miArreglo;
	private JMenu mFiguras, mEspirales;
	private JPanel panel, panelLista, pDialog;
	private JLabel lLista;
	private JTextField tfLista;
	private GraphicsArrayPD primero, ultimo, actual, anterior;
	
	private int arreglo[];
	private int m, cont = 0;
	private String options[] = {"Aceptar"};
	
	private GraphicsLinkedListAD lista = new GraphicsLinkedListAD();
	
	public GraphicsLinkedList()
	{
		super("Figuras Geométricas");
		
		mbFiguras = new JMenuBar();
		
		miRectangulo = new JMenuItem("Dibujar Prisma Rectangular");
		miRectangulo.addActionListener(this);
		
		miCirculo = new JMenuItem("Dibujar Círculo");
		miCirculo.addActionListener(this);
		
		miCilindro = new JMenuItem("Dibujar Cilindro");
		miCilindro.addActionListener(this);
		
		miEspiralRectangulo = new JMenuItem("Dibujar Espiral Rectangular");
		miEspiralRectangulo.addActionListener(this);
		
		miEspiralCirculo = new JMenuItem("Dibujar Espiral Circular");
		miEspiralCirculo.addActionListener(this);
		
		miCubo = new JMenuItem("Dibujar Cubo");
		miCubo.addActionListener(this);
		
		miEspiralCubo = new JMenuItem("Dibujar Espiral Cúbico");
		miEspiralCubo.addActionListener(this);
		
		miSalir = new JMenuItem("Salir");
		miSalir.addActionListener(this);
		
		mFiguras = new JMenu("Figuras");
		mEspirales = new JMenu("Dibujar Espirales");
		
		miArreglo = new JMenuItem("Crear Arreglo");
		miArreglo.addActionListener(this);
		
		panel = new JPanel();
		panelLista = new JPanel();
		pDialog = new JPanel();
		
		lLista = new JLabel("Número de Columnas = ");
		
		tfLista = new JTextField(10);
		
		//Cuadro de Dialogo
		pDialog.add(lLista);
		pDialog.add(tfLista);
		
		mEspirales.add(miEspiralRectangulo);
		mEspirales.add(miEspiralCirculo);
		mEspirales.add(miEspiralCubo);
		
		mFiguras.add(miArreglo);
		mFiguras.add(miRectangulo);
		mFiguras.add(miCirculo);
		mFiguras.add(miCilindro);
		mFiguras.add(miCubo);
		mFiguras.add(mEspirales);
		mFiguras.add(miSalir);
		
		mbFiguras.add(mFiguras);
		
		//Añadir atributos al JFrame
		setJMenuBar(mbFiguras);
		
		//Visualizar Frame
		setSize(800, 500);
		setVisible(true);
		
	}
	
	public int pedirValor()
	{
		int valor = 0, mensaje;
		boolean correct = false;
		String valr = "";
		
		while(correct == false)
		{
			boolean negativo = false;
			try
			{
				mensaje = JOptionPane.showOptionDialog(null, pDialog, "Arreglo de Gráficos", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
				if(mensaje == 0)
					valr = tfLista.getText();
				valor = Integer.parseInt(valr);
				if(valor < 0)
				{
					negativo = true;
					valor = Integer.parseInt("null");
				}
				else
					correct = true;
			}
			catch(NumberFormatException nfe)
			{
				if(negativo == true)
					JOptionPane.showMessageDialog(null, "ERROR: No se pueden introducir números negativos.");
				else
					JOptionPane.showMessageDialog(null, "ERROR: Debes introducir un número entero.");
				System.out.println("Error: " + nfe);
			}
		}
		return valor;
	}
	
	private void crear(String str, int r, int g, int b)
	{
		if((panel != null) &&(panelLista != null))
		{	panelLista.setVisible(false);
			panel.setVisible(false);
		}
		
		lista.crearNodo(str, r, g, b);
		lista.mostrarFiguras();
		
		if(panel != null)
		{
			panel.setVisible(false);
		}
		panel = lista.getPanel();
		panel.setVisible(true);
		add(panel);
		setVisible(true);
		//panelLista.add(panel);
		//panelLista.setVisible(true);
		cont ++;
		
			/*	panelLista.setVisible(true);
				JOptionPane.showMessageDialog(null, "El arreglo ya se encuentra lleno. En caso de que desees crear \nmás figuras, crea un nuevo arreglo en la pestaña de 'Crear Arreglo'");*/
	}
	private void crearArreglo()
	{
		//1) Reiniciar a los paneles para asegurarse de que estén vacíos
		panel.setVisible(false);
		panelLista.setVisible(false);
		panel = new JPanel();
		panelLista = new JPanel();
		
		//2) Se le pide la dimensión del 'arreglo' al usuario
		m = pedirValor();

		//3) Se crea un panel en base al tamaño del arreglo
		panelLista.setLayout(new GridLayout());
		
		//4) Agregar el Panel del Arreglo al Frame
		add(panelLista);
		
		//5) Reiniciar el contador del límite de casilla para el arreglo
		cont = 0;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == miSalir)
			System.exit(0);
			
		if(event.getSource() == miArreglo)
			crearArreglo();
			
		if(event.getSource() == miRectangulo)
		{
			crear("RECTANGULO", 100, 149, 237);
		}
		
		
		if(event.getSource() == miCirculo)
			crear("CIRCULO", 152, 245, 255);
		
		if(event.getSource() == miCilindro)
			crear("CILINDRO", 188, 238, 104);
				
		if(event.getSource() == miEspiralRectangulo)
			crear("ESP-RECT", 255, 246, 143);
		
		if(event.getSource() == miEspiralCirculo)
			crear("ESP-CIRC", 176, 23, 31);
		
		if(event.getSource() == miCubo)
			crear("CUBO", 255, 192, 203);
		
		if(event.getSource() == miEspiralCubo)
			crear("ESP-CUBO", 255, 153, 18);
	}
	
	public static void main(String args[])
	{
		GraphicsLinkedList graficos = new GraphicsLinkedList();
		graficos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}