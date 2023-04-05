package com.example.mybatisdemo.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.mybatisdemo.entity.User;
import com.example.mybatisdemo.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
  @Autowired
  private UserMapper userMapper;

  @GetMapping("/api/user")
  public Format getAll() {
    List<User> all = userMapper.selectList(null);
    System.out.println(all);

    return new Format(200, all.toString());
  }

  @PostMapping("/api/user")
  public Format save(@RequestBody() User user) {
    userMapper.insert(user);
    return new Format(200, "success");
  }

  @DeleteMapping("/api/user/{id}")
  public Format del(@PathVariable int id) {
    User i = userMapper.selectById(id);
    if (i != null) {
      userMapper.deleteById(i.getId());
      return new Format(201, "删除成功");
    } else {
      return new Format(400, "not Found User");
    }
  }

  @PutMapping("/api/user/{id}")
  public Format update(@PathVariable int id, @RequestBody User user) {
    UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>();


    User i = userMapper.selectById(id);
    System.out.println("=======>" + i);
    if (i != null) {
      userMapper.update(user, updateWrapper);
      return new Format(200, "更新成功");
    } else {
      return new Format(500, "更新失败");
    }
  }

  public record Format(long code, String message) {

  }
}
