package novli.auth.authentication.core.validate.image;

import lombok.extern.slf4j.Slf4j;
import novli.auth.authentication.core.model.ImageCode;
import novli.auth.authentication.core.validate.AbstractValidateCodeProcessor;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * @author novLi
 * @date 2019年08月14日 12:41
 */
@Slf4j
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

    /**
     * 操作session的工具类
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws IOException {
        log.info("this is image validate");
        ImageIO.write(imageCode.getBufferedImage(), "JPEG", request.getResponse().getOutputStream());
    }

    @Override
    protected void save(ServletWebRequest request, ImageCode validateCode) {
        sessionStrategy.setAttribute(new ServletRequestAttributes(request.getRequest()), SESSION_IMAGE_KEY, validateCode);
    }
}
