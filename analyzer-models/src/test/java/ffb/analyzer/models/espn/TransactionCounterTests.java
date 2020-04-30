package ffb.analyzer.models.espn;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ffb.test.utilities.GenericTestUtils;

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
        transactionCounter.setCountOfPlayerMovesToActiveRoster(42);
        transactionCounter.setCountOfPlayerMovesToIR(2);
        transactionCounter.setCountOfDroppedPlayers(8);
        transactionCounter.setCountOfWaiverAcquisitions(11);

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

        Assert.assertEquals(EXPECTED_ACQUISITION_COUNT, transactionCounters.get(0).getCountOfWaiverAcquisitions());
        Assert.assertEquals(EXPECTED_DROP_COUNT, transactionCounters.get(0).getCountOfDroppedPlayers());
        Assert.assertFalse(transactionCounters.get(0).getAcquisitionsByScoringPeriod().isEmpty());

        GenericTestUtils.validateGetMethodsReturnNonNullValue(transactionCounters);
    }
}
