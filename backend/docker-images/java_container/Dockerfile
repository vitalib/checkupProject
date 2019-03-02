FROM openjdk:11.0-jdk-oracle

WORKDIR /app

COPY . /app

CMD if test ! -e data/code.java; then exit 3; fi; \
	javac -d . data/code.java; \
	cp data/in.txt . ; \
	if test $(cat data/out.txt) = $(java Code); then exit 0; else exit 4; fi
