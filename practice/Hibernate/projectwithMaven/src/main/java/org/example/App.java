package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project started!" );
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory=cfg.buildSessionFactory();

        System.out.println(factory);
    }
}
