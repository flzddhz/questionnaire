package com.example.questionnaire.utils;

import org.junit.Test;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailUtils {

    private static String myEmailAccount = "luoshuai9527@163.com";          //发送邮箱
    private static String myEmailPassword = "DKCMIEPOTUKAMJQX";             //邮箱授权码
    private static String smtp = "smtp.163.com";                            //163的smtp
//    private static String receiveMailAccount = "sluo@suntakpcb.com";        // 收件人邮箱
    private static String receiveMailAccount = "sluo@suntakpcb.com,luoshuai9527@163.com";        // 收件人邮箱

    /**
     * 发送邮件
     *
     * @param emailContent
     */
    public void senEmail(String emailContent) {
        try {
            // 1. 创建参数配置, 用于连接邮件服务器的参数配置
            Properties props = new Properties();
            // 使用的协议（JavaMail规范要求）
            props.setProperty("mail.transport.protocol", "smtp");
            // 发件人的邮箱的 SMTP 服务器地址
            props.setProperty("mail.smtp.host", smtp);
            // 需要请求认证
            props.setProperty("mail.smtp.auth", "true");
            // 2. 根据配置创建会话对象, 用于和邮件服务器交互
            Session session = Session.getInstance(props);
            // 设置为debug模式, 可以查看详细的发送 log
            session.setDebug(true);
            // 3. 创建一封邮件    session、发件人、收件人、邮件内容
            MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount, emailContent);
            // 4. 根据 Session 获取邮件传输对象
            Transport transport = session.getTransport();
            // 5. 使用 邮箱账号 和 密码/授权码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
            transport.connect(myEmailAccount, myEmailPassword);
            // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            System.out.println("发送成功！！！！！！！！！！");
            transport.sendMessage(message, message.getAllRecipients());
            // 7. 关闭连接
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MimeMessage createMimeMessage(Session session, String myEmailAccount, String receiveMailAccount, String message) {
        try {
            // 1. 创建一封邮件
            MimeMessage mimeMessage = new MimeMessage(session);
            // 2. From: 发件人   emailUserName、昵称、编码格式
            mimeMessage.setFrom(new InternetAddress(myEmailAccount, "sluo", "UTF-8"));
            // 3. To: 收件人（可以增加多个收件人）
//            mimeMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount, "收件人名称", "UTF-8"));
            //多个收件人
            String[] split = receiveMailAccount.split(",");
             for(int i = 0; i < split.length; i++){
             mimeMessage.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(split[i]));
             }
            // 4. Subject: 邮件主题
            mimeMessage.setSubject("问卷调查", "UTF-8");
            // 5. Content: 邮件正文（可以使用html标签）
            mimeMessage.setContent(message, "text/html;charset=UTF-8");
            // 6. 设置发件时间
            mimeMessage.setSentDate(new Date());
            // 7. 保存设置
            mimeMessage.saveChanges();

            return mimeMessage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void testSend(){
        senEmail("test邮件");
    }
}
