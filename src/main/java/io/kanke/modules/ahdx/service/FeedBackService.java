package io.kanke.modules.ahdx.service;


import com.baomidou.mybatisplus.service.IService;
import io.kanke.modules.ahdx.entity.FeedBack;

import java.util.List;

public interface FeedBackService extends IService<FeedBack> {

    Object getFeedBackResult();

    Object getDataListByVideoType(List<String> dates,String type);

    List<FeedBack> queryDataListByVideoType(String videoType, List<String> dates);
 }
