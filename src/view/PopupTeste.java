/*
 * Created on 04/03/2004
 */
package view;

import javax.swing.JFrame;

/**
 * @author Douglas Siviotti
 */
public class PopupTeste extends JFrame {
	private javax.swing.JPanel jContentPane = null;

	private javax.swing.JPanel jPanel = null;
	private javax.swing.JButton jButton = null;
	private javax.swing.JPopupMenu popup = null;
	private javax.swing.JMenuItem miPopup1 = null;
	private javax.swing.JMenuItem miPopu2 = null;
	
	public static void main(String[] args) {
		PopupTeste app = new PopupTeste();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.show();
	}
	/**
	 * This is the default constructor
	 */
	public PopupTeste() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(370, 266);
		this.setContentPane(getJContentPane());
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getJPanel(), java.awt.BorderLayout.NORTH);
			jContentPane.add(getPopup(), java.awt.BorderLayout.EAST);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJPanel() {
		if(jPanel == null) {
			jPanel = new javax.swing.JPanel();
			jPanel.add(getJButton(), null);
		}
		return jPanel;
	}
	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton() {
		if(jButton == null) {
			jButton = new javax.swing.JButton();
			jButton.setText("Mostrar Popup");
			jButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					popup.show(jButton, jButton.getWidth(), jButton.getHeight());
				}
			});
		}
		return jButton;
	}
	/**
	 * This method initializes popup
	 * 
	 * @return javax.swing.JPopupMenu
	 */
	private javax.swing.JPopupMenu getPopup() {
		if(popup == null) {
			popup = new javax.swing.JPopupMenu();
			popup.add(getMiPopup1());
			popup.add(getMiPopu2());
		}
		return popup;
	}
	/**
	 * This method initializes miPopup1
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private javax.swing.JMenuItem getMiPopup1() {
		if(miPopup1 == null) {
			miPopup1 = new javax.swing.JMenuItem();
			miPopup1.setText("Item 1");
		}
		return miPopup1;
	}
	/**
	 * This method initializes miPopu2
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private javax.swing.JMenuItem getMiPopu2() {
		if(miPopu2 == null) {
			miPopu2 = new javax.swing.JMenuItem();
			miPopu2.setText("Item 2");
		}
		return miPopu2;
	}
}