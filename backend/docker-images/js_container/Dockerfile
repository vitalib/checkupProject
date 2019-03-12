FROM node:11.10-alpine

WORKDIR /app

CMD if test ! -e data/code.js; then exit 4; fi; \
    cp data/in.txt . ; \
	cp data/code.js . ; \
	node code.js > result.txt; \
	exitCode=$?; \
	if test $exitCode != 0; then exit 6; fi; \
    if test $(cat data/out.txt) = $(cat result.txt); then exit 0; else exit 3; fi
