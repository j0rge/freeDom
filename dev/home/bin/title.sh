TITLE="$1"
[[ -z $TITLE ]] && TITLE="`basename $PWD`"
echo -ne "\033]0;$TITLE\007"
