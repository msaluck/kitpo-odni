package indooptik.utility;

/**  
 *  [Class Description]
 *
 * @author : syaiful
 * @version : ICPS 1.0
 * @since : Jun 12, 2015
 *
 * History of modification
 * ========================
 *
 
 *  Version  |  Updated Date | Updated By | Description
 *
 * <Filled after release>
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SystemID {

	static Map<String, Date> lastUpdate = new HashMap<>();
	static Map<String, Integer> lastValue = new HashMap<>();
	static Map<String, Long> shiftMap = new HashMap<>();
	
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
	
	public static synchronized String generate(String context, String codeToko){
		
		Date now = new Date();
		
		if (lastUpdate.containsKey(context) && !(Integer.parseInt(dateFormat.format(lastUpdate.get(context))) < Integer.parseInt(dateFormat.format(now)))) lastValue.put(context, lastValue.get(context) + 1);			
		else lastValue.put(context, 1);
		
		lastUpdate.put(context, now);
		
		StringBuffer sb = new StringBuffer();
		sb.append(codeToko);
		sb.append(String.format("%07d", lastValue.get(context)));
		
		return sb.toString();
		
	}
	
	public static synchronized long generate(String type, int storeId){
		
		Date now = new Date();
		
		if (lastUpdate.containsKey(type) && !(Integer.parseInt(dateFormat.format(lastUpdate.get(type))) < Integer.parseInt(dateFormat.format(now)))) lastValue.put(type, lastValue.get(type) + 1);			
		else lastValue.put(type, 1);
		
		lastUpdate.put(type, now);
		
		StringBuffer sb = new StringBuffer();
		sb.append(String.format("%06d", storeId));
		
		sb.append(dateFormat.format(now));
		sb.append(String.format("%07d", lastValue.get(type)));
		
		return Long.parseLong(sb.toString());
		
	}
	
	/**
	 * Generate dokumen code for stock opname
	 * @param type :SOBIC, SOPOT, SOM, SOA, SOITEM
	 * @param stockOpnameType: BIC(B), POT(P), Materials(M), Item(I), Asset(A)
	 * @param storeCode
	 * @return
	 */
	public static synchronized String generateSO(String type, char stockOpnameType, String storeCode){
		DateFormat monthFormat = new SimpleDateFormat("yyyyMM");		
		Date now = new Date();
		
		if (lastUpdate.containsKey(type) && !(Integer.parseInt(monthFormat.format(lastUpdate.get(type))) < Integer.parseInt(monthFormat.format(now)))) lastValue.put(type, lastValue.get(type) + 1);
		else lastValue.put(type, 1);
		
		lastUpdate.put(type, now);
		
		StringBuffer sb = new StringBuffer();
		sb.append("LSO-");
		sb.append(stockOpnameType+"/");
		sb.append(storeCode+"/");
		sb.append(monthFormat.format(now)+"/");
		sb.append(lastValue.get(type));
		
		return sb.toString();
	}
	
	public static synchronized int generate(String context){
		
		Date now = new Date();
		
		if (lastUpdate.containsKey(context) && !(Integer.parseInt(dateFormat.format(lastUpdate.get(context))) < Integer.parseInt(dateFormat.format(now)))) lastValue.put(context, lastValue.get(context) + 1);			
		else lastValue.put(context, 1);
		
		lastUpdate.put(context, now);
		
		return lastValue.get(context);		
	}
	
	public static synchronized int generate(Long id){
		String key = id.toString();
		
		if (!(shiftMap.containsKey(key) && lastValue.containsKey(key))) lastValue.put(key, 1);
		
		else lastValue.put(key, lastValue.get(key)+1); 
		
		shiftMap.put(key, id);
		
		return lastValue.get(key);
	}
	
	static class IdFile implements Serializable {		
		
		private static final long serialVersionUID = 4723899644892221973L;
		
		Map<String, Date> lastUpdate;
		Map<String, Integer> lastValue;
		Map<String, Long> shiftMap;
		
	}
	
	public static void save() {
		
		IdFile idFile = new IdFile();
		idFile.lastUpdate = lastUpdate;
		idFile.lastValue = lastValue;
		idFile.shiftMap = shiftMap;
		
		try {
			FileOutputStream fos = new FileOutputStream(new File("systemID.dat"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(idFile);
			oos.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void load() {
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File("systemID.dat"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			IdFile idFile = (IdFile) ois.readObject();
			lastUpdate = (Map<String, Date>) (idFile.lastUpdate == null? new HashMap<>() : idFile.lastUpdate);
			lastValue = (Map<String, Integer>) (idFile.lastValue == null? new HashMap<>() : idFile.lastValue);
			shiftMap = (Map<String, Long>) (idFile.shiftMap == null? new HashMap<>() : idFile.shiftMap);
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		//SystemID.load();
		//System.out.println(generate((long) 1));
		//SystemID.save();
		
		System.out.println(SystemID.generateSO("SOBIC", 'B', "ACL001"));
	}
}
