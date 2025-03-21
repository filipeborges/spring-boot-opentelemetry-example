#!/bin/bash

sudo docker-compose up | grep -E 'Span #|Attributes|\-> messaging|(ID|Name|Kind|time|Status \w+)\s+:'
