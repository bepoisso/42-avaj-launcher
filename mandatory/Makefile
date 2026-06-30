SRC_DIR = src/fr/bepoisso/avaj
BUILD_DIR = bin
MAIN_CLASS = Main

SOURCES = \
	$(SRC_DIR)/Main.java \
	$(SRC_DIR)/aircraft/Aircraft.java \
	$(SRC_DIR)/aircraft/Balloon.java \
	$(SRC_DIR)/aircraft/Helicopter.java \
	$(SRC_DIR)/aircraft/JetPlane.java \
	$(SRC_DIR)/coordinates/Coordinates.java \
	$(SRC_DIR)/simulator/Simulator.java \
	$(SRC_DIR)/weather/Tower.java \
	$(SRC_DIR)/weather/WeatherTower.java \
	$(SRC_DIR)/weather/WeatherProvider.java \
	$(SRC_DIR)/logger/Logger.java \
	$(SRC_DIR)/parser/Parser.java \
	$(SRC_DIR)/exception/InvalidAircraftException.java \
	$(SRC_DIR)/exception/InvalidCoordinateException.java \
	$(SRC_DIR)/exception/InvalidScenarioException.java \


all: $(BUILD_DIR)/.compiled

$(BUILD_DIR)/.compiled: $(SOURCES)
	@mkdir -p $(BUILD_DIR)
	javac -d $(BUILD_DIR) $(SOURCES)
	@touch $@

run: all
	java -cp $(BUILD_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(BUILD_DIR)

fclean: clean

re: clean all

.PHONY: all run clean fclean re
