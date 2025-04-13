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

make_http_request_2() {
  curl -v -X POST "http://localhost:8080/hello-world" -H "Content-Type: application/json" -d '{"message":"Hello World", "language":"EN"}'
}

while true; do
	clear
	make_http_request
	make_http_request_2
	sleep 5
done
