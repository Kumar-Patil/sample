package com.taxi.helper;

import java.util.List;

import com.taxi.email.MailUtils;
import com.taxi.exception.EmailException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordReset implements Runnable {

    private List<String> to;
    private String from;
    private String mailBody;
    private String subject;

    public PasswordReset(List<String> recipientEmails, String from, String mailBody, String subject) {
        super();
        this.to = recipientEmails;
        this.from = from;
        this.mailBody = mailBody;
        this.subject = subject;
    }

    private MailUtils mailUtil = new MailUtils();

    public String getMailBody() {
        return mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    //Setting email disclimer1
    public void run() {
        try {
            mailUtil.sendMail(from, to, subject, mailBody);
        } catch (EmailException ex) {
            Logger.getLogger(PasswordReset.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
