FROM node:11.10-alpine

WORKDIR /app

CMD if test ! -e data/code.js; then exit 3; fi; \
    cp data/in.txt . ; \
    if test $(cat data/out.txt) = $(node data/code.js); then exit 0; else exit 4; fi
