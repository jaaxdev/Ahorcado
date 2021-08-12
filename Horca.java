package Ahorcado;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Horca extends JFrame implements ActionListener {

	Palabras word;
	private JButton[] bt = new JButton[ 2 ];
	private JLabel lab;
	private ImageIcon icon;

	public Horca(){
		setTitle( "Ahorcado" );
		setBounds( 100, 100, 400, 400 );
		setResizable( false );
		setLayout( null );
		getContentPane().setBackground( Color.BLACK );
		initComponents();
		setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
		setVisible( true );
	}

	public void initComponents(){
        bt[0] = new JButton( "Jugar" );
		bt[0].setBounds( 240, 40, 100, 90 );
		bt[1] = new JButton( "Salir" );
		bt[1].setBounds( 255, 200, 70, 60 );

		for( int i=0; i<bt.length; i++ ){
			bt[i].setFocusPainted( false );	// quitar linea punteada de un JButton
			bt[i].setForeground( Color.black );	// cambia el color del texto del JButton
			//bt[i].setBackground( Color.black );	// cambia el color de fondo del JButton
			add( bt[i] );
			bt[i].addActionListener( this );
		}
		lab = new JLabel();
		icon = new ImageIcon( "Ahorcado/ah.png" );
        lab.setIcon( icon );
        lab.setHorizontalAlignment( JLabel.CENTER );
		lab.setVerticalAlignment( JLabel.CENTER );
		lab.setBounds( 0, -30, 400, 400 );
        add( lab );
	}
	public void actionPerformed( ActionEvent ac ){
		if( ac.getSource() == bt[0] ){
			word = new Palabras();
			this.setVisible( false );
		}
		if( ac.getSource() == bt[1] )
			System.exit(0);
	}
	public static void main( String[] args ){
		new Horca();
	}
}