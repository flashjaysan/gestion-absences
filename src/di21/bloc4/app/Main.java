package di21.bloc4.app;

import di21.bloc4.dao.Learner;

public class Main {

	public static void main(String[] args) {
		Learner learner = new Learner(
				"DI21",
				"Jérôme",
				"Barbier",
				"jerome.barbier@viacesi.fr",
				"+33555373636",
				1,
				false);
		System.out.println(learner);
	}

}
