package com.example.demo.service;

import com.example.demo.pojo.Happiness;

import java.util.List;

public interface HappinessService {
    List<Happiness> selectService(String city);
    void insertService(String city,Integer num);
}
