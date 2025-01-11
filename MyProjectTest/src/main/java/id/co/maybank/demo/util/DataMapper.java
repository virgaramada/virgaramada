package id.co.maybank.demo.util;
import java.util.List;

import org.modelmapper.ModelMapper;

/**
 * The type Data mapper.
 */
public class DataMapper {
    /**
     * Map list list.
     *
     * @param <S>         the type parameter
     * @param <T>         the type parameter
     * @param source      the source
     * @param targetClass the target class
     * @return the list
     */
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        ModelMapper modelMapper = new ModelMapper();
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .toList();
    }

    /**
     * Map d.
     *
     * @param <D>             the type parameter
     * @param source          the source
     * @param destinationType the destination type
     * @return the d
     */
    public <D> D map(Object source, Class<D> destinationType) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(source, destinationType);
    }
}
