package designpattern.structural.filter;

import java.util.List;

public interface ICriteria {
     List<Person> meetCriteria(List<Person> persons);
}
