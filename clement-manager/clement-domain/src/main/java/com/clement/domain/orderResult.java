package com.clement.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class orderResult<T> implements Serializable {

    private static final long serialVersionUID = 5088731327110545573L;

    private List<T> orders;


    public orderResult(List<T> orders) {
        this.orders = orders;
    }
}
