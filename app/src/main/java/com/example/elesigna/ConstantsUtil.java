package com.example.elesigna;

import android.content.Context;

import java.io.File;

public class ConstantsUtil {

    // 图片存储的地址
    public static String IMG_FOLDER_PATH = FilePath.PATH_APP_STORAGE_BASE + "imgOnline/";

    /**
     * 各种文件路径
     */
    public static class FilePath {

        public static FilePath instance;
        /**
         * 应用的 文件根目录
         */
        public static String PATH_APP_STORAGE_BASE;


        public static FilePath getInstance(Context context) {
            if (instance == null) {
                instance = new FilePath();
                if (CommonUtil.checkSDCard()) {
                    PATH_APP_STORAGE_BASE = CommonUtil.getDBAbsolutePath(context) + "/signOnline/";
                } else {
                    String path = "/mnt/sdcard2/";
                    File file = new File(path);
                    if (!file.exists()) {
                        path = "/mnt/sdcard/";
                    }
                    PATH_APP_STORAGE_BASE = path + "/signOnline/";
                }
                CommonUtil.createFolder(ConstantsUtil.FilePath.PATH_APP_STORAGE_BASE);
            }
            return instance;
        }
    }

}
