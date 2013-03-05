package fotballinfo;

import fotballinfo.data.*;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public class DataProviderFactory {
    public static IDataProvider createDataProvider(String dataProvider) throws UnsupportedDataProviderException {
        switch(dataProvider) {
            case DataProviders.XML_REMOTE:
                return createXmlOnlineDataProvider();
        }
        
        throw new UnsupportedDataProviderException(dataProvider);
    }
    
    private static IDataProvider createXmlOnlineDataProvider () {
        return new XmlDataProvider();
    }
}
