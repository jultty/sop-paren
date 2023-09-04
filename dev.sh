while true; do
  clear
  gradle test --rerun --fail-fast &&
  gradle run
  echo
  inotifywait -r -e modify .
done
