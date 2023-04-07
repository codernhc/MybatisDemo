package com.example.mybatisdemo.utils;

import java.io.Serializable;

public class Result<T> implements Serializable {
  // 自定义状态码
  private Integer code;
  // 提示内容，如果接口出错，则存放异常信息
  private String msg;
  // 返回数据体
  private T data;
  // 接口成功检测。拓展字段，前台可用该接口判断接口是否正常，或者通过code状态码
  private boolean success;
  private static final long serialVersionUID = 1L;

  public Result() {
  }

  public Result(Integer code, String msg, T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  public static <T> Result<T> success() {
    return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), null);
  }

  public static <T> Result<T> success(T data) {
    return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
  }

  public static <T> Result<T> failed(String msg) {
    return new Result<>(ResultCode.FAILED.getCode(), msg, null);
  }

  public static <T> Result<T> failed(String msg, T data) {
    return new Result<>(ResultCode.FAILED.getCode(), msg, data);
  }

  public static <T> Result<T> failed(ResultCode errorCode) {
    return new Result<>(errorCode.getCode(), errorCode.getMsg(), null);
  }

  public static <T> Result<T> failed(ResultCode errorCode, T data) {
    return new Result<>(errorCode.getCode(), errorCode.getMsg(), data);
  }

  public boolean isSuccess() {
    return this.code == ResultCode.SUCCESS.getCode();
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  @Override
  public String toString() {
    return "Result{" + "code=" + code +
      ", msg='" + msg + '\'' +
      ", data=" + data +
      ", success=" + success +
      '}';
  }
}
