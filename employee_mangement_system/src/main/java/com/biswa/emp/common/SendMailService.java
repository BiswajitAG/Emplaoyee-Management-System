package com.biswa.emp.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.biswa.entity.Employee;

@Service
public class SendMailService {
	
@Autowired
private JavaMailSender javaMailSender;

public void sendEmail(Employee employee,String m) {
SimpleMailMessage msg = new SimpleMailMessage();
msg.setTo(employee.getMailid());
msg.setSubject("EMS Project");
switch (m) {
case "save": {
	msg.setText("Hello "+employee.getFname()+"\n you registration process is complete"
			+"\n Your password is :"+employee.getPassword());
	break;
}
case "forgot":{
	msg.setText("Hello "+employee.getFname()+"\n Your password is :"+employee.getPassword());
	break;
}
case "ubdate":{
	msg.setText("Hello "+employee.getFname()+"\n Your ubdated password is :"+employee.getPassword());
	break;
}
default:
	msg.setText("Invalid Choise");
break;
}


javaMailSender.send(msg);
System.out.println("mail send sucessfully to"+ employee.getFname());

}
}
