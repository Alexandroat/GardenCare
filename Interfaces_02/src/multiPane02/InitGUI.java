package multiPane02;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import javax.swing.Box;
import javax.swing.UIManager;

public class InitGUI extends JFrame {

	private JPanel contentPane;
	private Component frame;
	private final static String IMG = "Images/";
	private JLabel lblNewLabel_4;
	private String sel;
	private JButton btnOpenDialog;
	private CardLayout cl_panel;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitGUI frame = new InitGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	{
		for (LookAndFeelInfo info : javax.swing.UIManager
				.getInstalledLookAndFeels()) {
			try {
				javax.swing.UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public InitGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 446);
		setTitle("Garden care");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));

		JToolBar toolBar = new JToolBar();
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setToolTipText("Choose weather conditions");
		toolBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.add(toolBar);

		JLabel lblPerfectSun = new JLabel("Perfect sun");
		lblPerfectSun.setBackground(UIManager.getColor("Button.background"));
		lblPerfectSun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cl_panel.show(panel, "panel1");
			}
		});
		
		Component horizontalGlue = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue);
		lblPerfectSun.setIconTextGap(3);
		lblPerfectSun.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPerfectSun.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Sunshine@Low.png")));
		toolBar.add(lblPerfectSun);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue_1);
		// toolBar.add(new JSeparator (SwingConstants.VERTICAL));
		toolBar.addSeparator();

		JLabel lblCloudy = new JLabel("Cloudy");
		lblCloudy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cl_panel.show(panel, "panel2");

			}
		});
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue_2);
		lblCloudy.setIconTextGap(3);
		lblCloudy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCloudy.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Cloudy@Low.png")));
		toolBar.add(lblCloudy);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue_3);
		// toolBar.add(new JSeparator (SwingConstants.VERTICAL));
		toolBar.addSeparator();
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue_4);

		JLabel lblRain = new JLabel("Rains");
		lblRain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cl_panel.show(panel, "panel4");
			}
		});
		lblRain.setIconTextGap(3);
		lblRain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRain.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Cloud-Download@Low.png")));
		toolBar.add(lblRain);
		
		Component horizontalGlue_7 = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue_7);
		toolBar.addSeparator();

		JLabel lblWind = new JLabel("Windy");
		lblWind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cl_panel.show(panel, "panel3");
			}
		});
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue_5);
		lblWind.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblWind.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Refresh@Low.png")));
		toolBar.add(lblWind);
		
		Component horizontalGlue_6 = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue_6);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));

		/**
		 * Defining JList and its model for supplying content
		 */

		ListModel jList1Model = new DefaultComboBoxModel(new String[] {
				"Water", "Petrol", "Milk" });
		final JList list = new JList();
		panel_3.add(list);
		list.setFont(new Font("Courier New", Font.PLAIN, 14));
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		list.setBackground(new Color(238, 238, 238));
		list.setModel(jList1Model);

		// multiple selection
		int[] selectedIx = list.getSelectedIndices();

		// Get all the selected items using the indices
		for (int i = 0; i < selectedIx.length; i++) {
			Object sel = list.getModel().getElementAt(selectedIx[i]);
		}

		// Get the index of the first selected item
		// int firstSelIx = list.getSelectedIndex();

		/**
		 * customized square button
		 */

		btnOpenDialog = new JButton("");
		btnOpenDialog.setToolTipText("Go?");
		btnOpenDialog.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOpenDialog.setIcon(new ImageIcon(InitGUI.class
				.getResource("/Images/Water-Drop.png")));
		btnOpenDialog.setMnemonic('W');
		btnOpenDialog.setMargin(new Insets(0, 0, 0, 0));
		panel_2.add(btnOpenDialog);

		/**
		 * JList selected
		 * 
		 * @param evt
		 */
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		final JSlider slider = new JSlider();
		slider.setAlignmentX(Component.LEFT_ALIGNMENT);
		slider.setValue(25);
		panel_1.add(slider);

		lblNewLabel_4 = new JLabel("Dropping...");
		panel_1.add(lblNewLabel_4);

		/**
		 * shows an option pane with a dialog asking for confirmation
		 */
		btnOpenDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Dialoging
				String message = "Are you 100% sure?";
				int answer = JOptionPane.showConfirmDialog(frame, message);
				if (answer == JOptionPane.YES_OPTION) {
					int[] selectedIx = list.getSelectedIndices();
					lblNewLabel_4.setText("Dropping...");
					// Get all the selected items using the indices
					for (int i = 0; i < selectedIx.length; i++) {
						sel = (String) list.getModel().getElementAt(
								selectedIx[i]);
						lblNewLabel_4.setText(lblNewLabel_4.getText() + " "
								+ sel + " ");
						System.out.println(sel);
					}
					lblNewLabel_4.setText(lblNewLabel_4.getText() + " at "
							+ slider.getValue() + "%");
					// User clicked YES.
				} else if (answer == JOptionPane.NO_OPTION) {
					// User clicked NO.
					lblNewLabel_4.setText(" Dropping... nothing yet");
				}
			}
		});

		/**
		 * New panel with a card layout, which contains another 4 panels in
		 * order to use 4 different images.
		 */
		panel = new JPanel();
		contentPane.add(panel);
		cl_panel = new CardLayout(0, 0);
		panel.setLayout(cl_panel);

		/**
		 * For each new panel, we call our drawing panel.
		 */
		JPanel panel_4 = new ImgPanel(IMG + "hierba-footer.png");
		panel.add(panel_4, "panel1");

		JPanel panel_5 = new ImgPanel(IMG + "hierba-Cloudy.png");
		panel.add(panel_5, "panel2");

		JPanel panel_6 = new ImgPanel(IMG + "hierba-wind.png");
		panel.add(panel_6, "panel3");
		
		JPanel panel_7 = new ImgPanel(IMG + "hierba-rain.png");
		panel.add(panel_7, "panel4");

		cl_panel.show(panel, "panel1");

	}
}
