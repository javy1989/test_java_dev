package com.rbravo.ms_account.messaging.listener;

import com.rbravo.ms_account.messaging.model.ClientCreateMessage;
import com.rbravo.ms_account.model.dto.AccountDTO;
import com.rbravo.ms_account.model.enums.AccountTypeEnum;
import com.rbravo.ms_account.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Class that producer client creation messages
 *
 * @author rbravo
 */
@Service
public class ClientCreateListener {

    private static final Logger log = LoggerFactory.getLogger(ClientCreateListener.class);

    private final IAccountService accountService;

    public ClientCreateListener(IAccountService accountService) {
        this.accountService = accountService;
    }

    @RabbitListener(queues = "${app.rabbit.client.created-queue}")
    public void handleCreateAccount(ClientCreateMessage clientCreateMessage) {
        log.info("Reception create account client event: {}", clientCreateMessage);
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setClientId(clientCreateMessage.getClientId());
        accountDTO.setStatus(true);
        accountDTO.setBalance(BigDecimal.ZERO);
        accountDTO.setAccountType(AccountTypeEnum.SAVINGS);
        accountService.create(accountDTO);
    }
}
