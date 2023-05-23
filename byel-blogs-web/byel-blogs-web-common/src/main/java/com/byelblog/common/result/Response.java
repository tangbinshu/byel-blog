package com.byelblog.common.result;

import lombok.Data;

@Data
public class Response<T> {

    private  String code;

    private  String msg;

    private   T data;

    public Response(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public   static <T> Response<T> ok(){
        return  new Response<>("0","成功",null);
    }

    public  static <T> Response<T> ok(T data){
        return  new Response<>("0","成功",data);
    }

    public  static <T> Response<T> ok(String msg,T data){
        return  new Response<>("0",msg,data);
    }

    public  static <T> Response<T> fail(String msg){
        return  new Response<>("-1",msg,null);
    }




}
