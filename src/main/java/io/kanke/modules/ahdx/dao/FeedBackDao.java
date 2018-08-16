package io.kanke.modules.ahdx.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.kanke.modules.ahdx.entity.FeedBack;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface FeedBackDao extends BaseMapper<FeedBack> {

   List<String> queryDateList(@Param("videoType") String videoType);

   List<String> queryDateListBystartAndEndTime(Map<String, Object> map);

   List<FeedBack>  queryDataListByVideoType(Map<String, Object> map);
}
