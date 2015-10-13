package com.powerlong.service.impl;


import com.powerlong.mapper.ReceiptMapper;
import com.powerlong.service.ReceiptServiceI;
import com.powerlong.model.Receipt;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("receiptService")
public class ReceiptServiceImpl implements ReceiptServiceI {
	private static final Logger logger = Logger.getLogger(ReceiptServiceImpl.class);
	@Resource
	private ReceiptMapper receiptMapper;

	public ReceiptMapper getReceiptMapper() {
		return receiptMapper;
	}

	@Autowired
	public void setReceiptMapper(@SuppressWarnings("SpringJavaAutowiringInspection") ReceiptMapper receiptMapper) {
		this.receiptMapper = receiptMapper;
	}

	@Override
	public Receipt getReceiptById(Long id) {
		return receiptMapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveReceiptData(Receipt receipt) {
		
		receiptMapper.insertSelective(receipt);
		
	}
	@Override
	public Receipt selectByQRCode(String qrcode){
		try {
			return receiptMapper.selectByQRCode( qrcode);
		}catch (Exception e){
			logger.error("selectByQRCode查询数据库出错！",e);
		}
		return null;
	}
	

}
