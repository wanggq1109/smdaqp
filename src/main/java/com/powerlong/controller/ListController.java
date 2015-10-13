package com.powerlong.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.powerlong.model.Screenvideo;
import com.powerlong.service.IbeaconService;
import com.powerlong.service.ScreenVideoService;
import com.powerlong.vo.IbeanconStatisticVo;
import com.powerlong.vo.ScreenVideoDataVo;

@Controller
@RequestMapping("/data")
public class ListController {
	private static final Logger logger = Logger
            .getLogger(ListController.class);
	
	
    @Resource
    private ScreenVideoService screenVideoService;
    @Resource
    private IbeaconService ibeaconService;
	
	
//	@RequestMapping("dataReport")
//    public String dataReport(HttpServletRequest request,ModelMap map,String data,String mobile) throws Exception{
//        try {
//        	ScreenVideoVo Guanggao=new ScreenVideoVo();
//        	ScreenVideoVo PinPai=new ScreenVideoVo();
//        	ScreenVideoVo HuoDong=new ScreenVideoVo();
//        	ScreenVideoVo DiTu=new ScreenVideoVo();
//        	List<ScreenVideoVo> GuanggaoList=new ArrayList<ScreenVideoVo>();
//        	List<ScreenVideoVo> PinPaiList=new ArrayList<ScreenVideoVo>();
//        	List<ScreenVideoVo> HuoDongList=new ArrayList<ScreenVideoVo>();
//        	List<ScreenVideoVo> DiTuList=new ArrayList<ScreenVideoVo>();
//        	Screenvideo record=new Screenvideo();
//        	record.setContent("广告");
//        	Guanggao=screenVideoService.selectContentGroupBy(record);
//        	GuanggaoList=screenVideoService.selectContentGroupByList(record);
//        	record.setContent("店铺");
//        	PinPai=screenVideoService.selectContentGroupBy(record);
//        	PinPaiList=screenVideoService.selectContentGroupByList(record);
//        	record.setContent("活动");
//        	HuoDong=screenVideoService.selectContentGroupBy(record);
//        	HuoDongList=screenVideoService.selectContentGroupByList(record);
//        	record.setContent("地图");
//        	DiTu=screenVideoService.selectContentGroupBy(record);
//        	DiTuList=screenVideoService.selectContentGroupByList(record);
//        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        	SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm");
//        	map.put("Guanggao", Guanggao);
//        	map.put("PinPai", PinPai);
//        	map.put("HuoDong", HuoDong);
//        	map.put("DiTu", DiTu);
//        	
//        	if(GuanggaoList!=null && GuanggaoList.size() > 10){
//        		List<ScreenVideoVo> GuanggaoList2=new ArrayList<ScreenVideoVo>();
//        		for (int i = 0; i < 10; i++) {
//        			ScreenVideoVo vo=new ScreenVideoVo();
//        			vo=GuanggaoList.get(i);
//        			GuanggaoList2.add(vo);
//				}
//        		GuanggaoList=GuanggaoList2;
//        	}
//        	
//        	
//        	if(PinPaiList!=null && PinPaiList.size() > 0){
//        		if(PinPaiList.size() > 10){
//        			List<ScreenVideoVo> PinPaiList2=new ArrayList<ScreenVideoVo>();
//            		for (int i = 0; i < 10; i++) {
//            			ScreenVideoVo vo=new ScreenVideoVo();
//            			vo=PinPaiList.get(i);
//            			vo.setContent(vo.getContent().substring(3, vo.getContent().length()-1));
//            			PinPaiList2.add(vo);
//    				}  
//            		PinPaiList=PinPaiList2;
//        		}
//        		else{
//        			List<ScreenVideoVo> PinPaiList2=new ArrayList<ScreenVideoVo>();
//        			for (int i = 0; i < PinPaiList.size(); i++) {
//        				ScreenVideoVo vo=new ScreenVideoVo();
//            			vo=PinPaiList.get(i);
//            			vo.setContent(vo.getContent().substring(3, vo.getContent().length()-1));
//            			PinPaiList2.add(vo);
//					}
//        			PinPaiList=PinPaiList2;
//        		}
//        	}
//        	
//        	if(HuoDongList!=null && HuoDongList.size() > 0){
//        		if(HuoDongList.size() > 10){
//            		List<ScreenVideoVo> HuoDongList2=new ArrayList<ScreenVideoVo>();
//            		for (int i = 0; i < 10; i++) {
//            			ScreenVideoVo vo=new ScreenVideoVo();
//            			vo=HuoDongList.get(i);
//            			HuoDongList2.add(vo);
//    				}  
//            		HuoDongList=HuoDongList2;
//            	}
//        		else{
//        			List<ScreenVideoVo> HuoDongList2=new ArrayList<ScreenVideoVo>();
//        			for (int i = 0; i < HuoDongList.size(); i++) {
//        				ScreenVideoVo vo=new ScreenVideoVo();
//            			vo=HuoDongList.get(i);
//            			vo.setContent(vo.getContent().substring(3, vo.getContent().length()-1));
//            			HuoDongList2.add(vo);
//					}
//        			HuoDongList=HuoDongList2;
//        		}
//        	}
//        	
//        	if(DiTuList!=null && DiTuList.size() > 10){
//        		List<ScreenVideoVo> DiTuList2=new ArrayList<ScreenVideoVo>();
//        		for (int i = 0; i < 10; i++) {
//        			ScreenVideoVo vo=new ScreenVideoVo();
//        			vo=DiTuList.get(i);
//        			DiTuList2.add(vo);
//				}  
//        		DiTuList=DiTuList2;
//        	}
//        	map.put("GuanggaoList", GuanggaoList);
//        	map.put("PinPaiList", PinPaiList);
//        	map.put("HuoDongList",HuoDongList);
//        	map.put("DiTuList", DiTuList);
//        	map.put("date", sdf.format(new Date()));
//        	map.put("time", sdf2.format(new Date()));
//        }catch (Exception e){
//            logger.error("dataReport方法异常！",e);
//            throw new Exception(e);
//        }
//        return "list";
//    }
    @RequestMapping("dataReport")
	public String dataReport(HttpServletRequest request,ModelMap map,String data,String mobile) throws Exception{
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	Screenvideo record = new Screenvideo();
    	if(null==request.getParameter("date")){
    		map.put("date", sdf.format(new Date()));
    		record.setClicktime(sdf.format(new Date()));
    	}
    	else{
    		String date=request.getParameter("date");
    		String type=request.getParameter("type");
    		if("next".equals(type)){   			
    			record.setClicktime(sdf.format(sdf.parse(date).getTime()+24 * 60 * 60 * 1000));
    		}
    		else if("pre".equals(type)){
    			record.setClicktime(sdf.format(sdf.parse(date).getTime()-24 * 60 * 60 * 1000));
    		}
    		map.put("date", record.getClicktime());
    	}
    	Object[] tick=null ;
    	Object[] tick2=null ;
    	Object[] tick3=null ;
    	Object[] datamap =null;
    	Object[] datamap2 =null;
    	Object[] datamap3 =null;
    	List<ScreenVideoDataVo> retList=new ArrayList<ScreenVideoDataVo>();    	
    	List<IbeanconStatisticVo> beanconList = ibeaconService.getBeaconStatistic();
    	int total = 0;
    	for(IbeanconStatisticVo beanconInfo : beanconList){
    		String lastChar = beanconInfo.getIbeaconno().substring(beanconInfo.getIbeaconno().length() - 1);
    		if(lastChar.equals("0")){
    			total += beanconInfo.getCnt();
    			map.put("zeroStream", beanconInfo.getCnt());
    		}else if(lastChar.equals("3")){
    			total += beanconInfo.getCnt();
    			map.put("threeStream", beanconInfo.getCnt());
    		}
    	}
    	map.put("total", total);
    	try {
    		//全部数据
    		retList=screenVideoService.selectGroupByList(record);       	
        	if(null !=retList && retList.size() > 0){
        		//tick处理
        		tick=new Object[retList.size()];
        		datamap=new Object[retList.size()];
        		for (int i = 0; i < retList.size(); i++) {
        			Object[] arrtick={i,retList.get(i).getContent()};
        			Object[] arrdata={i,retList.get(i).getCnt()};
        			tick[i]=arrtick;
        			datamap[i]=arrdata;
    			}
        		//总数数据处理
        	}   	
        	
        	//导视频1
        	record.setTouchid("1");
        	retList=screenVideoService.selectGroupByList(record);
        	if(null !=retList && retList.size() >0){
        		tick2=new Object[retList.size()];
        		datamap2=new Object[retList.size()];
        		for (int i = 0; i < retList.size(); i++) {
        			Object[] arrtick={i,retList.get(i).getContent()};
        			Object[] arrdata={i,retList.get(i).getCnt()};
        			datamap2[i]=arrdata;
        			tick2[i]=arrtick;
    			}
        	}
        	
        	//导视频2
        	record.setTouchid("2");
        	retList=screenVideoService.selectGroupByList(record);
        	if(null !=retList && retList.size() >0){
        		datamap3=new Object[retList.size()];
        		tick3=new Object[retList.size()];
        		for (int i = 0; i < retList.size(); i++) {
        			Object[] arrtick={i,retList.get(i).getContent()};
        			Object[] arrdata={i,retList.get(i).getCnt()};
        			datamap3[i]=arrdata;
        			tick3[i]=arrtick;
    			}
        	}
        	map.put("data",JSONArray.toJSON(datamap));
        	map.put("data2",JSONArray.toJSON(datamap2));
        	map.put("data3", JSONArray.toJSON(datamap3));
        	map.put("tick", JSONArray.toJSON(tick));
        	map.put("tick2", JSONArray.toJSON(tick2));
        	map.put("tick3", JSONArray.toJSON(tick3));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error(e);
		}    	
    	
    	return "screen";
	}
	
}
