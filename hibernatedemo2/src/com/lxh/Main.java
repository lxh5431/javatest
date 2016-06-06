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
		Configuration cfg = new Configuration().configure();// ����configure()���������ǿ���������Դ������в鿴���������·
		// �����Զ�ȥ����һ��Ĭ�ϵ�hibernate.cfg.xml�ļ�����������뻻�������֣�����ʹ�������ط�����������Բ鿴��Դ���루���ص�ѹ�������У�
		SessionFactory factory = cfg.buildSessionFactory();
		Tuser user = new Tuser();
		user.setName("Kobi");

		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();// ��������
			session.save(user);// ���б���
			tx.commit();// �ύ����
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();// �ع�����
			}
			throw e;// �����׳��쳣
		} finally {
			if (session != null) {
				session.close();// �ر�session
			}
		}
	}

}
