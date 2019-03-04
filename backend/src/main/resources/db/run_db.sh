#!/bin/bash
PGPASSWORD=postgres psql -U postgres -h localhost -f create_schema.sql