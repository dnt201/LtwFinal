package com.example.ltwnhom10.dao.impl;

import com.example.ltwnhom10.dao.ProductDao;
import com.example.ltwnhom10.model.ProductModel;
import com.example.ltwnhom10.utl.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class ProductDaoImpl extends AbstractDao<Integer, ProductModel> implements ProductDao {

    @Override
    public List<ProductModel> findByBrand(Integer brandId){
        List<ProductModel> products = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                StringBuilder sqlcmd = new StringBuilder("from ");
                sqlcmd.append(this.getPersistenceClassName());
                sqlcmd.append(" WHERE brand.brand_id= "+brandId.toString());

                Query query = session.createQuery(sqlcmd.toString());
                products = query.getResultList();
                transaction.commit();
            }
            catch (HibernateException e){
                transaction.rollback();
                throw e;
            }
            finally {
                session.close();
            }
        }
        catch (HibernateException e){
            throw e;
        }

        return products;
    }
}