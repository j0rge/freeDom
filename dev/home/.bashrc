# .bashrc

# Source global definitions
if [ -f /etc/bashrc ]; then
	. /etc/bashrc
fi

#autoload -U compinit
#compinit

#allow tab completion in the middle of a word
#setopt COMPLETE_IN_WORD

## keep background processes at full speed
#setopt NOBGNICE
## restart running processes on exit
#setopt HUP

## history
#setopt APPEND_HISTORY
## for sharing history between zsh processes
#setopt INC_APPEND_HISTORY
#setopt SHARE_HISTORY

## never ever beep ever
#setopt NO_BEEP

## automatically decide when to page a list of completions
#LISTMAX=0

## disable mail checking
#MAILCHECK=0

# autoload -U colors
#colors
#
AH_LONG_DATE_FORMAT="+%a %Y-%m-%d %k:%M:%S"
AH_SHORT_DATE_FORMAT="+%Y-%m-%d %k:%M"

export PS1="\$?:\u@\h \W\\$ "
#export PROMPT="%n %m %~ "
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
alias env="env | grep -v AH_HOST_ACCESS_KEY"
alias g="gvim"
alias sd="screen -dmS"
alias rin='rm `ls *gem` || true && gem build `ls *gemspec` && gem install `ls *gem`'
alias fin="firefox ./doc/index.html&"
alias mcd="mvn clean deploy"
alias mcp="mvn clean package"
alias mci="mvn clean install"
alias fif="nohup firefox > /dev/null 2> /dev/null < /dev/null & ; disown"
# Idea insists on suspend = n
set -o vi
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
#ssh-add /home/alim/.ssh/ais_rsa
# the other keys should be set up in ~/.ssh/conf
#export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/usr/local/rvm/rubies/ruby-1.9.3-p392/lib
#export PATH=$PATH:/usr/local/rvm/bin
#export rvmsudo_secure_path=1
__git_files () { 
    _wanted files expl 'local files' _files     
}
export TERM="xterm-256color"
source ~/bin/title.sh 'virt'
alias gitl='git log --pretty=format:"%h:%aD/%cn %s"'
alias gitlc='git log --pretty=format:"%Cblue%H%Creset:%aD/%Cred%cn%Creset.%f%e"'
alias rtd='rake test docs'
# check for background processes that need to be closed manually
alias checkBack='ps -ef | grep -v grep | grep -P "ssh|vim|tmux" || echo "clean"'
export M2_HOME="/opt/mvn/default"
export M2="$M2_HOME/bin"
export MAVEN_OPTS="-Xms512M -Xmx512M"

unset PROMPT_COMMAND
export HISTTIMEFORMAT='%F %T '
