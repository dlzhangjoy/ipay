package com.ipay.core.util;

import java.util.UUID;
/**
 * UUID工具
 * @author kaifa
 *
 */
public class UUIDUtil {
	/**
	 * 返回UUID字符串
	 * @return
	 */
      public static String randomUUIDStr(){
    	  return UUID.randomUUID().toString().replace("-", "");
      }
}
