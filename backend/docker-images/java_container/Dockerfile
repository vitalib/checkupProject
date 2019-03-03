FROM openjdk:11.0-jdk-oracle

WORKDIR /app

CMD if test ! -e data/code.java; then exit 3; fi; \
	javac -d . data/code.java 2>errors.txt; \
	if test -s errors.txt; then exit 5; fi; \
	cp data/in.txt . ; \
	if test $(cat data/out.txt) = $(java Code); then exit 0; else exit 4; fi
