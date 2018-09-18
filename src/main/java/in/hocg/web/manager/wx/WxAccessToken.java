package in.hocg.web.manager.wx;

import in.hocg.web.pojo.domain.Wxer;
import lombok.Data;

/**
 * Created by hocgin on 2018/9/16.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class WxAccessToken {
    
    /**
     * openId : oyRKu4jS6SKlz6wS3mC9zpZk2QXo
     * nickName : hocgin
     * gender : 1
     * language : zh_CN
     * city : Quanzhou
     * province : Fujian
     * country : China
     * avatarUrl : https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83ersiaRwUHJ2w8j1VCWcftKz7R7lUhglUia3e4yCA8AGP2qiaBoFYEtUVOO7ibEndCAlw2tdibsd6TbpiaMg/132
     * watermark : {"timestamp":1537101022,"appid":"wx2465beecc036aa3f"}
     */
    
    private String openId;
    private String nickName;
    private int gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private WatermarkBean watermark;
    
    @Data
    public static class WatermarkBean {
        /**
         * timestamp : 1537101022
         * appid : wx2465beecc036aa3f
         */
        
        private int timestamp;
        private String appid;
    }
    
    
    public Wxer asWxer() {
        Wxer wxer = new Wxer();
        wxer.setOpenId(openId);
        wxer.setNickName(nickName);
        wxer.setGender(gender);
        wxer.setLanguage(language);
        wxer.setCity(city);
        wxer.setProvince(province);
        wxer.setCountry(country);
        wxer.setAvatarUrl(avatarUrl);
        return wxer;
    }
}
