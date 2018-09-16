package in.hocg.web.constant.http;

/**
 * @author hocgin
 * @date 18-8-20
 **/
public interface AntiReplayConstant {
    String ANTI_REPLAY_PARAMETER_SIGN = "sign";
    String ANTI_REPLAY_PARAMETER_TIMESTAMP = "timestamp";
    String ANTI_REPLAY_PARAMETER_NONCE = "nonce";
    int ANTI_REPLAY_INTERVAL = 60 * 1000;
}
