package rabbit.com.br.producer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static rabbit.com.br.producer.Configs.RabbitMQConfig.EXG_MARKET_PLACE;
import static rabbit.com.br.producer.Configs.RabbitMQConfig.RK_PRODUCT_LOG;

@Log4j2
@Service
@RequiredArgsConstructor
public class StringService {

    private final RabbitTemplate rabbitTemplate;

    public void produce(String message){
        log.info("Received Message " + message);
        rabbitTemplate.convertAndSend(EXG_MARKET_PLACE, RK_PRODUCT_LOG, message);
    }


}
