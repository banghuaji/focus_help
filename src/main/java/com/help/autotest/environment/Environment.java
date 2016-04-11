package com.help.autotest.environment;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 环境变量控制
 * 在第一次使用set方法是载入所有环境变量
 * 提供set和get用另外的环境变量的设置和获取时使用
 * @author Peter
 */
public class Environment {
    private static int tag=0;

    private Environment(){}
    /**
     * 设置环境变量。在接口测试这种不涉及浏览器的case中使用。
     * 默认路径是d:/TA/TA.properties
     */
    public static void set4If(){
		if (tag == 0) {
			FileInputStream propFile = null;
			try {
				// 如果没有通过持续集成工具指定测试环境配置文件，那么使用d:/TA/TA.properties中指定的文件
				if (get("Selenium.TestEnv") == null || get("Selenium.TestEnv").equals("")) {
					propFile = new FileInputStream("d:/TA/TA.properties");
					Properties p = new Properties(System.getProperties());
					p.load(propFile);
					System.setProperties(p);
				}
				set("d:/TA/" + get("Selenium.TestEnv"));
				setProperites(new File(System.getProperty("Selenium.EnvironmentRoot")));
				String logcontent = "Set test Environment to " + get("Selenium.TestEnv");
				Logger.getLogger(Environment.class.getName()).log(Level.INFO, logcontent);
				tag = 1;
			} catch (IOException ex) {
				Logger.getLogger(Environment.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				try {
					if (propFile != null) {
						propFile.close();
					}
				} catch (IOException ex) {
					Logger.getLogger(Environment.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
    }

    /**
     *
     * @param f
     * 目标目录，将目录下所有的properties文件都载入。
     */
    private static void setProperites(File f){
        if(f.isFile() && f.getName().substring(f.getName().lastIndexOf( ".")+1).equals(System.getProperty("Selenium.ProperitiesExt"))){
            FileInputStream propFile=null;
            try {
                propFile = new FileInputStream(f);
                Properties p = new Properties(System.getProperties());
                p.load(propFile);
                System.setProperties(p);
                } catch (IOException ex) {
                    Logger.getLogger(Environment.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                try {
                    propFile.close();
                } catch (IOException ex) {
                    Logger.getLogger(Environment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else if(f.isDirectory()){
            for(File subf:f.listFiles()){
                setProperites(subf);
            }
        }
    }

     /**
     * 设置环境变量。
     * @param filename
     *  环境变量配置文件的绝对路径
     */
   public static void set(String filename){
       FileInputStream propFile=null;
        try {
            propFile = new FileInputStream(filename);
            Properties p = new Properties(System.getProperties());
            p.load(propFile);
            System.setProperties(p);
            //System.getProperties().list(System.out);
            } catch (IOException ex) {
                Logger.getLogger(Environment.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            try {
                propFile.close();
            } catch (IOException ex) {
                Logger.getLogger(Environment.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
   /**
    * 获得名字为key的环境变量
    * @param key
    * 要获得环境变量的名字
    * @return
    * 获取的名字为key的环境变量的值
    */
   public static String get(String key){
            String result="";
        try {
            String tmp1=System.getProperty(key);
            if(tmp1==null || tmp1.equals("")){
                return null;
            }
            byte[] temp2=tmp1.getBytes("ISO-8859-1");
            result = new String(temp2, "utf-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Environment.class.getName()).log(Level.SEVERE, null, ex);
        }
            return result;
   }
   /**
    * 设置环境变量
    * @param key
    * 变量名
    * @param value
    * 变量值
    */
   public static void set(String key,String value){
        System.setProperty(key, value);
   }
}
