package BookManageSystem.exception.processor;

import BookManageSystem.pojo.resp.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionProcessor {
    @ExceptionHandler(Exception.class)
    public Result exception(Exception ex) {
        ex.printStackTrace();
        log.warn("违规操作");
        return Result.error("违规操作");
    }
}
