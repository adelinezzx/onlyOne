package IO.LoginDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IOUtil {
    public static Map<String ,String> loginDatas = new HashMap<String ,String>();
    
    private static final String DATA_FILE = "data.dat";
   
    static{
    	load();
    }
    
    //数据永久存储在data.dat文件中
    public static boolean save(String username , String password) {
    	loginDatas.put(username, password);
    	try {
			FileOutputStream out = new FileOutputStream(DATA_FILE);
			out.write((username + " " + password).getBytes());
			out.flush();
			out.close();
			return true ;
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return false;
    }
    
    //加载
    public static void load() {
    	try {
			FileInputStream in= new FileInputStream(DATA_FILE);
			byte[] bs = new byte[1024];
			int len = 0 ;
			StringBuilder dataStr = new StringBuilder();
			while((len = in.read(bs)) != -1){
			   dataStr.append(new String(bs, 0 ,len));
			}
			String[] datas = dataStr.toString().trim().split("\\s+");//拆分出所有的登录信息，然后存放到Map中
			for (int i = 0; i < datas.length; i+=2) {
				loginDatas.put(datas[i], datas[i+1]);
			}
			in.close();
		}catch ( FileNotFoundException e) {
			try {
				new File(DATA_FILE).createNewFile(); //文件不存在   创建储存登录信息的文件
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch ( IOException e) {
			e.printStackTrace();
		}
    	
    }
}
