SRC_DIR = src/fr/bepoisso/avaj
BUILD_DIR = bin
MAIN_CLASS = fr.bepoisso.avaj.Main

SOURCES = \
	$(SRC_DIR)/Main.java \
	$(SRC_DIR)/aircraft/Aircraft.java \
	$(SRC_DIR)/aircraft/Balloon.java \
	$(SRC_DIR)/aircraft/Helicopter.java \
	$(SRC_DIR)/aircraft/JetPlane.java \
	$(SRC_DIR)/coordinates/Coordinates.java \
	$(SRC_DIR)/simulator/Simulator.java \
	$(SRC_DIR)/tower/Tower.java \
	$(SRC_DIR)/tower/WeatherTower.java \
	$(SRC_DIR)/weather/WeatherProvider.java

all: $(BUILD_DIR)/.compiled

$(BUILD_DIR)/.compiled: $(SOURCES)
	@mkdir -p $(BUILD_DIR)
	javac -d $(BUILD_DIR) $(SOURCES)
	@touch $@

run: all
	java -cp $(BUILD_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(BUILD_DIR)

re: clean all

.PHONY: all run clean re
