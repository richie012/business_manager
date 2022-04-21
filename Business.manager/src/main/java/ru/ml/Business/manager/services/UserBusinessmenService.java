package ru.ml.Business.manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.ml.Business.manager.entity.UserBusinessmen;
import ru.ml.Business.manager.entity.Businessmen;
import ru.ml.Business.manager.repository.BusinessmenRepository;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserBusinessmenService implements BusinessmenService
{
    private BusinessmenRepository businessmenRepository;

    @Autowired
    public UserBusinessmenService(BusinessmenRepository businessmenRepository) {
        this.businessmenRepository = businessmenRepository;
    }

    @Override
    public List<Businessmen> getBusinessmen() {
        List<Businessmen> result = new ArrayList<>();
        businessmenRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Businessmen getBusinessmenById(Long id) {
        return businessmenRepository.findById(id).get();
    }

    @Override
    public void saveBusinessmen(String name)
    {
        UserBusinessmen businessmen = new UserBusinessmen(name);
        businessmenRepository.save(businessmen);
    }
}
