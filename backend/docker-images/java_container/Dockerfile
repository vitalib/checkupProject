FROM azul/zulu-openjdk-alpine:11

WORKDIR /app

COPY . /app

CMD if test ! -e code.java; then exit 3; fi; if test $(cat out.txt) = $(java code.java); then exit 0; else exit 4; fi
