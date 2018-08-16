package io.kanke.modules.ahdx.controller;


import io.kanke.modules.ahdx.service.FeedBackService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("ahdx")
public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;
    /**
     * 获取电影反馈数据
     */
    @GetMapping("/film/list")
    public Object getFilmDataList(@RequestParam(required=false) String startTime,@RequestParam(required=false) String endTime){
        return  getData(startTime,endTime,"film");
    }
    /**
     * 获取电视剧反馈数据
     */
    @GetMapping("/tv/list")
    public Object getTvDataList(@RequestParam(required=false) String startTime,@RequestParam(required=false) String endTime){

        return  getData(startTime,endTime,"tv");
    }

    /**
     * 获取综艺反馈数据
     */
    @GetMapping("/arts/list")
    public Object getArtsDataList(@RequestParam(required=false) String startTime,@RequestParam(required=false) String endTime){
        return  getData(startTime,endTime,"arts");
    }
    /**
     * 获取电视剧反馈数据
     */
    @GetMapping("/anime/list")
    public Object getAnimeDataList(@RequestParam(required=false) String startTime,@RequestParam(required=false) String endTime){
        return  getData(startTime,endTime,"anime");
    }
    /**
     * 获取纪录片反馈数据
     */
    @GetMapping("/documentary/list")
    public Object getDocumentaryDataList(@RequestParam(required=false) String startTime,@RequestParam(required=false) String endTime){
        return  getData(startTime,endTime,"documentary");
    }

    public  Object getData (String startTime,String endTime,String type){
        if(StringUtils.isNotBlank(startTime)&&StringUtils.isNotBlank(endTime)){
            List<String> list = new ArrayList<>();
            list.add(startTime);
            list.add(endTime);
            return  feedBackService.getDataListByVideoType(list,type);
        }
        return  feedBackService.getDataListByVideoType(null,type);
    }

}
