package me.threeq.libs.swagger.validators.plugins.parameter;

import com.google.common.base.Optional;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.bean.validators.plugins.Validators;
import springfox.documentation.service.AllowableRangeValues;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.ParameterContext;

import static me.threeq.libs.swagger.validators.plugins.RangeAnnotations.stringLengthRange;
import static springfox.bean.validators.plugins.Validators.annotationFromParameter;

@Component
@Order(Validators.BEAN_VALIDATOR_PLUGIN_ORDER)
public class LengthAnnotationPlugin implements ParameterBuilderPlugin {

    private static final Logger LOG = LoggerFactory.getLogger(LengthAnnotationPlugin.class);

    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }

    @Override
    public void apply(ParameterContext context) {
        Optional<Length> length = annotationFromParameter(context, Length.class);
        LOG.debug("searching for @Length: {}", length.isPresent());
        if (length.isPresent()) {
            AllowableRangeValues values = stringLengthRange(length.get());
            LOG.debug("Adding allowable Values @Length: {} - {}", values.getMin(), values.getMax());
            context.parameterBuilder().allowableValues(values);

            context.parameterBuilder()
                    .description(
                            String.format("@Length: %s - %s",
                                    values.getMin(),
                                    values.getMax()));
        }
    }
}
