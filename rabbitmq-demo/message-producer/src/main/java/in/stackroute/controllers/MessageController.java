package in.stackroute.controllers;

import in.stackroute.dto.MessageDto;
import in.stackroute.dto.ResponseDto;
import in.stackroute.messaging.Receiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/v1/messaging")
public class MessageController {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    @Value("${spring.rabbitmq.template.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.template.routing-key}")
    private String routingkey;

    public MessageController(RabbitTemplate rabbitTemplate, Receiver receiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
    }

    @GetMapping("/send/{name}")
    public ResponseEntity<ResponseDto> send(@PathVariable String name) {
        //var message = String.format("%s has sent a message to RabbitMQ at %s", name, LocalTime.now().toString());
        final var res = new MessageDto(LocalTime.now(),name,HttpStatus.OK.value());
        rabbitTemplate.convertAndSend(exchange, routingkey, res);
        return ResponseEntity.ok(new ResponseDto(HttpStatus.OK, res));
    }
}
