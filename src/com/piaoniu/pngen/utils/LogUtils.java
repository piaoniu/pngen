package com.piaoniu.pngen.utils;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;

/**
 * @author code4crafter@gmail.com
 *         Date: 16/7/28
 *         Time: 下午6:25
 */
public class LogUtils {

	public static void showError(String content) {
		Notifications.Bus.notify(new Notification("pngen", "pngen", content, NotificationType.ERROR));
	}

	public static void showInfo(String content) {
		Notifications.Bus.notify(new Notification("pngen", "pngen", content, NotificationType.INFORMATION));
	}
}
