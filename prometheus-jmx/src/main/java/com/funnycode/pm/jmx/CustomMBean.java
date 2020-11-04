package com.funnycode.pm.jmx;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author tc
 * @date 2020/11/3
 */
public class CustomMBean {

    private MBeanServer mbs = null;

    private ObjectName name;

    @PostConstruct
    public void start() {
        init();
    }

    @PreDestroy
    public void destroy() {
        try {
            mbs.unregisterMBean(name);
        } catch (InstanceNotFoundException | MBeanRegistrationException e) {
            throw new RuntimeException(e);
        }
    }

    public void init() {
        mbs = ManagementFactory.getPlatformMBeanServer();
    }

    public void registry(ApiCountMBean mb)
        throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException,
        MBeanRegistrationException {
        Class<? extends ApiCountMBean> objectClass = mb.getClass();

        name = new ObjectName(
            String.format("%s:type=basic,name=%s", objectClass.getPackage().getName(), objectClass.getName())
        );

        mbs.registerMBean(mb, name);
    }

}
