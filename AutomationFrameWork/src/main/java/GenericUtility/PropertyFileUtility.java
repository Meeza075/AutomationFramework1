package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is contain of method related to property file
 * @author VCT
 *
 */

public class PropertyFileUtility {
	/**
	 * This method is used to read data from propery file provided key
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String toReadDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IConstantUtility.propertyFileUtility);	
        Properties prop= new Properties();
        prop.load(fis);
        String value = prop.getProperty(key);
        return value;
	}
	

}

