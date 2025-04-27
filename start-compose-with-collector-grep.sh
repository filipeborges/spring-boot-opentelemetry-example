#!/bin/bash

sudo docker-compose up | grep -E 'Span #|Attributes|\-> |(ID|Name|Kind|time|Status \w+)\s+:|(ScopeLogs|InstrumentationScope|LogRecord|Timestamp|Severity|Body|Trace|Span)'
