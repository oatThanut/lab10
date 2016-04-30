package coinmachine;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * This program is used to show the number of coin that user put in the machine
 * @author Thanut Sajjakulnukit (5810545416)
 *
 */
public class AcceptingCoin extends JFrame implements Observer {
	
	private JPanel contentPane;
	private JTextField textField;
	private CoinMachine coinMachine;
	
	/**
	 * the constructor of the accepting coin UI
	 * @param cm is the CoinMatchine object
	 */
	public AcceptingCoin(CoinMachine cm){
		this.coinMachine = cm;
		this.setTitle("Accepting Coins");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	
	/**
	 * UI element to show number of coin that user turn in
	 */
	public void initComponents(){
		setBounds(100, 50, 219, 144);
		this.setAlwaysOnTop (true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblcoins = new JLabel("#Coins: ");
		GridBagConstraints gbc_lblcoins = new GridBagConstraints();
		gbc_lblcoins.insets = new Insets(0, 0, 5, 5);
		gbc_lblcoins.anchor = GridBagConstraints.EAST;
		gbc_lblcoins.gridx = 1;
		gbc_lblcoins.gridy = 0;
		contentPane.add(lblcoins, gbc_lblcoins);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel acceptingCoins = new JLabel("Accepting Coins");
		GridBagConstraints gbc_lblAcceptingCoins = new GridBagConstraints();
		gbc_lblAcceptingCoins.insets = new Insets(0, 0, 5, 0);
		gbc_lblAcceptingCoins.gridwidth = 2;
		gbc_lblAcceptingCoins.gridx = 1;
		gbc_lblAcceptingCoins.gridy = 1;
		contentPane.add(acceptingCoins, gbc_lblAcceptingCoins);
		this.pack();
	}

	/**
	 * method update of observer function
	 */
	public void update(Observable o, Object arg) {
		this.textField.setText(""+this.coinMachine.getCount() );
	}
}
