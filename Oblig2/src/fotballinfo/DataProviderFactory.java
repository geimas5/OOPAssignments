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
                return createXmlRemoteDataProvider();
            case DataProviders.SQL_REMOTE:
                return createSqlRemoteDataProvider();
        }
        
        throw new UnsupportedDataProviderException(dataProvider);
    }
    
    private static IDataProvider createXmlRemoteDataProvider () {
        return new XmlDataProvider("http://www.it.hiof.no/~borres/commondata/fotballstatistikk/XML/data%s.xml");
    }
    
    private static IDataProvider createSqlRemoteDataProvider () {
        return new SqlDataProvider("jdbc:mysql://frigg.hiof.no/bsdiverse?user=student&password=student");
    }
}
