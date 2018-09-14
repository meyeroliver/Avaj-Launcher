DIR_PATH=src/avaj_launcher/
RUN_PATH=avaj_launcher.simulator.Simulator 

LIBS=$(DIR_PATH)simulator $(DIR_PATH)simulator/vehicles  $(DIR_PATH)weather

complie:
	@find . -name *.java > sources.txt
	@javac -sourcepath ./src/ @sources.txt
	@echo "Compilation is done. Ready to Run."
	@echo "\nTo launch this program, Enter \"make run FILE=\" specify source file IMMEDIATELY after the = sign"

run:
	@java -cp ./src/ $(RUN_PATH) $(FILE)
	@echo "Simulation is complete." 

clean:
	@rm simulation.txt
	@rm sources.txt
	@for dir in $(LIBS); do \
		cd $$dir; \
		rm -f *.class; \
		cd -; \
		done

	@echo "Thank you. Come again"



