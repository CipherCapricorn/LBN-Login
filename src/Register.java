import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import fetch_user.User;
import send_email.SendEmail;

// Register interface
// Variable name format: [class][Usage]
public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private Login loginFrame;
	private JTextField textUsername;
	private JTextField textRealname;
	private JComboBox<String> comboCountry;
	private JTextField textAge;
	private JTextField textEmail;
	private JPasswordField passwordPassword;
	private JPasswordField passwordConfirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 780);
		JPanel contentPane=new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(240, 255, 255));
		desktopPane.setBounds(49, 93, 402, 616);
		contentPane.add(desktopPane);
		
		JLabel labelRegister = new JLabel("註冊");
		labelRegister.setBounds(118, 13, 75, 38);
		desktopPane.add(labelRegister);
		labelRegister.setHorizontalAlignment(SwingConstants.LEFT);
		labelRegister.setFont(new Font("新細明體", Font.BOLD, 26));
		labelRegister.setForeground(Color.BLACK);
		
		textUsername = new JTextField();
		textUsername.setBounds(108, 61, 252, 50);
		desktopPane.add(textUsername);
		textUsername.setBackground(SystemColor.text);
		textUsername.setToolTipText("顯示給其他用戶的名稱，至少四個字元以上");
		
		textRealname = new JTextField();
		textRealname.setBounds(108, 121, 252, 50);
		desktopPane.add(textRealname);
		textRealname.setBackground(SystemColor.text);
		textRealname.setToolTipText("只顯示在個人檔案中");
		
		String[] countries = {"Select your country", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Republic", "Chad", "Chile", "China (People's Republic)", "Colombia", "Comoros", "Congo (Republic)", "Costa Rica", "Cote d'Ivoire (Ivory Coast)", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor (Timor-Leste)", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea (North)", "Korea (South)", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia (Federated States of)", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar (Burma)", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Macedonia (formerly Macedonia)", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"};
		comboCountry = new JComboBox<>(countries);
		comboCountry.setBounds(108, 181, 252, 50);
		desktopPane.add(comboCountry);
		
		textAge = new JTextField();
		textAge.setBounds(108, 241, 252, 50);
		desktopPane.add(textAge);
		textAge.setBackground(SystemColor.text);
		textAge.setToolTipText("輸入您的年齡");
		
		textEmail = new JTextField();
		textEmail.setBounds(108, 301, 252, 50);
		desktopPane.add(textEmail);
		textEmail.setBackground(SystemColor.text);
		textEmail.setToolTipText("abc@example.com");
		
		passwordPassword = new JPasswordField();
		passwordPassword.setBounds(108, 361, 252, 50);
		desktopPane.add(passwordPassword);
		passwordPassword.setToolTipText("請輸入至少八個字元的密碼");
		
		passwordConfirmPassword = new JPasswordField();
		passwordConfirmPassword.setBounds(108, 421, 252, 50);
		desktopPane.add(passwordConfirmPassword);
		passwordConfirmPassword.setToolTipText("輸入與上面相同的密碼");
		
		JLabel labelUsername = new JLabel("帳號");
		labelUsername.setBounds(10, 61, 100, 50);
		desktopPane.add(labelUsername);
		labelUsername.setFont(new Font("新細明體", Font.PLAIN, 20));
		labelUsername.setBackground(new Color(240, 240, 240));
		labelUsername.setForeground(new Color(0, 0, 0));
		
		JLabel labelRealname = new JLabel("真實姓名");
		labelRealname.setBounds(10, 121, 100, 50);
		desktopPane.add(labelRealname);
		labelRealname.setFont(new Font("新細明體", Font.PLAIN, 20));
		labelRealname.setBackground(new Color(240, 240, 240));
		labelRealname.setForeground(new Color(0, 0, 0));
		
		JLabel labelCountry = new JLabel("國家");
		labelCountry.setBounds(10, 181, 100, 50);
		desktopPane.add(labelCountry);
		labelCountry.setFont(new Font("新細明體", Font.PLAIN, 20));
		labelCountry.setBackground(new Color(240, 240, 240));
		labelCountry.setForeground(new Color(0, 0, 0));
		
		JLabel labelAge = new JLabel("年齡");
		labelAge.setBounds(10, 241, 100, 50);
		desktopPane.add(labelAge);
		labelAge.setFont(new Font("新細明體", Font.PLAIN, 20));
		labelAge.setBackground(new Color(240, 240, 240));
		labelAge.setForeground(new Color(0, 0, 0));
		
		JLabel labelEmail = new JLabel("電子信箱");
		labelEmail.setBounds(10, 301, 100, 50);
		desktopPane.add(labelEmail);
		labelEmail.setFont(new Font("新細明體", Font.PLAIN, 20));
		labelEmail.setBackground(new Color(240, 240, 240));
		labelEmail.setForeground(new Color(0, 0, 0));
		
		JLabel labelPassword = new JLabel("密碼");
		labelPassword.setBounds(10, 361, 100, 50);
		desktopPane.add(labelPassword);
		labelPassword.setFont(new Font("新細明體", Font.PLAIN, 20));
		labelPassword.setBackground(new Color(240, 240, 240));
		labelPassword.setForeground(new Color(0, 0, 0));
		
		JLabel labelConfirmPassword = new JLabel("確認密碼");
		labelConfirmPassword.setBounds(10, 421, 100, 50);
		desktopPane.add(labelConfirmPassword);
		labelConfirmPassword.setFont(new Font("新細明體", Font.PLAIN, 20));
		labelConfirmPassword.setBackground(new Color(240, 240, 240));
		labelConfirmPassword.setForeground(new Color(0, 0, 0));
		
		JButton buttonRegister = new JButton("註冊");
		buttonRegister.setBounds(108, 481, 252, 30);
		desktopPane.add(buttonRegister);
		buttonRegister.setFocusPainted(false);
		buttonRegister.setBackground(new Color(255, 255, 255));
		buttonRegister.setForeground(SystemColor.activeCaptionBorder);
		buttonRegister.setFont(new Font("新細明體", Font.PLAIN, 15));
		buttonRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				try {
		        	user = new User(textUsername.getText());
		        	System.out.println("Old user detected.");
		        	JOptionPane.showMessageDialog(null, "此用戶名稱已被使用，請嘗試其他名稱！");
		        } catch (Exception unusedUsername) {
		        	if(textUsername.getText().length() < 4) JOptionPane.showMessageDialog(null, "用戶名稱不得小於四個字元");
		        	else if(Integer.parseInt(textAge.getText()) < 13) JOptionPane.showMessageDialog(null, "很抱歉，您的年齡不足無法註冊（去給我乖乖念書！ψ( • ̀ω•́ )ψ ）");
		        	else if(new String(passwordPassword.getPassword()).length() < 8) JOptionPane.showMessageDialog(null, "密碼長度應至少八字元長");
		        	else if(!new String(passwordPassword.getPassword()).equals(new String(passwordConfirmPassword.getPassword()))) JOptionPane.showMessageDialog(null, "密碼與確認密碼不相同！");
		        	else {
		        		user.register(textUsername.getText(), textRealname.getText(), comboCountry.getSelectedItem().toString(), textAge.getText(), textEmail.getText(), new String(passwordPassword.getPassword()));
		        		try {
							user = new User(textUsername.getText());
						} catch (Exception e1) {
							e1.printStackTrace();
						}
		        		SendEmail mail = new SendEmail();
			        	mail.customer = textEmail.getText();
			        	mail.Subject = "LBN競技擂台註冊完成！";
			        	mail.txt = user.userName + "<html>，感謝您使用LBN競技擂台！<br>" + 
			        			   "您現在可以使用聯盟功能並且參與聯盟及活動，並解鎖了許多功能，立刻去登入看看吧！<br>" + 
			        			   "祝您有個美好的一天！<br><br><br>" + 
			        			   "本訊息為LBN平台自動發送，請勿回信。</html>";
			        	mail.SendEmail();
			        	JOptionPane.showMessageDialog(null, "註冊完成！將引導您返回登入頁面進行登入...");
		        		loginFrame = new Login();
			        	loginFrame.setVisible(true);
			        	setVisible(false);
		        	}
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
