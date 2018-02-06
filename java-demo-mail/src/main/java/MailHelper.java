/**
 * <p>项目名称: ecm-intelligent-trips</p>
 * <p>Copyright (c) 2016, Inspur GSP All Rights Reserved.</p>
 * <p>修改记录1: 新建文件-16-4-13$上午9:02-bufan</p>
 */
import com.sun.mail.pop3.POP3Store;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import java.io.*;
import java.security.Security;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>.</p>
 */
public class MailHelper
{

    public static void main(String[] args) throws IOException, MessagingException, ParseException
    {
        Folder emailFolder = null;
        Store emailStore = null;
//        String mailPop3Host = "pop.163.com";
//        String mailStoreType = "pop3";
//        String mailUser = "inspurgsptjsb@163.com";
//        String mailPassword = "123456a?";

        String mailPop3Host = "mail.inspur.com";
        String mailStoreType = "pop3";
        String mailUser = "zhangshixu@inspur.com";
        String mailPassword = "`zsx7031074lyu";

        try
        {
            emailStore = createMailStore(mailPop3Host, mailStoreType, mailUser, mailPassword);
            emailFolder = getFolder(emailStore);
            Message[] messages = receiveEmail(emailFolder);
            parseMessage(messages);
        } finally
        {
            emailFolder.close(false);
            emailStore.close();
        }
    }

    public static Store createMailStore(String pop3Host, String storeType, String user, String password)
            throws MessagingException
    {
        Message[] messages = null;

        Properties properties = new Properties();
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        // Get a Properties object

        properties.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);

        properties.setProperty("mail.pop3.socketFactory.fallback", "false");

        properties.setProperty("mail.pop3.port", "995");

        properties.setProperty("mail.pop3.socketFactory.port", "995");

        properties.put("mail.pop3.host", pop3Host);

        Session emailSession = Session.getDefaultInstance(properties);

        Store emailStore = (POP3Store) emailSession.getStore(storeType);
        emailStore.connect(user, password);

        return emailStore;
    }

    public static Folder getFolder(Store emailStore) throws MessagingException
    {
        Folder emailFolder = emailStore.getFolder("INBOX");
        emailFolder.open(Folder.READ_ONLY);
        return emailFolder;
    }

    public static Message[] receiveEmail(Folder emailFolder) throws MessagingException
    {
        Message[] messages = null;

        messages = emailFolder.getMessages();

        return messages;
    }

    /**
     * 解析邮件
     *
     * @param messages 要解析的邮件列表
     */
    public static void parseMessage(Message... messages)
            throws MessagingException, IOException, ParseException
    {
        if (messages == null || messages.length < 1)
            throw new MessagingException("未找到要解析的邮件!");

        // 解析所有邮件
        for (int i = 0, count = messages.length; i < count; i++)
        {

            MimeMessage msg = (MimeMessage) messages[i];
            if (getSubject(msg).contains("网上购票系统-用户支付通知"))
            {
                System.out.println(
                        "------------------解析第" + msg.getMessageNumber() + "封邮件-------------------- ");
                System.out.println("主题: " + getSubject(msg));
                System.out.println("发件人: " + getFrom(msg));
                System.out.println("收件人：" + getReceiveAddress(msg, null));
                System.out.println("发送时间：" + getSentDate(msg, null));
                System.out.println("是否已读：" + isSeen(msg));
                System.out.println("邮件优先级：" + getPriority(msg));
                System.out.println("是否需要回执：" + isReplySign(msg));
                System.out.println("邮件大小：" + msg.getSize() * 1024 + "kb");
                boolean isContainerAttachment = isContainAttachment(msg);
                System.out.println("是否包含附件：" + isContainerAttachment);


//                if (isContainerAttachment)
//                {
//                    saveAttachment(msg, "c:\\mailtmp\\" + msg.getSubject() + "_"); //保存附件
//                }
//                StringBuffer content = new StringBuffer(30);
//                getMailTextContent(msg, content);
//
//                String orderID = "";
//                Pattern pattern = Pattern.compile("订单号码[\\w]+(?=。)");
//                Matcher matcher = pattern.matcher(content.toString());
//                if (matcher.find())
//                {
//                    orderID = matcher.group().replace("订单号码", "");
//                }
//
//                pattern = Pattern.compile("\\d[\\.]([^,成功元]+,){5,8}[^成功元]+元");
//                matcher = pattern.matcher(content.toString());
//
//                int ticketcount = 0;
//                while (matcher.find())
//                {
//                    ticketcount++;
//                    String result = matcher.group();
//                    String ticketnum = result.substring(0, 1);
//                    result = result.substring(2);
//                    String[] tripInfList = result.split(",");
//
//                    if (!ticketnum.equals(String.valueOf(ticketcount)))
//                    {
//                        continue;
//                    }
//
//                    if (tripInfList.length < 6)
//                    {
//                        throw new MessagingException(String.format("解析的邮箱内容失败:(%s)!", tripInfList));
//                    }
//
//                    String sourceuname = tripInfList[0];
//
//                    SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日HH:mm开");
//                    sf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//                    Date start = sf.parse(tripInfList[1]);
//
//                    if (!tripInfList[2].contains("―"))   //  ―  不是减号 -
//                    {
//                        System.out.println(String.format("解析的火车的始发地失败:(%s)!", tripInfList[2]));
//                        throw new MessagingException(String.format("解析的火车的始发地失败:(%s)!", tripInfList[2]));
//                    }
//                    String from = tripInfList[2].split("—")[0];
//                    String to = tripInfList[2].split("—")[1];
//
//                    if (!tripInfList[3].contains("次列车"))
//                    {
//                        System.out.println(String.format("解析的火车的车次失败:(%s)!", tripInfList[3]));
//                        throw new MessagingException(String.format("解析的火车的车次失败:(%s)!", tripInfList[3]));
//                    }
//                    String number = tripInfList[3].replace("次列车", "");
//
//                    String seatNum = tripInfList[4];
//                    String level = tripInfList[5];
//
//                    if (!tripInfList[6].matches("^票价[\\ ]*\\d+\\.?\\d*[\\ ]*元$"))
//                    {
//                        System.out.println(String.format("解析的火车的票价失败:(%s)!", tripInfList[6]));
//                        throw new MessagingException(String.format("解析的火车的票价失败:(%s)!", tripInfList[6]));
//                    }
//                    Double cost = Double
//                            .parseDouble(tripInfList[6].replace("票价", "").replace("元", "").trim());
//
//
//
//                }
                System.out.println(
                        "------------------第" + msg.getMessageNumber() + "封邮件解析结束-------------------- ");
                System.out.println();
            }
        }
    }

    /**
     * 获得邮件主题
     *
     * @param msg 邮件内容
     * @return 解码后的邮件主题
     */
    public static String getSubject(MimeMessage msg) throws UnsupportedEncodingException, MessagingException
    {
        return MimeUtility.decodeText(msg.getSubject());
    }

    /**
     * 获得邮件发件人
     *
     * @param msg 邮件内容
     * @return 姓名 <Email地址>
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    public static String getFrom(MimeMessage msg) throws MessagingException, UnsupportedEncodingException
    {
        String from = "";
        Address[] froms = msg.getFrom();
        if (froms.length < 1)
            throw new MessagingException("没有发件人!");

        InternetAddress address = (InternetAddress) froms[0];
        String person = address.getPersonal();
        if (person != null)
        {
            person = MimeUtility.decodeText(person) + " ";
        } else
        {
            person = "";
        }
        from = person + "<" + address.getAddress() + ">";

        return from;
    }

    /**
     * 根据收件人类型，获取邮件收件人、抄送和密送地址。如果收件人类型为空，则获得所有的收件人
     * <p>Message.RecipientType.TO  收件人</p>
     * <p>Message.RecipientType.CC  抄送</p>
     * <p>Message.RecipientType.BCC 密送</p>
     *
     * @param msg  邮件内容
     * @param type 收件人类型
     * @return 收件人1 <邮件地址1>, 收件人2 <邮件地址2>, ...
     * @throws MessagingException
     */
    public static String getReceiveAddress(MimeMessage msg, Message.RecipientType type)
            throws MessagingException
    {
        StringBuffer receiveAddress = new StringBuffer();
        Address[] addresss = null;
        if (type == null)
        {
            addresss = msg.getAllRecipients();
        } else
        {
            addresss = msg.getRecipients(type);
        }

        if (addresss == null || addresss.length < 1)
            throw new MessagingException("没有收件人!");
        for (Address address : addresss)
        {
            InternetAddress internetAddress = (InternetAddress) address;
            receiveAddress.append(internetAddress.toUnicodeString()).append(",");
        }

        receiveAddress.deleteCharAt(receiveAddress.length() - 1); //删除最后一个逗号

        return receiveAddress.toString();
    }

    /**
     * 获得邮件发送时间
     *
     * @param msg 邮件内容
     * @return yyyy年mm月dd日 星期X HH:mm
     * @throws MessagingException
     */
    public static String getSentDate(MimeMessage msg, String pattern) throws MessagingException
    {
        Date receivedDate = msg.getSentDate();
        if (receivedDate == null)
            return "";

        if (pattern == null || "".equals(pattern))
            pattern = "yyyy年MM月dd日 E HH:mm ";

        return new SimpleDateFormat(pattern).format(receivedDate);
    }

    /**
     * 判断邮件中是否包含附件
     *
     * @return 邮件中存在附件返回true，不存在返回false
     * @throws MessagingException
     * @throws IOException
     */
    public static boolean isContainAttachment(Part part) throws MessagingException, IOException
    {
        boolean flag = false;
        if (part.isMimeType("multipart/*"))
        {
            MimeMultipart multipart = (MimeMultipart) part.getContent();
            int partCount = multipart.getCount();
            for (int i = 0; i < partCount; i++)
            {
                BodyPart bodyPart = multipart.getBodyPart(i);
                String disp = bodyPart.getDisposition();
                if (disp != null && (disp.equalsIgnoreCase(Part.ATTACHMENT) || disp
                        .equalsIgnoreCase(Part.INLINE)))
                {
                    flag = true;
                } else if (bodyPart.isMimeType("multipart/*"))
                {
                    flag = isContainAttachment(bodyPart);
                } else
                {
                    String contentType = bodyPart.getContentType();
                    if (contentType.indexOf("application") != -1)
                    {
                        flag = true;
                    }

                    if (contentType.indexOf("name") != -1)
                    {
                        flag = true;
                    }
                }

                if (flag)
                    break;
            }
        } else if (part.isMimeType("message/rfc822"))
        {
            flag = isContainAttachment((Part) part.getContent());
        }
        return flag;
    }

    /**
     * 判断邮件是否已读  www.2cto.com
     *
     * @param msg 邮件内容
     * @return 如果邮件已读返回true, 否则返回false
     * @throws MessagingException
     */
    public static boolean isSeen(MimeMessage msg) throws MessagingException
    {
        return msg.getFlags().contains(Flags.Flag.SEEN);
    }

    /**
     * 判断邮件是否需要阅读回执
     *
     * @param msg 邮件内容
     * @return 需要回执返回true, 否则返回false
     * @throws MessagingException
     */
    public static boolean isReplySign(MimeMessage msg) throws MessagingException
    {
        boolean replySign = false;
        String[] headers = msg.getHeader("Disposition-Notification-To");
        if (headers != null)
            replySign = true;
        return replySign;
    }

    /**
     * 获得邮件的优先级
     *
     * @param msg 邮件内容
     * @return 1(High):紧急  3:普通(Normal)  5:低(Low)
     * @throws MessagingException
     */
    public static String getPriority(MimeMessage msg) throws MessagingException
    {
        String priority = "普通";
        String[] headers = msg.getHeader("X-Priority");
        if (headers != null)
        {
            String headerPriority = headers[0];
            if (headerPriority.indexOf("1") != -1 || headerPriority.indexOf("High") != -1)
                priority = "紧急";
            else if (headerPriority.indexOf("5") != -1 || headerPriority.indexOf("Low") != -1)
                priority = "低";
            else
                priority = "普通";
        }
        return priority;
    }

    /**
     * 获得邮件文本内容
     *
     * @param part    邮件体
     * @param content 存储邮件文本内容的字符串
     * @throws MessagingException
     * @throws IOException
     */
    public static void getMailTextContent(Part part, StringBuffer content)
            throws MessagingException, IOException
    {
        //如果是文本类型的附件，通过getContent方法可以取到文本内容，但这不是我们需要的结果，所以在这里要做判断
        boolean isContainTextAttach = part.getContentType().indexOf("name") > 0;
        if (part.isMimeType("text/*") && !isContainTextAttach)
        {
            content.append(part.getContent().toString());
        } else if (part.isMimeType("message/rfc822"))
        {
            getMailTextContent((Part) part.getContent(), content);
        } else if (part.isMimeType("multipart/*"))
        {
            Multipart multipart = (Multipart) part.getContent();
            int partCount = multipart.getCount();
            for (int i = 0; i < partCount; i++)
            {
                BodyPart bodyPart = multipart.getBodyPart(i);
                getMailTextContent(bodyPart, content);
            }
        }
    }

    /**
     * 保存附件
     *
     * @param part    邮件中多个组合体中的其中一个组合体
     * @param destDir 附件保存目录
     * @throws UnsupportedEncodingException
     * @throws MessagingException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void saveAttachment(Part part, String destDir)
            throws UnsupportedEncodingException, MessagingException, FileNotFoundException, IOException
    {
        if (part.isMimeType("multipart/*"))
        {
            Multipart multipart = (Multipart) part.getContent();    //复杂体邮件
            //复杂体邮件包含多个邮件体
            int partCount = multipart.getCount();
            for (int i = 0; i < partCount; i++)
            {
                //获得复杂体邮件中其中一个邮件体
                BodyPart bodyPart = multipart.getBodyPart(i);
                //某一个邮件体也有可能是由多个邮件体组成的复杂体
                String disp = bodyPart.getDisposition();
                if (disp != null && (disp.equalsIgnoreCase(Part.ATTACHMENT) || disp
                        .equalsIgnoreCase(Part.INLINE)))
                {
                    InputStream is = bodyPart.getInputStream();
                    saveFile(is, destDir, decodeText(bodyPart.getFileName()));
                } else if (bodyPart.isMimeType("multipart/*"))
                {
                    saveAttachment(bodyPart, destDir);
                } else
                {
                    String contentType = bodyPart.getContentType();
                    if (contentType.indexOf("name") != -1 || contentType.indexOf("application") != -1)
                    {
                        saveFile(bodyPart.getInputStream(), destDir, decodeText(bodyPart.getFileName()));
                    }
                }
            }
        } else if (part.isMimeType("message/rfc822"))
        {
            saveAttachment((Part) part.getContent(), destDir);
        }
    }

    /**
     * 读取输入流中的数据保存至指定目录
     *
     * @param is       输入流
     * @param fileName 文件名
     * @param destDir  文件存储目录
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void saveFile(InputStream is, String destDir, String fileName)
            throws FileNotFoundException, IOException
    {
        BufferedInputStream bis = new BufferedInputStream(is);
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(new File(destDir + fileName)));
        int len = -1;
        while ((len = bis.read()) != -1)
        {
            bos.write(len);
            bos.flush();
        }
        bos.close();
        bis.close();
    }

    /**
     * 文本解码
     *
     * @param encodeText 解码MimeUtility.encodeText(String text)方法编码后的文本
     * @return 解码后的文本
     * @throws UnsupportedEncodingException
     */
    public static String decodeText(String encodeText) throws UnsupportedEncodingException
    {
        if (encodeText == null || "".equals(encodeText))
        {
            return "";
        } else
        {
            return MimeUtility.decodeText(encodeText);
        }
    }

}
