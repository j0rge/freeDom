#function kill-agent {
#    pid=`cat /tmp/.ssh-agent-pid`
#    kill $pid
#}

#bindkey '^P' up-history
#bindkey '^N' down-history
#bindkey '^?' backward-delete-char
#bindkey '^h' backward-delete-char
#bindkey '^w' backward-kill-word
#bindkey '^r' history-incremental-search-backward

export KEYTIMEOUT=1

autoload -U compinit
compinit

# parameter expansion, command substitution and arithmetic expansion are performed in prompts
setopt prompt_subst
# case insensitive matching when performing filename expansion
setopt no_case_glob
# don't display RPROMPT for previously accepted lines; only display it next to current line
setopt transient_rprompt
#allow tab completion in the middle of a word
setopt COMPLETE_IN_WORD

## keep background processes at full speed
setopt NOBGNICE
## restart running processes on exit
#setopt HUP

## history
#setopt APPEND_HISTORY
## for sharing history between zsh processes
setopt INC_APPEND_HISTORY
#setopt SHARE_HISTORY

# don't save duplicates in command history
setopt histignoredups

## never ever beep ever
setopt NO_BEEP
setopt autocd
setopt extended_glob

## automatically decide when to page a list of completions
#LISTMAX=0

## disable mail checking
#MAILCHECK=0

# autoload -U colors
#colors
#
AH_LONG_DATE_FORMAT="+%a %Y-%m-%d %k:%M:%S"
AH_SHORT_DATE_FORMAT="+%Y-%m-%d %k:%M"

# USER_COLOR="$(echo -n '\e[0;32m')"
# HOST_COLOR="$(echo -n '\e[0;31m')"
# DIR_COLOR="$(echo -n '\e[0;35m')"
# PITCH_BLACK="$(echo -n '\e[0;30m')"
# those escape seqs mess up tab completion
#PROMPT="${USER_COLOR}%n ${HOST_COLOR}%U%m%u ${DIR_COLOR}%~$PITCH_BLACK "
#PROMPT="%U%n%u %m %U%~%u "

# this is for running application shell scripts:
# can not set it to gvim, gvim does not pick the file up
alias ls='ls --time-style="$AH_SHORT_DATE_FORMAT" --color=never'
alias l='ls -lh --time-style="$AH_SHORT_DATE_FORMAT" --color=never'
alias ll='ls -lh --time-style="$AH_LONG_DATE_FORMAT" --color=never'
alias lt='ls -lht --time-style="$AH_SHORT_DATE_FORMAT" --color=never'
alias llt='ls -lht --time-style="$AH_LONG_DATE_FORMAT" --color=never'
alias lS='ls -lhS --time-style="$AH_SHORT_DATE_FORMAT" --color=never'
alias llS='ls -lhS --time-style="$AH_LONG_DATE_FORMAT" --color=never'
alias t='title.sh'
alias tt='tmuxWinName.sh'
alias m='mc -dsab'
alias s="screen"
alias v="vim"
#alias g="gvim" # we now use the script in ~/bin
alias sd="screen -dmS"
alias fin="firefox ./doc/index.html&"
alias env="env | grep -v AH_HOST_ACCESS_KEY"
alias mcp="mvn clean package"
alias mci="mvn clean install"
alias fif="nohup firefox > /dev/null 2> /dev/null < /dev/null & ; disown"
# Idea insists on suspend = n
bindkey -v
HISTFILE="$HOME/.zhistory"
SAVEHIST=20000
HISTSIZE=20000

#alias a='/usr/bin/ssh-add'
export SSH_AUTH_SOCK=/tmp/.ssh-socket

# Set everything up via ~/.ssh/conf, don't run the agent
#ssh-add -l >/dev/null 2>&1
#if [ $? = 2 ]; then
#    # Exit status 2 means couldn't connect to ssh-agent; start one now
#    rm -rf /tmp/.ssh-*
#    ssh-agent -a $SSH_AUTH_SOCK >/tmp/.ssh-script
#    . /tmp/.ssh-script
#    echo $SSH_AGENT_PID >/tmp/.ssh-agent-pid
#fi
#export DISPLAY=localhost:0
#export TERM="rxvt-cygwin-native"
#export TERM="cygwin"
#export VIM="/usr/local/share/vim/vim73"
#export VIMRUNTIME="/usr/local/share/vim/vim73"
export TMP="/tmp"
# Add a couple of most popular keys
#ssh-add
# the other keys should be set up in ~/.ssh/conf
#export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/usr/local/rvm/rubies/ruby-1.9.3-p392/lib
#export rvmsudo_secure_path=1
__git_files () { 
    _wanted files expl 'local files' _files     
}
export TERM=xterm-256color
source ~/bin/title.sh 'virt'
alias gitl='git log --pretty=format:"%h:%aD/%cn %s"'
alias gitlc='git log --pretty=format:"%Cblue%H%Creset:%aD/%Cred%cn%Creset.%f%e"'
alias jrake='rake docs && rake test'
alias rtd='rake test docs'
alias rin='rm `ls *gem` || true && gem build `ls *gemspec` && gem install `ls *gem`'
alias ldg='legaFleetDeployGem.rb `ls *gem`'
export M2_HOME="/opt/maven/default"
export M2="$M2_HOME/bin"
export MAVEN_OPTS="-Xms512M -Xmx512M -Djava.net.preferIPv4Stack=true"
alias checkBack='ps -ef | grep -v grep | grep -P "ssh|vim|tmux|screen" || echo "clean"'
# Don’t clear the screen after quitting a manual page
export MANPAGER="less -X"
#vim_ins_mode="[INS]"
#vim_cmd_mode="[CMD]"
#vim_mode=$vim_ins_mode
PROMPT="%(?..[%?] )%n@%m %~ "
function zle-line-init zle-keymap-select {
    RPS1="${${KEYMAP/vicmd/=}/(main|viins)/<}%* %D %l"
    RPS2=$RPS1
    zle reset-prompt
}
#
#function zle-keymap-select {
#  vim_mode="${${KEYMAP/vicmd/${vim_cmd_mode}}/(main|viins)/${vim_ins_mode}}"
#  zle reset-prompt
#}
zle -N zle-line-init
zle -N zle-keymap-select
#zle-line-init() { zle -K vicmd; } # this enables "command" mode
#zle -N zle-line-init
#
#function zle-line-finish {
#  vim_mode=$vim_ins_mode
#}
#zle -N zle-line-finish

#RPROMPT="%* %D %l"

function TRAPINT() {
  vim_mode=$vim_ins_mode
  return $(( 128 + $1 ))
}

# [RUBY] (make GC speedier by using more memory) (sources: https://gist.github.com/1688857, https://gist.github.com/jjb/7389552/)
# # (1.9.x, 2.0.0)
# export RUBY_HEAP_MIN_SLOTS=1000000 # (1M) initial number of slots on the heap as well as the minimum number of slots allocated
# export RUBY_FREE_MIN=100000 # (1M) minimum number of heap slots that should be available after GC runs; if they are not available then, ruby will allocate more slots
# # (1.9.x, 2.0.0, 2.1.0+)
# export RUBY_GC_MALLOC_LIMIT=90000000 # (90MB) number of C data structures that can be allocated before GC kicks in; if too low, GC will run even if there are still heap slots available; too high setting will increase memory fragmentation
# # (2.1.0+)
# export RUBY_GC_HEAP_INIT_SLOTS=1000000 # (1M) (renamed from RUBY_HEAP_MIN_SLOTS)
# export RUBY_GC_HEAP_FREE_SLOTS=1000000 # (1M) (renamed from RUBY_FREE_MIN)
# export RUBY_GC_HEAP_GROWTH_FACTOR=1.2 # (1.2) factor used to grow the heap; since our heap is already quite big with the settings above, we reduce the growth factor to add slots in smaller increments.
# export RUBY_GC_HEAP_GROWTH_MAX_SLOTS=300000 # (300K) maximum new slots to add; in addition to reducing the growth factor, we cap it so a maximum of 300k objects can be added to the heap at once
# export RUBY_GC_MALLOC_LIMIT_GROWTH_FACTOR=1.2 # (1.2) factor used to grow malloc; since our limit is already big, no need to increase it further
# export RUBY_GC_MALLOC_LIMIT_MAX=200000000 # (200MB) (?)
# # (2.1.0+ variables for oldgen GC)
# export RUBY_GC_OLDMALLOC_LIMIT=$RUBY_GC_MALLOC_LIMIT
# export RUBY_GC_OLDMALLOC_LIMIT_MAX=$RUBY_GC_MALLOC_LIMIT_MAX
# export RUBY_GC_OLDMALLOC_LIMIT_GROWTH_FACTOR=$RUBY_GC_MALLOC_LIMIT_GROWTH_FACTOR
#
#
alias tmain='t "Main Terminal" && tmux new -s "Main Terminal"'
alias vvi='t "EDIT" && vim .'
alias lli='ssh admin@legaLink'
