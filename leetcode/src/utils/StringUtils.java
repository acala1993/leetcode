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

    public static String replaceSpecChar(String str, char[] orgs, char[] dests) {
        if (orgs.length != dests.length) return str;
        String ret = null;
        for (int i = 0; i < orgs.length; i++) {
            ret = str.replace(orgs[i], dests[i]);
        }
        return ret;
    }

    /**
     * 把文本设置到剪贴板（复制）
     */
    public static void setClipboardString(String text) {
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 封装文本内容
        Transferable trans = new StringSelection(text);
        // 把文本内容设置到系统剪贴板
        clipboard.setContents(trans, null);
    }

    public static void main(String[] args) {
        while (true) {
            String s = ScannerUtil.readLine();
            if (s.equals("exit"))
                break;
            char[] orgs = {'\"', '\"'};
            char[] dests = {'\'', '\''};
            setClipboardString(replaceSpecChar(s, orgs, dests));
        }
    }
}
