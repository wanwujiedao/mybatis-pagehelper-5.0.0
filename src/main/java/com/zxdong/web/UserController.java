package com.zxdong.web;

import com.github.pagehelper.PageHelper;
import com.zxdong.service.IUserService;
import com.zxdong.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * Created by zxdong on 2017/4/1.
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findByUserName")
    public List<User> findByUserName(String username){
        return userService.findByUserName(username);
    }

    @RequestMapping("/findById")
    public User findById(Integer id){
        return userService.findById(id);
    }

    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
         userService.deleteById(id);
         return "万物皆导";
    }

    @RequestMapping("/findByPage")
    public List<User> findByPage(){
        try {
            PageHelper.startPage(1,10);
            return userService.findByPage();
        }catch (Exception e){
            System.err.println("错误"+e);
        }
         return null;
    }

    @RequestMapping("/save")
public String  save(int k){
        try {
            long startTime = System.currentTimeMillis();
            for(int i=0;i<k;i++) {
                userService.save(new User(getRandom(5, false), getRandom(6, false), Integer.valueOf(getRandom(3, true))));
            }
            long endTime = System.currentTimeMillis();
            System.out.println("使用时间："+(endTime-startTime));
        } catch (Exception e) {
            System.err.println("错误："+e);
            return "save fail!";
        }

        return "save success!";
    }



    private String getRandom(int n,boolean flag){
        Random random = new Random();
        String[] code={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String rs=new String();
        for(int i=0;i<n;i++){
            if(flag){
                rs+=code[random.nextInt(10)];
            }else{
                rs+=code[random.nextInt(36)];
            }

        }
        return rs;
    }

}
