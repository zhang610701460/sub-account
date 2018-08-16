package io.kanke.modules.subaccount.dao;

import io.kanke.modules.subaccount.entity.BarData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HomePageDao {

    Long queryTotalAccounts(@Param("cpName") String cpName);

    List<BarData> queryBarDataList(@Param("cpName") String cpName);
}
