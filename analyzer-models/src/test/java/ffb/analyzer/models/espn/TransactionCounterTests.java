package ffb.analyzer.models.espn;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ffb.test.utilities.GenericTestUtils;

public class TransactionCounterTests extends BaseSerializationTests {
    private static final int EXPECTED_ACQUISITION_COUNT = 18;
    private static final int EXPECTED_DROP_COUNT = 17;

    private static ObjectMapper MAPPER;

    @BeforeClass
    public static void buildPrep() {
        MAPPER  = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        MAPPER.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    }

    @Override
    public void testSerialization() throws JsonProcessingException {
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

    @Override
    public void testDeserialization() throws IOException {
        List<TransactionCounter> transactionCounters = deserializeObjects(TransactionCounter.class);

        Assert.assertEquals(EXPECTED_ACQUISITION_COUNT, transactionCounters.get(0).getCountOfWaiverAcquisitions());
        Assert.assertEquals(EXPECTED_DROP_COUNT, transactionCounters.get(0).getCountOfDroppedPlayers());
        Assert.assertFalse(transactionCounters.get(0).getAcquisitionsByScoringPeriod().isEmpty());

        GenericTestUtils.validateGetMethodsReturnNonNullValue(transactionCounters);
    }

    @Override
    protected String getResourceFileName() {
        return "transaction-counter.json";
    }

    @Override
    protected Class<?> getClassUnderTesting() {
        return TransactionCounter.class;
    }
}
