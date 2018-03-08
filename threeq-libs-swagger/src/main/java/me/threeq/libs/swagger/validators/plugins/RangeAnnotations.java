package me.threeq.libs.swagger.validators.plugins;

import com.google.common.base.Optional;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springfox.documentation.service.AllowableRangeValues;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class RangeAnnotations {
    private static final Logger LOG = LoggerFactory.getLogger(springfox.bean.validators.plugins.RangeAnnotations.class);

    private RangeAnnotations() {
        throw new UnsupportedOperationException();
    }

    public static AllowableRangeValues stringLengthRange(Size size) {
        LOG.debug("@Size detected: adding MinLength/MaxLength to field");
        return new AllowableRangeValues(minValue(size), maxValue(size));
    }

    public static AllowableRangeValues stringLengthRange(Length size) {
        LOG.debug("@Size detected: adding MinLength/MaxLength to field");
        return new AllowableRangeValues(minValue(size), maxValue(size));
    }

    private static String minValue(Size size) {
        return String.valueOf(Math.max(size.min(), 0));
    }

    private static String maxValue(Size size) {
        return String.valueOf(Math.max(0, Math.min(size.max(), Integer.MAX_VALUE)));
    }

    private static String minValue(Length size) {
        return String.valueOf(Math.max(size.min(), 0));
    }


    private static String maxValue(Length size) {
        return String.valueOf(Math.max(0, Math.min(size.max(), Integer.MAX_VALUE)));
    }

    public static AllowableRangeValues allowableRange(Optional<Min> min, Optional<Max> max) {
        AllowableRangeValues myvalues = null;

        if (min.isPresent() && max.isPresent()) {
            LOG.debug("@Min+@Max detected: adding AllowableRangeValues to field ");
            myvalues = new AllowableRangeValues(
                    Double.toString(min.get().value()),
                    false,
                    Double.toString(max.get().value()),
                    false);

        } else if (min.isPresent()) {
            LOG.debug("@Min detected: adding AllowableRangeValues to field ");
            myvalues = new AllowableRangeValues(
                    Double.toString(min.get().value()),
                    false,
                    null,
                    null);

        } else if (max.isPresent()) {
            LOG.debug("@Max detected: adding AllowableRangeValues to field ");
            myvalues = new AllowableRangeValues(
                    null,
                    null,
                    Double.toString(max.get().value()),
                    false);
        }
        return myvalues;
    }
}
