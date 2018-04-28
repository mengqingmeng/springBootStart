package com.example.demo.service.impl;

import com.example.demo.mapper.HappinessDao;
import com.example.demo.pojo.Happiness;
import com.example.demo.service.HappinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HappinessServiceImpl implements HappinessService {
    @Autowired
    private HappinessDao happinessDao;

    @Override
    public List<Happiness> selectService(String city) {
        return happinessDao.findHappinessByCity(city);
    }

    @Override
    public void insertService(String name,Integer num) {
        happinessDao.insertHappiness(name,num);
    }
}
