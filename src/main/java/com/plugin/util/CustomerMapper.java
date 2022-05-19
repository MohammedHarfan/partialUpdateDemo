package com.plugin.util;

import com.plugin.model.Customer;
import com.plugin.model.dto.CustomerDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring ")
public interface CustomerMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCustomerFromDto(CustomerDto customerDto, @MappingTarget Customer entity);
}
