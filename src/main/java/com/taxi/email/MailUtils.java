package com.taxi.email;

import com.taxi.exception.EmailException;
import com.taxi.exception.FileNotFoundException;
import com.taxi.helper.PasswordReset;
import com.taxi.service.UserService;
import com.taxi.to.Response;
import com.taxi.util.Config;
import com.taxi.util.Status;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.mail.MessagingException;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class MailUtils {

    static final Logger LOG = Logger.getLogger(MailUtils.class);

    public void sendMail(String from, List<String> to, String subject, String msg) throws EmailException {
        try {
            Resource res = new ClassPathResource("mailConfiguration.xml");
            BeanFactory factory = new XmlBeanFactory(res);
            Object o = factory.getBean("id2");
            AOPUtil ml = (AOPUtil) o;
            ml.sendMail(from, to, subject, msg);
        } catch (UnsupportedEncodingException | MessagingException | BeansException ex) {
            throw new EmailException("Enable to send email {}" + ex.getMessage());
        }
    }

    public Response sendOTPMail(String emailId, UserService service) throws EmailException {
        Response response = null;
        try {
            List<String> recipientEmails = new ArrayList<>();
            recipientEmails.add(emailId);
            Config config = new Config();
            String fromEmail = config.getProperty("FROM_EMAIL_ID");
            String emailBody = null;
            int randNum = (new Random()).nextInt(900000) + 100000;
            StringBuilder message = new StringBuilder();
            message.append("<table><tr style=\"vertical-align:top;\"><td><b>Use OTP to change existed password  :" + randNum + "</b></td>");
            emailBody = message.toString();
            Thread thread1 = new Thread(new PasswordReset(recipientEmails, fromEmail, emailBody, "Reset Password : OTP details"));
            thread1.start();
            //Need to handle 
            //this.userService.updateOTP(emailId, String.valueOf(randNum));
            response = new Response(Status.SUCESS.getName(), Status.SUCESS.getDisplayName());
        } catch (FileNotFoundException e) {
            response = new Response(Status.ERROR.getName(), Status.ERROR.getDisplayName());
        }
        return response;
    }
}
