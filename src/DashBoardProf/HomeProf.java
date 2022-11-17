package DashBoardProf;

import JpanelsEvent.JpanelMouseEvent;
import MultiChat.CallClient;
import ProfHomeCenterContent.ProfClassAdmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import CenterConetnet.EtudiantClassAdimn;
import ClasseHomeCenterContent.ClasseClassAdmin;
import DashBoard.HomeContent;

public class HomeProf extends JFrame implements ActionListener {
	Container container = getContentPane();
	
	JPanel left = new JPanel();
	JPanel center = new JPanel();
    JPanel DashHome =  new JPanel();
    JPanel JPEtudiant =  new JPanel();
    JPanel JPchat = new JPanel();
    
//    center panel
    JPanel JHeader = new JPanel();
    JPanel JPcontentPnae  = new JPanel();

    
    JLabel ProfielName;
    JLabel DashHomeLabel =new JLabel("Home");
    JLabel JPEtudiantLabel =  new JLabel("Etudiants");
    JLabel JPClasseLabel =  new JLabel("Classe");
    JLabel JPchatLabel = new JLabel("Chat");

//    JButtons
    String name = "";
	public HomeProf(String name) {
		
		this.name = name;
		this.ProfielName = new JLabel(name);
		setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        this.setTitle("DashBoard");
        this.setVisible(true);
        this.setBounds(10, 10, 800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        setSize(800, 600);
        setLocationRelativeTo(null);
		
	}
	private void setLayoutManager() {
		container.setLayout(new BorderLayout());
        container.setBackground(getBackgroundWhite());
		left.setLayout(null);

		
	}
	private Color getBackgroundWhite() {
		return Color.white;
	}
	public Color getBackgroundPurpol() {
    	return new java.awt.Color(63, 42, 100);
    }
	
	private void addComponentsToContainer() {
		container.add(left,BorderLayout.WEST);
		container.add(center,BorderLayout.CENTER);
		
		left.setBackground(getBackgroundPurpol());
		left.setPreferredSize(new Dimension(250,HEIGHT));
		
		
		center.setSize(550, HEIGHT);
		center.setBackground(getBackgroundWhite());;
		
		addComponentsToLeftPanels();
		addComponentsToRightPanels();
	}
	private void addComponentsToLeftPanels() {
		ProfielName.setBounds(80,70,100,30);
		ProfielName.setForeground(getBackgroundWhite());
		DashHome.add(DashHomeLabel);
		DashHome.setBackground(getBackgroundWhite());
		DashHome.setBounds(23,140,200,30);
		left.add(DashHome);
		left.add(ProfielName);
		

		
		JPEtudiant.add(JPEtudiantLabel);
		JPEtudiant.setBackground(getBackgroundWhite());
		JPEtudiant.setBounds(23,180,200,30);
		left.add(JPEtudiant);

		
		JPchat.add(JPchatLabel);
		JPchat.setBackground(getBackgroundWhite());
		JPchat.setBounds(23,220,200,30);
		left.add(JPchat);
		
	}
	
	private void addComponentsToRightPanels() {
		JHeader.setBackground(getBackgroundPurpol());
		JHeader.setPreferredSize(new Dimension(550,100));
	
		JPcontentPnae.setPreferredSize(new Dimension(500,430));
		JLabel lb = new JLabel("Hello");
		JPcontentPnae.add(lb);
		center.add(JHeader);
		center.add(JPcontentPnae);
		new HomeContent().addComponentsToHome(JPcontentPnae ,JHeader);

		
		DashHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	new JpanelMouseEvent(DashHome).AccueilpnMouseEntered(evt);
            }
			public void mouseExited(java.awt.event.MouseEvent evt) {
                new JpanelMouseEvent(DashHome).AccueilpnMouseExited(evt);
	        }
			public void mouseClicked(java.awt.event.MouseEvent evt) {
//				here I will add a part that shows the count of etudiant, prof and classes
				DashHome.setBackground(new java.awt.Color(150, 42, 100));
				new HomeContent().addComponentsToHome(JPcontentPnae ,JHeader);
			}
		});

		
		JPEtudiant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                new JpanelMouseEvent(JPEtudiant).AccueilpnMouseEntered(evt);
            }
			public void mouseExited(java.awt.event.MouseEvent evt) {
                new JpanelMouseEvent(JPEtudiant).AccueilpnMouseExited(evt);
	        }
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JPEtudiant.setBackground(new java.awt.Color(150, 42, 100));
				new EtudiantClassPorf(JHeader,JPcontentPnae).AddContentPaneTop(evt);
			}
		});
		
		JPchat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                new JpanelMouseEvent(JPchat).AccueilpnMouseEntered(evt);
            }
			public void mouseExited(java.awt.event.MouseEvent evt) {
                new JpanelMouseEvent(JPchat).AccueilpnMouseExited(evt);
	        }
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JPchat.setBackground(new java.awt.Color(150, 42, 100));
				try {
					
					new CallClient().RunChat(JPcontentPnae,JHeader,name);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			}
			
		});
	}
	
	private void addActionEvent() {
	}
	private void setLocationAndSize() {

		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
	}


}
