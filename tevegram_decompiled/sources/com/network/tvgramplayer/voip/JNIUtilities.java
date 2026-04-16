package com.network.tvgramplayer.voip;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class JNIUtilities {
    public static Context context;

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
    
        r1 = android.telephony.SubscriptionManager.getDefaultDataSubscriptionId();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String[] getCarrierInfo() {
        /*
            android.content.Context r0 = com.network.tvgramplayer.voip.JNIUtilities.context
            if (r0 != 0) goto L5
            goto L53
        L5:
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r1 < r2) goto L1e
            int r1 = androidx.emoji2.text.y.a()
            r2 = -1
            if (r1 == r2) goto L1e
            android.telephony.TelephonyManager r0 = androidx.emoji2.text.y.h(r0, r1)
        L1e:
            java.lang.String r1 = r0.getNetworkOperatorName()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L53
            java.lang.String r1 = r0.getNetworkOperator()
            if (r1 == 0) goto L3f
            int r2 = r1.length()
            r3 = 3
            if (r2 <= r3) goto L3f
            r2 = 0
            java.lang.String r2 = r1.substring(r2, r3)
            java.lang.String r1 = r1.substring(r3)
            goto L42
        L3f:
            java.lang.String r2 = ""
            r1 = r2
        L42:
            java.lang.String r3 = r0.getNetworkOperatorName()
            java.lang.String r0 = r0.getNetworkCountryIso()
            java.lang.String r0 = r0.toUpperCase()
            java.lang.String[] r0 = new java.lang.String[]{r3, r0, r2, r1}
            return r0
        L53:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.network.tvgramplayer.voip.JNIUtilities.getCarrierInfo():java.lang.String[]");
    }

    @TargetApi(23)
    public static String getCurrentNetworkInterfaceName() {
        Network activeNetwork;
        LinkProperties linkProperties;
        Context context2 = context;
        if (context2 == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
        activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) == null) {
            return null;
        }
        return linkProperties.getInterfaceName();
    }

    public static String[] getLocalNetworkAddressesAndInterfaceName() {
        Network activeNetwork;
        LinkProperties linkProperties;
        Context context2 = context;
        String str = null;
        if (context2 != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
            if (Build.VERSION.SDK_INT >= 23) {
                activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork != null && (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) != null) {
                    Iterator<LinkAddress> it = linkProperties.getLinkAddresses().iterator();
                    String str2 = null;
                    while (it.hasNext()) {
                        InetAddress address = it.next().getAddress();
                        if (address instanceof Inet4Address) {
                            if (!address.isLinkLocalAddress()) {
                                str = address.getHostAddress();
                            }
                        } else if ((address instanceof Inet6Address) && !address.isLinkLocalAddress() && (address.getAddress()[0] & 240) != 240) {
                            str2 = address.getHostAddress();
                        }
                    }
                    return new String[]{linkProperties.getInterfaceName(), str, str2};
                }
            } else {
                try {
                    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    if (networkInterfaces != null) {
                        while (networkInterfaces.hasMoreElements()) {
                            NetworkInterface nextElement = networkInterfaces.nextElement();
                            if (!nextElement.isLoopback() && nextElement.isUp()) {
                                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                                String str3 = null;
                                String str4 = null;
                                while (inetAddresses.hasMoreElements()) {
                                    InetAddress nextElement2 = inetAddresses.nextElement();
                                    if (nextElement2 instanceof Inet4Address) {
                                        if (!nextElement2.isLinkLocalAddress()) {
                                            str3 = nextElement2.getHostAddress();
                                        }
                                    } else if ((nextElement2 instanceof Inet6Address) && !nextElement2.isLinkLocalAddress() && (nextElement2.getAddress()[0] & 240) != 240) {
                                        str4 = nextElement2.getHostAddress();
                                    }
                                }
                                return new String[]{nextElement.getName(), str3, str4};
                            }
                        }
                    }
                } catch (Exception e9) {
                    VLog.e(e9);
                    return null;
                }
            }
        }
        return null;
    }

    public static int getMaxVideoResolution() {
        return 320;
    }

    public static String getSupportedVideoCodecs() {
        return "";
    }

    public static int[] getWifiInfo() {
        Context context2 = context;
        if (context2 == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) context2.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return new int[]{connectionInfo.getRssi(), connectionInfo.getLinkSpeed()};
        } catch (Exception unused) {
            return null;
        }
    }
}
