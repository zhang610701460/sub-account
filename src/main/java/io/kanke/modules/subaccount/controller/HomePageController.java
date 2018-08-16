package io.kanke.modules.subaccount.controller;

import io.kanke.modules.subaccount.service.IHomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 首页数据获取
 *
 *
 * */
@RestController
@RequestMapping("homePage")
public class HomePageController {


    @Autowired
    private IHomePageService iHomePageService;
    /**
     *
     * 获取首页数据
     *
     * */
    @GetMapping("/home/data")
    public Object getHomePageData(@RequestParam(required=false) String cpName){
        return getDate(cpName);
    }

    public Object getDate(String cpName){
        return iHomePageService.getDateByCp(cpName);
    }

}
