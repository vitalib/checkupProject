FROM python:3.7-alpine

WORKDIR /app

CMD if test ! -e data/code.py; then exit 4; fi; \
    cp data/in.txt . ; \
	python data/code.py > result.txt; \
	if test $? != 0; then exit 6; fi; \
    if test $(cat data/out.txt) = $(cat result.txt); then exit 0; else exit 3; fi
