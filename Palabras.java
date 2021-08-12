package Ahorcado;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Palabras extends JFrame implements ActionListener {

	Horca hor;
	Palabras word;
	private String[] rom = new String[ 30 ];
	private Random r = new Random();
	private String tmp, cs;
	private char[] at;
 	private JTextField[] tx;
 	private JLabel[] tag;
 	private JLabel[] pac;
 	private JButton[] sal = new JButton[ 3 ];
	private int ran, i, a=1, h=0, k=0;
	private boolean ri;
	private ImageIcon[] icon = new ImageIcon[ 6 ];
	private JLabel[] lab = new JLabel[ 6 ];

	public Palabras(){
		setTitle( "Jugando..." );
		setBounds( 600, 70, 650, 650 );
		setResizable( false );
		setLayout( null );
		generador();
		lab[0].setIcon( icon[0] );
		getContentPane().setBackground( Color.BLACK );
		setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
		setVisible( true );
	}
	public void generador(){
		for( i=0; i<rom.length; i++ ){
			rom[i] = new String();
		}
		rom[0]="herencia"; rom[1]="polimorfismo";  rom[2]="agregacion"; rom[3]="objeto"; rom[4]="metodos"; rom[5]="abstraccion"; rom[6]="jtextfield";
		rom[7]="atributo"; rom[8]="asociacion"; rom[9]="clase"; rom[10]="encapsulamiento"; rom[11]="composicion"; rom[12]="java"; rom[13]="poo"; 
		rom[14]="constructor"; rom[15]="arraylist"; rom[16]="private"; rom[17]="public"; rom[18]="protected"; rom[19]="default"; rom[20]="jpanel"; rom[21]="jbutton"; 
		rom[22]="interfaz"; rom[23]="jlabel"; rom[24]="evento"; rom[25]="jframe"; rom[26]="package"; rom[27]="tostring"; rom[28]="equals"; rom[29]="gettext";

		ran = r.nextInt( 30 );	// genera aleatorio
		tmp = rom[ ran ];	// ran = indice en que está la palabra
		at = tmp.toCharArray();	// creación de arreglo char desde string
		tx = new JTextField[ at.length ];
		tag = new JLabel[ at.length ];
		pac = new JLabel[ at.length ];

		for( i=0; i<at.length; i++ ){
			tx[i] = new JTextField();
			tag[i] = new JLabel();
			pac[i] = new JLabel();
			tx[i].setBounds( a*20, 70, 30, 30 );
			tag[i].setBounds( a*20, 100, 30, 30 );
			pac[i].setBounds( a*20, 70, 30, 30 );
			tag[i].setText( "    "+( i+1 ) );
			pac[i].setText( "    "+cs.valueOf( at[i] ) );
			tag[i].setForeground( Color.white );
			pac[i].setForeground( Color.white );	// cambia color del texto en cada label
			add( pac[i] );
			add( tx[i] );
			add( tag[i] );
			tx[i].addActionListener( this );
			a = a+2;
		}
		icon[0] = new ImageIcon( "Ahorcado/cabeza.png" );
		icon[1] = new ImageIcon( "Ahorcado/torso.jpg" );
		icon[2] = new ImageIcon( "Ahorcado/bder.jpg" );
		icon[3] = new ImageIcon( "Ahorcado/bizq.jpg" );
		icon[4] = new ImageIcon( "Ahorcado/lder.jpg" );
		icon[5] = new ImageIcon( "Ahorcado/lizq.jpg" );
		for( i=0; i<icon.length; i++ ){
			lab[i] = new JLabel();
			lab[i].setBounds( 130, 70, 500, 500 );
			lab[i].setHorizontalAlignment(JLabel.CENTER);
			lab[i].setVerticalAlignment(JLabel.CENTER);
			add( lab[i] );
		}
		sal[0] = new JButton( "Volver" );
		sal[1] = new JButton( "Reiniciar" );
		sal[2] = new JButton( "Mostrar Palabra" );
		//sal[3] = new JButton( "Verificar" );
		sal[0].setBounds( 500, 520, 100, 50 );
		sal[1].setBounds( 50, 520, 100, 50 );
		sal[2].setBounds( 230, 520, 200, 50 );
		//sal[3].setBounds( 50, 410, 100, 50 );
		for( i=0; i<sal.length; i++ ){
			//sal[i].setBorderPainted( false ); // quitar borde del jbutton
			add( sal[i] );
			sal[i].addActionListener( this );
		}
		System.out.println( tmp );
	}
	public void actionPerformed( ActionEvent ac ){
		for( i=0; i<at.length; i++ ){
			if( ac.getSource() == tx[i] )
				correcto( ac );
			
		}
		if( ac.getSource() == sal[0] ){
			this.dispose();
			hor = new Horca();
		}
		if( ac.getSource() == sal[1] ){
			this.dispose();
			word = new Palabras();
		}
		if( ac.getSource() == sal[2] ){
			JOptionPane.showMessageDialog( null, tmp, "Palabra secreta", JOptionPane.INFORMATION_MESSAGE,
			new ImageIcon( "Ahorcado/pirate.jpg" ) );
			this.dispose();
			hor = new Horca();
		}
		//if( ac.getSource() == sal[3] ){		}
	}
	public void correcto( ActionEvent ac ){
		//for( i=0; i<at.length; i++ ){
			if( ac.getSource() == tx[i] ){
				ri = tx[i].getText().equalsIgnoreCase( cs.valueOf( at[i] ) );
				if( ri == true ){
					k++;
					tx[i].setVisible( false );
				} else {
					h++;
					tx[i].setText( null );
				}
			}
		//}
		if( h == 1 )
			lab[0].setVisible( false );	// nuevas coordenadas para label
			lab[1].setIcon( icon[1] );
		if( h == 2 )
			lab[1].setVisible( false );
			lab[2].setIcon( icon[2] );
		if( h == 3 )
			lab[2].setVisible( false );
			lab[3].setIcon( icon[3] );
		if( h == 4 )
			lab[3].setVisible( false );
			lab[4].setIcon( icon[4] );
		if( h == 5 ){
			lab[4].setVisible( false );
			lab[5].setIcon( icon[5] );
			JOptionPane.showMessageDialog( this, "Has Perdido", "Juego terminado", JOptionPane.INFORMATION_MESSAGE,
			new ImageIcon( "Ahorcado/dsper.jpg" ) );
			this.dispose();
			hor = new Horca();
		}
		if( k == at.length ){
			JOptionPane.showMessageDialog( null, "Has ganado", "Juego terminado", JOptionPane.INFORMATION_MESSAGE,
			new ImageIcon( "Ahorcado/falone.png" ) );
			this.dispose();
			hor = new Horca();
		}
	}
}