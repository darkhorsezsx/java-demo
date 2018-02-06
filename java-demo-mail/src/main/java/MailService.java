import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.security.Security;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import static javax.mail.internet.MimeUtility.decodeText;

/**
 * This is {@link MailService}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class MailService {

    public static void main(String[] args) throws Exception {
    }

    /**
     * 扫描邮箱
     */
    public void scanMailBox() throws IOException, MessagingException, ParseException
    {
//        Folder emailFolder = null;
//        Store emailStore = null;
//        try
//        {
//            emailStore = MailHelper.createMailStore(mailPop3Host, mailStoreType, mailUser, mailPassword);
//            emailFolder = MailHelper.getFolder(emailStore);
//            Message[] messages = MailHelper.receiveEmail(emailFolder);
//            if (messages == null || messages.length < 1)
//                throw new MessagingException("未找到要解析的邮件!");
//
//            Pageable page = new PageRequest(0, 1);
//            List<SimpleTrip> trip = tripRepo
//                    .findbyWayAndSource(SimpleTripWay.TRAIN, Constant.EMAILSOURCE, page);
//            Date lastSendDate = new Date();
//            String lastnumber = "";
//            if (trip.size() == 1)
//            {
//                lastSendDate = trip.get(0).getSendDate();
//                lastnumber = trip.get(0).getNumber();
//            }
//
//            // 解析所有邮件
//            for (int i = 0, count = messages.length; i < count; i++)
//            {
//                MimeMessage msg = (MimeMessage) messages[i];
//                if (MailHelper.getSubject(msg).contains("网上购票系统-用户支付通知"))
//                {
//                    scanTicketBook(msg, lastnumber, lastSendDate);
//                }
//                if (MailHelper.getSubject(msg).contains("网上购票系统-用户改签通知"))
//                {
//                    scanTicketEndorsed(msg, lastnumber, lastSendDate);
//                }
//                if (MailHelper.getSubject(msg).contains("网上购票系统-用户退票通知"))
//                {
//                    scanTicketRefund(msg, lastnumber, lastSendDate);
//                }
//            }
//        } finally
//        {
//            if (emailFolder != null)
//            {
//                emailFolder.close(false);
//            }
//            if (emailStore != null)
//            {
//                emailStore.close();
//            }
//        }
    }


}
