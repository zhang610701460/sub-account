package io.kanke.modules.subaccount.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.kanke.modules.subaccount.dao.HomePageDao;
import io.kanke.modules.subaccount.entity.BarData;
import io.kanke.modules.subaccount.entity.HomePage;
import io.kanke.modules.subaccount.entity.InforCardData;
import io.kanke.modules.subaccount.entity.PieData;
import io.kanke.modules.subaccount.service.IHomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("homePageService")
public class IHomePageServiceImpl implements IHomePageService {

    @Autowired
    private HomePageDao homePageDao;
    @Override
    public Object getDateByCp(String cpName) {

        Long totalAccounts = homePageDao.queryTotalAccounts(cpName);
        InforCardData inforCardData =  new InforCardData("总分账","logo-yen",totalAccounts.toString(),"#2d8cf0");

        PieData  pieData= new PieData("335","单片收费");

        //最近15日折线图数据
        List<BarData> barDataList  = homePageDao.queryBarDataList(cpName);


       Map barData= new HashMap<>();
        for (int i =0 ; i<barDataList.size() ; i++){
            barData.put(barDataList.get(i).getTime(),barDataList.get(i).getValue());
        }
        HomePage data = new HomePage(inforCardData,pieData,barData);

        JSONObject jsonObject = (JSONObject) JSON.toJSON(data);

        /*String json = "{ inforCardData: [ { title: '总分账', icon: 'logo-yen', count: 80332, color: '#2d8cf0' }," +
                "{ title: '本月已分账', icon: 'md-locate', count: 23432, color: '#19be6b' }," +
                "{ title: '本月待分账', icon: 'md-help-circle', count: 54234, color: '#ff9900' }," +
                "{ title: '预计月收入', icon: 'md-share', count: 75563, color: '#ed3f14' }," +
                "{ title: '同期百分比', icon: 'md-trending-up', count: 12, color: '#E46CBB' }," +
                "{ title: '同行业参数', icon: 'md-map', count: 14, color: '#9A66E4' }]," +
                "pieData: [" +
                " {value: 335, name: '单片收费'}, {value: 310, name: '单月购买'},{value: 234, name: '连续包月'},{value: 135, name: '包季'},{value: 154, name: '包年'}, {value: 158, name: '活动'}]," +
                "barData: {'2018-08-01': 13253,'2018-08-02': 34235}}";*/

        return jsonObject;
    }

    public static void main(String[] args) {
        JSONObject js = new JSONObject();
        String json = "{ inforCardData: [ { title: '总分账', icon: 'logo-yen', count: 80332, color: '#2d8cf0' }," +
                "{ title: '本月已分账', icon: 'md-locate', count: 23432, color: '#19be6b' }]}";
        js = JSONObject.parseObject(json);
        System.out.println(js);
    }
}
