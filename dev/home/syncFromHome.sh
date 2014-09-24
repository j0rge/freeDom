#!/bin/zsh
rsync -r ~/bin ./
rsync -r ~/.vim ./

cp ~/.bashrc ~/.bash_profile ~/.inputrc ~/.screenrc ~/.tmux.conf ~/.vimrc ~/.zshenv ~/.zshrc ~/.zprofile .
