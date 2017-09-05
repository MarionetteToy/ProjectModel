/**
 * 
 */
package com.yxd.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @作者 YXD
 *
 * @时间 2017年1月18日
 *
 * @说明 TODO
 */
public class HibernateSessionFactory {
    private static String CONFIG_FILE_LOCATION="hibernate.cfg.xml";
    private static final ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
    private static Configuration configuration=new Configuration();
    private static SessionFactory sessionFactory;
    //静态加载配置文件，获得session工厂
    static{
        try {
            configuration.configure(CONFIG_FILE_LOCATION);
            sessionFactory=configuration.buildSessionFactory();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    private HibernateSessionFactory(){
    }
  
    //获取Session对象
    public static Session getSession() throws HibernateException{
        Session session=(Session) threadLocal.get();
        if(session==null||!session.isOpen()){
            if(sessionFactory==null){
                rebuildSessionFactory();
            }
            session=(sessionFactory!=null)? sessionFactory.openSession():null;
            threadLocal.set(session);     
        }
        return session;
    }
    
    //如果session不能从session工厂中获取，重新加载配置文件，获得session工厂
    public static void rebuildSessionFactory()
    {
        try {
            configuration.configure(CONFIG_FILE_LOCATION);
            sessionFactory=configuration.buildSessionFactory();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    //关闭session
    public static void closeSession() throws HibernateException{
        Session session=(Session) threadLocal.get();
        threadLocal.set(null);
        if(session!=null) {
            session.close();
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static Configuration getConfiguration(){
        return configuration;
    }
    public static void main(String[] args) {
		
	}
}
    



