package br.com.ongvd.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@Service
public class EmailServiceImpl implements EmailService {
	
	private final Logger LOG = LoggerFactory.getLogger(EmailServiceImpl.class);
	
	private SendGrid sendGridClient;
	
    @Autowired
    public EmailServiceImpl(SendGrid sendGridClient) {
        this.sendGridClient = sendGridClient;
    }
    
    @Override
    public void enviarTexto(String emailDe, String emailPara, String assunto, String corpo) {
        Response response = enviarEmail(emailDe, emailPara, assunto, new Content("text/plain", corpo));
        LOG.info("Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: "
                + response.getHeaders());
    }
    
    @Override
    public void enviarHTML(String emailDe, String emailPara, String assunto, String corpo) {
        Response response = enviarEmail(emailDe, emailPara, assunto, new Content("text/html", corpo));
        LOG.info("Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: "
                + response.getHeaders());
    }
    
    private Response enviarEmail(String emailDe, String emailPara, String assunto, Content content) {
        Mail mail = new Mail(new Email(emailDe), assunto, new Email(emailPara), content);
        mail.setReplyTo(new Email(emailDe));
        Request request = new Request();
        Response response = null;
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = sendGridClient.api(request);
        } catch (IOException ex) {
        	LOG.info(ex.getMessage());
        }
        return response;
    }
}
