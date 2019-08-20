package novli.auth.authentication.core.model;

import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;

/**
 * @author novLi
 * @date 2019年08月13日 12:25
 */
public class ImageCode extends ValidateCode {

    @Setter
    @Getter
    public BufferedImage bufferedImage;

    public ImageCode(BufferedImage bufferedImage, String code, int expireTime) {
        super(code, expireTime);
        this.bufferedImage = bufferedImage;
    }


}
