package com.lzh.base;

public class BusinessException extends Exception {

    private static final long serialVersionUID = 3455708526465670030L;

    public BusinessException(String msg){
        super(msg);
    }
}
