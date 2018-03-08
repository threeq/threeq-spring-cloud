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
import springfox.documentation.spi.service.ExpandedParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.ParameterExpansionContext;

import static me.threeq.libs.swagger.validators.plugins.RangeAnnotations.stringLengthRange;
import static springfox.bean.validators.plugins.Validators.validatorFromExpandedParameter;

@Component
@Order(Validators.BEAN_VALIDATOR_PLUGIN_ORDER)
public class ExpandedParameterLengthAnnotationPlugin implements ExpandedParameterBuilderPlugin {

    private static final Logger LOG = LoggerFactory.getLogger(ExpandedParameterLengthAnnotationPlugin.class);

    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }

    @Override
    public void apply(ParameterExpansionContext context) {
        Optional<Length> length = validatorFromExpandedParameter(context, Length.class)
                            .or(validatorFromExpandedParameter(context, Length.class));

        if (length.isPresent()) {
            AllowableRangeValues values = stringLengthRange(length.get());
            LOG.debug("Adding allowable Values: {} - {}", values.getMin(), values.getMax());

            context.getParameterBuilder().allowableValues(values);
        }
    }
}
