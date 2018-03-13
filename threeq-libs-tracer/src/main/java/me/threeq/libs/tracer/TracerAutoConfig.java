package me.threeq.libs.tracer;

import com.google.gson.Gson;
import com.uber.jaeger.Configuration;
import io.opentracing.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

@org.springframework.context.annotation.Configuration
@Slf4j
@ConfigurationProperties(prefix = "opentracing.tracer")
public class TracerAutoConfig {

    private JaegerConfig jaeger = new JaegerConfig();

    @Autowired
    private Environment env;

    @Bean
    public Tracer tracer() {

        setSystemProperty();
        return Configuration.fromEnv()
                .getTracer();
    }

    private void setSystemProperty() {

        if(StringUtils.isEmpty(jaeger.name)) {
            jaeger.name = env.getProperty("spring.application.name");
        }

        log.debug("jaeger 配置信息：" + new Gson().toJson(jaeger));

        if(!StringUtils.isEmpty(jaeger.name)) {
            System.setProperty(Configuration.JAEGER_SERVICE_NAME, jaeger.name);
        }

        if(!StringUtils.isEmpty(jaeger.endPoint)) {
            System.setProperty(Configuration.JAEGER_ENDPOINT, jaeger.endPoint);
        }

        if(!StringUtils.isEmpty(jaeger.user)) {
            System.setProperty(Configuration.JAEGER_USER, jaeger.user);
        }

        if(!StringUtils.isEmpty(jaeger.password)) {
            System.setProperty(Configuration.JAEGER_PASSWORD, jaeger.password);
        }

        if(!StringUtils.isEmpty(jaeger.agentHost)) {
            System.setProperty(Configuration.JAEGER_AGENT_HOST, jaeger.agentHost);
        }

        if(!StringUtils.isEmpty(jaeger.agentPort)) {
            System.setProperty(Configuration.JAEGER_AGENT_PORT, jaeger.agentPort);
        }

        if(!StringUtils.isEmpty(jaeger.reporterLogSpans)) {
            System.setProperty(Configuration.JAEGER_REPORTER_LOG_SPANS, jaeger.reporterLogSpans);
        }

        if(!StringUtils.isEmpty(jaeger.reporterMaxQueueSize)) {
            System.setProperty(Configuration.JAEGER_REPORTER_MAX_QUEUE_SIZE, jaeger.reporterMaxQueueSize);
        }

        if(!StringUtils.isEmpty(jaeger.reporterFlushInterval)) {
            System.setProperty(Configuration.JAEGER_REPORTER_FLUSH_INTERVAL, jaeger.reporterFlushInterval);
        }

        if(!StringUtils.isEmpty(jaeger.samplerType)) {
            System.setProperty(Configuration.JAEGER_SAMPLER_TYPE, jaeger.samplerType);
        }

        if(!StringUtils.isEmpty(jaeger.samplerParam)) {
            System.setProperty(Configuration.JAEGER_SAMPLER_PARAM, jaeger.samplerParam);
        }

        if(!StringUtils.isEmpty(jaeger.samplerManagerHostPort)) {
            System.setProperty(Configuration.JAEGER_SAMPLER_MANAGER_HOST_PORT, jaeger.samplerManagerHostPort);
        }

        if(!StringUtils.isEmpty(jaeger.tags)) {
            System.setProperty(Configuration.JAEGER_TAGS, jaeger.tags);
        }

        if(!StringUtils.isEmpty(jaeger.progragation)) {
            System.setProperty(Configuration.JAEGER_PROPAGATION, jaeger.progragation);
        }

        if(!StringUtils.isEmpty(jaeger.authToken)) {
            System.setProperty(Configuration.JAEGER_AUTH_TOKEN, jaeger.authToken);
        }

    }

    public static class JaegerConfig {
        @Value("${spring.application.name:application}")
        private String name;
        private String endPoint;
        private String user;
        private String password;
        private String agentHost;
        private String agentPort;
        private String reporterLogSpans;
        private String reporterMaxQueueSize;
        private String reporterFlushInterval;
        private String samplerType;
        private String samplerParam;
        private String samplerManagerHostPort;
        private String tags;
        private String progragation;
        private String authToken;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEndPoint() {
            return endPoint;
        }

        public void setEndPoint(String endPoint) {
            this.endPoint = endPoint;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAgentHost() {
            return agentHost;
        }

        public void setAgentHost(String agentHost) {
            this.agentHost = agentHost;
        }

        public String getAgentPort() {
            return agentPort;
        }

        public void setAgentPort(String agentPort) {
            this.agentPort = agentPort;
        }

        public String getReporterLogSpans() {
            return reporterLogSpans;
        }

        public void setReporterLogSpans(String reporterLogSpans) {
            this.reporterLogSpans = reporterLogSpans;
        }

        public String getReporterMaxQueueSize() {
            return reporterMaxQueueSize;
        }

        public void setReporterMaxQueueSize(String reporterMaxQueueSize) {
            this.reporterMaxQueueSize = reporterMaxQueueSize;
        }

        public String getReporterFlushInterval() {
            return reporterFlushInterval;
        }

        public void setReporterFlushInterval(String reporterFlushInterval) {
            this.reporterFlushInterval = reporterFlushInterval;
        }

        public String getSamplerType() {
            return samplerType;
        }

        public void setSamplerType(String samplerType) {
            this.samplerType = samplerType;
        }

        public String getSamplerParam() {
            return samplerParam;
        }

        public void setSamplerParam(String samplerParam) {
            this.samplerParam = samplerParam;
        }

        public String getSamplerManagerHostPort() {
            return samplerManagerHostPort;
        }

        public void setSamplerManagerHostPort(String samplerManagerHostPort) {
            this.samplerManagerHostPort = samplerManagerHostPort;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getProgragation() {
            return progragation;
        }

        public void setProgragation(String progragation) {
            this.progragation = progragation;
        }

        public String getAuthToken() {
            return authToken;
        }

        public void setAuthToken(String authToken) {
            this.authToken = authToken;
        }
    }

    public JaegerConfig getJaeger() {
        return jaeger;
    }

    public void setJaeger(JaegerConfig jaeger) {
        this.jaeger = jaeger;
    }
}
