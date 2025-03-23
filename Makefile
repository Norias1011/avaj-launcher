# Directories
SRC_DIR = avaj_launcher/src
OUT_DIR = out

# Find all Java source files
SOURCES := $(shell find $(SRC_DIR) -name "*.java")
CLASSES := $(patsubst $(SRC_DIR)/%.java,$(OUT_DIR)/%.class,$(SOURCES))

# Default target
all: compile

# Compile only if source files are newer than class files
compile: $(OUT_DIR) $(CLASSES)

# Create out directory if it doesn't exist
$(OUT_DIR):
	mkdir -p $(OUT_DIR)

# Rule to compile Java files to class files
$(OUT_DIR)/%.class: $(SRC_DIR)/%.java
	javac -d $(OUT_DIR) $(SOURCES)

# Run the program
run:
	java -cp $(OUT_DIR) com.app.Main scenario.txt

# Clean compiled files and simulation.txt
clean:
	find $(OUT_DIR) -name "*.class" -type f -delete
	rm -f simulation.txt

# Phony targets
.PHONY: all compile run clean