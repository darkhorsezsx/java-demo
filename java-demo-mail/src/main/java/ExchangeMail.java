import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.PropertySet;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.service.folder.Folder;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.core.service.item.Item;
import microsoft.exchange.webservices.data.core.service.schema.FolderSchema;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.FolderId;
import microsoft.exchange.webservices.data.search.FindFoldersResults;
import microsoft.exchange.webservices.data.search.FindItemsResults;
import microsoft.exchange.webservices.data.search.FolderView;
import microsoft.exchange.webservices.data.search.ItemView;
import microsoft.exchange.webservices.data.search.filter.SearchFilter;

import java.net.URI;
import java.util.List;

/**
 * This is {@link ExchangeMail}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class ExchangeMail {

    public static void main(String[] args) throws Exception {
        ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
//        ExchangeCredentials credentials = new WebCredentials("用户名", "密码", "域");
        ExchangeCredentials credentials = new WebCredentials("zhangshixu", "ZSX`7031074lyu", "home");
        service.setCredentials(credentials);
        service.setUrl(new URI("https://"+"jtjncas02.home.langchao.com"+"/EWS/Exchange.asmx"));
        // Bind to the Inbox.
        //Folder inbox = Folder.bind(service, WellKnownFolderName.Inbox);



//        Folder inbox = Folder.bind(service, WellKnownFolderName.valueOf("12306网上购票系统"));

        //***********************
//        FolderView folderView = new FolderView(10);
//        FindFoldersResults results = service.findFolders(WellKnownFolderName., folderView);
//        service.findFolders()
//
//        for (Folder folder : results) {
//            System.out.println(folder.getDisplayName());
//        }

        //***********************



        //***********  找到该文件夹

        FolderView fview = new FolderView(1);
        fview.setPropertySet(new PropertySet(FolderSchema.DisplayName, FolderSchema.Id));
        Folder msgF = Folder.bind(service,WellKnownFolderName.MsgFolderRoot);
        FindFoldersResults res = msgF.findFolders(new SearchFilter.ContainsSubstring(FolderSchema.DisplayName,"12306网上购票系统"),fview);
        List<Folder> fl = res.getFolders();

        //***********

        if (fl.size() == 0) {
            System.out.println("folder not found");
            return;
        }

        Folder ticketFolder = fl.get(0);
        System.out.println(ticketFolder.getDisplayName());
        ItemView view = new ItemView(20);
        FindItemsResults<Item> findResults = service.findItems(ticketFolder.getId(), view);
        for (Item item : findResults.getItems()) {
            EmailMessage message = EmailMessage.bind(service, item.getId());
            System.out.println(message.getSender());
            System.out.println("Sub -->" + item.getSubject());

            item.load();
            System.out.println(item.getBody());

        }

    }

}
