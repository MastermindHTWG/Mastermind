import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import de.htwg.mastermind.controller.IMastermindController;
import de.htwg.mastermind.model.IField;


public class MastermindModel extends AbstractModule {

	private static final int SIZE = 4;
	private static final int HEIGHT = 6;
	
	@Override
	protected void configure() {
		bind(IField.class).to(de.htwg.mastermind.model.implementierung.Field.class);
		bind(IMastermindController.class).to(de.htwg.mastermind.controller.implementierung.MastermindController.class);
		
		bindConstant().annotatedWith(Names.named("size")).to(SIZE);
		bindConstant().annotatedWith(Names.named("height")).to(HEIGHT);
	}

}
