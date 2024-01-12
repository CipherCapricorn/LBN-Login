import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import fetch_user.User;
import send_email.SendEmail;

// Forgot password interface
// Variable name format: [class][Usage]
public class ForgotPassword extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Login loginFrame;
	private JTextField textUsername;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
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
	public ForgotPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 500);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(240, 255, 255));
		desktopPane.setBounds(49, 93, 402, 336);
		contentPane.add(desktopPane);
		
		textUsername = new JTextField();
		textUsername.setBounds(108, 61, 252, 50);
		desktopPane.add(textUsername);
		textUsername.setBackground(SystemColor.text);
		textUsername.setToolTipText("用戶名稱");
		
		textEmail = new JTextField();
		textEmail.setBounds(108, 121, 252, 50);
		desktopPane.add(textEmail);
		textEmail.setBackground(SystemColor.text);
		textEmail.setToolTipText("註冊時使用的電子信箱（曾收到註冊成功的信箱）");
		
		JLabel labelUsername = new JLabel("帳號");
		labelUsername.setBounds(10, 61, 100, 50);
		desktopPane.add(labelUsername);
		labelUsername.setFont(new Font("新細明體", Font.PLAIN, 20));
		labelUsername.setBackground(new Color(240, 240, 240));
		labelUsername.setForeground(new Color(0, 0, 0));
		
		JLabel labelEmail = new JLabel("電子信箱");
		labelEmail.setBounds(10, 119, 100, 50);
		desktopPane.add(labelEmail);
		labelEmail.setForeground(Color.BLACK);
		labelEmail.setFont(new Font("新細明體", Font.PLAIN, 20));
		labelEmail.setBackground(UIManager.getColor("Button.background"));
		
		JLabel labelLogin = new JLabel("忘記密碼");
		labelLogin.setBounds(118, 13, 147, 38);
		desktopPane.add(labelLogin);
		labelLogin.setHorizontalAlignment(SwingConstants.LEFT);
		labelLogin.setFont(new Font("新細明體", Font.BOLD, 26));
		labelLogin.setForeground(Color.BLACK);
		
		JButton buttonRequest = new JButton("送出請求");
		buttonRequest.setBounds(108, 181, 252, 30);
		desktopPane.add(buttonRequest);
		buttonRequest.setFocusPainted(false);
		buttonRequest.setBackground(new Color(255, 255, 255));
		buttonRequest.setForeground(SystemColor.activeCaptionBorder);
		buttonRequest.setFont(new Font("新細明體", Font.PLAIN, 15));
		buttonRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				try {
		        	user = new User(textUsername.getText());
		        	System.out.println("Old user detected.");
		        	if(!user.email.equals(new String(textEmail.getText()))) throw new ArrayIndexOutOfBoundsException();
		        	SendEmail mail = new SendEmail();
		        	mail.customer = textEmail.getText();
		        	mail.Subject = "LBN競技擂台取回密碼請求";
		        	mail.txt = user.userName + "<html>，您已要求本平台送出密碼至此電子郵件信箱，若操作者並非您本人，請立即更改您的密碼或者聯繫平台管理員。<br>" + 
		        			   "您的密碼為：" + user.password + "<br>" + 
		        			   "祝您有個美好的一天！<br><br><br>" + 
		        			   "本訊息為LBN平台自動發送，請勿回信。</html>";
		        	mail.SendEmail();
		        	JOptionPane.showMessageDialog(null, "已發送密碼至你的電子郵件信箱，請查收並嘗試登入！");
		        	loginFrame = new Login();
		        	loginFrame.setVisible(true);
		        	setVisible(false);
		        } catch (Exception noMatchUserEmail) {
		        	JOptionPane.showMessageDialog(null, "此用戶不存在或者電子郵件信箱錯誤，請重試！");
		        }
		        System.out.println(user.userName);
			}
		});
		
		JButton buttonPrevious = new JButton("返回");
		buttonPrevious.setFont(new Font("新細明體", Font.PLAIN, 20));
		buttonPrevious.setBorderPainted(false);
		buttonPrevious.setFocusPainted(false);
		buttonPrevious.setBackground(new Color(255, 255, 255));
		buttonPrevious.setBounds(10, 0, 79, 46);
		contentPane.add(buttonPrevious);
		buttonPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginFrame = new Login();
				loginFrame.setVisible(true);
				setVisible(false);
			}
		});
	}
}
