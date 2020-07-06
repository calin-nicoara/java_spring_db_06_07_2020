package designpatterns;

import org.junit.jupiter.api.Test;

import designpatterns.factorymethod.AccoutantMonthlyActionPlan;
import designpatterns.factorymethod.MonthlyActionPlan;
import designpatterns.factorymethod.MonthlyActionPlanBad;

class FactoryMethodTest {

    @Test
    public void testJob() {
        MonthlyActionPlanBad monthlyActionPlan = new MonthlyActionPlanBad();

        monthlyActionPlan.doMonthlyActivities();
    }

    @Test
    public void testJobWithFactoryMethod() {
        MonthlyActionPlan accoutantMonthlyActionPlan = new AccoutantMonthlyActionPlan();

        accoutantMonthlyActionPlan.doMonthlyActivities();
    }
}
