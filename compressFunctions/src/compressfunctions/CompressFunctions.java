package compressfunctions;

//import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.tibco.xml.cxf.common.annotations.XPathFunction;
import com.tibco.xml.cxf.common.annotations.XPathFunctionGroup;
import com.tibco.xml.cxf.common.annotations.XPathFunctionParameter;

@XPathFunctionGroup(category = "Compress Functions", prefix = "comp", namespace = "compress", helpText = "Functions to Gzip/Gunzip strings")
public class CompressFunctions {

	@XPathFunction(helpText = "Description", parameters = { @XPathFunctionParameter(name = "inputString", optional = false, optionalValue = "") })
	public static String gzip(String inputString) {
		//System.out.println("Gzip Input length : " + inputString.length());
		ByteArrayOutputStream bos = new ByteArrayOutputStream(inputString.length());
		GZIPOutputStream gzip;
		byte[] compressed = null;
		try {
			gzip = new GZIPOutputStream(bos);
			gzip.write(inputString.getBytes());
			gzip.close();
			compressed = bos.toByteArray();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//String encoded = new String(compressed);
		String encoded = Base64.getEncoder().encodeToString(compressed);
        //System.out.println("Gzip Output bytes length : " + encoded.length());
		return encoded;
	}

	@XPathFunction(helpText = "Description", parameters = { @XPathFunctionParameter(name = "inputString", optional = false, optionalValue = "") })
	public static String gunzip(String inputString) {
		//System.out.println("Gunzip Input length : " + inputString.length());
		byte[] decoded = Base64.getDecoder().decode(inputString.getBytes());
		ByteArrayInputStream bis = new ByteArrayInputStream(decoded);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		GZIPInputStream gis;
		try {
			gis = new GZIPInputStream(bis);
			int res = 0;
			byte buf[] = new byte[1024];
			while (res >= 0) {
			    res = gis.read(buf, 0, buf.length);
			    if (res > 0) {
			        bos.write(buf, 0, res);
			    }
			}
			gis.close();
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

        //System.out.println("gunzip output String length : " + sb.toString().length());
		return bos.toString();
	}
}
