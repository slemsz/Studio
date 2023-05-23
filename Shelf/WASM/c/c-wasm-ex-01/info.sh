#!/bin/bash
#

echo "emcc -o out/hello3/hello3.html src/main/hello3.c --shell-file src/resources/html_template/shell_minimal.html -s NO_EXIT_RUNTIME=1 -s \"EXPORTED_RUNTIME_METHODS=['ccall']\""
