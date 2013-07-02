$handle = WinGetHandle("File Upload", "")

WinWait($handle)
ControlSetText($handle,'File name','Edit1',$CmdLine[1])
ControlClick($handle,'Open','Button1')