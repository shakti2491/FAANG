package designpattern.structural.filter;

import java.util.List;

public class AndCriteria implements ICriteria {

    private ICriteria criteria;
    private ICriteria otherCriteria;

    public AndCriteria(ICriteria criteria, ICriteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {

        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
