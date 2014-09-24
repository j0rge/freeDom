" Vim color file
" Maintainer:	Yasuhiro Matsumoto <mattn@mail.goo.ne.jp>
" Last Change:	2001 May 25

" This look like normal text editor.
" This color scheme uses a light background.

" First remove all existing highlighting.
set background=light
hi clear
if exists("syntax_on")
  syntax reset
endif

let colors_name = "elim"

hi Normal ctermbg=White ctermfg=Black guifg=Black guibg=White

" Groups used in the 'highlight' and 'guicursor' options default value.
hi ErrorMsg term=standout ctermbg=DarkRed ctermfg=White guibg=Red guifg=White
hi IncSearch term=reverse cterm=reverse gui=reverse
hi ModeMsg term=none cterm=none gui=none  guibg=#000066 guifg=#ffffaa
hi User1 term=reverse cterm=reverse guibg=#000066 guifg=#ffffaa
hi StatusLine term=reverse cterm=reverse guibg=#000066 guifg=#ffffaa
hi StatusLineNC term=reverse cterm=reverse guibg=Darkblue guifg=#ffffaa
hi VertSplit term=reverse cterm=reverse gui=reverse guifg=#CC0099
hi Visual term=reverse cterm=reverse guifg=Black guibg=White guifg=#400033 guibg=#90FFE9
hi VisualNOS term=none cterm=none gui=underline,bold guifg=#330066 guibg=#E9FFC0
hi DiffText term=reverse cterm=none ctermbg=Red gui=bold guibg=Red
hi Cursor ctermbg=Green guibg=#FF9900 guifg=Black
hi lCursor guibg=Cyan guifg=Black
hi Directory term=none ctermfg=LightRed guifg=Red
hi LineNr term=underline ctermfg=Yellow guifg=Yellow
hi MoreMsg term=none ctermfg=LightGreen gui=bold guifg=#FF0000
hi NonText term=none ctermfg=LightBlue gui=bold guifg=#FF3300 guibg=#EEEEEE
hi Question term=standout ctermfg=LightGreen gui=bold guifg=#FF0000
hi Search term=reverse ctermbg=Yellow ctermfg=Black guibg=Yellow guifg=Black
hi SpecialKey term=none ctermfg=LightBlue guifg=Blue
hi Title term=none ctermfg=LightMagenta gui=bold guifg=Magenta
hi WarningMsg term=standout ctermfg=LightRed guifg=Red
hi WildMenu term=standout ctermbg=Yellow ctermfg=Black guibg=Yellow guifg=Black
hi Folded term=standout ctermbg=LightGrey ctermfg=DarkBlue guibg=LightGrey guifg=DarkBlue
hi FoldColumn term=standout ctermbg=LightGrey ctermfg=DarkBlue guibg=Grey guifg=DarkBlue
hi DiffAdd term=none ctermbg=DarkBlue guibg=DarkBlue
hi DiffChange term=none ctermbg=DarkMagenta guibg=DarkMagenta
hi DiffDelete term=none ctermfg=Blue ctermbg=DarkCyan gui=bold guifg=Blue guibg=DarkCyan
hi TabLineSel ctermbg=14 ctermfg=2 guifg=#004000 guibg=#F0FFF0
hi TabLine ctermbg=11 ctermfg=1 guifg=#400000 guibg=#FFF0F9

hi Identifier term=underline ctermfg=6 guifg=#000066 guibg=White

hi Comment ctermfg=DarkGrey ctermbg=White guifg=DarkGrey guibg=#EEFFF0 guifg=#009933
hi SpecialChar ctermfg=DarkGrey ctermbg=White guifg=#FF0000 gui=bold
hi StorageClass ctermfg=Red ctermbg=White guifg=#0000FF gui=bold
hi Number ctermfg=LightRed ctermbg=White guifg=#996666 gui=bold
hi Type term=underline ctermfg=2 gui=bold guifg=#663399

" Groups for syntax highlighting
hi Constant term=none ctermfg=Magenta guibg=#F0F0FF guifg=Black
hi Special term=none ctermfg=LightRed guibg=White gui=bold guifg=#000066
if &t_Co > 8
  hi Statement term=none cterm=none ctermfg=DarkGreen ctermbg=White guifg=#000080 gui=bold
endif
hi Ignore ctermfg=LightGrey guifg=#FF0000

" vim: sw=2
