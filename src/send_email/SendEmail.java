package send_email;

import java.util.Properties;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.*;

public class SendEmail 
{	
	//基本資料設定
	private String Systemuser = "rainlin0625@gmail.com";//寄件者帳號
	private String Systempassword = "putkqpkgpqaixjlj";//寄件者密碼
	public String customer= "411177016@mail.nknu.edu.tw";//收件者帳號，之後會改成接受到的
	public String Subject = "恭喜註冊此帳號";//信件標題
	public String txt = "您的驗證碼為：";//信件內容
	
	@SuppressWarnings("static-access")
	public void SendEmail() {
		//------連線設定
		Properties prop= new Properties();
		
		//設定連線方式為smtp
		prop.setProperty("mail.transport.protocol", "smtp");//設定網頁檔案smtp
		
		//host : smtp.gamil.com
		prop.setProperty("mail.host", "smtp.gmail.com");
		
		//host port 465
		prop.put("mail.smtp.port", "465");
		
		//驗證寄件者帳號
		prop.put("mail.smtp.auth", "true");//使否要驗證，auth值為布林，所以後面要輸入true or false
		
		//呼叫安全傳輸層(SSL)
		//為甚麼?因為java直接傳輸到網路上是沒有被包裝得很安全的，所以需要一個安全的保護層去使傳送時更加安全
		prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		
		//安全資料傳送層 + prot465
		prop.put("mail.smtp.socketFactory", "465");
		
		//------帳號驗證
		//------Session javamail api 基礎設定屬性
		
		//session獲得帳號和密碼
		Session session= Session.getDefaultInstance(prop, new Authenticator(){
			/*如何創建Override?
			 * 對Authenticator點右鍵，點Source的Override/implement
			 *把視窗內的框框打勾(只有一個框框叫做getPasswordAuthentication)
			 *註：此功能擁有，但不代表所有的object可以使用，需要用到要去確認java有沒有此功能
			*/
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(Systemuser,Systempassword);
			}
			
		});
		
		//------Message放入基本資料
		//這裡是主要寄信的內容
		MimeMessage message = new MimeMessage(session);
		
		try {
			//設定寄件者 //匿名類別
			message.setSender(new InternetAddress(Systemuser));
			
			//設定收件者
			message.setRecipient(RecipientType.TO, new InternetAddress(customer));
			
			//設定標題
			message.setSubject(Subject);
			
			//設定內容/格式
			message.setContent(txt, "text/html;charset=UTF-8");//設定資料型態就像html的寫法
			
			//------Transport將message傳出去(把信件包好後寄出)
			Transport transport = session.getTransport();
			transport.send(message);
			transport.close();
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}