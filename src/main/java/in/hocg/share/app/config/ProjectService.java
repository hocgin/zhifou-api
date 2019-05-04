package in.hocg.share.app.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by hocgin on 2019/5/4.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@AllArgsConstructor
public class ProjectService {
    private final static String INFO_FILE_NAME = ".INFO.json";
    
    /**
     * 仅匹配 非.开头并且为.json结尾的文件
     */
    private final static FileFilter JSON_FILE_FILTER = f -> {
        String filename = f.getName();
        return !filename.startsWith(".") && filename.endsWith(".json");
    };
    
    
    /**
     * 以 JSON 格式来输出目录
     *
     * @param path
     * @return
     * @throws JSONException
     */
    public JSONObject traversingDirToJSON(Path path) {
        File file = path.toFile();
        JSONObject dirJSON = getJSONDetail(path);
        File[] files = file.listFiles(JSON_FILE_FILTER);
        JSONArray childrenJSON = new JSONArray();
        for (File f : files) {
            if (f.isDirectory()) {
                childrenJSON.add(traversingDirToJSON(f.toPath()));
                break;
            }
            childrenJSON.fluentAdd(getJSONDetail(f.toPath()));
        }
        return dirJSON.fluentPut("children", childrenJSON);
    }
    
    /**
     * 获取文件的描述内容
     *
     * @param path
     * @return
     */
    public JSONObject getJSONDetail(Path path) {
        File file = path.toFile();
        String id = file.getName();
        boolean isDirectory = file.isDirectory();
        if (isDirectory) {
            path = path.resolve(INFO_FILE_NAME);
        }
        JSONObject json;
        try {
            json = JSONObject.parseObject(new String(Files.readAllBytes(path)));
        } catch (IOException e) {
            json = new JSONObject();
        }
        json.fluentPut("isDirectory", isDirectory);
        json.fluentPut("id", id);
        return json;
    }
    
}
