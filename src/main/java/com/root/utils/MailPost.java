package com.root.utils;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import sun.misc.BASE64Decoder;


public class MailPost {

    public static void main(String[] args) throws MessagingException {
        //服务器的设置
        Properties props = new Properties();
        props.setProperty("mail.host", "smtp.qq.com");//设置服务器地址
        props.setProperty("mail.smtp.auth", "true");//验证

        //邮箱帐号密码
        Authenticator authenticator = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                //必须使用授权码，而不是密码，去qq邮箱申请    
                return new PasswordAuthentication("12043246678@qq.com","doubleetmgsctxzvnibge");
            }
        };

        //1、与服务器建立连接：Session
        Session session = Session.getDefaultInstance(props, authenticator);

        //2、编写邮件：Message
        Message message = new MimeMessage(session);
        //2.1、发件人
        message.setFrom(new InternetAddress("12043246678@qq.com"));
        //2.2、收件人 , to:收件人、cc ：抄送、bcc：暗送（密送）。
 //       message.setRecipient(RecipientType.TO, new InternetAddress("1016635671@qq.com"));
        message.setRecipient(RecipientType.TO, new InternetAddress("12043246678@qq.com"));
        //2.3、主题
        message.setSubject("测试");
        //2.4、正文
        String str = "哈哈，我发送了222";
        message.setContent(str, "text/html;charset=UTF-8");

        //3、发送
        Transport.send(message);
        System.out.println(str);
    }

    
    public static void testmain(String[] args) throws MessagingException {
        //服务器的设置
        Properties props = new Properties();
        props.setProperty("mail.host", "localhost");//设置服务器地址
        props.setProperty("mail.smtp.auth", "true");//权限验证

        //邮箱帐号密码
        Authenticator authenticator = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("aaa@store.com","123");
            }
        };

        //1、与服务器建立连接：Session
        Session session = Session.getDefaultInstance(props, authenticator);

        //2、编写邮件：Message
        Message message = new MimeMessage(session);
        //2.1、发件人
        message.setFrom(new InternetAddress("aaa@store.com"));
        //2.2、收件人 , to:收件人、cc ：抄送、bcc：暗送（密送）。
        message.setRecipient(RecipientType.TO, new InternetAddress("bbb@store.com"));
        //2.3、主题
        message.setSubject("测试");
        //2.4、正文
        String str = "哈哈，我发送了";
        message.setContent(str, "text/html;charset=UTF-8");

        //3、发送
        Transport.send(message);
    }

    public static void maintest(String args[]) throws IOException{
        /*System.out.print("请输入用户名:");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String userName = in.readLine();
        System.out.print("请输入密码:");
        String password = in.readLine();
        BASE64Encoder encoder = new BASE64Encoder();
        System.out.println("编码后的用户名为:" + encoder.encode(userName.getBytes()));
        System.out.println("编码后的密码为:" + encoder.encode(password.getBytes()));*/
        
        BASE64Decoder decoder = new BASE64Decoder();
        //邮件主题的Base64编码
        String emailSubject = "=?GBK?B?08q8/rLiytQ=?=";
        //邮件文本内容的Base64编码
        String emailPlainContent = "vPK1pbXE08q8/reiy82y4srUo6E=";
        //带html标签和邮件内容的Base64编码
        String emailHtmlContent = "PFA+vPK1pbXE08q8/reiy82y4srUo6E8L1A+";
        //将使用Base64编码过后的文本内容再使用Base64来解码
        emailSubject = new String(decoder.decodeBuffer(emailSubject),"GBK");
        emailPlainContent = new String(decoder.decodeBuffer(emailPlainContent),"GBK");
        emailHtmlContent = new String(decoder.decodeBuffer(emailHtmlContent),"GBK");
        System.out.println("邮件标题："+emailSubject);
        System.out.println("邮件内容："+emailPlainContent);
        System.out.println("带html标签的邮件内容："+emailHtmlContent);
    }

    
}
