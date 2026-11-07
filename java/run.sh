#!/bin/bash
set -euo pipefail
cd "$(dirname "$0")"
JAVA_HOME=$(/usr/libexec/java_home -v 25)
if [[ "$("$JAVA_HOME/bin/java" -XshowSettings:properties -version 2>&1 | sed -n 's/^[[:space:]]*java.specification.version = //p')" != "25" ]]; then
    echo "Java 25 wird benötigt." >&2
    exit 1
fi
sources=()
while IFS= read -r -d '' source; do
    sources+=("$source")
done < <(find src -name '*.java' -print0)
if [[ ${#sources[@]} -eq 0 ]]; then
    echo "Keine Java-Dateien in src gefunden." >&2
    exit 1
fi
mkdir -p out
"$JAVA_HOME/bin/javac" --release 25 -encoding UTF-8 -d out "${sources[@]}"
main_class="${1:-Main}"
if [[ $# -gt 0 ]]; then shift; fi
exec "$JAVA_HOME/bin/java" -cp out "$main_class" "$@"
