FROM python:3.7-alpine

WORKDIR /app

COPY . /app

CMD if test ! -e data/code.py; then exit 3; fi; \
    cp data/in.txt . ; \
    if test $(cat data/out.txt) = $(python data/code.py); then exit 0; else exit 4; fi
