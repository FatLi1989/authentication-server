package novli.auth.authentication.app.support;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimpleResponse<T> {

    public T data;

    public SimpleResponse(T data) {
        this.data = data;
    }
}
