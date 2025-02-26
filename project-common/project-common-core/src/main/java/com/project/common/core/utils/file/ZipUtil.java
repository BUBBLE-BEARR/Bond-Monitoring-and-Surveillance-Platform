package com.project.common.core.utils.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    private static final Logger log = LoggerFactory.getLogger(ZipUtil.class);

    /**
     * 设置返回前端文件名
     * @param response response
     * @param fileName 文件名,包含后缀
     * @return OutputStream
     * @throws Exception Exception
     */
    public static OutputStream getOutputStreamFileName(HttpServletResponse response, String fileName) throws Exception{
        response.reset();
        String fileType = fileName.split("\\.")[1].toLowerCase();
        switch (fileType){
            case "doc":
                response.setContentType("application/msword");//设置生成的文件类型
                break;
            case "docx":
                response.setContentType("application/msword");//设置生成的文件类型
                break;
            case "xls":
                response.setContentType("application/vnd.ms-excel");//设置生成的文件类型
                break;
            case "xlsx":
                response.setContentType("application/vnd.ms-excel");//设置生成的文件类型
                break;
            case "pdf":
                response.setContentType("application/pdf");//设置生成的文件类型
                break;
            case "zip":
                response.setContentType("application/zip");//设置生成的文件类型
                break;
            case "dbf":
                response.setContentType("application/x-dbf");//设置生成的文件类型
                break;
            default:
                return response.getOutputStream();
        }
        response.setCharacterEncoding("UTF-8");//设置文件头编码方式和文件名
        response.setHeader("Content-Disposition", "attachment;filename=" +
                new String(URLEncoder.encode(fileName, "UTF-8").getBytes("utf-8"), "ISO8859-1"));
        return response.getOutputStream();
    }

    /**
     * 压缩文件
     * @param response response
     * @param filePath 文件路径
     * @param fileName 压缩生成文件名
     * @throws IOException IOException
     */
    public static void zipDateFile(HttpServletResponse response, String filePath, String fileName) throws Exception {
        if (StringUtils.isEmpty(filePath) || !new File(filePath).exists()) return;
        zipDateFile(response, getAllFile(filePath), fileName, true);
    }




    /**
     * 压缩文件
     * @param response response
     * @param fileList 文件集合
     * @param fileName 压缩生成文件名
     * @throws IOException IOException
     */
    public static void zipDateFile(HttpServletResponse response, List<File> fileList, String fileName, boolean deleteSourceFile) throws Exception {
        getOutputStreamFileName(response, fileName);
        ServletOutputStream servletOutputStream = response.getOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(servletOutputStream);
        zipFile(fileList, zipOutputStream, deleteSourceFile);
        try {
            zipOutputStream.close();
        } catch (IOException e) {
            log.error("流关闭失败", e);
        }
    }

    /**
     * 压缩导出
     * @param fileList 文件列表
     * @param zipOutputStream zip流
     * @throws IOException IOException
     */
    public static void zipFile(List<File> fileList, ZipOutputStream zipOutputStream, boolean deleteSourceFile) throws IOException {
        byte[] buffer = new byte[1024];
        for (File file : fileList) {
            if (file.exists()) {
                if (file.isFile()) {
                    try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
                        zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                        int size = 0;
                        while ((size = bis.read(buffer)) > 0) {
                            zipOutputStream.write(buffer, 0, size);
                        }
                        zipOutputStream.closeEntry();
                    } finally {
                        if(deleteSourceFile) file.delete();
                    }
                } else {
                    File[] files = file.listFiles();
                    if(null == files) continue;
                    List<File> childrenFileList = Arrays.asList(files);
                    zipFile(childrenFileList, zipOutputStream, deleteSourceFile);
                }
            }
        }
    }

    /**
     * 获取指定文件夹下所有文件，不含文件夹里的文件
     * @param filePath 文件路径
     * @return fileList
     */
    public static List<File> getAllFile(String filePath) {
        if (StringUtils.isEmpty(filePath)) return null;
        return getAllFile(new File(filePath));
    }

    /**
     * 获取指定文件夹下所有文件，不含文件夹里的文件
     * @param dirFile 文件夹
     * @return fileList
     */
    public static List<File> getAllFile(File dirFile) {
        // 如果文件夹不存在或着不是文件夹，则返回 null
        if (Objects.isNull(dirFile) || !dirFile.exists() || dirFile.isFile()){
            return null;
        }
        File[] childrenFiles = dirFile.listFiles();
        if (Objects.isNull(childrenFiles) || childrenFiles.length == 0){
            return null;
        }
        List<File> files = new ArrayList<>();
        for (File childFile : childrenFiles) {
            // 如果是文件，直接添加到结果集合
            if (childFile.isFile()) {
                files.add(childFile);
            }
            //以下几行代码取消注释后可以将所有子文件夹里的文件也获取到列表里
//            else {
//                // 如果是文件夹，则将其内部文件添加进结果集合
//                List<File> cFiles = getAllFile(childFile);
//                if (Objects.isNull(cFiles) || cFiles.isEmpty()) continue;
//                files.addAll(cFiles);
//            }
        }
        return files;
    }

    public static boolean createFilePath(String path){
        try {
            File filePath = new File(path);
            if (!filePath.exists()) {
                if(!filePath.mkdirs()){
                    return false;
                }
            }
        } catch (Exception e) {
            log.error("服务端创建文件夹出错",e);
            return false;
        }
        return true;
    }

    public static boolean deleteFilePath(File file) {
        if (file.isDirectory()) {
            String[] children = file.list();
            if(null != children && children.length > 0){
                File file1 = null;
                //递归删除目录中的子目录下
                for(String str : children){
                    file1 = new File(file, str);
                    log.info(file1.getPath());
                    deleteFilePath(file1);
                }
            }
        }
        return file.delete();
    }

}

