FROM openjdk:11.0-jdk-oracle

WORKDIR /app

CMD if test ! -e data/Code.java; then exit 4; fi; \
	javac -d . data/Code.java; \
	if test $? != 0; then exit 5; fi; \
	cp data/in.txt . ; \
	java Code > data/result.txt 2>&1; \
	exitCode=$?; \
	echo $exitCode >> data/result.txt; \
	if test $exitCode != 0; then exit 6; fi; \
	if test $(cat data/out.txt) = $(cat result.txt); then exit 0; else exit 3; fi
