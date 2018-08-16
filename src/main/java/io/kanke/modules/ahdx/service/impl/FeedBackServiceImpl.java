package io.kanke.modules.ahdx.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.kanke.modules.ahdx.dao.FeedBackDao;
import io.kanke.modules.ahdx.entity.FeedBack;
import io.kanke.modules.ahdx.service.FeedBackService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service("feedBackService")
public class FeedBackServiceImpl extends ServiceImpl<FeedBackDao, FeedBack> implements FeedBackService{


    @Override
    public Object getFeedBackResult() {
        JSONObject js = new JSONObject();
//        DecimalFormat df = new DecimalFormat(".000");
//        //获取日期列表  折线图横坐标
//        List<String> datelist = baseMapper.queryDateList();
//        js.put("date",datelist);
//        String[] videoTypeList = {"film","tv","arts","anime","documentary"};
//        for(String videoType : videoTypeList){
//          List<FeedBack> list = baseMapper.queryDataListByVideoType(videoType,datelist);
//            List<String> A_list = new ArrayList<>();
//            List<String> B_list = new ArrayList<>();
//          for(FeedBack fb:list){
//              if("iti_01".equals(fb.getStrategy())){
//                  Integer a = fb.getRecplaycount() ;
//                  Integer b = fb.getTotalpalycount() ;
//                  double d = (double)a/b;
//                  A_list.add("0"+df.format(d));
//              }else if("iti_02".equals(fb.getStrategy())){
//                  Integer a = fb.getRecplaycount() ;
//                  Integer b = fb.getTotalpalycount() ;
//                  double d = (double)a/b;
//                  B_list.add("0"+df.format(d));
//              }
//          }
//            js.put("iti_01_"+videoType,A_list);
//            js.put("iti_02_"+videoType,B_list);
//
//        }


        return js;
    }

    @Override
    public Object getDataListByVideoType(List<String> dates,String type) {
        JSONObject js = new JSONObject();
        DecimalFormat df = new DecimalFormat(".00000");
        DecimalFormat df1 = new DecimalFormat(".000");
        List<String> datelist = new ArrayList<>();
        if(null!=dates&&dates.size()>0){
            Map<String, Object> map = new HashMap<>();
            map.put("startTime", dates.get(0));
            map.put("endTime", dates.get(1));
            map.put("videoType", type);
            datelist = baseMapper.queryDateListBystartAndEndTime(map);
        }else{
            datelist = baseMapper.queryDateList(type);
            if(datelist.size()>=10){
                datelist  = datelist.subList(datelist.size()-10,datelist.size());
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("list", datelist);
        map.put("videoType", type);
        List<FeedBack> list = baseMapper.queryDataListByVideoType(map);
        System.out.println("list"+list);
        List<String> A_list = new ArrayList<>();
        List<String> B_list = new ArrayList<>();
        for(FeedBack fb:list){
            if("iti_01".equals(fb.getStrategy())){
                Integer a = fb.getRecplaycount() ;
                Integer b = fb.getTotalpalycount() ;
                double d = (double)a/b;
                Double  db = Double.valueOf("0"+df.format(d));
                 A_list.add(df1.format(db*100));
             }else if("iti_02".equals(fb.getStrategy())){
                 Integer a = fb.getRecplaycount() ;
                 Integer b = fb.getTotalpalycount() ;
                 double d = (double)a/b;
                Double  db = Double.valueOf("0"+df.format(d));
                B_list.add(df1.format(db*100));
            }
        }
        js.put("iti_01",A_list);
        js.put("iti_02",B_list);
        js.put("date",datelist);
        return js;
    }


    @Override
    public List<FeedBack> queryDataListByVideoType(String videoType, List<String> list) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("videoType", videoType);
        return baseMapper.queryDataListByVideoType(map);
    }

    public static void main(String[] args) {
        Integer i =100379;
        Integer j =3068865;

        double d = (double)i/j;

        DecimalFormat df = new DecimalFormat(".00000");
        DecimalFormat df1 = new DecimalFormat(".000");
        System.out.println(df.format(d));
        Double  fb = Double.valueOf("0"+df.format(d));
        System.out.println(df1.format(fb*100)+"%");

    /*    List list  =   new LinkedList();
        for  ( int  i  =   0 ; i  <10 ; i ++ )  {
            list.add( " a " + i);
        }
        System.out.println(list.subList(list.size()-10,list.size()));*/
//        Collections.sort(list); // 顺序排列
//        System.out.println(list);
//
//        Collections.shuffle(list); // 混乱的意思
//        System.out.println(list);

//        Collections.reverse(list); // 倒序排列
//        System.out.println(list.subList(0,10));

    }

}
