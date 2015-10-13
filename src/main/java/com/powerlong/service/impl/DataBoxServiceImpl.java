package com.powerlong.service.impl;

import com.powerlong.common.Paginator;
import com.powerlong.mapper.*;
import com.powerlong.model.*;
import com.powerlong.service.DataBoxService;
import com.powerlong.vo.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2015/5/20.
 */
@Service("dataBoxService")
public class DataBoxServiceImpl implements DataBoxService {

    private static final Logger logger = Logger.getLogger(DataBoxServiceImpl.class);
    @Resource
    private DataBoxPosmonitorMapper dataBoxPosmonitorMapper;
    @Resource
    private DataboxUserMapper databoxUserMapper;
    @Resource
    private DataBoxReceiptMapper dataBoxReceiptMapper;

    @Resource
    private DataboxItemtypeMapper databoxItemtypeMapper;

    @Resource
    private WifiMaxGustMapper wifiMaxGustMapper;

    @Resource
    private TrafficShopMapper trafficShopMapper;

    @Resource
    private ParkingDetailMapper parkingDetailMapper;

    @Resource
    private ScreenvideoMapper screenvideoMapper;

    @Resource
    private AppPayDataMapper appPayDataMapper;

    @Resource
    private ParkingUserMapper parkingUserMapper;

    @Resource
    private TrafficMallMapper trafficMallMapper;

    @Resource
    private IbeanconLogMapper ibeanconLogMapper;

    /**
     * 查询数据列表分页
     * @param paginator
     * @return
     */
    @Override
    public List<DataBoxPosmonitor> selectDataBoxPosmonitorData(Paginator paginator) throws Exception{
        List<DataBoxPosmonitor> list = this.dataBoxPosmonitorMapper.selectDataBoxPosmonitorData(paginator);
        return list;
    }

    /**
     * 查询数据总数分页
     * @param paginator
     * @return
     */
    @Override
    public Long selectDataBoxPosmonitorDataCount(Paginator paginator) throws Exception {
        Long count = this.dataBoxPosmonitorMapper.selectDataBoxPosmonitorDataCount(paginator);
        return count;
    }

    /**
     * 插入databoxuser数据
     * @param record
     * @return
     */
    @Override
    public int insertDataboxUser(DataboxUser record) throws Exception {
        try{
            return this.databoxUserMapper.insert(record);
        }catch (Exception e){
            logger.error("databoxuser插入数据库出错！",e);
        }
        return 0;
    }

    /**
     * 根据水单号查询水单信息
     * @param databoxUser
     * @return
     * @throws Exception
     */
    @Override
    public DataBoxReceipt selectByQRCode(DataboxUser databoxUser) throws Exception {
        return this.dataBoxReceiptMapper.selectByReceiptnum(databoxUser.getReceiptnum());
    }

    /**
     * 获取流水信息以及用户信息
     * @param paginator
     * @return
     * @throws Exception
     */
    @Override
    public List<DataBoxVo> selectDataBoxAndUserData(Paginator paginator) throws Exception {
        return this.dataBoxReceiptMapper.selectDataBoxAndUserData(paginator);
    }

    /**
     * 获取流水信息以及用户信息
     * @param paginator
     * @return
     * @throws Exception
     */
    @Override
    public Long selectDataBoxAndUserDataCount(Paginator paginator) throws Exception {
        return this.dataBoxReceiptMapper.selectDataBoxAndUserDataCount(paginator);
    }

    /**
     * 根据主键获取用户信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public DataboxUser selectByDataBoxUserId(Long id) throws Exception {
        return this.databoxUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取用户本月消费次数和消费总金额
     * @param mobile
     * @return
     * @throws Exception
     */
    @Override
    public DataBoxCountVo selectDataBoxCountByUserId(String mobile) throws Exception {
        return this.dataBoxReceiptMapper.selectDataBoxCountByUserId(mobile);
    }

    /**
     * 获取用户本月消费次数和消费总金额
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public List<DataBoxDetailVo> selectDataBoxToMonthDataByUserId(Long id) throws Exception {
        return this.dataBoxReceiptMapper.selectDataBoxToMonthDataByUserId(id);
    }

    /**
     * 业态消费
     * @param mobile
     * @return
     * @throws Exception
     */
    @Override
    public List<DataBoxItemTypeDataVo> selectDataBoxToMonthTypeByUserId(String mobile) throws Exception {
        return this.databoxItemtypeMapper.selectDataBoxToMonthTypeByUserId(mobile);
    }

    /**
     * wifi当前人停留时间所在楼层
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public List<WifiMaxGust> selectCountTimeOnFloor(WifiMaxGust record) throws Exception {
        return this.wifiMaxGustMapper.selectCountTimeOnFloor(record);
    }

    /**
     * wifi当前人停留时间所在店铺
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public List<WifiMaxGust> selectCountTimeOnShop(WifiMaxGust record) throws Exception {
        return this.wifiMaxGustMapper.selectCountTimeOnShop(record);
    }

    /**
     * 获取用户停留店铺列表
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public List<TrafficShop> selectShopByUser(TrafficShop record) throws Exception {
        return this.trafficShopMapper.selectShopByUser(record);
    }

    /**
     * 获取用户停留店铺时间列表
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public List<TrafficShopUserTimeVo> selectShopTimeByUser(TrafficShop record) throws Exception {
        return this.trafficShopMapper.selectShopTimeByUser(record);
    }

    /**
     * 根据手机号获取用户当月停留时间
     * @param mobile
     * @return
     * @throws Exception
     */
    @Override
    public Long selectParkingUserTimeCount(String mobile) throws Exception {
        return this.parkingDetailMapper.selectParkingUserTimeCount(mobile);
    }

    /**
     * 获取支付方式金额列表
     * @param mobile
     * @return
     * @throws Exception
     */
    @Override
    public List<ParkingDetail> selectParkingUserPayTypeCount(String mobile) throws Exception {
        return this.parkingDetailMapper.selectParkingUserPayTypeCount(mobile);
    }

    /**
     * 获取总金额支付
     * @param mobile
     * @return
     * @throws Exception
     */
    @Override
    public Double selectParkingUserPayCount(String mobile) throws Exception {
        return this.parkingDetailMapper.selectParkingUserPayCount(mobile);
    }

    /**
     * 获取用户出口数据
     * @param mobile
     * @return
     * @throws Exception
     */
    @Override
    public List<ParkingDetail> selectParkingEnterCount(String mobile) throws Exception {
        return this.parkingDetailMapper.selectParkingEnterCount(mobile);
    }

    /**
     * 获取用户入口数据
     * @param mobile
     * @return
     * @throws Exception
     */
    @Override
    public List<ParkingDetail> selectParkingLeaveCount(String mobile) throws Exception {
        return this.parkingDetailMapper.selectParkingLeaveCount(mobile);
    }

    /**
     * 获取用户到视屏点击内容
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public List<Screenvideo> selectContentByUserMobile(Screenvideo record) throws Exception {
        return this.screenvideoMapper.selectContentByUserMobile(record);
    }

    /**
     * 获取用户到视屏点击内容次数
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public List<Screenvideo> selectContentCountByUserMobile(Screenvideo record) throws Exception {
        return this.screenvideoMapper.selectContentCountByUserMobile(record);
    }

    /**
     * 获取商户当月消费人数
     * @param record
     * @return
     */
    @Override
    public Long selectDataBoxUserCount(DataBoxReceipt record) {
        return this.dataBoxReceiptMapper.selectDataBoxUserCount(record);
    }

    /**
     * 获取商户信息
     * @param dataBoxPosmonitor
     * @return
     */
    @Override
    public DataBoxPosmonitor selectMerchantByMerchantid(DataBoxPosmonitor dataBoxPosmonitor) {
        return this.dataBoxPosmonitorMapper.selectMerchantByMerchantid(dataBoxPosmonitor);
    }

    /**
     * 获取线上消费数
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public AppPayData selectMerchantPayAmountByMerchantId(AppPayData record) throws Exception {
        return this.appPayDataMapper.selectMerchantPayAmountByMerchantId(record);
    }

    /**
     * 获取线下消费数
     * @param dataBoxPosmonitor
     * @return
     */
    @Override
    public Double selectMerchantTotalSumPay(DataBoxPosmonitor dataBoxPosmonitor) {
        return this.dataBoxPosmonitorMapper.selectMerchantTotalSumPay(dataBoxPosmonitor);
    }

    /**
     * 获取商铺消费性别比例
     * @param dataBoxPosmonitor
     * @return
     * @throws Exception
     */
    @Override
    public List<DataBoxPosmonitor> selectMerchantPaySexCount(DataBoxPosmonitor dataBoxPosmonitor) throws Exception {
        return this.dataBoxPosmonitorMapper.selectMerchantPaySexCount(dataBoxPosmonitor);
    }

    /**
     * 获取店铺每天客流列表
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public List<TrafficShopUserTimeVo> selectShopDayUserCountByShopId(TrafficShop record) throws Exception {
        return this.trafficShopMapper.selectShopDayUserCountByShopId(record);
    }

    /**
     * 获取当月店铺消费用户年龄分布
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public List<DataboxItemtype> selectDataBoxToMonthAgeTypeByMerchantId(DataboxItemtype record) throws Exception {
        return this.databoxItemtypeMapper.selectDataBoxToMonthAgeTypeByMerchantId(record);
    }

    /**
     * 获取当月广场在线消费信息
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public List<AppPayData> selectMallPayMonthAmountByMerchantId(AppPayData record) throws Exception {
        return this.appPayDataMapper.selectMallMonthPaySumByMallId(record);
    }

    /**
     * 获取当月广场线下消费信息
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public List<DataBoxPosmonitor> selectMallPayPosmonitorSum(DataBoxPosmonitor record) throws Exception {
        return this.dataBoxPosmonitorMapper.selectMallPaySum(record);
    }

    /**
     * 获取当天广场所有连接数
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public Long selectMallAllDataByMallId(WifiMaxGust record) throws Exception {
        return this.wifiMaxGustMapper.selectMallAllDataByMallId(record);
    }

    /**
     * 获取当前时时停车数
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public Long selectParkingMallAllDataByMallId(ParkingUser record) throws Exception {
        return this.parkingUserMapper.selectParkingMallAllDataByMallId(record);
    }

    /**
     * 获取当天客流量
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public Long selectMallTrafficDataByMallId(TrafficMall record) throws Exception {
        return this.trafficMallMapper.selectMallTrafficDataByMallId(record);
    }

    /**
     * 获取当月每天wifi连接信息
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public List<WifiMaxGust> selectMallWifiMonthDataByMallId(WifiMaxGust record) throws Exception {
        return this.wifiMaxGustMapper.selectMallWifiMonthDataByMallId(record);
    }

    /**
     * 获取当月客流信息
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public List<TrafficMall> selectMallTrafficMonthDataByMallId(TrafficMall record) throws Exception {
        return this.trafficMallMapper.selectMallTrafficMonthDataByMallId(record);
    }

    /**
     * 获取当月停车场数据
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public List<ParkingUser> selectParkingMallCountDataByMallId(ParkingUser record) throws Exception {
        return this.parkingUserMapper.selectParkingMallCountDataByMallId(record);
    }

    /**
     * 获取用户平均停留时间
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public Long selectUserMonthAvgTimeByUser(TrafficShop record) throws Exception {
        return this.trafficShopMapper.selectUserMonthAvgTimeByUser(record);
    }

    /**
     * 根据车牌号获取车牌
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public String selectByUserMobile(ParkingUser record) throws Exception {
        return this.parkingUserMapper.selectPlateNoByUserMobile(record);
    }

    /**
     * 获取店铺每天消费人数
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public List<DataBoxDetailVo> selectDataBoxToMonthUserCountByUserId(DataBoxReceipt record) throws Exception {
        return this.dataBoxReceiptMapper.selectDataBoxToMonthUserCountByUserId(record);
    }

    /**
     * 获取用户占比
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public Double selectByUserNewAndOld(DataboxUser record) throws Exception {
        return this.databoxUserMapper.selectByUserNewAndOld(record);
    }

    /**
     * 获取当月用户总消费次数
     * @param mobile
     * @return
     * @throws Exception
     */
    @Override
    public Long selectDataBoxToMonthCountPayByUser(String mobile) throws Exception {
        return this.databoxItemtypeMapper.selectDataBoxToMonthCountPayByUser(mobile);
    }

    /**
     * 获取当月消费总人数
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public Long selectByUserToMonthNewAndOldCount(DataboxUser record) throws Exception {
        return this.databoxUserMapper.selectByUserToMonthNewAndOldCount(record);
    }

    /**
     * 获取新会员
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public Long selectByUserNewCount(DataboxUser record) throws Exception {
        return this.databoxUserMapper.selectByUserNewCount(record);
    }

    /**
     *
     * @param dataBoxPosmonitor
     * @return
     * @throws Exception
     */
    @Override
    public List<DataBoxPosmonitor> selectMerchantPaySexCountBySex(DataBoxPosmonitor dataBoxPosmonitor) throws Exception {
        return this.dataBoxPosmonitorMapper.selectMerchantPaySexCountBySex(dataBoxPosmonitor);
    }

    @Override
    public List<DataboxUser> selectByUserToMonthOldList(DataboxUser record) throws Exception {
        return this.databoxUserMapper.selectByUserToMonthOldList(record);
    }

    @Override
    public List<DataboxUser> selectByUserToMonthNewList(DataboxUser record) throws Exception {
        return this.databoxUserMapper.selectByUserToMonthNewList(record);
    }

    @Override
    public List<DataboxItemtype> selectDataBoxToMonthAgeList(DataboxItemtype record) throws Exception {
        return this.databoxItemtypeMapper.selectDataBoxToMonthAgeList(record);
    }

    @Override
    public Long selectIbeanconLogToMonthCount(IbeanconLog record) throws Exception {
        return ibeanconLogMapper.selectIbeanconLogToMonthCount(record);
    }

    @Override
    public List<IbeanconLog> selectIbeanconLogToMonthCountByDay(IbeanconLog record) throws Exception {
        return this.ibeanconLogMapper.selectIbeanconLogToMonthCountByDay(record);
    }
}
