package com.example.ltwnhom10.service.impl;

import com.example.ltwnhom10.dao.DiscountDao;
import com.example.ltwnhom10.dao.impl.DiscountDaoImpl;
import com.example.ltwnhom10.model.DiscountModel;
import com.example.ltwnhom10.service.IDiscountService;

import javax.inject.Inject;
import java.util.List;

public class DiscountService implements IDiscountService {

    @Inject
    private DiscountDao discountDAO;

    public DiscountService() {
        discountDAO = new DiscountDaoImpl();
    }

    @Override
    public void save(DiscountModel discountModel) {
        discountDAO.save(discountModel);
    }

    @Override
    public void update(DiscountModel discountModel) {
        discountDAO.update(discountModel);
    }

    @Override
    public void deleteOne(DiscountModel discountModel) { discountDAO.deleteOne(discountModel); }

    @Override
    public DiscountModel findByID(Integer discountId) {
        return discountDAO.findById(discountId);
    }

    @Override
    public Integer delete(List<Integer> ids) {
        return discountDAO.delete(ids);
    }

    @Override
    public List<DiscountModel> findAll() {
        List<DiscountModel> result = discountDAO.findAll();
        return result;
    }

    @Override
    public DiscountModel findByName(String discountName) {
        return discountDAO.findByName(discountName);
    }
}
