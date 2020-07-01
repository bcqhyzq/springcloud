package com.bcqh.springcloud8001.comtroller;

import com.bcqh.springcloud8001.service.impl.MessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/7/1
 */
@RestController
public class MessageController {

    @Resource
    private MessageProvider messageProvider;

    @GetMapping("/send")
    public String sendMessage(){
        return messageProvider.send();
    }

}
