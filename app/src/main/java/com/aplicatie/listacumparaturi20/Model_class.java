package com.aplicatie.listacumparaturi20;

public class Model_class {

    Integer id;
    String product;


    public Model_class(Integer id, String product) {
        this.product = product;
        this.id = id;
    }

    public Model_class(String product) {
     this.product = product;
    }


    public Integer getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

}

