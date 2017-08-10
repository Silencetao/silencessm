package com.silencetao.util;

import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.silencetao.common.SilenceInfo;
import com.silencetao.common.SilenceStatus;
import com.silencetao.exception.SilenceException;

/**
 * 邮件工具类
 * @author Silence
 * create time 2017年7月28日 下午3:02:53
 * @version 1.0.1
 */
public class EmailUtils {
    private static final Logger logger = LoggerFactory.getLogger(EmailUtils.class);
    
    /**
     * 用于匹配邮箱的正则表达式
     */
    private static final Pattern emailPattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
    
    /**
     * 判断string是否为正确的邮箱
     * @version 1.0.1 
     * @param string
     * @return
     */
    public static boolean isEmail(String string) {
        return emailPattern.matcher(string).matches();
    }
    
    /**
     * 
     * @version 1.0.1 
     * @param toEmail 目的邮箱地址
     * @param subject 邮件主题
     * @param content 邮件内容
     * @throws SilenceException 
     */
    public static void sendEmail(String toEmail, String subject, String content) throws SilenceException {
        if (StringUtils.isBlank(toEmail)) {
            throw new SilenceException(SilenceStatus.ILLEGAL_ARGUMENT, SilenceInfo.EMAIL_EMPTY);
        } else if (!isEmail(toEmail)) {
            throw new SilenceException(SilenceStatus.ILLEGAL_ARGUMENT, SilenceInfo.EMAIL_FORMAT_ERROR);
        }
        
        if (StringUtils.isBlank(subject)) {
            throw new SilenceException(SilenceStatus.ILLEGAL_ARGUMENT, SilenceInfo.EMAIL_TOPIC_EMPTY);
        }
        
        if (StringUtils.isBlank(content)) {
            throw new SilenceException(SilenceStatus.ILLEGAL_ARGUMENT, SilenceInfo.EMAIL_CONTENT_EMPTY);
        }
        
        Properties properties = new Properties();
        properties.setProperty("mail.host", PropertiesUtils.getProperties("host"));
        properties.setProperty("mail.smtp.auth", "true");
        
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(PropertiesUtils.getProperties("email"), 
                        PropertiesUtils.getProperties("password"));
            }
        });
        
        try {
            MimeMessage message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(PropertiesUtils.getProperties("email")));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(subject);
            message.setContent(content, "text/html;charset=UTF-8");
            
            Transport.send(message);
            logger.info("邮件发送成功:{}", toEmail);
        } catch (AddressException e) {
            logger.error(SilenceInfo.EMAIL_FORMAT_ERROR, e);
            throw new SilenceException(SilenceStatus.ILLEGAL_ARGUMENT, SilenceInfo.EMAIL_FORMAT_ERROR);
        } catch (MessagingException e) {
            logger.error(SilenceInfo.EMAIL_CONTENT_ILLEGAL, e);
            throw new SilenceException(SilenceStatus.ILLEGAL_ARGUMENT, SilenceInfo.EMAIL_CONTENT_ILLEGAL);
        } catch (Exception e) {
            logger.error(SilenceInfo.EMAIL_SEND_FAILED, e);
            throw new SilenceException(SilenceStatus.FAILED, SilenceInfo.EMAIL_SEND_FAILED);
        }
    }
}
