package ffb.analyzer.models.espn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ffb.test.utilities.GenericTests;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TransactionCounterTests {
    private static final String TRANSACTION_COUNTER = "transaction-counter.json";
    private static final int EXPECTED_ACQUISITION_COUNT = 18;
    private static final int EXPECTED_DROP_COUNT = 17;

    private static ObjectMapper MAPPER;

    @BeforeClass
    public static void buildPrep() {
        MAPPER  = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        MAPPER.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    }

    @Test
    public void testTransactionCounterSerialization() throws JsonProcessingException {
        TransactionCounter transactionCounter = new TransactionCounter();

        transactionCounter.setAcquisitionBudgetSpent(13);
        transactionCounter.setCountOfTrades(13);
        transactionCounter.setCountPlayerMovesToActiveRoster(42);
        transactionCounter.setCountPlayerMovesToIR(2);
        transactionCounter.setDroppedPlayerCount(8);
        transactionCounter.setWaiverAcquisitions(11);

        String json = MAPPER.writeValueAsString(transactionCounter);

        Assert.assertFalse(json.isEmpty());
    }

    @Test
    public void testTransactionCounterDeserialization() throws IOException, InvocationTargetException, IllegalAccessException {

        File file = new File(Objects.requireNonNull(getClass()
                .getClassLoader()
                .getResource(TRANSACTION_COUNTER)
        ).getFile());

        List<TransactionCounter> transactionCounters = MAPPER.readValue(file,
                MAPPER.getTypeFactory().constructCollectionType(List.class, TransactionCounter.class));

        Assert.assertEquals(EXPECTED_ACQUISITION_COUNT, transactionCounters.get(0).getWaiverAcquisitions());
        Assert.assertEquals(EXPECTED_DROP_COUNT, transactionCounters.get(0).getDroppedPlayerCount());
        Assert.assertFalse(transactionCounters.get(0).getAcquisitionsByScoringPeriod().isEmpty());

        GenericTests.validateGetMethodsReturnNonNullValue(transactionCounters);
    }
}
