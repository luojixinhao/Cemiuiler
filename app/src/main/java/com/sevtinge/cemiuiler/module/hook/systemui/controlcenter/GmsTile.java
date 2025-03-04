package com.sevtinge.cemiuiler.module.hook.systemui.controlcenter;

import static com.sevtinge.cemiuiler.utils.devicesdk.SystemSDKKt.isMoreAndroidVersion;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.ArrayMap;

import com.sevtinge.cemiuiler.R;
import com.sevtinge.cemiuiler.utils.TileUtils;

import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import de.robv.android.xposed.XposedHelpers;

public class GmsTile extends TileUtils {
    String CheckGms = "com.google.android.gms";
    String mQSFactoryClsName = isMoreAndroidVersion(Build.VERSION_CODES.TIRAMISU) ? "com.android.systemui.qs.tileimpl.MiuiQSFactory" :
        "com.android.systemui.qs.tileimpl.QSFactoryInjectorImpl";
    String[] GmsAppsSystem = new String[]{
        "com.google.android.gms",
        "com.google.android.gsf",
        "com.android.vending",
        "com.google.android.syncadapters.contacts",
        "com.google.android.backuptransport",
        "com.google.android.onetimeinitializer",
        "com.google.android.partnersetup",
        "com.google.android.configupdater",
        "com.google.android.ext.shared",
        "com.google.android.printservice.recommendation"};

    @Override
    public void init() {
        super.init();
    }

    @Override
    public Class<?> customQSFactory() {
        return findClassIfExists(mQSFactoryClsName);
    }

    @Override
    public Class<?> customClass() {
        return findClassIfExists("com.android.systemui.qs.tiles.ScreenLockTile");
    }

    @Override
    public String[] customTileProvider() {
        String[] TileProvider = new String[2];
        TileProvider[0] = "screenLockTileProvider";
        TileProvider[1] = isMoreAndroidVersion(Build.VERSION_CODES.TIRAMISU) ? "createTileInternal" : "interceptCreateTile";
        return TileProvider;
    }

    @Override
    public String customName() {
        return "custom_GMS";
    }

    @Override
    public int customValue() {
        return R.string.security_center_gms_open;
    }

    @Override
    public void tileCheck(MethodHookParam param, String tileName) {
        Context mContext = (Context) XposedHelpers.getObjectField(param.thisObject, "mContext");
        PackageManager packageManager = mContext.getPackageManager();
        try {
            packageManager.getPackageInfo(CheckGms, PackageManager.GET_ACTIVITIES);
            param.setResult(true);
        } catch (PackageManager.NameNotFoundException e) {
            logI("Not Find GMS App");
            param.setResult(false);
        }
    }

    @Override
    public Intent tileHandleLongClick(MethodHookParam param, String tileName) {
        // 长按跳转谷歌基础服务页面
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.googlebase.ui.GmsCoreSettings"));
        return intent;
    }

    @Override
    public void tileClick(MethodHookParam param, String tileName) {
        Context mContext = (Context) XposedHelpers.getObjectField(param.thisObject, "mContext");
        PackageManager packageManager = mContext.getPackageManager();
        int End = packageManager.getApplicationEnabledSetting(CheckGms);
        if (End == PackageManager.COMPONENT_ENABLED_STATE_DISABLED) {
            for (String GmsAppsSystem : GmsAppsSystem) {
                try {
                    packageManager.getPackageInfo(GmsAppsSystem, PackageManager.GET_ACTIVITIES);
                    packageManager.setApplicationEnabledSetting(GmsAppsSystem, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, 0);
                    logI("To Enabled Gms App:" + GmsAppsSystem);
                } catch (PackageManager.NameNotFoundException e) {
                    logI("Don't have Gms app :" + GmsAppsSystem);
                }
            }
            XposedHelpers.callMethod(param.thisObject, "refreshState");
        } else if (End == PackageManager.COMPONENT_ENABLED_STATE_ENABLED || End == PackageManager.COMPONENT_ENABLED_STATE_DEFAULT) {
            for (String GmsAppsSystem : GmsAppsSystem) {
                try {
                    packageManager.getPackageInfo(GmsAppsSystem, PackageManager.GET_ACTIVITIES);
                    packageManager.setApplicationEnabledSetting(GmsAppsSystem, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, 0);
                    logI("To Disabled Gms App:" + GmsAppsSystem);
                } catch (PackageManager.NameNotFoundException e) {
                    logI("Don't have Gms app :" + GmsAppsSystem);
                }
            }
            XposedHelpers.callMethod(param.thisObject, "refreshState");
        }

    }

    @Override
    public ArrayMap<String, Integer> tileUpdateState(MethodHookParam param, Class<?> mResourceIcon, String tileName) {
        boolean isEnable;
        Context mContext = (Context) XposedHelpers.getObjectField(param.thisObject, "mContext");
        PackageManager packageManager = mContext.getPackageManager();
        int End = packageManager.getApplicationEnabledSetting(CheckGms);
        isEnable = End == PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
        ArrayMap<String, Integer> tileResMap = new ArrayMap<>();
        tileResMap.put("custom_GMS_Enable", isEnable ? 1 : 0);
        tileResMap.put("custom_GMS_ON", mResHook.addResource("ic_control_center_gms_toggle_on", R.drawable.ic_control_center_gms_toggle_on));
        tileResMap.put("custom_GMS_OFF", mResHook.addResource("ic_control_center_gms_toggle_off", R.drawable.ic_control_center_gms_toggle_off));
        return tileResMap;
    }
}
