
package org.example.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HibernateFactoryTest {

    @Test
    void getSessionFactory() {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        assertNotNull(sessionFactory);

        Session session = sessionFactory.openSession();

        assertNotNull(session);

        session.close();
    }
}