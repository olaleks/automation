package com.stormnet;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigModel {
        @JsonProperty("baseUrl")
        private String baseUrl;

        @JsonProperty("timeout")
        private long timeout;

        @JsonProperty("browser")
        private String browser;

        @JsonProperty("seleniumBrowserSize")
        private String browserSize;

        @JsonProperty("browserPosition")
        private String browserPosition;

        @JsonProperty("headless")
        private Boolean headless;

        @JsonProperty("savePageSource")
        private Boolean savePageSource;

        @JsonProperty("fastSetValue")
        private Boolean fastSetValue;
}
