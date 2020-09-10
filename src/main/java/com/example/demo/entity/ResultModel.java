package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "返回数据")
@Data
public class ResultModel<T> {

    @ApiModelProperty(value = "状态")
    private Integer code;
    @ApiModelProperty(value = "提示信息")
    private String msg;
    @ApiModelProperty(value = "数据")
    private T data;

    public ResultModel() {
    }

    public ResultModel(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

  
  
  

  
  
  

  
  
  

  
  
  

  
  
  

  
  
  
}
