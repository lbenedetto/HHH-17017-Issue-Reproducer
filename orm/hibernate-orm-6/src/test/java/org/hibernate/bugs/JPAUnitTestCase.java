package org.hibernate.bugs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh17017Test() throws Exception {
		Long id = 1L;
		MyEnum enumValue = MyEnum.A;

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Write a new entity
		entityManager.getTransaction().begin();
		TblWithBadModel tbl = new TblWithBadModel(id, enumValue);
		entityManager.persist(tbl);
		entityManager.getTransaction().commit();

		// Clearing is necessary so we don't return the previously cached entity
		entityManager.clear();

		// Read back the same entity
		TblWithBadModel foundTbl = entityManager.find(TblWithBadModel.class, id);

		assert foundTbl.myEnum == enumValue;

		entityManager.close();
	}
}
