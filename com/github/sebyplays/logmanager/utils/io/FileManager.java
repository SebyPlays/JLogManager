package com.github.sebyplays.logmanager.utils.io;

import com.github.sebyplays.logmanager.api.LogManager;
import com.github.sebyplays.logmanager.api.LogType;
import com.github.sebyplays.logmanager.utils.DateUtil;

import java.io.*;
import java.util.Scanner;

public class FileManager {

    public File getFile(String name){
        DateUtil dateUtil = new DateUtil();
        File file = new File(System.getProperty("user.dir") + "/logs/", name + "-" + dateUtil.getDate()  + ".log");
        return file;
    }

    public String initLogFile(String logName) throws IOException{
        File file = getFile(logName);
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        if (!file.exists()){
            file.createNewFile();
            return logName;
        }

        int suffix = 0;
        while (file.exists()) {
            suffix++;
            file = getFile(logName + "_" + suffix);
        }
        file.createNewFile();
        LogManager.getLogManager(logName).log(LogType.INFORMATION, logName.toUpperCase() + "-LOG initialized..", false, false, true, true);
        return logName + "_" + suffix;
    }

    public void log(String logName, String message) throws IOException{
        File file = getFile(logName);
        String messageLine = "";
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) messageLine += scanner.nextLine() + "\n";
        FileWriter writer = new FileWriter(file);
        writer.write(messageLine + message);
        writer.close();
    }


}
