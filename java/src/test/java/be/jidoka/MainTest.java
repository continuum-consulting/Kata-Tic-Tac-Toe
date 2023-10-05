package be.jidoka;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class MainTest {

	@Test
	void helloWorldTest() {
		assertThat(Main.hello()).isEqualTo("world");
	}
}
