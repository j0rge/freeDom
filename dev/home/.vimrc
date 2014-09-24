filetype on
filetype plugin on
filetype indent on
syntax on
"set laststatus=2
set ls=2 " last status
"set statusline=%F%m%r%h%w\ [fmt=%{&ff}]\ [ty=%Y]\ [d=\%03.3b]\ [x=\%02.2B]\ [pos=%04l,%04v][%p%%]\ [tot=%L] 
"set statusline=%<[%02n]\ %F%(\ %m%h%w%y%r%)\ %a%=\ %8l,%c%V/%L\ (%P)\ [%08O:%02B]
"set statusline=%F%m%r%h%w\ %{&ff}\ %Y\ d=\%04.8b\ x=\%04.4B\ pos=%04l,%04v\ %p%%\ len=%L
hi User1 term=underline cterm=none ctermfg=white ctermbg=darkblue guifg=#A00000 guibg=#00FFFF
hi Normal ctermbg=15 ctermfg=black  guifg=#A00000 guibg=White
hi NonText ctermbg=white ctermfg=lightred
hi StatusLine ctermfg=white ctermbg=black gui=bold,reverse
hi StatusLineNC ctermfg=yellow ctermbg=black gui=bold,reverse
"hi StatusLine term=reverse ctermfg=white ctermbg=black gui=bold,reverse
"hi User1 term=underline cterm=bold ctermfg=white ctermbg=black guifg=#40ffff guibg=#0000aa
"set statusline=%1*%F%m%r%h%w%=%(%c%V\ %l/%L\ %P%)
"set stl=%1*%F%m%r%h%w%=%(%c%V\ %l/%L\ %P%)
set stl=%F%m%r%h%w%=%(%c%V\ %l/%L\ %P%)
"set laststatus=2
"help stl
"set guifont=monospace\ 9
set guifont=dejavu\ sans\ mono\ book\ 9
"set guifont=lucidatypewriter:h12

"set guifont=-b&h-lucidatypewriter-medium-r-normal-sans-12-120-75-75-m-70-iso8859-1
set expandtab
set tabstop=2
set shiftwidth=2
"set softtabstop=2
"         xrdb -merge $HOME/.Xdefaults
"
colorscheme github
if version >= 700
  "set toolbar=
  set guioptions=aAcm
 " au InsertEnter * hi StatusLine term=reverse ctermbg=5 gui=undercurl guisp=Magenta
 " au InsertLeave * hi StatusLine term=reverse ctermfg=0 ctermbg=2 gui=bold,reverse
 
au InsertLeave * hi ModeMsg ctermfg=white ctermbg=red gui=undercurl guisp=Magenta
au InsertEnter * hi ModeMsg ctermfg=white ctermbg=none
"au InsertLeave * hi Normal ctermbg=NONE
"au InsertEnter * hi Normal ctermbg=lightRed

endif
au BufNewFile,BufRead *.m set filetype=mason
au BufNewFile,BufRead *.mi set filetype=mason
if has("gui_running")
  colorscheme elim
endif  
set noeb
ab qt ConqueTermTab zsh 
ab qv ConqueTermVSplit zsh 
ab qs ConqueTermSplit zsh 
ab qz ConqueTerm zsh 

if has("gui_running")
  " GUI is running or is about to start.
  " Maximize gvim window.
  set lines=999 columns=999
  " Make shift-insert work like in Xterm
"  map <S-Insert> <MiddleMouse>
"  map! <S-Insert> <MiddleMouse>
  map <S-Insert> "+gP
  imap <S-Insert> *
  cmap <S-Insert> +
  map <C-INsert> "+y
else
  " This is console Vim.
  if exists("+lines")
    "set lines=50
  endif
  if exists("+columns")
    "set columns=100
  endif
endif

nnoremap K :echo "hi<" . synIDattr(synID(line("."),col("."),1),"name") . '> trans<'
    \ . synIDattr(synID(line("."),col("."),0),"name") . "> lo<"
    \ . synIDattr(synIDtrans(synID(line("."),col("."),1)),"name") . ">"<CR>

let g:ConqueTerm_FastMode = 1
let g:ConqueTerm_Color = 0
let g:ConqueTerm_SessionSupport = 1
let g:ConqueTerm_InsertOnEnter = 1
let g:ConqueTerm_CloseOnEnd = 1
let g:ConqueTerm_CWInsert = 1

function! GuiTabLabel()
  let label = ''
  let bufnrlist = tabpagebuflist(v:lnum)

" Add '+' if one of the buffers in the tab page is modified
  for bufnr in bufnrlist
    if getbufvar(bufnr, "&modified")
      let label = '+'
      break
    endif
  endfor

" Append the number of windows in the tab page if more than one
  let wincount = tabpagewinnr(v:lnum, '$')
  if wincount > 1
    let label .= wincount
  endif
  if label != ''
    let label .= ' '
  endif

" Append the buffer name
  let bufId = bufnrlist[tabpagewinnr(v:lnum) - 1]
  let fn = bufname(bufId)
  let lastSlash = strridx(fn, '/')
  return label . strpart(fn, lastSlash+1, strlen(fn))
endfunction

set guitablabel=%{GuiTabLabel()}

function! WhichHiLiteGroup()
  echom "hi<" . synIDattr(synID(line("."),col("."),1),"name") . '> trans<'  . synIDattr(synID(line("."),col("."),0),"name") . "> lo<"  . synIDattr(synIDtrans(synID(line("."),col("."),1)),"name") . ">"
endfunction

if match($TERM, "screen")!=-1
  set term=xterm
  let g:GNU_Screen_used = 1
else
  let g:GNU_Screen_used = 0
endif
