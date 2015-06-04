package dnd;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class InventoryFrame {

	private JFrame frame;
	private JPanel contentPane, itemsPanel;
	private CharacterPanel parent;

	// Constructor for frame
	public InventoryFrame(CharacterPanel parent) {
		this.parent = parent;
		frame = new JFrame("Inventory of " + parent.character.getName());
		contentPane = new JPanel();
		frame.setContentPane(contentPane);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		itemsPanel = new JPanel();
		drawItems();
		contentPane.add(itemsPanel);
		JPanel btnPanel = new JPanel();
		JButton btnAdd = new JButton("Add Item");
		// ActionListener for remove item button
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddItemFrame addItemFrame = new AddItemFrame(parent.character);
				// WindowListener to update GUI after adding item
				addItemFrame.addWindowListener(new WindowListener() {
					@Override
					public void windowClosed(WindowEvent arg0) {
						drawItems();
						frame.pack();
					}

					@Override
					public void windowClosing(WindowEvent arg0) {
					}

					@Override
					public void windowDeactivated(WindowEvent arg0) {
					}

					@Override
					public void windowDeiconified(WindowEvent arg0) {
					}

					@Override
					public void windowIconified(WindowEvent arg0) {
					}

					@Override
					public void windowOpened(WindowEvent arg0) {
					}

					@Override
					public void windowActivated(WindowEvent e) {
					}
				});
			}
		});
		btnPanel.add(btnAdd);
		contentPane.add(btnPanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// Draws the items in the items ArrayList
	private void drawItems() {
		itemsPanel.removeAll();
		itemsPanel.setLayout(new GridBagLayout());
		int i = 0;
		for (Item item : parent.character.getItemList()) {
			int j = 0;
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(0, 5, 0, 5);
			gbc.gridx = j++;
			gbc.gridy = i++;
			JLabel lblName = new JLabel(item.getName());
			itemsPanel.add(lblName, gbc);
			gbc.gridx = j++;
			JLabel lblPrice = new JLabel(String.valueOf(item.getValue()) + "g");
			itemsPanel.add(lblPrice, gbc);
			gbc.gridx = j++;
			JLabel lblDesc = new JLabel(item.getDescription());
			itemsPanel.add(lblDesc, gbc);
			gbc.gridx = j++;
			JButton btnRemove = new JButton("Delete");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					parent.character.removeItem(item);
					drawItems();
					frame.pack();
				}
			});
			itemsPanel.add(btnRemove, gbc);
		}
	}
}
