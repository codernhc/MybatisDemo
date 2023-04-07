package com.example.mybatisdemo.utils;

import java.io.Serializable;

public class Result<T> implements Serializable {
  private Integer code;
  private String msg;
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

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  @Override
  public String toString() {
    return "Result{" +
      "code=" + code +
      ", msg='" + msg + '\'' +
      ", data=" + data +
      ", success=" + success +
      '}';
  }
}
