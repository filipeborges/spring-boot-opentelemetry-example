#!/bin/bash

make_http_request () {
	path=""
	epoch=$(date +%s)

	if ! ((epoch % 2)); then
		path="hello-world/uppercase"
	else
		path="hello-world"
	fi

	curl -X GET "http://localhost:8080/${path}"
}

while true; do
	clear
	make_http_request
	sleep 5
done
