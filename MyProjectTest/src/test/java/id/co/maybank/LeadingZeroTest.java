/**
 * 
 */
package id.co.maybank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * The type Leading zero test.
 */
@Slf4j
public class LeadingZeroTest {
	
	private ResponseData data = null;

    /**
     * Populate data.
     */
    @BeforeEach
	void populateData() {
		data = new ResponseData();		
		log.info("Data populated");
	}
	
	private void testWithParam(String accNum) {		
		
		data.setAutodebetaccountnumber(accNum);
		try {
			String trimmed = String.valueOf(Integer.parseInt(data.getAutodebetaccountnumber()));
			log.info("Parse Integer to String: " + trimmed);
			Assert.isTrue (!trimmed.startsWith("0"), "remove leading zero with parse integer failed");

		} catch (NumberFormatException e) {
			log.error("Parse Integer failed");
			Assert.isTrue(e instanceof NumberFormatException, "number format exception");
		}

		try {
			String trimmed = String.valueOf(Long.parseLong(data.getAutodebetaccountnumber()));
			log.info("Parse Long to String: " + trimmed);
			Assert.isTrue (!trimmed.startsWith("0"), "remove leading zero with parse long failed");
		} catch (NumberFormatException e) {
			log.error("Parse Long failed");
			Assert.isTrue(e instanceof NumberFormatException, "number format exception");
		}

		
		data.setTrimValue(data.getAutodebetaccountnumber().replaceFirst("^0+(?!$)", ""));
		log.info("Replace first with Regex: " + data.getTrimValue());
		log.info("Has spaces: "  + (StringUtils.containsWhitespace(data.getTrimValue()) ? "Yes" :"No"));
		Assert.isTrue (!data.getTrimValue().startsWith("0"), "remove leading zero with regex failed");
				
		
		String trimmedWithStringUtils = StringUtils.trimLeadingCharacter(data.getAutodebetaccountnumber(), '0');
		log.info("With Spring string utils: " + trimmedWithStringUtils );
		log.info("Has spaces: "  + (StringUtils.containsWhitespace(trimmedWithStringUtils) ? "Yes" :"No"));
		Assert.isTrue(trimmedWithStringUtils.equals(data.getTrimValue()), "Trim with regex does not match trim with String utils");
		
	}

    /**
     * When string has leading zero too long then replace zero.
     */
    @Test
	void whenStringHasLeadingZeroTooLong_thenReplaceZero() {
		String methodName = new Object() {}
	      .getClass()
	      .getEnclosingMethod()
	      .getName();
	      
	    log.info("Executing " + methodName);
		testWithParam("000000000000000000000001234567890123456789012345678901234567890");
	}


    /**
     * When string has leading zero then replace zero.
     */
    @Test
	void whenStringHasLeadingZero_thenReplaceZero() {
		String methodName = new Object() {}
	      .getClass()
	      .getEnclosingMethod()
	      .getName();
	      
	    log.info("Executing " + methodName);
		testWithParam("00000000000000000000000123456789");
	}

    /**
     * When string has leading zero to long for integer then replace zero.
     */
    @Test
	void whenStringHasLeadingZeroTooLongForInteger_thenReplaceZero() {
		String methodName = new Object() {}
	      .getClass()
	      .getEnclosingMethod()
	      .getName();
	      
	    log.info("Executing " + methodName);
		testWithParam("000000000000000000000001234567890123456789");		
	}

    /**
     * When string has leading zero with special char then replace zero.
     */
    @Test
	void whenStringHasLeadingZeroWithSpecialChar_thenReplaceZero() {
		String methodName = new Object() {}
	      .getClass()
	      .getEnclosingMethod()
	      .getName();
	      
	    log.info("Executing " + methodName);
		testWithParam("000000000000000000000001234567890123456789$#@");		
	}

    /**
     * When string has leading zero with spaces then replace zero.
     */
    @Test
	void whenStringHasLeadingZeroWithSpaces_thenReplaceZero() {
		String methodName = new Object() {}
	      .getClass()
	      .getEnclosingMethod()
	      .getName();
	      
	    log.info("Executing " + methodName);
		testWithParam("000000000000000000000001234567890123456789  ");
	}

    /**
     * When string has leading zero with non numeric then replace zero.
     */
    @Test
	void whenStringHasLeadingZeroWithNonNumeric_thenReplaceZero() {
		String methodName = new Object() {}
	      .getClass()
	      .getEnclosingMethod()
	      .getName();
	      
	    log.info("Executing " + methodName);
		testWithParam("000000000000000000000001234567890123456789ABC");		
	}
	
	
	private class ResponseData {

		private String Autodebetaccountnumber;
		private String trimValue;

        /**
         * Gets trim value.
         *
         * @return the trim value
         */
        public String getTrimValue() {
			return trimValue;
		}

        /**
         * Sets trim value.
         *
         * @param trimValue the trim value
         */
        public void setTrimValue(String trimValue) {
			this.trimValue = trimValue;
		}

        /**
         * Gets autodebetaccountnumber.
         *
         * @return the autodebetaccountnumber
         */
        public String getAutodebetaccountnumber() {
			return Autodebetaccountnumber;
		}

        /**
         * Sets autodebetaccountnumber.
         *
         * @param autodebetaccountnumber the autodebetaccountnumber
         */
        public void setAutodebetaccountnumber(String autodebetaccountnumber) {
			Autodebetaccountnumber = autodebetaccountnumber;
		}


	}
}
