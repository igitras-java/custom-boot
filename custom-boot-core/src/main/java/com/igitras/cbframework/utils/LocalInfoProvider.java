package com.igitras.cbframework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Local Instance information provider.
 *
 * @author mason
 */
public abstract class LocalInfoProvider {
    private static final Logger LOG = LoggerFactory.getLogger(LocalInfoProvider.class);

    private static InetAddress LOCAL_INET_ADDR;

    static {
        try {
            LOCAL_INET_ADDR = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            LOG.warn("Retrieving local Inet Address failed.");
        }
    }

    public static String getLocalIpAddress() {
        return LOCAL_INET_ADDR.getHostAddress();
    }

    public static String getLocalHostname() {
        return LOCAL_INET_ADDR.getHostName();
    }

    public static String getCanonicalHostname() {
        return LOCAL_INET_ADDR.getCanonicalHostName();
    }
}
