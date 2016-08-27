package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Cart;

@Repository("CartDAO")
public class CartDAOImpl implements CartDAO {
	
@Autowired
private SessionFactory sessionFactory;
	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Transactional
	public List<Cart> list() {
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	@Transactional
	public void saveOrUpdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}

	@Transactional
	public String delete(String id) {
		Cart cart = new Cart();
		cart.setUserID(id);
		sessionFactory.getCurrentSession().delete(cart);
		return null;
	}

	@Transactional
	public Cart get(String id) {
		String hql = "from Cart where userID=" + "'" + id + "'  and status = " + "O";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}


	@Override
	public int getTotalAmount(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*@Transactional
	public int getTotalAmount(String id) {
		String hql = "select sum(price) from Cart where userID = " + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
		return query.getFirstResult();
		return 0;*/

	

}