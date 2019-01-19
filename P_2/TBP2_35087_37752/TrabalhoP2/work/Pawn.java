package work;

import java.util.*;

public class Pawn implements IPawn {

	Route route;

	public Pawn(Route route) {
		super();
		this.route = route;
	}

	@Override
	public void move(Move move) {

		if (route.checkMove(move) == true) {
			route.move(move);
		}

		else {
			route.backTracking();
		}
	}

	@Override
	public Route getRoute() {
		return route;
	}
}