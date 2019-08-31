package com.ncs.green;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class UserMailSendService {

	@Autowired
	private JavaMailSender mailSender;
	

	// 회원가입 발송 이메일(인증키 발송)
	public void mailSendWithUserKey(String id, String name, int seq,HttpServletRequest request) {  //id,name,seq를 받아온다
		
		MimeMessage mail = mailSender.createMimeMessage();
		String htmlStr = "<h2>안녕하세요 2nd row 스터디플레너입니다!</h2><br><br>" 
				+ "<h3>" + name + "님</h3>" 
				+ "<p>인증하기 버튼을 누르시면 로그인을 하실 수 있습니다 : " 
				+ "<a href='http://localhost:9090" + request.getContextPath() // request.getContextPath() 값이 green(우리 주소)임
				+ "/joinSuccess?id="+ id +"&seq="+seq //id랑 seq값 넘겨주기
				+"'>인증하기</a></p>"
				+ "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)";  //여기가 내용(html처럼 써야함)
		try {
			mail.setSubject("[2nd row] 스터디 플레너가 발송한 인증메일입니다", "utf-8"); //아마도 제목
			mail.setText(htmlStr, "utf-8", "html");
			mail.addRecipient(RecipientType.TO, new InternetAddress(id));
			mailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		//요기는 저희도 긁어온거라...정확히는 모르겠어욤
	}
}