package com.lxh;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.lxh.Tuser;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration().configure();// 对于configure()方法，我们可以引入其源代码进行查看，其会在类路
		// 径下自动去加载一个默认的hibernate.cfg.xml文件；如果我们想换其他名字，可以使用其重载方法，具体可以查看其源代码（下载的压缩包中有）
		SessionFactory factory = cfg.buildSessionFactory();
		Tuser user = new Tuser();
		user.setName("Kobi");

		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();// 开启事务
			session.save(user);// 进行保存
			tx.commit();// 提交事务
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();// 回滚事务
			}
			throw e;// 必须抛出异常
		} finally {
			if (session != null) {
				session.close();// 关闭session
			}
		}
	}

}
