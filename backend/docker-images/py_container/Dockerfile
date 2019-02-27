FROM python:3.7-alpine

WORKDIR /app

COPY . /app

CMD if test ! -e code.py; then exit 3; fi; if test $(cat out.txt) = $(python code.py); then exit 0; else exit 4; fi
