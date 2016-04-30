package coinmachine;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * This program is user interface that show the button of coin
 * and let user choose coin to put in the machine
 * @author Thanut Sajjakulnukit (5810545416)
 *
 */
public class CoinMachineUI extends JFrame implements Observer {
	
	private CoinMachine coinMachine;
	private JPanel contentPane;
	JLabel acceptingCoins;
	JProgressBar progressBar;
	
	/**
	 * The constructor of the accepting coin UI
	 * @param cm is the CoinMatchine object
	 */
	public CoinMachineUI( CoinMachine cm){
		this.coinMachine = cm;
		this.setTitle("Coin machine");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	
	/**
	 * UI element to let user choose the coin to put in the machine
	 */
	public void initComponents(){
		setBounds(100, 100, 440, 201);
		this.setAlwaysOnTop (true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Balance: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		acceptingCoins = new JLabel("0");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 0;
		contentPane.add(acceptingCoins, gbc_label);
		
		JLabel lblStatus = new JLabel("Status:");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.anchor = GridBagConstraints.WEST;
		gbc_lblStatus.gridx = 4;
		gbc_lblStatus.gridy = 0;
		contentPane.add(lblStatus, gbc_lblStatus);
		
		progressBar = new JProgressBar();
		progressBar.setMaximum(this.coinMachine.getCapacity());
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar.gridx = 5;
		gbc_progressBar.gridy = 0;
		contentPane.add(progressBar, gbc_progressBar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Insert Money", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 7;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton oneBahtButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("images/1baht.png")));
		oneBahtButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				click(1);
			}
		});
		panel.add(oneBahtButton);
		
		JButton fiveBahtButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("images/5baht.png")));
		fiveBahtButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				click(5);
			}
		});
		panel.add(fiveBahtButton);
		
		JButton tenBahtButton = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("images/10baht.png")));
		tenBahtButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				click(10);
			}
		});
		panel.add(tenBahtButton);
		this.pack();
	}
	
	/**
	 * This method is used to put value in the machine due to coin that user choose to put in
	 * @param value is the value that the button on the UI have
	 */
	public void click(int value){
		Coin coin = new Coin(value);
		if ( this.coinMachine.insert( coin ) ) {
			System.out.println(coin+" inserted");
		} else {
			System.out.println("Insert "+coin+" FAILED.");
		}
		System.out.println();
	}
	
	/**
	 * method update of observer function
	 */
	public void update(Observable arg0, Object arg1) {
		this.acceptingCoins.setText(""+this.coinMachine.getBalance());
		this.progressBar.setValue(coinMachine.getCount());
	}

}
