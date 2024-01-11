import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class League extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					League frame = new League();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public League() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(192, 192, 192));
		desktopPane.setBounds(28, 36, 717, 254);
		contentPane.add(desktopPane);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(new Color(89, 90, 102));
		desktopPane_1.setBounds(31, 47, 653, 143);
		desktopPane.add(desktopPane_1);
		
		JLabel lblNewLabel = new JLabel("聯盟公告");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblNewLabel.setBounds(279, 10, 100, 107);
		desktopPane_1.add(lblNewLabel);
		
		JDesktopPane desktopPane_2 = new JDesktopPane();
		desktopPane_2.setLayout(null);
		desktopPane_2.setBackground(new Color(192, 192, 192));
		desktopPane_2.setBounds(28, 331, 719, 420);
		contentPane.add(desktopPane_2);
		
		JButton btnNewButton = new JButton("送出");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(623, 371, 87, 23);
		desktopPane_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("簡介");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(23, 51, 87, 23);
		desktopPane_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("盟規");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(23, 95, 87, 23);
		desktopPane_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("成員");
		btnNewButton_3.setBounds(23, 143, 87, 23);
		desktopPane_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("管理員");
		btnNewButton_4.setBounds(23, 185, 87, 23);
		desktopPane_2.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("聊天室");
		btnNewButton_5.setBounds(23, 233, 87, 23);
		desktopPane_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("公告");
		btnNewButton_6.setBounds(23, 278, 87, 23);
		desktopPane_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("商店");
		btnNewButton_7.setBounds(23, 323, 87, 23);
		desktopPane_2.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("積分判定手冊");
		btnNewButton_8.setBounds(23, 371, 87, 23);
		desktopPane_2.add(btnNewButton_8);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(0, 0, 0));
		textPane.setBounds(201, 62, 480, 300);
		desktopPane_2.add(textPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setLineWrap(true);
		textArea.setTabSize(100);
		textArea.setBounds(201, 371, 400, 23);
		desktopPane_2.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("聯盟名稱");
		lblNewLabel_1.setBounds(20, 10, 100, 15);
		desktopPane_2.add(lblNewLabel_1);
	}
}
