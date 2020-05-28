package utils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class StringUtils {
    public static int[] Strings2Array(String str) {
        String[] strings = str.split(" ");
        int[] ret = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ret[i] = Integer.parseInt(strings[i]);
        }
        return ret;
    }

    public static String replaceSpecSubStr(String origin, String originSubStr, String destSubStr) {
        return origin.replace(originSubStr, destSubStr);
    }

    public static void main(String[] args) {
        String s = ScannerUtil.readLine();
        String originSubStr = ScannerUtil.readLine();
        String destSubStr = ScannerUtil.readLine();
        String replaceSpecSubStr = replaceSpecSubStr(s, originSubStr, destSubStr);
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 封装文本内容
        Transferable trans = new StringSelection(replaceSpecSubStr);
        // 把文本内容设置到系统剪贴板
        clipboard.setContents(trans, null);
    }
}
