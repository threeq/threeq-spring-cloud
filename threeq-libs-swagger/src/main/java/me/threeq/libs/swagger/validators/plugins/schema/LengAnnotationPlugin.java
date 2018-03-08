package me.threeq.libs.swagger.validators.plugins.schema;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import org.hibernate.validator.constraints.Length;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.bean.validators.plugins.Validators;
import springfox.documentation.service.AllowableRangeValues;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;

import static me.threeq.libs.swagger.validators.plugins.RangeAnnotations.stringLengthRange;
import static springfox.bean.validators.plugins.Validators.annotationFromBean;
import static springfox.bean.validators.plugins.Validators.annotationFromField;

@Component
@Order(Validators.BEAN_VALIDATOR_PLUGIN_ORDER)
public class LengAnnotationPlugin implements ModelPropertyBuilderPlugin {

    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }

    @Override
    public void apply(ModelPropertyContext context) {
        Optional<Length> length = extractAnnotation(context);

        if (length.isPresent()) {
            AllowableRangeValues values = stringLengthRange(length.get());
            context.getBuilder().allowableValues(values);
        }
    }

    @VisibleForTesting
    Optional<Length> extractAnnotation(ModelPropertyContext context) {
        return annotationFromBean(context, Length.class).or(annotationFromField(context, Length.class));
    }
}
