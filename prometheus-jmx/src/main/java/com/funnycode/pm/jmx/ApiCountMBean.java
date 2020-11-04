package com.funnycode.pm.jmx;

/**
 * 1、标准MBean 名称必需是在要监控的类名后面加上“MBean ”。
 * <p>
 * 2、监控的类和MBean 接口必需在同一包下，也可以理解为注册的接口名字必须以MBean结尾，接口实现类比接口名字少了MBean,而且接口和接口实现类必须放在同一个包下
 *
 * @author tc
 * @date 2020/11/3
 */
public interface ApiCountMBean {

    long getTotal();

}
