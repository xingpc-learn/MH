package com.hibernate.service;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.hibernate.model.Customer;

public class HibernateCfgDemo {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		//加載配置文件
		Configuration config=new Configuration().configure();
		//創建sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		//得到一個session
		Session session = sessionFactory.openSession();
		//開啟事務
		session.beginTransaction();
		//操作數據庫,保存數據
//		Customer customer=new Customer();
//		customer.setAddress("北京");
//		customer.setName("joney");
//		customer.setId(1001023);
//		session.save(customer);
		//修改數據
//		customer.setAddress("鄭州");
//		customer.setName("莉莉");
//		customer.setId(1);
//		session.update(customer);
		//查詢數據
//		Customer c = (Customer)session.get(Customer.class, 1);
		//刪除數據
//		session.delete(c);
		//hql查詢所有數據
		Query createQuery = session.createQuery("from Customer");
//		List list = createQuery.list();
//		Iterator<Customer> iterator = list.iterator();
//		while (iterator.hasNext()) {
//			Customer customer = (Customer) iterator.next();
//			System.out.println(customer);
//		}
		//分頁查詢
		createQuery.setFirstResult(4);
		createQuery.setMaxResults(2);
		List list = createQuery.list();
		ListIterator<Customer> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			Customer customer = (Customer) listIterator.next();
			System.out.println(customer);
		}
		//提交事務
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
