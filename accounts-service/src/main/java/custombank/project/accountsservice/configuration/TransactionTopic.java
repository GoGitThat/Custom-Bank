package custombank.project.accountsservice.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TransactionTopic {

    @Bean
    public NewTopic createTransactionTopic() {
        return TopicBuilder.name("Transactions").replicas(1).compact().build();
    }
}
