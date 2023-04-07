package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.entity.Login;
import com.example.mybatisdemo.utils.JsonWebToken;
//import org.springframework.beans.factory.annotation.Autowired;
import com.example.mybatisdemo.utils.Result;
import com.example.mybatisdemo.utils.ResultCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
  @PostMapping("/api/auth")
  public Result<String> login(@RequestBody Login user) {
//    System.out.println(JsonWebToken.generateToken(user.getUsername()));
//    return new Result<String>(200, "true", JsonWebToken.generateToken(user.getUsername()));
    return Result.success(JsonWebToken.generateToken(user.getUsername()));
  }
}
