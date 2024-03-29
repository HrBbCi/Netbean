package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import Constants.Constant;
import Constants.Language;
import Data.FileData;
import Data.RoutineData;
import Setting.ButtonSetting;
import Setting.DataSetting;
import Setting.PanelSetting;

public class LeftPanel extends PanelSetting{
	private static final long serialVersionUID = 1L;
	private ButtonSetting save, load, New, setting;
	private RoutineData RD;
	
	public LeftPanel(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color); //대부분 설정은 상위class인 PanelSetting에 있음.
	}

	public void View() {
		// TODO Auto-generated method stub
		this.removeAll();
		
		Constant.LeftWidth = this.getWidth();
		Constant.LeftHeight = this.getHeight();
		
		this.setBounds(0,0,Constant.PreferSize(1000, 500,Constant.FrameWidth),Constant.PreferSize(455, 455,Constant.Frameheight-45));
		//저장, 불러오기 버튼
		save = new ButtonSetting(Language.Language[Language.Lan.Save.ordinal()+Language.LSelect],"Save",//아래는 크기설정
				Constant.PreferSize(500, 10,this.getWidth()), Constant.PreferSize(465, 420,this.getHeight()), Constant.PreferSize(500, 80,this.getWidth()), Constant.PreferSize(500, 30,this.getHeight())); // 저장 버튼을 x=10,y=420 떨어진곳에 크기 80 X 30 으로 버튼 생성(가변)
		save.addActionListener(new myActionListener()); //버튼 클릭시 설정은 하단에 프로그래밍함.
		
		load = new ButtonSetting(Language.Language[Language.Lan.Load.ordinal()+Language.LSelect],"Load",//아래는 크기설정
				Constant.PreferSize(500, 100,this.getWidth()), Constant.PreferSize(465, 420,this.getHeight()), Constant.PreferSize(500, 80,this.getWidth()), Constant.PreferSize(500, 30,this.getHeight())); // 불러오기 버튼을 x=100,y=420 떨어진곳에 크기 80 X 30 으로 버튼 생성(가변)
		load.addActionListener(new myActionListener()); //버튼 클릭시 설정은 하단에 프로그래밍함.
		
		New = new ButtonSetting(Language.Language[Language.Lan.New.ordinal()+Language.LSelect],"New",//아래는 크기설정
				Constant.PreferSize(500, 310,this.getWidth()), Constant.PreferSize(465, 420,this.getHeight()), Constant.PreferSize(500, 80,this.getWidth()), Constant.PreferSize(500, 30,this.getHeight())); // 새로만들기 버튼을 x=100,y=420 떨어진곳에 크기 80 X 30 으로 버튼 생성(가변)
		New.addActionListener(new myActionListener());
		
		setting = new ButtonSetting(Language.Language[Language.Lan.setting.ordinal()+Language.LSelect],"setting",//아래는 크기설정
				Constant.PreferSize(500, 410,this.getWidth()), Constant.PreferSize(465, 420,this.getHeight()), Constant.PreferSize(500, 80,this.getWidth()), Constant.PreferSize(500, 30,this.getHeight())); // 언어변경 버튼을 x=100,y=420 떨어진곳에 크기 80 X 30 으로 버튼 생성(가변)
		setting.addActionListener(new myActionListener());
	
		if(Constant.FrameWidth > 300 && Constant.Frameheight>300) {
			this.add(save);
			this.add(load);
			this.add(New);
			this.add(setting);
		}
	
	}
	
	class myActionListener implements ActionListener{
		@SuppressWarnings("unchecked")
		@Override
		//버튼 설정
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 //오류가 나면 잡아주는 함수.
			try {
				switch(e.getActionCommand()) {
				
				case "Save": //버튼의 입력이 Save이면
					String S = JOptionPane.showInputDialog(null,Language.Language[Language.Lan.MsgSFile.ordinal()+Language.LSelect],"input",JOptionPane.QUESTION_MESSAGE);
					RD = new RoutineData(); 
					RD.setObj(Constant.data); // Routine 들을 직렬화 시키고
					new FileData(); //파일을 만들어주는 class를 생성한뒤
					FileData.save(S, RD.getObj()); //위에서 입력한 파일이름 D로 Routine들을 저장함.
					break;
					
				case "Load": // 버튼의 입력이 Load이면
					String L = JOptionPane.showInputDialog(null,Language.Language[Language.Lan.MsgLFile.ordinal()+Language.LSelect],"input",JOptionPane.QUESTION_MESSAGE);
					new FileData();
					Constant.data = (Vector<DataSetting>) FileData.read(L); //파일을 읽어서 Constant 클래스의 data에 저장.
					break;
					
				case "New": // 버튼의 입력이 New이면
					int Ok = JOptionPane.showOptionDialog(null, Language.Language[Language.Lan.MsgNFile.ordinal()+Language.LSelect], "new", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					if(Ok == 0) Constant.data.removeAllElements();
					break;
					
				case "setting": // 버튼의 입력이 Language이면
					Constant.RightP.onSee_Focus();
					Constant.RightP.setData(Constant.setting);
					Constant.RightP.view();
					break;
				}
			}catch(Exception E) {}
		}
	}
}
