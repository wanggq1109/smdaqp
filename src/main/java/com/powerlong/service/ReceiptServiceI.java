package com.powerlong.service;


import com.powerlong.model.Receipt;

/**
 * 水单数据接口
 */
public interface ReceiptServiceI {
	
	public Receipt getReceiptById(Long id);
	
	public void saveReceiptData(Receipt receipt);

	public Receipt selectByQRCode(String qrcode);

}
