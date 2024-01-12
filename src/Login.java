import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;

import fetch_user.User;

// Login Interface
// Variable name format: [class][Usage]
public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private ForgotPassword forgotPasswordFrame;
	private Register registerFrame;
	private JTextField textUsername;
	private JPasswordField passwordPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0,500 , 500);
		JPanel contentPane=new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(240, 255, 255));
		desktopPane.setBounds(49, 93, 402, 336);
		contentPane.add(desktopPane);
		
		textUsername = new JTextField();
		textUsername.setBounds(88, 61, 252, 50);
		desktopPane.add(textUsername);
		textUsername.setBackground(SystemColor.text);
		textUsername.setToolTipText("電子信箱/帳號");
		
		passwordPassword = new JPasswordField();
		passwordPassword.setBounds(88, 121, 252, 50);
		desktopPane.add(passwordPassword);
		passwordPassword.setToolTipText("密碼");
		
		JLabel labelUsername = new JLabel("帳號");
		labelUsername.setBounds(10, 61, 100, 50);
		desktopPane.add(labelUsername);
		labelUsername.setFont(new Font("新細明體", Font.PLAIN, 20));
		labelUsername.setBackground(new Color(240, 240, 240));
		labelUsername.setForeground(new Color(0, 0, 0));
		
		JLabel labelPassword = new JLabel("密碼");
		labelPassword.setBounds(10, 119, 100, 50);
		desktopPane.add(labelPassword);
		labelPassword.setForeground(Color.BLACK);
		labelPassword.setFont(new Font("新細明體", Font.PLAIN, 20));
		labelPassword.setBackground(UIManager.getColor("Button.background"));
		
		JButton buttonLogin = new JButton("登入");
		buttonLogin.setBounds(88, 181, 252, 30);
		desktopPane.add(buttonLogin);
		buttonLogin.setFocusPainted(false);
		buttonLogin.setBackground(new Color(255, 255, 255));
		buttonLogin.setForeground(SystemColor.activeCaptionBorder);
		buttonLogin.setFont(new Font("新細明體", Font.PLAIN, 15));
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				try {
		        	user = new User(textUsername.getText());
		        	System.out.println("Old user detected.");
		        	if(!user.password.equals(new String(passwordPassword.getPassword()))) throw new ArrayIndexOutOfBoundsException();
		        	JOptionPane.showMessageDialog(null, "登入成功！");
		        	
		        	// ...
		        	// 跳轉回主頁面並使用已驗證身分的user的內容來進行後續操作
		        	
		        } catch (Exception noMatchUserPassword) {
		        	JOptionPane.showMessageDialog(null, "帳號或密碼錯誤，請重試！");
		        }
		        System.out.println(user.userName);
			}
		});
		
		JButton buttonForget = new JButton("忘記密碼");
		buttonForget.setBounds(88, 221, 85, 23);
		desktopPane.add(buttonForget);
		buttonForget.setBorderPainted(false);
		buttonForget.setFocusPainted(false);
		buttonForget.setBackground(new Color(240, 255, 255));
		buttonForget.setForeground(new Color(192, 192, 192));
		buttonForget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (forgotPasswordFrame == null) {
	                forgotPasswordFrame = new ForgotPassword();
	            }
	            forgotPasswordFrame.setVisible(true);
	            setVisible(false);
			}
		});
		
		JButton buttonRegister = new JButton("立即註冊");
		buttonRegister.setBounds(253, 28, 87, 23);
		desktopPane.add(buttonRegister);
		buttonRegister.setBorderPainted(false);
		buttonRegister.setFocusPainted(false);
		buttonRegister.setForeground(new Color(192, 192, 192));
		buttonRegister.setBackground(new Color(240, 255, 255));
		buttonRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (registerFrame == null) {
					registerFrame = new Register();
	            }
				registerFrame.setVisible(true);
	            setVisible(false);
			}
		});
		
		JLabel labelLogin = new JLabel("登入");
		labelLogin.setBounds(98, 13, 75, 38);
		desktopPane.add(labelLogin);
		labelLogin.setHorizontalAlignment(SwingConstants.LEFT);
		labelLogin.setFont(new Font("新細明體", Font.BOLD, 26));
		labelLogin.setForeground(Color.BLACK);
		
		JButton buttonHome = new JButton("首頁");
		buttonHome.setFont(new Font("新細明體", Font.PLAIN, 20));
		buttonHome.setBorderPainted(false);
		buttonHome.setFocusPainted(false);
		buttonHome.setBackground(new Color(255, 255, 255));
		buttonHome.setBounds(10, 0, 79, 46);
		contentPane.add(buttonHome);
		buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ...
				// 跳轉回主頁
			}
		});
	}
}
