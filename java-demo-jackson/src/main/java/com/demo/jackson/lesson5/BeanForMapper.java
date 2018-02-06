package com.demo.jackson.lesson5;

/**
 * This is {@link BeanForMapper}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class BeanForMapper {
    public int id;
    public String firstName;
    public String lastName;
    public String originalLocationAddress;

    public BeanForMapper(int id, String firstName, String lastName, String originalLocationAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.originalLocationAddress = originalLocationAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof BeanForMapper) == false)
            return false;
        BeanForMapper beanForMapper = (BeanForMapper) obj;
        return beanForMapper.id == this.id;
    }
}
