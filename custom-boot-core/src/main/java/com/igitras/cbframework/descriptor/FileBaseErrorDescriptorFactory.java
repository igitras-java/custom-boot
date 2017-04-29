package com.igitras.cbframework.descriptor;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * File Based Error getCode provider.
 *
 * @author mason
 */
public class FileBaseErrorDescriptorFactory extends AbstractErrorDescriptorFactory {

    private static final String[] DEFAULT_CONFIGS = {"/error_code.csv"};

    private String[] errorCodeResources = DEFAULT_CONFIGS;

    public FileBaseErrorDescriptorFactory() {
    }

    public FileBaseErrorDescriptorFactory(String[] errorCodeResources) {
        Assert.notNull(errorCodeResources, "Error Code configuration files must not be null.");
        this.errorCodeResources = errorCodeResources;
    }

    public FileBaseErrorDescriptorFactory setErrorCodeResources(String[] errorCodeResources) {
        this.errorCodeResources = errorCodeResources;
        return this;
    }

    @Override
    public void loadDescriptors() {
        //        errorDescriptorMap
        errorDescriptorMap.putAll(Stream.of(errorCodeResources)
                .flatMap(resource -> loadObjectsFromCsv(GeneralErrorDescriptor.class, resource))
                .collect(Collectors.toMap(GeneralErrorDescriptor::getIdentity, descriptor -> descriptor, (f, s) -> s)));
    }

    private static <T> Stream<T> loadObjectsFromCsv(Class<T> type, String resourceName) {
        try {
            CsvSchema schema = CsvSchema.emptySchema()
                    .withHeader();
            CsvMapper mapper = new CsvMapper();
            MappingIterator<T> readValues = mapper.readerFor(type)
                    .with(schema)
                    .readValues(new ClassPathResource(resourceName).getInputStream());
            return readValues.readAll()
                    .stream();
        } catch (IOException e) {
            return Stream.empty();
        }
    }
}
