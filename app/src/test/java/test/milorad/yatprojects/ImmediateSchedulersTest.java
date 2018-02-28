package test.milorad.yatprojects;


import org.junit.ClassRule;

public class ImmediateSchedulersTest {
	@ClassRule public static final RxImmediateSchedulerRule schedulers =
			new RxImmediateSchedulerRule();
}
