package org.jsp.A_1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SF_Helper {

    private static Configuration cfg = new Configuration();
    private static SessionFactory factory;

    static {
        cfg.configure();
        factory = cfg.buildSessionFactory();
    }

    public static Configuration getConfiguration() {
        return cfg;
    }

    public static SessionFactory getFactory() {
        return factory;
    }

    public static Session getSession() {
        return  factory.openSession();
    }
    
}