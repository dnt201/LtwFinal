package com.example.ltwnhom10.dao.impl;

import com.example.ltwnhom10.dao.OrderDetailsDao;
import com.example.ltwnhom10.model.OrderDetailsModel;
import com.example.ltwnhom10.utl.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDetailsDaoImpl extends AbstractDao<Integer, OrderDetailsModel> implements OrderDetailsDao {
    @Override
    public Integer saveReturnId(OrderDetailsModel orderDetailModel) {
        Integer id = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(orderDetailModel);
            transaction.commit();
            id = orderDetailModel.getOrder_id();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return id;
    }
}
