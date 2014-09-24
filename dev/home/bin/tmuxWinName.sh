TITLE="$1"
[[ -z $TITLE ]] && TITLE="`basename $PWD`"
tmux rename-w "$TITLE"
