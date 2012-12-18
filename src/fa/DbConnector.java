package fa;

import javax.persistence.*;

public class DbConnector  {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	/*
	 * Get feeds from specific user
	 */
	public void getFeeds(User user) {
	}
	
	/*
	 * Set single article
	 */
	public void setArticle(Article article) {
		this.sendQuery(article);
	}
	
	/*
	 * Establish database connection
	 */
	public void connectDb() {
		emf = Persistence.createEntityManagerFactory("objectdb://localhost:6136/feeds.odb;user=admin;password=admin");
		em = emf.createEntityManager();
	}
	
	/*
	 * Close database connection
	 */
	public void disconnectDb() {
		em.close();
		emf.close();
	}
	
	/*
	 * Executes a query
	 */
	public void sendQuery(Object object) {
		try {
			em.getTransaction().begin();
			
			em.persist(object);
			
			em.getTransaction().commit();
		} catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}
}