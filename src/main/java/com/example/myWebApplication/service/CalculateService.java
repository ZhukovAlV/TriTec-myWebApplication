package com.example.myWebApplication.service;

import com.example.myWebApplication.model.OperationModel;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    public int add(OperationModel model){
        return model.getA() + model.getB();
    }

    public int subtract(OperationModel model){
        return model.getA() - model.getB();
    }

    public int multiply(OperationModel model){
        return model.getA() * model.getB();
    }

    public double divide(OperationModel model){
        if(model.getA() == 0) return 0;
        if(model.getB() == 0) return 0;
        return (double) model.getA() / model.getB();
    }

    public OperationModel clearSimple(OperationModel model){
        model.setA(0);
        model.setB(0);
        return model;
    }
}
