
package org.example.factory;

import org.example.factory.impl.H2Factory;
import org.example.factory.impl.PostgresFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class H2FactoryTest {

    @Test
    void getSessionFactory() {
        SessionFactory sessionFactory = new H2Factory().getSessionFactory();
        assertNotNull(sessionFactory);

        Session session = sessionFactory.openSession();

        assertNotNull(session);

        session.close();
    }
}