package com.sevtinge.cemiuiler.module.app;

import static com.sevtinge.cemiuiler.utils.api.VoyagerApisKt.isPad;
import static com.sevtinge.cemiuiler.utils.devicesdk.SystemSDKKt.isAndroidR;

import com.sevtinge.cemiuiler.module.base.BaseModule;
import com.sevtinge.cemiuiler.module.hook.home.AllAppsBlur;
import com.sevtinge.cemiuiler.module.hook.home.AnimDurationRatio;
import com.sevtinge.cemiuiler.module.hook.home.FreeFormCountForHome;
import com.sevtinge.cemiuiler.module.hook.home.HideNavigationBar;
import com.sevtinge.cemiuiler.module.hook.home.HomeDexKit;
import com.sevtinge.cemiuiler.module.hook.home.HomePortraitReverse;
import com.sevtinge.cemiuiler.module.hook.home.MaxFreeForm;
import com.sevtinge.cemiuiler.module.hook.home.ScreenSwipe;
import com.sevtinge.cemiuiler.module.hook.home.SeekPoints;
import com.sevtinge.cemiuiler.module.hook.home.SetDeviceLevel;
import com.sevtinge.cemiuiler.module.hook.home.StickyFloatingWindowsForHome;
import com.sevtinge.cemiuiler.module.hook.home.ToastSlideAgain;
import com.sevtinge.cemiuiler.module.hook.home.UnlockHotseatIcon;
import com.sevtinge.cemiuiler.module.hook.home.UserPresentAnimation;
import com.sevtinge.cemiuiler.module.hook.home.WidgetCornerRadius;
import com.sevtinge.cemiuiler.module.hook.home.WidgetCrack;
import com.sevtinge.cemiuiler.module.hook.home.dock.DisableRecentsIcon;
import com.sevtinge.cemiuiler.module.hook.home.dock.DockCustom;
import com.sevtinge.cemiuiler.module.hook.home.dock.FoldDeviceDock;
import com.sevtinge.cemiuiler.module.hook.home.dock.FoldDock;
import com.sevtinge.cemiuiler.module.hook.home.dock.HideSeekPoint;
import com.sevtinge.cemiuiler.module.hook.home.dock.ShowDockIconTitle;
import com.sevtinge.cemiuiler.module.hook.home.drawer.AllAppsContainerViewBlur;
import com.sevtinge.cemiuiler.module.hook.home.drawer.AppDrawer;
import com.sevtinge.cemiuiler.module.hook.home.folder.BigFolderIcon;
import com.sevtinge.cemiuiler.module.hook.home.folder.BigFolderIconBlur;
import com.sevtinge.cemiuiler.module.hook.home.folder.BigFolderIconBlur1x2;
import com.sevtinge.cemiuiler.module.hook.home.folder.BigFolderIconBlur2x1;
import com.sevtinge.cemiuiler.module.hook.home.folder.BigFolderItemMaxCount;
import com.sevtinge.cemiuiler.module.hook.home.folder.FolderAnimation;
import com.sevtinge.cemiuiler.module.hook.home.folder.FolderAutoClose;
import com.sevtinge.cemiuiler.module.hook.home.folder.FolderBlur;
import com.sevtinge.cemiuiler.module.hook.home.folder.FolderColumns;
import com.sevtinge.cemiuiler.module.hook.home.folder.FolderShade;
import com.sevtinge.cemiuiler.module.hook.home.folder.FolderVerticalPadding;
import com.sevtinge.cemiuiler.module.hook.home.folder.SmallFolderIconBlur;
import com.sevtinge.cemiuiler.module.hook.home.gesture.DoubleTap;
import com.sevtinge.cemiuiler.module.hook.home.gesture.HotSeatSwipe;
import com.sevtinge.cemiuiler.module.hook.home.gesture.ShakeDevice;
import com.sevtinge.cemiuiler.module.hook.home.layout.HotSeatsHeight;
import com.sevtinge.cemiuiler.module.hook.home.layout.HotSeatsMarginBottom;
import com.sevtinge.cemiuiler.module.hook.home.layout.HotSeatsMarginTop;
import com.sevtinge.cemiuiler.module.hook.home.layout.SearchBarMarginBottom;
import com.sevtinge.cemiuiler.module.hook.home.layout.UnlockGrids;
import com.sevtinge.cemiuiler.module.hook.home.layout.WorkspacePadding;
import com.sevtinge.cemiuiler.module.hook.home.mipad.EnableHideGestureLine;
import com.sevtinge.cemiuiler.module.hook.home.mipad.EnableMoreSetting;
import com.sevtinge.cemiuiler.module.hook.home.navigation.BackGestureAreaHeight;
import com.sevtinge.cemiuiler.module.hook.home.navigation.BackGestureAreaWidth;
import com.sevtinge.cemiuiler.module.hook.home.other.AlwaysBlurWallpaper;
import com.sevtinge.cemiuiler.module.hook.home.other.AlwaysShowStatusClock;
import com.sevtinge.cemiuiler.module.hook.home.other.BlurRadius;
import com.sevtinge.cemiuiler.module.hook.home.other.BlurWhenShowShortcutMenu;
import com.sevtinge.cemiuiler.module.hook.home.other.DisableHideGoogle;
import com.sevtinge.cemiuiler.module.hook.home.other.FixAndroidRS;
import com.sevtinge.cemiuiler.module.hook.home.other.FreeformShortcutMenu;
import com.sevtinge.cemiuiler.module.hook.home.other.HomeMode;
import com.sevtinge.cemiuiler.module.hook.home.other.InfiniteScroll;
import com.sevtinge.cemiuiler.module.hook.home.other.OverlapMode;
import com.sevtinge.cemiuiler.module.hook.home.other.ShortcutItemCount;
import com.sevtinge.cemiuiler.module.hook.home.other.ShowAllHideApp;
import com.sevtinge.cemiuiler.module.hook.home.recent.AlwaysShowCleanUp;
import com.sevtinge.cemiuiler.module.hook.home.recent.BlurLevel;
import com.sevtinge.cemiuiler.module.hook.home.recent.CardTextColor;
import com.sevtinge.cemiuiler.module.hook.home.recent.CardTextSize;
import com.sevtinge.cemiuiler.module.hook.home.recent.DisableRecentViewWallpaperDarken;
import com.sevtinge.cemiuiler.module.hook.home.recent.FreeformCardBackgroundColor;
import com.sevtinge.cemiuiler.module.hook.home.recent.HideCleanUp;
import com.sevtinge.cemiuiler.module.hook.home.recent.HideFreeform;
import com.sevtinge.cemiuiler.module.hook.home.recent.HideStatusBarWhenEnterRecent;
import com.sevtinge.cemiuiler.module.hook.home.recent.MemInfoShow;
import com.sevtinge.cemiuiler.module.hook.home.recent.RealMemory;
import com.sevtinge.cemiuiler.module.hook.home.recent.RecentResource;
import com.sevtinge.cemiuiler.module.hook.home.recent.RecentText;
import com.sevtinge.cemiuiler.module.hook.home.recent.RemoveCardAnim;
import com.sevtinge.cemiuiler.module.hook.home.recent.RemoveIcon;
import com.sevtinge.cemiuiler.module.hook.home.recent.TaskViewHorizontal;
import com.sevtinge.cemiuiler.module.hook.home.recent.TaskViewVertical;
import com.sevtinge.cemiuiler.module.hook.home.title.BigIconCorner;
import com.sevtinge.cemiuiler.module.hook.home.title.DisableHideFile;
import com.sevtinge.cemiuiler.module.hook.home.title.DisableHideTheme;
import com.sevtinge.cemiuiler.module.hook.home.title.DownloadAnimation;
import com.sevtinge.cemiuiler.module.hook.home.title.EnableIconMonoChrome;
import com.sevtinge.cemiuiler.module.hook.home.title.FixAnimation;
import com.sevtinge.cemiuiler.module.hook.home.title.IconTitleColor;
import com.sevtinge.cemiuiler.module.hook.home.title.LargeIconCornerRadius;
import com.sevtinge.cemiuiler.module.hook.home.title.NewInstallIndicator;
import com.sevtinge.cemiuiler.module.hook.home.title.PerfectIcon;
import com.sevtinge.cemiuiler.module.hook.home.title.TitleFontSize;
import com.sevtinge.cemiuiler.module.hook.home.title.TitleMarquee;
import com.sevtinge.cemiuiler.module.hook.home.widget.AllWidgetAnimation;
import com.sevtinge.cemiuiler.module.hook.home.widget.AllowMoveAllWidgetToMinus;
import com.sevtinge.cemiuiler.module.hook.home.widget.AlwaysShowMiuiWidget;
import com.sevtinge.cemiuiler.module.hook.home.widget.HideWidgetTitles;
import com.sevtinge.cemiuiler.module.hook.home.widget.ResizableWidgets;
import com.sevtinge.cemiuiler.module.hook.systemframework.mipad.SetGestureNeedFingerNum;

import java.util.Objects;

public class Home extends BaseModule {

    @Override
    public void handleLoadPackage() {
        // Dexkit
        initHook(new HomeDexKit());

        // 手势
        initHook(new DoubleTap(), mPrefsMap.getInt("home_gesture_double_tap_action", 0) > 0);
        initHook(new ScreenSwipe(), mPrefsMap.getInt("home_gesture_up_swipe_action", 0) > 0 ||
            mPrefsMap.getInt("home_gesture_down_swipe_action", 0) > 0 ||
            mPrefsMap.getInt("home_gesture_up_swipe2_action", 0) > 0 ||
            mPrefsMap.getInt("home_gesture_down_swipe2_action", 0) > 0);
        initHook(new HotSeatSwipe(), mPrefsMap.getInt("home_gesture_left_swipe_action", 0) > 0
            || mPrefsMap.getInt("home_gesture_right_swipe_action", 0) > 0);
        initHook(new ShakeDevice(), mPrefsMap.getInt("home_gesture_shake_action", 0) > 0);
        // initHook(new SwipeAndStop(), mPrefsMap.getInt("home_gesture_swipe_and_stop_action" ,0) > 0);

        initHook(new BackGestureAreaHeight(), mPrefsMap.getInt("home_navigation_back_area_height", 60) != 60);
        initHook(new BackGestureAreaWidth(), mPrefsMap.getInt("home_navigation_back_area_width", 100) != 100);

        // 布局
        initHook(new UnlockGrids(), mPrefsMap.getBoolean("home_layout_unlock_grids"));
        // initHook(new UnlockGridsNoWord(), mPrefsMap.getBoolean("home_layout_unlock_grids_no_word"));
        initHook(new WorkspacePadding(), mPrefsMap.getBoolean("home_layout_workspace_padding_bottom_enable") ||
            mPrefsMap.getBoolean("home_layout_workspace_padding_top_enable"));

        initHook(new HotSeatsHeight(), mPrefsMap.getBoolean("home_layout_hotseats_height_enable"));
        initHook(new HotSeatsMarginTop(), mPrefsMap.getBoolean("home_layout_hotseats_margin_top_enable"));
        initHook(new HotSeatsMarginBottom(), mPrefsMap.getBoolean("home_layout_hotseats_margin_bottom_enable"));
        initHook(new SearchBarMarginBottom(), (mPrefsMap.getInt("home_layout_searchbar_margin_bottom", 0) > 0) &&
            mPrefsMap.getBoolean("home_layout_searchbar_margin_bottom_enable"));


        // 文件夹
        initHook(FolderAutoClose.INSTANCE, mPrefsMap.getBoolean("home_folder_auto_close"));
        initHook(new FolderShade(), mPrefsMap.getStringAsInt("home_folder_shade", 1) > 0);
        initHook(FolderColumns.INSTANCE, mPrefsMap.getInt("home_folder_columns", 3) != 3 ||
            mPrefsMap.getBoolean("home_folder_width"));
        initHook(new FolderAnimation(), mPrefsMap.getBoolean("home_folder_animation"));
        initHook(new SmallFolderIconBlur(), mPrefsMap.getBoolean("home_small_folder_icon_bg"));
        initHook(FolderVerticalPadding.INSTANCE, mPrefsMap.getInt("home_folder_vertical_padding", 0) != 0);

        initHook(new BigFolderIcon(), false);
        initHook(new BigFolderIconBlur2x1(), mPrefsMap.getBoolean("home_big_folder_icon_bg_2x1"));
        initHook(new BigFolderIconBlur1x2(), mPrefsMap.getBoolean("home_big_folder_icon_bg_1x2"));
        initHook(new BigFolderIconBlur(), mPrefsMap.getBoolean("home_big_folder_icon_bg"));
        initHook(new BigFolderItemMaxCount(), mPrefsMap.getBoolean("home_big_folder_item_max_count"));

        // 抽屉
        initHook(AppDrawer.INSTANCE, mPrefsMap.getBoolean("home_drawer_all") ||
            mPrefsMap.getBoolean("home_drawer_editor"));
        initHook(AllAppsContainerViewBlur.INSTANCE, mPrefsMap.getBoolean("home_drawer_blur") && !isAndroidR());

        // 最近任务
        initHook(BlurLevel.INSTANCE, mPrefsMap.getStringAsInt("home_recent_blur_level", 6) != 6);
        initHook(DisableRecentViewWallpaperDarken.INSTANCE, mPrefsMap.getBoolean("home_recent_disable_wallpaper_dimming"));
        initHook(HideStatusBarWhenEnterRecent.INSTANCE, true);
        initHook(RemoveCardAnim.INSTANCE, mPrefsMap.getBoolean("home_recent_modify_animation"));
        initHook(TaskViewHorizontal.INSTANCE);
        initHook(TaskViewVertical.INSTANCE);
        initHook(HideFreeform.INSTANCE, mPrefsMap.getBoolean("home_recent_hide_freeform"));
        initHook(HideCleanUp.INSTANCE, mPrefsMap.getBoolean("home_recent_hide_clean_up"));
        initHook(FreeformCardBackgroundColor.INSTANCE);
        initHook(CardTextColor.INSTANCE);
        initHook(CardTextSize.INSTANCE);
        initHook(RecentText.INSTANCE, !Objects.equals(mPrefsMap.getString("home_recent_text", ""), ""));
        initHook(RemoveIcon.INSTANCE, mPrefsMap.getBoolean("home_recent_remove_icon"));
        initHook(RecentResource.INSTANCE, mPrefsMap.getInt("task_view_corners", 20) != 20 ||
            mPrefsMap.getInt("task_view_header_height", 40) != 40);
        initHook(RealMemory.INSTANCE, mPrefsMap.getBoolean("home_recent_show_real_memory"));
        initHook(MemInfoShow.INSTANCE, mPrefsMap.getBoolean("home_recent_show_memory_info") && isPad());
        initHook(AlwaysShowCleanUp.INSTANCE, mPrefsMap.getBoolean("always_show_clean_up"));

        // 图标
        initHook(BigIconCorner.INSTANCE, mPrefsMap.getBoolean("home_title_big_icon_corner"));
        initHook(new DownloadAnimation(), mPrefsMap.getBoolean("home_title_download_animation"));
        initHook(DisableHideTheme.INSTANCE, mPrefsMap.getBoolean("home_title_disable_hide_theme"));
        initHook(DisableHideFile.INSTANCE, mPrefsMap.getBoolean("home_title_disable_hide_file"));
        // initHook(new IconScaleHook()/*, mPrefsMap.getInt("home_title_icon_scale", 100) != 100*/);

        // 标题
        initHook(new TitleMarquee(), mPrefsMap.getBoolean("home_title_title_marquee"));
        initHook(new NewInstallIndicator(), mPrefsMap.getBoolean("home_title_title_new_install"));
        initHook(new TitleFontSize(), mPrefsMap.getInt("home_title_font_size", 12) != 12);
        initHook(IconTitleColor.INSTANCE);
        initHook(new UnlockHotseatIcon(), mPrefsMap.getBoolean("home_dock_unlock_hotseat"));

        // 小部件
        initHook(new AllWidgetAnimation(), mPrefsMap.getBoolean("home_widget_all_widget_animation"));
        initHook(AlwaysShowMiuiWidget.INSTANCE, mPrefsMap.getBoolean("home_widget_show_miui_widget"));
        initHook(AllowMoveAllWidgetToMinus.INSTANCE, mPrefsMap.getBoolean("home_widget_allow_moved_to_minus_one_screen"));
        initHook(new WidgetCornerRadius(), mPrefsMap.getInt("home_widget_corner_radius", 0) > 0);
        initHook(HideWidgetTitles.INSTANCE, mPrefsMap.getBoolean("home_widget_hide_title"));
        initHook(ResizableWidgets.INSTANCE, mPrefsMap.getBoolean("home_widget_resizable"));

        // 底栏
        initHook(new DockCustom(), mPrefsMap.getBoolean("home_dock_bg_custom_enable"));
        initHook(new SeekPoints(), mPrefsMap.getStringAsInt("home_other_seek_points", 0) > 0);
        initHook(FoldDeviceDock.INSTANCE, mPrefsMap.getBoolean("home_dock_fold"));
        initHook(HideSeekPoint.INSTANCE, mPrefsMap.getBoolean("home_dock_hide_seekpoint"));
        initHook(ShowDockIconTitle.INSTANCE, mPrefsMap.getBoolean("home_dock_icon_title"));
        initHook(new HideNavigationBar(), mPrefsMap.getBoolean("system_ui_hide_navigation_bar"));
        initHook(DisableRecentsIcon.INSTANCE, mPrefsMap.getBoolean("home_dock_disable_recents_icon"));

        // 其他
        initHook(new HomeMode(), mPrefsMap.getStringAsInt("home_other_home_mode", 0) > 0);
        initHook(AlwaysShowStatusClock.INSTANCE, mPrefsMap.getBoolean("home_other_show_clock"));
        initHook(new InfiniteScroll(), mPrefsMap.getBoolean("home_other_infinite_scroll"));
        initHook(new FreeformShortcutMenu(), (mPrefsMap.getBoolean("home_other_freeform_shortcut_menu") || (mPrefsMap.getBoolean("home_other_tasks_shortcut_menu"))));
        initHook(new UserPresentAnimation(), mPrefsMap.getBoolean("home_other_user_present_animation"));
        initHook(new PerfectIcon(), mPrefsMap.getBoolean("home_other_perfect_icon"));
        initHook(new EnableIconMonoChrome(), mPrefsMap.getBoolean("home_other_icon_mono_chrome"));
        initHook(new HomePortraitReverse(), mPrefsMap.getBoolean("home_other_portrait_reverse"));
        initHook(AlwaysBlurWallpaper.INSTANCE, mPrefsMap.getBoolean("home_other_always_blur_launcher_wallpaper"));
        initHook(BlurRadius.INSTANCE, mPrefsMap.getInt("home_other_blur_radius", 100) != 100);
        initHook(ShortcutItemCount.INSTANCE, mPrefsMap.getBoolean("home_other_shortcut_remove_restrictions"));
        initHook(DisableHideGoogle.INSTANCE, mPrefsMap.getBoolean("home_other_disable_hide_google"));
        initHook(ShowAllHideApp.INSTANCE); // 桌面快捷方式管理
        initHook(FixAndroidRS.INSTANCE, mPrefsMap.getBoolean("home_other_fix_android_r_s"));

        // 实验性功能
        initHook(BlurWhenShowShortcutMenu.INSTANCE, mPrefsMap.getBoolean("home_other_shortcut_background_blur"));
        initHook(FolderBlur.INSTANCE, mPrefsMap.getBoolean("home_folder_blur") && !isAndroidR());
        initHook(new FoldDock(), mPrefsMap.getBoolean("home_other_fold_dock"));
        initHook(new AllAppsBlur(), true);
        initHook(new FixAnimation(), mPrefsMap.getBoolean("home_title_fix_animation"));
        initHook(new LargeIconCornerRadius(), mPrefsMap.getBoolean("home_large_icon_enable"));

        // 多小窗
        initHook(new FreeFormCountForHome(), mPrefsMap.getBoolean("system_framework_freeform_count"));
        initHook(new MaxFreeForm(), mPrefsMap.getBoolean("system_framework_freeform_count"));

        // Fold2样式负一屏
        initHook(new OverlapMode(), mPrefsMap.getBoolean("personal_assistant_overlap_mode"));

        // Other
        initHook(new ToastSlideAgain(), mPrefsMap.getBoolean("home_other_toast_slide_again"));
        initHook(new StickyFloatingWindowsForHome(), mPrefsMap.getBoolean("system_framework_freeform_sticky"));
        initHook(new WidgetCrack(), mPrefsMap.getBoolean("enable_hidden_function") && mPrefsMap.getBoolean("personal_assistant_widget_crack"));
        initHook(AnimDurationRatio.INSTANCE, true);
        initHook(SetDeviceLevel.INSTANCE, mPrefsMap.getBoolean("home_other_high_models"));

        // 小米/红米平板相关
        boolean mMoreSetting = mPrefsMap.getBoolean("home_other_mi_pad_enable_more_setting") && isPad();
        initHook(SetGestureNeedFingerNum.INSTANCE, mPrefsMap.getBoolean("mipad_input_need_finger_num") && isPad());
        initHook(EnableMoreSetting.INSTANCE, mMoreSetting);
        initHook(EnableHideGestureLine.INSTANCE, mMoreSetting);

    }

}
