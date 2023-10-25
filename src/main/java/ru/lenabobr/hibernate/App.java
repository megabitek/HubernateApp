package ru.lenabobr.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.lenabobr.hibernate.model.Item;
import ru.lenabobr.hibernate.model.Person;

import javax.security.auth.login.AppConfigurationEntry;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

 //Add items
 Person person = session.get(Person.class, 5);
Item newItem = new Item("from java", person);
session.save(newItem);


//Get Person
/*Item item = session.get(Item.class, 5);
System.out.println(item);
Person person = item.getOwner();
System.out.println(person);

// Get item
/*Person person = session.get(Person.class, 2);
System.out.println(person);
List<Item> items= person.getItems(); // обязательно делать внутри транзакции
        System.out.println(items);*/


        ////create person
      /*  Person person1 = new Person("Test4", 45);
        Person person2 = new Person("Test5", 8);
        Person person3 = new Person("Test6", 63);
        session.save(person1);
        session.save(person2);
        session.save(person3);
*/

        //HQL
        //session.createQuery("update Person set name = 'old' where age> 30").executeUpdate();
//session.createQuery("delete from Person where age > 30 ").executeUpdate();
        //for (Person person: personList)
           //System.out.println(person.getName());//


      ////UPDATE
//Person person = session.get(Person.class, 2);
//person.setName("New");


/// DELETE
//session.delete(person);
        //  Person person = session.get(Person.class, 1);
       // System.out.println(person.getAge()+ "  "+ person.getName());
        session.getTransaction().commit();
        sessionFactory.close();


    }
}