WinWaitActive( "Open" )
ControlSend( "Open", " ", "DirectUIHWND2", "Desktop"  )
ControlSend( "Open", " ", "DirectUIHWND2", "image.png" )
ControlClick( "Open", " ", "Button1" )
